package org.jboss.pnc.mapou.da.mode.impl;

import org.jboss.pnc.mapou.common.dependencies.InternalDependency;
import org.jboss.pnc.mapou.common.dependencies.PublicDependency;
import org.jboss.pnc.mapou.da.mode.IModeInfo;

import java.util.Map;
import java.util.Set;

// TODO: implement
public class NpmModeInfo implements IModeInfo {

    public String getDAEndpoint() {
        return null;
    }

    public String generateJsonRequestString(Set<PublicDependency> publicDeps) {
        return null;
    }

    public Map<PublicDependency, InternalDependency> parseResponse(byte[] response) {
        return null;
    }
}
