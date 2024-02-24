package flashcards;

public class Score {

    private int errorsCount = 0;

    public Score(int errorsCount) {
        this.errorsCount = errorsCount;
    }

    public void setErrorsCount(int errorsCount) {
        this.errorsCount = errorsCount;
    }

    public int getErrorsCount() {
        return errorsCount;
    }

    public void incrementErrorCount() {
        errorsCount++;
    }
}
