/*
 	Daniela Cruz Falquez
	Programming Assignment 3- Problem 2
	10/18/2019
*/
package cruzfalquez_p2;

//Test Program
public class Application {
    public static void main(String[] args) {
        final int NUM_MONTHS = 12;

        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);

        saver1.modifyInterestRate(0.04);

        //print out for all 12 months
        for(int i = 0; i < NUM_MONTHS; i++){


        }

        saver1.modifyInterestRate(0.05);

        // calculate next months interest and print for both
    }
}
