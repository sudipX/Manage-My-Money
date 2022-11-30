import java.util.Scanner;
import java.util.ArrayList;
public class UserData {
        static String name;
        static int cashAmount;
        static int userOption;
        static boolean exitWallet = false;
        static String expenditureCategory;
        static int expenditureAmount;
        static boolean haveOtherExpenses = true;
        static String incomeCategory;
        static int incomeAmount;
        static boolean haveOtherIncomes = true;

        public static void main(String[] args) {

                System.out.println("  __  __                                __  __         __  __                        \n" +
                        " |  \\/  |                              |  \\/  |       |  \\/  |                       \n" +
                        " | \\  / | __ _ _ __   __ _  __ _  ___  | \\  / |_   _  | \\  / | ___  _ __   ___ _   _ \n" +
                        " | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ | |\\/| | | | | | |\\/| |/ _ \\| '_ \\ / _ \\ | | |\n" +
                        " | |  | | (_| | | | | (_| | (_| |  __/ | |  | | |_| | | |  | | (_) | | | |  __/ |_| |\n" +
                        " |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___| |_|  |_|\\__, | |_|  |_|\\___/|_| |_|\\___|\\__, |\n" +
                        "                            __/ |               __/ |                           __/ |\n" +
                        "                           |___/               |___/                           |___/");
                System.out.println("######################################################################################");
                System.out.println("#------  Don't Go Beyond Your Budget. Track Your Expenses. Know Your Savings.  ------#");
                System.out.println("######################################################################################");
                Scanner sc = new Scanner(System.in);
                ArrayList<String> expCategories = new ArrayList<>();
                ArrayList<Integer> expAmounts = new ArrayList<>();
                ArrayList<String> incCategories = new ArrayList<>();
                ArrayList<Integer> incAmounts = new ArrayList<>();
                System.out.println("Enter Your Name: ");
                name = sc.next();
                System.out.println(name.toUpperCase()+" To get started, Please Set Up Your Cash Amount First");
                System.out.println("To gain access to additional feature called Merchant Payment, Please Generate Wallet Report First.");
                System.out.println("Enter The Amount Of Cash You Have In Your Wallet : ");
                cashAmount = sc.nextInt();
                while (exitWallet == false){
                        System.out.println("What would you like to do today ?\n1.Generate Wallet Report\n2.Enter Expense\n3.Enter Income\n4.Exit Wallet");
                        userOption = sc.nextInt();
                        if (userOption == 2){

                                while (haveOtherExpenses == true) {
                                        System.out.println("Enter the category of your expense (Ex. food, transport):\n");
                                        expenditureCategory = sc.next().toUpperCase();
                                        System.out.println("Enter your expenditure amount :");
                                        expenditureAmount = sc.nextInt();
                                        if (expenditureAmount > cashAmount){
                                                System.out.println("Sorry, Not enough balance in the wallet for "+expenditureCategory);
                                        }
                                        else{
                                                expCategories.add(expenditureCategory);
                                                expAmounts.add(expenditureAmount);
                                        }
                                        System.out.println("Do you have any other expenses ?\nType 'Y' or 'N' :");
                                        String otherExpense = sc.next().toLowerCase();
                                        if (otherExpense.equals("n")) {
                                                haveOtherExpenses = false;
                                        }
                                }
                        }
                        else if (userOption == 3){
                                while (haveOtherIncomes == true){
                                        System.out.println("Enter the category of your income (Ex. salary, dividends, investments):\n");
                                        incomeCategory = sc.next().toUpperCase();
                                        incCategories.add(incomeCategory);
                                        System.out.println("Enter your income amount :");
                                        incomeAmount = sc.nextInt();
                                        incAmounts.add(incomeAmount);
                                        System.out.println("Do you have any other income ?\nType 'Y' or 'N' :");
                                        String otherExpense = sc.next().toLowerCase();
                                        if (otherExpense.equals("n")){
                                                haveOtherIncomes = false;
                                        }
                                }

                        }
                        else if (userOption == 1){
                                Report.GenerateWalletReport(expCategories, expAmounts, incCategories, incAmounts, name, cashAmount);
                        }
                        else if (userOption == 4){
                                exitWallet = true;
                        }


                }


    }

}