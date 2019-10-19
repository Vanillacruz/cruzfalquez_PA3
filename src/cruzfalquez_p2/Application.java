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
        int monthlyInterest = 0;
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);
        saver1.modifyInterestRate(0.04); //modified for saver1 and 2 because its a class variable

        System.out.println("Interest Rate = 4%\n");
        System.out.println("Saver 1: ");
        for(int i = 0; i < NUM_MONTHS; i++){
            saver1.calculateMonthlyInterest();
            System.out.format("Month %d's balance is $%.2f\n", (i+1), saver1.getSavingsBalance());
        }

        System.out.println("\nSaver 2: ");
        for(int i = 0; i < NUM_MONTHS; i++){
            saver2.calculateMonthlyInterest();
            System.out.format("Month %d's balance is $%.2f\n", (i+1), saver2.getSavingsBalance());
        }

        System.out.println("\n\nInterest Rate = 5%");
        saver1.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        System.out.format("\nSaver 1: \nMonth 13's balance is: $%.2f\n", saver1.getSavingsBalance());
        
        saver2.calculateMonthlyInterest();
        System.out.format("\nSaver 2: \nMonth 13's balance is: $%.2f\n", saver2.getSavingsBalance());
    }
}
