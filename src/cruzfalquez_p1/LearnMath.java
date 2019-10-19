/*
 	Daniela Cruz Falquez
	Programming Assignment 3- Problem 1
	10/16/2019
*/
package cruzfalquez_p1;

import java.security.SecureRandom;
import java.util.Scanner;

public class LearnMath {
    public static void main (String[] args) {
        final int NUM_QUESTIONS = 10;
        int answer = 0;
        int choice = 0;
        int response = 0;
        String ans = "";
        double percentage;
        boolean correct;
        boolean quit = false;
        int numCorrect;
        SecureRandom random = new SecureRandom();
        Scanner scnr = new Scanner(System.in);

        while(!quit){
            numCorrect = 0;
            for(int i = 0; i <NUM_QUESTIONS; i++){ //CHANGE TO 10
                answer = generateQuestions(random);
                response = scnr.nextInt();
                correct = generateResponse(response, answer, random);

                if(correct){
                    numCorrect++;
                }

                /*while(!correct){
                    response = scnr.nextInt();
                    correct = generateResponse(response, answer, random);
                }*/
            }

            System.out.println("\nNumber of correct responses: " + numCorrect);
            System.out.println("Number of incorrect responses " + (NUM_QUESTIONS-numCorrect));

            percentage = ((1.0*numCorrect)/NUM_QUESTIONS)*100; // stop int division
            if(percentage<75){
                System.out.println( "\nPlease ask your teacher for extra help.");
            }else if(percentage >= 75){
                System.out.println("\nCongratulations, you are ready to go to the next level!");
            }

            System.out.println("\nThank you for using this program!\nWould you like to begin a new session? (y/n)");
            ans = scnr.next();

            choice = 0;
            if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")) {
                choice = 1;
            } else if (ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")) {
                quit = true;
                choice = 2;
            }
            //ensures a valid response
            while ((choice != 1) && (choice != 2)) {
                System.out.println("Sorry, that was not a valid response. \nPlease enter again:");
                System.out.println("Enter y/Y/yes/YES if another person would like to rate these topics.");
                System.out.println("Enter n/N/no/NO if all responses have been logged.");
                ans = scnr.next();
                System.out.print("\n");
                if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")) {
                    choice = 1;
                } else if (ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")) {
                    quit = true;
                    choice = 2;
                }
            }

        }

        scnr.close();
    }

    public static int generateQuestions(SecureRandom rand){
        int int1 = rand.nextInt(10);
        int int2 = rand.nextInt(10);

        System.out.println("How much is " + int1 + " times " + int2 + "?");

        return int1*int2;
    }

    public static boolean generateResponse(int response, int correctAnswer, SecureRandom rand){
        int randomNum = rand.nextInt((1)+4);

        if(response == correctAnswer){
            switch(randomNum) {
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
        }
        else{
            switch(randomNum) {
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

    public void determineDifficultyLevel(){

    }

    public void determineProblemType(){

    }




}
