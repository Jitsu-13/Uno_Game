# Uno_Game
It is game running through the terminal, and the user plays the game by intereacting with prompts from the terminal

## Application Running Video


https://github.com/Jitsu-13/Uno_Game/assets/107523890/647f896a-fddd-44ed-a837-2e505c7ec365


## Symbols Guide

### The Cards

In Uno there are 5 different types of card colors
<ul>
<li>red</li>
<li>green</li>
<li>blue</li>
<li>yellow</li>
<li>black/wild card (these cards allow you to change its color to one of the previous listen ones)</li>
</ul>

These are represented in the game as r, g, b, y, and s respectively

In Uno the cards are numbered 0-9 (inclusive) and in addition to that there are specials types of cards. These special cards are the following
<ul>
<li>Skip Card - skips the next player</li>
<li>Reverse Card - changes the direction of the game</li>
<li>Draw Two Card - the next player draws two cards and loses a turn</li>
<li>Wild Card - changes the color of the card itself when played</li>
<li>Draw Four Wild Card - the next player draws four cards, loses a turn, and the user gets to change the color of this card</li>
</ul>
These are represented as:
<ul>
<li>x for skip cards</li>
<li><> for reverse cards</li>
<li>+2 for draw two cards</li>
<li>w for wild cards</li>
<li>+4 for the draw four card In Uno each card as a color and a face value that is either a number or a special action Here are some examples our how an uno card would be represented in game:</li>
<li>a yellow 5 card would be y5</li>
<li>a red skip card would be rx</li>
<li>a wild card would be sw and a draw four card would be s+4<li>
</ul>

## Note: 
After changing the color of one of these types of cards the s would be changed to the letter of the new color The game represents face down cards as u, these are meant to simulate how the back of uno cards have say uno on the back

## Running the Game

1. Clone or download the reprository https://github.com/Jitsu-13/Uno_Game to your local machine.

2. Open a command line or an IDE and navigate to the project directory.

3. Compile the Java source files using the following command:

4. Run the compiled program using the following command: javac -d bin src/*.java
 
5. Or else in Ide got to Game.java file and run the main method.
 
6. Follow the instructions displayed in the console to play the game.

## Credit
To understand the game i use this <a href="https://www.ultraboardgames.com/uno/game-rules.php">site</a> for reference. <br>
I got the font from this <a href="https://fontmeme.com/uno-card-game-font/">site</a>.
