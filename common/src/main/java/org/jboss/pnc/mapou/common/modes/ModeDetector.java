package org.jboss.pnc.mapou.common.modes;


import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Optional;

public class ModeDetector {

    private Logger logger = LoggerFactory.getLogger(ModeDetector.class);

    /**
     * If Optional contains null, could not determine the mode
     *
     * @param file
     * @return
     */
    public Optional<Mode> detectModeForFolder(File file) {

        Mode modeDetected = null;
        String fileDetected = null;

        for (Mode mode : Mode.values()) {

            String[] filesToDetect = mode.getFilesToDetect();

            for (String fileToDetect : filesToDetect) {

                File fullPathToDetect = new File(FilenameUtils.concat(file.getAbsolutePath(), fileToDetect));

                if (fullPathToDetect.exists()) {

                    if (modeDetected != null) {
                        // if we're here, we already determined the mode from a previous run
                        // there is a conflict on which mode to select
                        logger.error("Conflicting files detected! Can't auto-detect the mode");
                        logger.error("File present: '{}' for mode: {}", fileDetected, modeDetected);
                        logger.error("File present: '{}' for mode: {}", fileToDetect, mode);

                        return Optional.empty();
                    }

                    logger.info("File '{}' found! Mode detected is: {}", fileToDetect, mode);
                    modeDetected = mode;
                    fileDetected = fileToDetect;
                    break;
                }
            }
        }
        return Optional.ofNullable(modeDetected);
    }
}
