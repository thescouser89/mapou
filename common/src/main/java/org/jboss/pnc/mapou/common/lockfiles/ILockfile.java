package org.jboss.pnc.mapou.common.lockfiles;

import org.jboss.pnc.mapou.common.dependencies.PublicDependency;
import org.jboss.pnc.mapou.common.dependencies.RedHatDependency;

import java.util.Map;
import java.util.Set;

public interface ILockfile {

    Set<PublicDependency> getAllDependencies();

    void scanAndReplaceDependency(Map<PublicDependency, RedHatDependency> mappedDependency);
}
