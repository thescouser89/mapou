package org.jboss.pnc.mapou.common.translator;

import org.jboss.pnc.mapou.common.dependencies.InternalDependency;
import org.jboss.pnc.mapou.common.dependencies.PublicDependency;
import org.jboss.pnc.mapou.common.modes.Mode;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface ITranslator {

    Map<PublicDependency, InternalDependency> translateVersions(Mode mode, Set<PublicDependency> publicDeps) throws IOException;
}
