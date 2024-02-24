package flashcards.log;

public interface Logger {

    String getLog();
    
    static Logger getDefault() {
        return new DefaultLogger();
    }

    void print(String menuMessage);

    String saveln(String s);

    void ln();

    void println(String s);
}
