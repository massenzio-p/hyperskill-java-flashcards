package flashcards;

import flashcards.command.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var cardStorage = new HashMapCardStorage();
        var commandFactory = CommandFactory.getDefaultFactory(cardStorage, scanner);
        try {
            while (true) {
                System.out.println("Input the action (add, remove, import, export, ask, exit):");
                String inputCommand = scanner.nextLine();
                Command command = commandFactory.buildCommand(CommandType.valueOf(inputCommand.toUpperCase()));
                int res = command.execute();
                if (res > 0) break;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
