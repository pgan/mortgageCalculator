import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MortgageCalculator {

    private static final int MONTHS_IN_YEAR = 12;
    public static void main(String[] args) throws Exception {
        System.out.println("--- Calculate your Mortgage Repayment ---");
        Scanner scanner = new Scanner(System.in);

        double principal = 0;
        float annualInterestRate = 0;
        int termInYears = 0;

        try{
            System.out.println("Enter your principal amount");
            principal = scanner.nextDouble();
        } catch(InputMismatchException e){
            System.out.println("Please enter a valid number for your prinicpal amount");
            scanner.close();
            return;
        }


        try{
            System.out.println("Enter your annual interest rate (eg., enter 5.99 for 5.99%)");
            annualInterestRate = scanner.nextFloat();
            if(annualInterestRate > 1){
                annualInterestRate /= 100;
            }
        }catch(InputMismatchException e){
            System.out.println("Please enter a valid number for your annual interest rate");
            scanner.close();
            return;
        }

        try{
            System.out.println("Enter how many years your loan is");
            termInYears = scanner.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Please enter a valid number of years for your loan length");
            scanner.close();
            return;
        }

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        int numberOfPayments = termInYears * MONTHS_IN_YEAR;

        double monthlyPayment = principal * ((monthlyInterestRate * 
                                            (Math.pow(1+monthlyInterestRate,numberOfPayments)))/
                                            ((Math.pow(1+monthlyInterestRate,numberOfPayments))-1));
        
        //String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("--- Your Monthly Payment is: "+ NumberFormat.getCurrencyInstance().format(monthlyPayment) + " ---");
        System.out.println("Do you want to know the total payback amount? y/n");
        String knowTruth = scanner.next();
        try{
            if(knowTruth.equalsIgnoreCase("y")){
                System.out.println("--- Total Payback amount: " + NumberFormat.getCurrencyInstance().format(monthlyPayment*numberOfPayments) + " ---");
            } else if (knowTruth.equalsIgnoreCase("n")) {
                System.out.println("Have a nice day ");
            } else{
                System.out.println(knowTruth + "is not a valid response.");
            }
        }catch(InputMismatchException e){
            System.out.println("Please enter a valid y/n response");
            scanner.close();
            return;
        }

        scanner.close();
    }
}
