package flashcards.command;

import flashcards.CardStorage;

import java.util.Scanner;

class DefaultCommandFactory implements CommandFactory {

    private final CardStorage cardStorage;
    private final Scanner scanner;

    DefaultCommandFactory(CardStorage cardStorage, Scanner scanner) {
        this.cardStorage = cardStorage;
        this.scanner = scanner;
    }

    @Override
    public Command buildCommand(CommandType command) {
        return switch (command) {
            case ADD -> new AddCommand(this.cardStorage, this.scanner);
            case REMOVE -> new RemoveCommand(this.cardStorage, this.scanner);
            case IMPORT -> new ImportCommand(this.cardStorage, this.scanner);
            case EXPORT -> new ExportCommand(this.cardStorage, this.scanner);
            case ASK -> new AskCommand(this.cardStorage, this.scanner);
            case EXIT -> args -> {
                System.out.println("Bye bye!");
                return 1;
            };
            default -> throw new UnsupportedOperationException(
                            String.format("The command \"%s\" isn't supported%n", command));
        };
    }
}
