package org.jboss.pnc.mapou.da;

import lombok.Getter;
import org.jboss.pnc.mapou.common.dependencies.InternalDependency;
import org.jboss.pnc.mapou.common.dependencies.PublicDependency;
import org.jboss.pnc.mapou.common.modes.Mode;
import org.jboss.pnc.mapou.common.translator.ITranslator;

import java.util.Map;
import java.util.Set;

public class DependencyAnalyzerTranslator implements ITranslator {

    @Getter
    private final String serverUrl;

    public DependencyAnalyzerTranslator(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public Map<PublicDependency, InternalDependency> translateVersions(Mode mode, Set<PublicDependency> publicDeps) {

        return null;

    }
}
