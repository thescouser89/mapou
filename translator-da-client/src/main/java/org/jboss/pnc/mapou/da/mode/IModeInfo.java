package org.jboss.pnc.mapou.da.mode;

import org.jboss.pnc.mapou.common.dependencies.InternalDependency;
import org.jboss.pnc.mapou.common.dependencies.PublicDependency;

import java.util.Map;
import java.util.Set;

public interface IModeInfo {

    String getDAEndpoint();

    String generateJsonRequestString(Set<PublicDependency> publicDeps);

    Map<PublicDependency, InternalDependency> parseResponse(byte[] response);
}
