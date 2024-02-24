# Flashcards

## Stage 1/7: Stage one, card one
### Description
A flashcard is a digital or paper card that contains a term on one side, and a definition, translation, or explanation of that term on the other. Flashcards are often used for learning foreign languages and are an effective study technique for many people.

flashcard application

An example of a flashcard. The upper part is the term the user is being asked, the lower part is the correct answer. Source: Wikipedia.

For this project, we’ll refer to the text on the front of the card as the term, and the text on the back will be the definition. There won't actually be any visual "front" and "back" side of a card: it'll all be done through sequential text. We'll ask the user for the definitions of the terms they previously entered, and check whether the given answers are correct. While developing this application, you will not only learn some programming but also save paper!

### Objectives
Your program should read two lines from the console, a term, and a definition, that represent a card.

Implement a program that outputs 4 lines:

The first line is Card:
The second line is the term provided by the user
The third line is Definition:
The fourth line is the definition which is also provided by the user
In this stage we are just laying the foundation for later stages, we'll start using these input values from next stage.

### Examples
Here are some output examples to clarify what the result should look like. The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1.

```Card:
> purchase
purchase
Definition:
> buy
buy
Example 2.

Card:
> cos'(x)
cos'(x)
Definition:
> -sin(x)
-sin(x)
```

## Stage 2/7: What’s on the card?
### Description
In Stage 1, we learnt how to create a dynamic flashcard from user's input. Let’s add a primitive guessing mechanism as well so that the user can check how well they remember the definitions.

For this stage you'll extend the flashcard-creation mechanism implemented in Stage 1 and add a functionality to check the user's answer on top of it.

### Objectives
Similar to Stage 1, your program should read two lines from the console, a term, and a definition, that represent a card. However there's no need to print Card: or Definition: in this stage.

After that, the user inputs a line as an answer (a definition of the term on the card). Compare the user's answer with the correct definition and print the result.

The output of the program must be one of the following:

Your answer is wrong... if the answer doesn't match the definition;
Your answer is right! if the answer matches the definition.
Of course, at this point, the user is unlikely to get the answer wrong, since they’re the ones who just typed in the answer... But don’t worry: right now we're just warming up so that in later stages we could make this a bit more challenging for our users.

### Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1: the user's answer is correct

Input (a term, then a definition, and, finally, an answer):

> print()
> outputs text
> outputs text
Output:

Your answer is right!
Example 2: the user's answer is incorrect

```Input (a term, a definition, an answer):

> Jetbrains
> A place for people who love to code
> A place for people who hate to code
Output:

Your answer is wrong...
```

## Stage 3/7: Make it your own
### Description
Your program can only entertain users with one card, which isn’t really fun. Let's take our game to the next level and implement a set of flashcards.

Let the user decide how many cards they would like to make. First, ask the player to enter the desired number of cards. Then, ask them to input the term and the definition for every flashcard.

In the end, once all flashcards have been defined and saved, your program is finally ready to be used as a game! Question the player about all the new words they have entered. The program should give the term and ask for its definition.

### Objectives
Your program should do the following:

Get the number of flashcards the user would like to create. To do that, print the line Input the number of cards: as a prompt for the user, and then read the number from the next line.
Create the defined amount of cards in a loop. To create a flashcard, print the line Card #n: where n is the index number of the card to be created; then read the user's input (the term) from the following line. Then print the line The definition for card #n: and read the user's definition of the term from the next line. Repeat until all the flashcards are created.
Test the user on their knowledge of the definitions of all terms in the order they were added. To do that with one flashcard, print the line Print the definition of "term": where "term" is the term of the flashcard to be checked, and then read the user's answer from the following line. Make sure to put the term of the flashcard in quotes. Then print the line Correct! if the user's answer is correct, or the line Wrong. The right answer is "definition". if the answer is incorrect, where "definition" is the correct definition. Repeat for all the flashcards in the set.
### Example
The symbol > represents the user input. Note that it's not part of the input.
```
Input the number of cards:
> 2
Card #1:
> print()
The definition for card #1:
> outputs text
Card #2:
> str()
The definition for card #2:
> converts to a string
Print the definition of "print()":
> outputs text
Correct!
Print the definition of "str()":
> outputs text
Wrong. The right answer is "converts to a string".
Note that all your outputs and user inputs should be on separate lines.
```

## Stage 4/7: A good stack
### Description
While learning new things, we may mix things up and use the right definition for the wrong term. Let's inform our players if they enter the definition that is wrong for the requested flashcard but correct for another flashcard in our set.

Also, it might be very confusing if our flashcard set contains cards with the same term or definition, since seeing only one side of the card we can't tell them apart. Let's add a constraint: the user must add only unique terms and definitions. To do this, you need to find a way to check whether the set contains a particular term or definition and get the term by the definition, and vice versa.

These two features will definitely improve our game!

