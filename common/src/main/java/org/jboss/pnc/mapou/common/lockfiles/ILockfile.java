package org.jboss.pnc.mapou.common.lockfiles;

import org.jboss.pnc.mapou.common.dependencies.PublicDependency;
import org.jboss.pnc.mapou.common.dependencies.InternalDependency;

import java.util.Map;
import java.util.Set;

public interface ILockfile {

    Set<PublicDependency> getAllDependencies();

    void scanAndReplaceDependency(Map<PublicDependency, InternalDependency> mappedDependency);
}
