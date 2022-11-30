import java.util.ArrayList;
import java.util.Scanner;
public class Report {
    static int totalExpenses;
    static int totalIncomes;
    static int moneyRemaining;
    static String wantToPay;

    public static void GenerateWalletReport(ArrayList<String> expenseCategories, ArrayList<Integer> expenseAmounts, ArrayList<String> incomeCategories, ArrayList<Integer> incomeAmounts, String username, int initialCashAmount) {
        System.out.println("---------------------------WALLET REPORT---------------------------");
        System.out.println("Username : " + username);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Initial Cash Balance In The Wallet:");
        System.out.println(initialCashAmount);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Expenses Report");
        System.out.println("........................");
        System.out.println("Expenditure Categories : ");
        for (String exp : expenseCategories) {
            System.out.println(exp);
        }
        System.out.println("Expenditure Amounts : ");
        for (int expAm : expenseAmounts) {
            System.out.println(expAm);
            totalExpenses = totalExpenses + expAm;
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("Incomes Report");
        System.out.println("......................");
        System.out.println("Income Categories : ");
        for (String inc : incomeCategories) {
            System.out.println(inc);
        }
        System.out.println("Income Amounts : ");
        for (int incAm : incomeAmounts) {
            System.out.println(incAm);
            totalIncomes = totalIncomes + incAm;
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total Expenses Done From The Wallet : ");
        System.out.println(totalExpenses);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Total Incomes Added In The Wallet : ");
        System.out.println(totalIncomes);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Amount of Money Left In The Wallet : ");
        moneyRemaining = initialCashAmount - totalExpenses + totalIncomes;
        System.out.println(moneyRemaining);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("######################################################################################");
        System.out.println("#######################################################################################");
        Scanner sc = new Scanner(System.in);
        System.out.println("Additional Feature | Merchant Payment");
        System.out.println("Do you want to try merchant payment feature ? Type 'Y' or 'N' :");
        wantToPay = sc.next().toLowerCase();
        if (wantToPay.equals("y")) {
            if (moneyRemaining <= 0) {
                System.out.println("Sorry, Your Wallet is Empty.");
            } else {
                Payment.PayTo(moneyRemaining);
            }
        }

    }
}

