import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Mortgatge Calculator Program Start ---");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your principal amount");
        double principal = scanner.nextDouble();

        System.out.println("Enter your annual interest rate");
        float annualInterestRate = scanner.nextFloat();

        System.out.println("Enter how many years your loan is");
        int termInYears = scanner.nextInt();

    }
}
