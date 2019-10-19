/*
 	Daniela Cruz Falquez
	Programming Assignment 3- Problem 2
	10/17/2019
*/

package cruzfalquez_p2;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void calculateMonthlyInterest(){
        savingsBalance += savingsBalance*(annualInterestRate/12);
    }

    public static void modifyInterestRate(double newValue){
        annualInterestRate = newValue;
    }


}
