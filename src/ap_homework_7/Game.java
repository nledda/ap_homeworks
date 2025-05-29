package ap_homework_7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JFrame {
    // GUI components
    protected JLabel wordLabel, attemptsLabel, timeLabel;
    protected JTextField inputField;

    // The word the player has to guess (fixed for now)
    protected String currentWord = "example";

    // Stores the letters guessed by the player
    protected ArrayList<Character> guessedLetters = new ArrayList<>();

    // Number of tries left
    protected int attemptsLeft = 6;

    // Time left (not yet functional – stays at 60)
    protected int timeLeft = 60;

    // Sets up the window and its components
    public Game() {
        setTitle("Hangman Game");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // Button to start a new game
        JButton startButton = new JButton("Start Game");
        add(startButton);

        // Label showing the guessed word with _ for unknown letters
        wordLabel = new JLabel("Word: ", SwingConstants.CENTER);
        add(wordLabel);

        // Label showing how many tries are left
        attemptsLabel = new JLabel("Attempts left: " + attemptsLeft, SwingConstants.CENTER);
        add(attemptsLabel);

        // Label showing the time left (not yet changing)
        timeLabel = new JLabel("Time left: " + timeLeft, SwingConstants.CENTER);
        add(timeLabel);

        // Input field where the player types their guess
        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setEnabled(false); // initially inactive
        add(inputField);

        // Starts the game when button is clicked and disables restart
        startButton.addActionListener(e -> {
            startGame();
            startButton.setEnabled(false);
        });

        // You will implement this method
        processInput();
        setVisible(true);
    }

    // Resets game state when starting a new game
    protected void startGame() {
        guessedLetters.clear();
        attemptsLeft = 6;
        timeLeft = 60;
        updateDisplay();
        inputField.setEnabled(true);
        inputField.requestFocus();
    }

    // Updates the word, attempts, and time on the screen
    protected void updateDisplay() {
        StringBuilder display = new StringBuilder();
        for (char c : currentWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                display.append(c).append(" ");
            } else {
                display.append("_ ");
            }
        }
        wordLabel.setText("Word: " + display.toString());
        attemptsLabel.setText("Attempts left: " + attemptsLeft);
        timeLabel.setText("Time left: " + timeLeft);
    }

    // Task 1: Add ActionListener for keyboard input on inputField and process the input
    public void processInput() {
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the text from the input field and convert to lowercase
                String input = inputField.getText().toLowerCase();

                // Clear the input field after reading the input
                inputField.setText("");

                // Check that the input is exactly one character and that it is a letter
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    System.out.println("Please enter exactly one letter.");
                    return;
                }

                // If the input is valid, call the handleGuess() method with the entered character
                handleGuess(input.charAt(0));
            }
        });
    }

    // Task 1: Check if the guessed letter is in the word and handle result
    protected void handleGuess(char guess) {
        // Check if the letter has already been guessed
        if (guessedLetters.contains(guess)) {
            System.out.println("You already guessed that letter! Try a different one.");
            return;
        }

        // Otherwise, add the letter to the set of guessed letters
        guessedLetters.add(guess);

        // If the letter is not part of the target word, reduce the number of remaining attempts
        if (!currentWord.contains(String.valueOf(guess))) {
            attemptsLeft--;
        }

        // Update the current display of the word
        updateDisplay();

        // End the game if the player has either guessed the word completely or used up all attempts
        if (hasWon()) {
            endGame(true);
        } else if (attemptsLeft <= 0) {
            endGame(false);
        }
    }

    // Task 1: Check if the player has guessed all letters correctly
    private boolean hasWon() {
        // Return true if every letter of the String currentWord has already been guessed
        for (char c : currentWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    // Task 1: End the game and show a message
    protected void endGame(boolean won) {
        if (won) {
            System.out.println("Congratulations! You won! The word was: " + currentWord);
        } else {
            System.out.println("Game over! You lost. The word was: " + currentWord);
        }

        // Disable further user input
        inputField.setEnabled(false);

        // End the whole program
        System.exit(0);
    }
}