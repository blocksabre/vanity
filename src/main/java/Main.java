import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        Option numberOption = Option.builder("n")
                .longOpt("number")
                .hasArg()
                .argName("quantity")
                .required(false)
                .desc("generate n number of addresses")
                .build();

        Option contractOption = Option.builder("t")
                .longOpt("contract")
                .required(false)
                .desc("generate contract addresses")
                .build();

        Option verboseOption = Option.builder("vv")
                .longOpt("verbose")
                .required(false)
                .desc("be extra verbose")
                .build();

        Option debugOption = Option.builder("d")
                .longOpt("debug")
                .required(false)
                .desc("print debugging information")
                .build();

        Option quietOption = Option.builder("q")
                .longOpt("quiet")
                .required(false)
                .desc("be extra quiet")
                .build();

        Option guiOption = Option.builder("g")
                .longOpt("gui")
                .required(false)
                .desc("use the JavaFX gui")
                .build();

        Option versionOption = Option.builder("v")
                .longOpt("version")
                .required(false)
                .desc("display the version")
                .build();

        Option startingOption = Option.builder("s")
                .longOpt("start")
                .hasArg()
                .argName("characters")
                .required(false)
                .desc("specify the starting characters for the address")
                .build();

        Option helpOption = Option.builder("h")
                .longOpt("help")
                .required(false)
                .desc("display this message")
                .build();

        Options options = new Options();
        options.addOption(numberOption);
        options.addOption(verboseOption);
        options.addOption(debugOption);
        options.addOption(quietOption);
        options.addOption(startingOption);
        options.addOption(guiOption);
        options.addOption(versionOption);
        options.addOption(helpOption);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = parser.parse(options, args);

        if (cmdLine.hasOption("version")) {
            displayVersion();
        }

        if (cmdLine.hasOption("help")) {

            String header = "Generate Ethereum vanity addresses\n\n";
            String footer = "\nPlease report issues at https://blocksabre.com/vanity/issues";

            displayHeader();
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("vanity", header, options, footer, true);
        } else {
            boolean withGui = !cmdLine.hasOption("gui");
        }
    }

    public static void displayVersion() {
        displayHeader();
        System.out.print("Vanity, ");
        System.out.println("Version 0.1-SNAPSHOT");
        System.out.println("http://blocksabre.com/vanity");
        System.out.println();
    }

    public static void displayHeader() {
        System.out.println("   ___  __         __             __           ");
        System.out.println("  / _ )/ /__  ____/ /__ ___ ___ _/ /  _______  ");
        System.out.println(" / _  / / _ \\/ __/  '_/(_-</ _ `/ _ \\/ __/ -_) ");
        System.out.println("/____/_/\\___/\\__/_/\\_\\/___/\\_,_/_.__/_/  \\__/  ");
        System.out.println();
    }
}
