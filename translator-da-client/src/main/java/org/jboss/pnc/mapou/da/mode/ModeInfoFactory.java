package org.jboss.pnc.mapou.da.mode;

import org.jboss.pnc.mapou.common.modes.Mode;
import org.jboss.pnc.mapou.da.mode.impl.NpmModeInfo;

public class ModeInfoFactory {

    public static IModeInfo getInstance(Mode mode) {

        IModeInfo modeInfo;

        switch (mode) {
            case NPM:
                modeInfo = new NpmModeInfo();
                break;

            default:
                throw new RuntimeException("Not yet implemented");
        }

        return modeInfo;
    }
}
