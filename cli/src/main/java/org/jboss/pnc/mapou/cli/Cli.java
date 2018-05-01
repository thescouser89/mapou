package org.jboss.pnc.mapou.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.jboss.pnc.mapou.common.modes.ModeDetector;

import java.io.File;

public class Cli {

    public static void main(String[] args) {
        ModeDetector detector = new ModeDetector();
        detector.detectModeForFolder(new File("/home/dcheung/projects/work/pnc/ui"));
        System.exit(run(args));
    }


    public static int run(String[] args) {

        CommandLineParser parser = new DefaultParser();

        try {

            Options options = getOptions();
            CommandLine cmd = parser.parse(options, args);

            return processOptions(cmd, options);

        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    private static Options getOptions() {
        Options options = new Options();

        options.addOption(Option.builder("h").longOpt("help").desc("Print this help message").build());
        options.addOption(Option.builder("m")
                .longOpt("mode")
                .hasArgs()
                .numberOfArgs(1)
                .desc("Determine which kind of package we are currently processing")
                .build());

        return options;
    }

    private static int processOptions(CommandLine cmd, Options options) {
        if (cmd.hasOption('h')) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("...", options);
            return 0;
        }

        return 0;
    }

}
