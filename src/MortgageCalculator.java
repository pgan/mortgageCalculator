import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    private static final int MONTHS_IN_YEAR = 12;
    public static void main(String[] args) throws Exception {
        System.out.println("--- Mortgatge Calculator Program Start ---");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your principal amount");
        double principal = scanner.nextDouble();

        System.out.println("Enter your annual interest rate");
        float annualInterestRate = scanner.nextFloat();

        System.out.println("Enter how many years your loan is");
        int termInYears = scanner.nextInt();

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        int numberOfPayments = termInYears * MONTHS_IN_YEAR;

        double monthlyPayment = principal * ((monthlyInterestRate * 
                                            (Math.pow(1+monthlyInterestRate,numberOfPayments)))/
                                            ((Math.pow(1+monthlyInterestRate,numberOfPayments))-1));

        System.out.println("Your Monthly Payment is: "+ NumberFormat.getCurrencyInstance().format(monthlyPayment));

    }
}
