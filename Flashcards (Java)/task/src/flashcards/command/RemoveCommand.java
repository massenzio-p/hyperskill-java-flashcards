package flashcards.command;

import flashcards.CardStorage;

import java.util.Scanner;
 class RemoveCommand implements Command {

     private final CardStorage cardStorage;
     private final Scanner scanner;

     public RemoveCommand(CardStorage cardStorage, Scanner scanner) {
         this.cardStorage = cardStorage;
         this.scanner = scanner;
    }

     @Override
     public int execute(Object... args) {
         System.out.println("Which card?");
         String term = this.scanner.nextLine();

         String msg = "The card has been removed.%n";
         if (!this.cardStorage.removeCard(term)) {
             msg = String.format("Can't remove \"%s\": there is no such card.%n", term);
         }

         System.out.printf(msg, term);
         return 0;
     }
 }
