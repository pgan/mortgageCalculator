import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    private static final int MONTHS_IN_YEAR = 12;
    public static void main(String[] args) throws Exception {
        System.out.println("--- Calculate your Mortgage Repayment ---");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your principal amount");
        double principal = scanner.nextDouble();

        System.out.println("Enter your annual interest rate");
        float annualInterestRate = scanner.nextFloat();

        System.out.println("Enter how many years your loan is");
        int termInYears = scanner.nextInt();
        //scanner.close();

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        int numberOfPayments = termInYears * MONTHS_IN_YEAR;

        double monthlyPayment = principal * ((monthlyInterestRate * 
                                            (Math.pow(1+monthlyInterestRate,numberOfPayments)))/
                                            ((Math.pow(1+monthlyInterestRate,numberOfPayments))-1));
        
        //String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("Your Monthly Payment is: "+ NumberFormat.getCurrencyInstance().format(monthlyPayment));
        System.out.println("Do you want to know the total payback amount? y/n");
        String knowTruth = scanner.next();

        if(knowTruth.equals("y")){
            System.out.println("Total Payback amount: " + NumberFormat.getCurrencyInstance().format(monthlyPayment*numberOfPayments));
            scanner.close();
        } else if (knowTruth.equals("n")) {
            System.out.println("Have a nice day ");
            scanner.close();
        } else{
            System.out.println(knowTruth + "is not a valid response.");
            scanner.close();
        }
    }
}
