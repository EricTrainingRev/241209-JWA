# Basic Coding Activity
## Objective
Create a Tic Tac Toe game that runs in the console. The game should allow two players to input their moves, display the game board, and announce the winner or if the game ends in a tie

## Requirements
- **Display the Board**: The game board should be displayed in the console after each move
- **User Input**: Prompt the first player to enter a move, then the second, repeat until the game is finished
- **End of Game**: Display a message indicating whether a player has won or if the game is a tie

## Stretch Goal
- Implement a single-player mode where the player competes against the computer

## Instructions
### Setup the Game Board:
- Create a 3x3 grid to represent the Tic Tac Toe board
- Initialize the board with empty spaces
### Player Moves:
- Use the Scanner class to take input from the players
- Prompt the players to enter their move
- Update the board with the player’s move
### Display the Board:
- After each move, print the current state of the board to the console
### Check for Win or Tie:
- After each move, check if there is a winner or if the game is a tie
- If a player wins, display a congratulatory message
- If the game is a tie, display a tie message
### Single Player Mode (Stretch Goal):
- Implement logic for the computer to make moves
- The computer can make random moves or use a simple AI strategy

## Starting Code
```java
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // This reads input from the terminal
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your move: ");
            String userInput = scanner.nextLine(); // Returns whatever the user enters into the terminal
            // Process the user input
        }
    }
}
```