package org.jboss.pnc.mapou.common.modes;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Optional;

@Slf4j
public class ModeDetector {

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
                        log.error("Conflicting files detected! Can't auto-detect the mode");
                        log.error("File present: '{}' for mode: {}", fileDetected, modeDetected);
                        log.error("File present: '{}' for mode: {}", fileToDetect, mode);

                        return Optional.empty();
                    }

                    log.info("File '{}' found! Mode detected is: {}", fileToDetect, mode);
                    modeDetected = mode;
                    fileDetected = fileToDetect;
                    break;
                }
            }
        }
        return Optional.ofNullable(modeDetected);
    }
}
