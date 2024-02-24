package flashcards.command;

import flashcards.CardStorage;
import flashcards.log.Logger;

import java.util.Scanner;

class DefaultCommandFactory implements CommandFactory {

    private final CardStorage cardStorage;
    private final Scanner scanner;
    private final Logger logger;

    DefaultCommandFactory(CardStorage cardStorage, Scanner scanner, Logger logger) {
        this.cardStorage = cardStorage;
        this.scanner = scanner;
        this.logger = logger;
    }

    @Override
    public Command buildCommand(CommandType command) {
        return switch (command) {
            case ADD -> new AddCommand(this.scanner, this.cardStorage, logger);
            case REMOVE -> new RemoveCommand(this.scanner, this.cardStorage, logger);
            case IMPORT -> new ImportCommand(this.scanner, this.cardStorage, logger);
            case EXPORT -> new ExportCommand(this.scanner, this.cardStorage, logger);
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
