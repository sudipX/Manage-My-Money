import java.util.Scanner;
public class Payment {
    static String payeeName;
    static int payingAmount;
    static String paymentCategory;
    static boolean finishPayment = false;
    static String furtherPayment;
    public static void PayTo(int availableCashBalance){
        Scanner sc = new Scanner(System.in);
        if (availableCashBalance < 0){
            System.out.println("You have insufficient fund.");
        }
        else {
            while (finishPayment == false){
                System.out.println("Enter payee name: ");
                payeeName = sc.next();
                System.out.println("Enter the amount to pay : ");
                payingAmount = sc.nextInt();
                if (payingAmount > availableCashBalance)
                    System.out.println("Sorry insufficient fund.");
                else{
                    System.out.println("Enter payment category :");
                    paymentCategory = sc.next();
                    System.out.println("You paid "+payingAmount+" to "+payeeName.toUpperCase()+" for "+paymentCategory+".");
                }
                System.out.println("Do you want to carry Further payment ? Enter 'Y' or 'N'.");
                furtherPayment = sc.next().toLowerCase();
                if (furtherPayment.equals("n")){
                    finishPayment = true;
                }
            }



        }




    }
}
