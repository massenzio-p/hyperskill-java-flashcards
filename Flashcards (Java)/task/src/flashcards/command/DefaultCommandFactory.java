package flashcards.command;

import flashcards.CardFilePorter;
import flashcards.CardStorage;
import flashcards.log.Logger;

import java.util.Scanner;

class DefaultCommandFactory implements CommandFactory {

    private final CardStorage cardStorage;
    private final Scanner scanner;
    private final Logger logger;
    private final CardFilePorter importer;
    private final CardFilePorter exporter;

    DefaultCommandFactory(CardStorage cardStorage,
                          Scanner scanner,
                          Logger logger,
                          CardFilePorter importer,
                          CardFilePorter exporter) {
        this.cardStorage = cardStorage;
        this.scanner = scanner;
        this.logger = logger;
        this.importer = importer;
        this.exporter = exporter;
    }

    @Override
    public Command buildCommand(CommandType command) {
        return switch (command) {
            case ADD -> new AddCommand(this.scanner, this.cardStorage, logger);
            case REMOVE -> new RemoveCommand(this.scanner, this.cardStorage, logger);
            case IMPORT -> new ImportCommand(this.scanner, this.logger, this.importer);
            case EXPORT -> new ExportCommand(this.scanner, this.logger, this.exporter);
            case ASK -> new AskCommand(this.scanner, this.cardStorage, logger);
            case LOG -> new LogCommand(this.scanner, this.cardStorage, logger);
            case HARDEST_CARD -> new HardestCardCommand(this.cardStorage, logger);
            case RESET_STATS -> new ResetStatsCommand(this.cardStorage, logger);
            case EXIT -> args -> {
                System.out.println("Bye bye!");
                return 1;
            };
        };
    }
}
