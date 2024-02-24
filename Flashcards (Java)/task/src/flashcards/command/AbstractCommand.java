package flashcards.command;

import flashcards.CardStorage;
import flashcards.log.Logger;

import java.util.Scanner;

public abstract class AbstractCommand implements Command {

    protected final Scanner scanner;
    protected final CardStorage cardStorage;
    protected final Logger logger;

    protected AbstractCommand(Scanner scanner, CardStorage cardStorage, Logger logger) {
        this.scanner = scanner;
        this.cardStorage = cardStorage;
        this.logger = logger;
    }

    public AbstractCommand(Scanner scanner, Logger logger) {
        this.scanner = scanner;
        this.logger = logger;
        this.cardStorage = null;
    }

    public AbstractCommand(CardStorage cardStorage, Logger logger) {
        this.scanner = null;
        this.cardStorage = cardStorage;
        this.logger = logger;
    }
}
