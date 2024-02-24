package flashcards.command;

import flashcards.CardStorage;
import flashcards.log.Logger;

class ResetStatsCommand extends AbstractCommand {


    public ResetStatsCommand(CardStorage cardStorage, Logger logger) {
        super(cardStorage, logger);
    }

    @Override
    public int execute(Object... args) {
        cardStorage.resetAllScore();
        logger.println("Card statistics have been reset.");
        return 0;
    }
}
