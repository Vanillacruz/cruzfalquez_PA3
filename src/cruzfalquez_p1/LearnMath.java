/*
 	Daniela Cruz Falquez
	Programming Assignment 3- Problem 1
	10/16/2019
*/
package cruzfalquez_p1;

import java.security.SecureRandom;
import java.util.Scanner;

public class LearnMath {
    public static void main(String[] args) {
        final int NUM_QUESTIONS = 10;
        int answer = 0;
        int response = 0;
        double percentage;
        boolean correct;
        boolean quit = false;
        int numCorrect;
        SecureRandom random = new SecureRandom();
        Scanner scnr = new Scanner(System.in);

        while (!quit) {
            numCorrect = 0;
            for (int i = 0; i < NUM_QUESTIONS; i++) { //CHANGE TO 10
                answer = generateQuestions(random);
                response = scnr.nextInt();
                correct = generateResponse(response, answer, random);

                if (correct) {
                    numCorrect++;
                }

                /*while(!correct){
                    response = scnr.nextInt();
                    correct = generateResponse(response, answer, random);
                }*/
            }

            System.out.println("\nNumber of correct responses: " + numCorrect);
            System.out.println("Number of incorrect responses " + (NUM_QUESTIONS - numCorrect));

            percentage = ((1.0 * numCorrect) / NUM_QUESTIONS) * 100; // stop int division
            if (percentage < 75) {
                System.out.println("\nPlease ask your teacher for extra help.");
            } else if (percentage >= 75) {
                System.out.println("\nCongratulations, you are ready to go to the next level!");
            }

            quit = endOfSession(scnr);

        }

        scnr.close();
    }

    public static int generateQuestions(SecureRandom rand) {
        int int1 = rand.nextInt(10);
        int int2 = rand.nextInt(10);

        System.out.println("How much is " + int1 + " times " + int2 + "?");

        return int1 * int2;
    }

    public static boolean generateResponse(int response, int correctAnswer, SecureRandom rand) {
        int randomNum = rand.nextInt((1) + 4);

        if (response == correctAnswer) {
            switch (randomNum) {
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
                default:
                    System.out.println("Very good!");
                    break;
            }
            return true;
        } else {
            switch (randomNum) {
                case 1:
                    System.out.println("No please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don't give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
                default:
                    System.out.println("No please try again.");
                    break;
            }
            return false;
        }

    }

    public int determineDifficultyLevel(Scanner scanner) {
        System.out.println("Which level of difficulty would you like?");
        System.out.println("1. Easy \n2.Medium \nHard \nVery Hard");
        System.out.println("Please enter the number of your selection (1-4)");

        int answer = scanner.nextInt();

        while (answer != 1 || answer != 2 || answer != 3 || answer != 4) {
            System.out.println("Sorry that was not a valid choice");
            System.out.println("Please enter the number of your selection (1-4)");

            answer = scanner.nextInt();
        }

        return answer;

    }

    public void determineProblemType() {

    }

    public static boolean endOfSession(Scanner scanner) {
        String ans = "";
        boolean notReturning = true;

        System.out.println("\nThank you for using this program!\nWould you like to begin a new session? (y/n)");
        ans = scanner.next();

        if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")) {
            return false;
        } else if (ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")) {
            return true;
        }
        //If it hasn't returned at this point it was an invalid response
        while (notReturning) {
            System.out.println("Sorry, that was not a valid response. \nPlease enter again:");
            System.out.println("Enter y/Y/yes/YES if you or another person would like to begin a session.");
            System.out.println("Enter n/N/no/NO if you want to quit.");
            ans = scanner.next();
            System.out.print("\n");
            if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")) {
                return false;
            } else if (ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")) {
                return true;
            }

        }
        //not needed because I force the return above but the IDE was yelling at me:
        return true;
    }
}

