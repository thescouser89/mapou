package org.jboss.pnc.mapou.common.modes;

/**
 * Enum to represent the current mode we are currently running. The mode is the type of package we'll process
 *
 */
public enum Mode {

    // List the files from highest to lowest priority

    NPM(new String[]{"npm-shrinkwrap.json", "package-lock.json"});


    private String[] filesToDetect;

    Mode(String[] filesToDetect) {
        this.filesToDetect = filesToDetect;
    }

    public String[] getFilesToDetect() {
        return filesToDetect;
    }
}
