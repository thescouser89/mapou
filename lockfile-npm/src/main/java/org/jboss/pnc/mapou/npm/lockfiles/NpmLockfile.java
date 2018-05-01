package org.jboss.pnc.mapou.npm.lockfiles;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.jboss.pnc.mapou.common.dependencies.PublicDependency;
import org.jboss.pnc.mapou.common.dependencies.InternalDependency;
import org.jboss.pnc.mapou.common.lockfiles.ILockfile;
import org.jboss.pnc.mapou.npm.dto.NpmDependency;
import org.jboss.pnc.mapou.npm.dto.PackageLock;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class NpmLockfile implements ILockfile {

    private PackageLock packageLock;

    public NpmLockfile(String filename) throws Exception {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        packageLock = mapper.readValue(new File(filename), PackageLock.class);

        log.info(packageLock.toString());
    }

    public Set<PublicDependency> getAllDependencies() {

        Set<PublicDependency> publicDependencies = new HashSet<PublicDependency>();

        // return empty set if lock has no dependencies
        if (packageLock.getDependencies() == null) {
            return publicDependencies;
        }

        for (Map.Entry<String, NpmDependency> entry : packageLock.getDependencies().entrySet()) {

            String name = entry.getKey();
            NpmDependency npmDependency = entry.getValue();

            findDependencies(name, npmDependency, publicDependencies);
        }

        return publicDependencies;
    }

    public void scanAndReplaceDependency(Map<PublicDependency, InternalDependency> mappedDependency) {

    }


    private void findDependencies(String name, NpmDependency dependency, Set<PublicDependency> publicDependencies) {

        if (dependency == null) {
            return;
        }

        // add the current dependency
        publicDependencies.add(new PublicDependency(name, dependency.getVersion()));

        // add requires versions
        if (dependency.getRequires() != null) {

            for (Map.Entry<String, String> entry : dependency.getRequires().entrySet()) {
                publicDependencies.add(new PublicDependency(entry.getKey(), entry.getValue()));
            }
        }

        if (dependency.getDependencies() != null) {

            for (Map.Entry<String, NpmDependency> entry : dependency.getDependencies().entrySet()) {
                findDependencies(entry.getKey(), entry.getValue(), publicDependencies);
            }

        }
    }

    public static void main(String[] args) throws Exception {
        NpmLockfile lockfile = new NpmLockfile("/home/dcheung/projects/work/pnc/ui/package-lock.json");

        List<PublicDependency> dependencies = new ArrayList<PublicDependency>();
        dependencies.addAll(lockfile.getAllDependencies());

        dependencies.sort(Comparator.comparing(PublicDependency::getName));
        for (PublicDependency dependency : dependencies) {
            log.info(dependency.toString());
        }
    }
}
