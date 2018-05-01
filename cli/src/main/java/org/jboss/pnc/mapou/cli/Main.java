package org.jboss.pnc.mapou.cli;

import org.jboss.pnc.mapou.common.dependencies.InternalDependency;
import org.jboss.pnc.mapou.common.dependencies.PublicDependency;
import org.jboss.pnc.mapou.common.lockfiles.ILockfile;
import org.jboss.pnc.mapou.common.modes.Mode;
import org.jboss.pnc.mapou.common.translator.ITranslator;
import org.jboss.pnc.mapou.da.DependencyAnalyzerTranslator;
import org.jboss.pnc.mapou.npm.lockfiles.NpmLockfile;

import java.util.Map;
import java.util.Set;

public class Main {
    public void test() throws Exception {

        ITranslator translator = new DependencyAnalyzerTranslator("hoho");
        ILockfile lockfile = new NpmLockfile("haha");

        Set<PublicDependency> publicDeps = lockfile.getAllDependencies();
        Map<PublicDependency, InternalDependency> translated = translator.translateVersions(Mode.NPM, publicDeps);
        lockfile.scanAndReplaceDependency(translated);
    }
}