### Objectives
Modify your program to behave the following way:

When the user tries to add a duplicate term, forbid it and output the message The term "term" already exists. Try again: using the term instead of "term". Ask for the term until the user inputs a unique term.
When the user tries to add a duplicate definition, forbid it and Output the message The definition "definition" already exists. Try again: with the definition instead of "definition". Ask the player to input the definition until the user inputs a unique one.
When the user enters the wrong definition for the requested term, but this definition is correct for another term, print the appropriate message Wrong. The right answer is "correct answer", but your definition is correct for "term for user's answer". , where "correct answer" is the actual definition for the requested term, and "term for user's answer" is the appropriate term for the user-entered definition.
### Examples
The symbol > represents the user input. Note that it's not part of the input.

Example 1: the user tries to add duplicated term and definition

```Input the number of cards:
> 2
Card #1:
> print()
The definition for card #1:
> outputs text
Card #2:
> print()
The term "print()" already exists. Try again:
> str()
The definition for card #2:
> outputs text
The definition "outputs text" already exists. Try again:
> converts to a string
Print the definition of "print()":
> outputs text
Correct!
Print the definition of "str()":
> converts to a string
Correct!
```
Example 2: the user gives a correct definition for a term that exists, but which is not the term that the program is asking about

```Input the number of cards:
> 2
Card #1:
> uncle
The definition for card #1:
> a brother of one's parent
Card #2:
> ankle
The definition for card #2:
> a part of the body where the foot and the leg meet
Print the definition of "uncle":
> a part of the body where the foot and the leg meet
Wrong. The right answer is "a brother of one's parent", but your definition is correct for "ankle".
Print the definition of "ankle":
> ???
Wrong. The right answer is "a part of the body where the foot and the leg meet".
Note that all your outputs and user inputs should be on separate lines.
```

## Stage 5/7: Menu, please!
### Description
Our users cannot create new flashcards all the time. It seems like a good idea to keep old but useful cards in storage so we can use them later. Let's try to do that!

In this stage, you will improve the application's interactivity by having it ask the user for an action and perform it. Also, it will provide additional functionality allowing the user to store flashcards in files for future use.

The program should support the following actions:

- add a card: add
- remove a card: remove
- load cards from file: import
- save cards to file: export
- ask for definitions of some random cards: ask
- exit the program: exit
You can use any format of separating to store cards in a file; tests do not check the content of the file, but they do check that all the saved flashcards are loaded correctly.

When you load flashcards from a file, you shouldn't erase the cards that aren't in the file. If the imported flashcard already exists, update its definition in the program memory. There won't be any conflict with definitions in the tests.

### Objectives
Print the message Input the action (add, remove, import, export, ask, exit): each time the user is prompted for their next action. The action is read from the next line, processed, and the message is output again until the user decides to exit the program.

The program's behavior depends on the action the user inputs:

add — create a new flashcard with a unique term and definition. After adding the card, output the message The pair ("term":"definition") has been added, where "term" is the term entered by the user and "definition" is the definition entered by the user.
remove — ask the user for the term of the card they want to remove with the message Which card?, and read the user's input from the next line. If a matching flashcard exists, remove it from the set and output the message The card has been removed.. If there is no such flashcard in the set, output the message Can't remove "card": there is no such card., where "card" is the user's input.
import — print the line File name:, read the user's input from the next line, which is the file name, and import all the flashcards written to this file. If there is no file with such name, print the message File not found.. After importing the cards, print the message n cards have been loaded., where n is the number of cards in the file. The imported cards should be added to the ones that already exist in the memory of the program. However, the imported cards have priority: if you import a card with the name that already exists in the memory, the card from the file should overwrite the one in memory.
export — request the file name with the line File name: and write all currently available flashcards into this file. Print the message n cards have been saved., where n is the number of cards exported to the file.
ask — ask the user about the number of cards they want to be asked about and then prompt them for definitions, like in the previous stage.
exit — print Bye bye! and finish the program.
### Examples
The symbol > represents the user input. Note that it's not part of the input.

Example 1: the user removes an existing card and tries to remove a non-existent one

```Input the action (add, remove, import, export, ask, exit):
> add
The card:
> France
The definition of the card:
> Paris
The pair ("France":"Paris") has been added.

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> France
The card "France" already exists.

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> Great Britain
The definition of the card:
> Paris
The definition "Paris" already exists.

Input the action (add, remove, import, export, ask, exit):
> remove
Which card?
> France
The card has been removed.

Input the action (add, remove, import, export, ask, exit):
> remove
Which card?
> Wakanda
Can't remove "Wakanda": there is no such card.

Input the action (add, remove, import, export, ask, exit):
> exit
Bye bye!
```

Example 2: the user uses files to import and export their flashcards; definitions of existing cards are updated after import

