package flashcards.log;

class DefaultLogger implements Logger {

    private final StringBuilder sb = new StringBuilder();

    @Override
    public String getLog() {
        return sb.toString();
    }

    @Override
    public void print(String menuMessage) {
        System.out.print(menuMessage);
        sb.append(menuMessage);
    }

    @Override
    public String saveln(String s) {
        sb.append(s);
        ln();
        return s;
    }

    @Override
    public void ln() {
        this.sb.append("\n");
    }

    @Override
    public void println(String s) {
        System.out.println(s);
        sb.append(s).append("\n");
    }
}
