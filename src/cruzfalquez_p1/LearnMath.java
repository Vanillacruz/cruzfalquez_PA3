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
        int answer = 0;
        boolean correct;
        boolean quit = false;
        SecureRandom random = new SecureRandom();
        Scanner scnr = new Scanner(System.in);

        while(!quit){
            answer = generateQuestions(random);
            correct = generateResponse(scnr.nextInt(), answer);

            while(!correct){
                correct = generateResponse(scnr.nextInt(), answer);
            }
        }


    }

    public static int generateQuestions(SecureRandom rand){
        int int1 = rand.nextInt(10);
        int int2 = rand.nextInt(10);

        System.out.println("How much is " + int1 + " times " + int2 + "?");

        return int1*int2;
    }

    public static boolean generateResponse(int response, int correctAnswer){
        if(response == correctAnswer){
            System.out.println("Very good!");
            return true;
        }
        else{
            System.out.println("No please try again.>again.");
            return false;
        }

    }

    public void determineDifficultyLevel(){

    }

    public void determineProblemType(){

    }




}