```Input the action (add, remove, import, export, ask, exit):
> import
File name:
> ghost_file.txt
File not found.

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> Japan
The definition of the card:
> Tokyo
The pair ("Japan":"Tokyo") has been added.

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> Russia
The definition of the card:
> UpdateMeFromFile
The pair ("Russia":"UpdateMeFromFile") has been added.

Input the action (add, remove, import, export, ask, exit):
> import
File name:
> capitals.txt
28 cards have been loaded.

Input the action (add, remove, import, export, ask, exit):
> ask
How many times to ask?
> 1
Print the definition of "Russia":
> Moscow
Correct!

Input the action (add, remove, import, export, ask, exit):
> export
File name:
> capitalsNew.txt
29 cards have been saved.

Input the action (add, remove, import, export, ask, exit):
> exit
Bye bye!
Example 3: the program asks for definitions several times

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> a brother of one's parent
The definition of the card:
> uncle
The pair ("a brother of one's parent":"uncle") has been added.

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> a part of the body where the foot and the leg meet
The definition of the card:
> ankle
The pair ("a part of the body where the foot and the leg meet":"ankle") has been added.

Input the action (add, remove, import, export, ask, exit):
> ask
How many times to ask?
> 6
Print the definition of "a brother of one's parent":
> ankle
Wrong. The right answer is "uncle", but your definition is correct for "a part of the body where the foot and the leg meet".
Print the definition of "a part of the body where the foot and the leg meet":
> ??
Wrong. The right answer is "ankle".
Print the definition of "a brother of one's parent":
> uncle
Correct!
Print the definition of "a part of the body where the foot and the leg meet":
> ankle
Correct!
Print the definition of "a brother of one's parent":
> ??
Wrong. The right answer is "uncle".
Print the definition of "a part of the body where the foot and the leg meet":
> uncle
Wrong. The right answer is "ankle", but your definition is correct for "a brother of one's parent".

Input the action (add, remove, import, export, ask, exit):
> exit
Bye bye!
```
Note that all your outputs and user inputs should be on separate lines.


## Stage 6/7: Statistics
### Description
While studying, it may be very helpful to pay more attention to challenging parts where you make the most mistakes. In this stage, you will add some statistics features to your program so that the users can track their progress.

Implement the following additional actions:

save the application log to the given file: log
print the term or terms that the user makes most mistakes with: hardest card
erase the mistake count for all cards: reset stats
Remember that now you need to store three items (term, definition, mistakes) instead of two (term, definition).

### Objectives
Print the message Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats): each time the user is prompted for their next action. The action is read from the next line, processed, and the message is output again until the user decides to exit the program.

The program's behavior depends on the user's input action:

log — ask the user where to save the log with the message File name:, save all the lines that have been input/output to the console to the file, and print the message The log has been saved. Don't clear the log after saving it to the file.
hardest card — print a string that contains the term of the card with the highest number of wrong answers, for example, The hardest card is "term". You have N errors answering it. If there are several cards with the highest number of wrong answers, print all of the terms: The hardest cards are "term_1", "term_2". If there are no cards with errors in the user's answers, print the message There are no cards with errors.
reset stats — set the count of mistakes to 0 for all the cards and output the message Card statistics have been reset.
Update your import and export actions from the previous stage, so that the error count for each flashcard is also imported and exported.

### Example
The symbol > represents the user input. Note that it's not part of the input.

```Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
There are no cards with errors.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> import
File name:
> capitals.txt
28 cards have been loaded.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
The hardest card is "France". You have 10 errors answering it.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> ask
How many times to ask?
> 1
Print the definition of "Russia":
> Paris
Wrong. The right answer is "Moscow", but your definition is correct for "France" card.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
The hardest cards are "Russia", "France". You have 10 errors answering them.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> reset stats
Card statistics have been reset.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
There are no cards with errors.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> log
File name:
> todayLog.txt
The log has been saved.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> exit
Bye bye!
Note that all your outputs and user inputs should be on separate lines.
```

## Stage 7/7: IMPORTant
### Description
Files are used to save progress and restore it the next time the user runs the program. It's tedious to print the actions manually. Sometimes you can just forget to do it! Let's add run arguments that define which file to read at the start and which file to save at the exit.

### Objectives
- When provided with command-line arguments, your program should do the following:

If -import IMPORT is passed, where IMPORT is the file name, read the initial card set from the external file and print the message n cards have been loaded. as the first line of the output, where n is the number of cards loaded from the external file. If such an argument is not provided, the set of cards should initially be empty and no message about card loading should be output.
If -export EXPORT is passed, where EXPORT is the file name, write all cards that are in the program memory into this file after the user has entered exit, and the last line of the output should be n cards have been saved., where n is the number of flashcards in the set.
Run arguments examples
`java Flashcards -import derivatives.txt`
`java Flashcards -export animals.txt`
`java Flashcards -import words13june.txt -export words14june.txt`
`java Flashcards -export vocab.txt -import vocab.txt`
