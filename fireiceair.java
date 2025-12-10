import java.util.Scanner;
import java.util.Random;

public class fireiceair {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter the number of matches you want to play:");
        int match = sc.nextInt();
        int won = 0;
        int loose = 0;
        int draw = 0;

        for (int i = 0; i < match; i++) {
            // Generate a random number from 0 to 99 for the computer's choice
            int comChoiceNum = rand.nextInt(100);
            
            // Re-map the random number comChoiceNum to a specific character:
            // 0-32 -> 'f' (Fire)
            // 33-65 -> 'i' (Ice)
            // 66-99 -> 'a' (Air)
            char comChoice;
            if (comChoiceNum < 33) {
                comChoice = 'f'; // Fire
            } else if (comChoiceNum < 66) {
                comChoice = 'i'; // Ice
            } else {
                comChoice = 'a'; // Air
            }

            System.out.println("\nPlease enter f for Fire, i for Ice, or a for Air:");
            // Check for valid input
            if (sc.hasNext()) {
                char userChoice = sc.next().charAt(0);
                System.out.println("You have entered: " + userChoice);
                System.out.println("Computer has chosen: " + comChoice);

                if (userChoice == 'f' || userChoice == 'i' || userChoice == 'a') {
                    
                    if (userChoice == comChoice) {
                        System.out.println("The match has drawn.");
                        draw++;
                    } 
                    // User chooses Fire ('f')
                    else if (userChoice == 'f') {
                        if (comChoice == 'i') {
                            System.out.println("You won the match! (Fire melts Ice)");
                            won++;
                        } else { // comChoice must be 'a'
                            System.out.println("You lose the match. (Air extinguishes Fire)");
                            loose++;
                        }
                    } 
                    // User chooses Ice ('i')
                    else if (userChoice == 'i') {
                        if (comChoice == 'a') {
                            System.out.println("You won the match! (Ice freezes Air/Clouds)");
                            won++;
                        } else { // comChoice must be 'f'
                            System.out.println("You lose the match. (Fire melts Ice)");
                            loose++;
                        }
                    } 
                    // User chooses Air ('a')
                    else if (userChoice == 'a') {
                        if (comChoice == 'f') {
                            System.out.println("You won the match! (Air extinguishes Fire)");
                            won++;
                        } else { // comChoice must be 'i'
                            System.out.println("You lose the match. (Ice freezes Air/Clouds)");
                            loose++;
                        }
                    }
                } else {
                    System.out.println("Please enter a valid input ('f', 'i', or 'a').");
                }
            } else {
                System.out.println("Error reading input. Skipping this round.");
            }
        }

        // --- Final Statistics ---
        System.out.println("\n********************************");
        System.out.println("FINAL STATISTICS 📊");
        System.out.println("You Won: " + won);
        System.out.println("You Lost: " + loose);
        System.out.println("Drawn: " + draw);
        System.out.println("********************************");
        
        sc.close();
    }
}