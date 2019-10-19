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
        SecureRandom random = new SecureRandom();
        Scanner scnr = new Scanner(System.in);
        final int NUM_QUESTIONS = 10;
        int numCorrect;
        int type;
        int level;
        double answer = 0;
        double response = 0;
        double percentage;
        boolean correct;
        boolean quit = false;

        while (!quit) {
            //Resets for each different user
            numCorrect = 0;
            level = determineDifficultyLevel(scnr);
            type = determineProblemType(scnr);

            for (int i = 0; i < NUM_QUESTIONS; i++) {
                answer = generateQuestions(random, level, type);
                response = scnr.nextDouble();
                correct = generateResponse(response, answer, random);

                if (correct) {
                    numCorrect++;
                }

                //In Dr. Hollander's announcement, it states to only give the student once chance on each question, so the following code from Pt1 is no longer needed.
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

    public static double generateQuestions(SecureRandom rand, int level, int type) {
        int num1 = 0;
        int num2 = 0;
        int random = rand.nextInt(4) + 1;
        double answer = 0;

        if(level == 1){
            num1 = rand.nextInt(10); // range from 0 to 9
            num2 = rand.nextInt(10);
        }else if(level == 2) {
            num1 = rand.nextInt((1)+ (99-10)) + 10; //range from 10 to 99
            num2 = rand.nextInt((1)+ (99-10)) + 10;
        }else if(level == 3){
            num1 = rand.nextInt((1)+ (999-100))+ 100;//range from 100 to 999
            num2 = rand.nextInt((1)+ (999-100)) +100;
        }else if(level == 4){
            num1 = rand.nextInt((1)+ (9999-1000))+1000;//range from 1000 to 9999
            num2 = rand.nextInt((1)+ (9999-1000))+1000;
        }

        if(type == 5){
            type = random;
        }

        if(type == 1){
            System.out.println("\nHow much is " + num1 + " plus " + num2 + "?");
            answer = num1 + num2;
        }else if(type == 2){
            System.out.println("\nHow much is " + num1 + " minus " + num2 + "?");
            answer = num1 - num2;
        }else if(type == 3){
            System.out.println("\nHow much is " + num1 + " times " + num2 + "?");
            answer = num1 * num2;
        }
        else if(type == 4){
            //to prevent 0/0 or 0/number cases
            if(num2 == 0){
                num2 = 1;
            }
            System.out.println("\nHow much is " + num1 + " divided by " + num2 + "?");
            answer = (1.0 * num1 ) / num2;
        }

        return answer;
    }

    public static boolean generateResponse(double response, double correctAnswer, SecureRandom rand) {
        int randomNum = rand.nextInt(4) + 1;

        //checks accuracy to the thousandths place (for division problems)
        if (Math.abs(response - correctAnswer) < 0.001) {
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
            }
            return false;
        }
    }

    public static int determineDifficultyLevel(Scanner scanner) {
        System.out.println("Which level of difficulty would you like?");
        System.out.println("1. Easy \n2. Medium \n3. Hard \n4. Very Hard");
        System.out.println("Please enter the number that corresponds to your selection(1-4)");

        int answer = scanner.nextInt();

        while (answer != 1 && answer != 2 && answer != 3 && answer != 4) {
            System.out.println("Sorry that was not a valid choice");
            System.out.println("Please enter the number of your selection (1-4)");

            answer = scanner.nextInt();
        }

        return answer;
    }

    public static int determineProblemType(Scanner scanner) {
        System.out.println("\nWhich type of arithmetic would you like to study?");
        System.out.println("1. Addition Only \n2. Subtraction Only \n3. Multiplication Only \n4. Division Only \n5. All Types");
        System.out.println("Please enter the number that corresponds to your selection(1-5)");

        int type = scanner.nextInt();

        while (type != 1 && type != 2 && type != 3 && type != 4 && type != 5) {
            System.out.println("Sorry that was not a valid choice");
            System.out.println("Please enter the number of your selection (1-5)");

            type = scanner.nextInt();
        }

        if (type == 4 || type == 5){
            System.out.println("Your answer for division problems will be checked to the thousandths decimal place for accuracy");
        }

        return type;
    }

    public static boolean endOfSession(Scanner scanner) {
        String answer = "";
        boolean notReturning = true;

        System.out.println("\nThank you for using this program!\nWould you like to begin a new session? (y/n)");
        answer = scanner.next();

        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            return false;
        } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
            return true;
        }

        //If it hasn't returned at this point it was an invalid response
        while (notReturning) {
            System.out.println("Sorry, that was not a valid response. \nPlease enter again:");
            System.out.println("Enter y/Y/yes/YES if you or another person would like to begin a session.");
            System.out.println("Enter n/N/no/NO if you want to quit.");
            answer = scanner.next();
            System.out.print("\n");
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                return false;
            } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                return true;
            }
        }

        //not needed because I force the return above but the IDE was yelling at me:
        return true;
    }
}