import java.util.Scanner;
class ATM{
    int balance =4000000;
    public void ATMDisplay(){
        System.out.println("The total balance in ATM machine is:"+balance);
    }
}
class userAccount{
    int mybalance;
    int Withdraw;
    int Deposite;
    public void myAccount(){
        mybalance=100000;
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Autometed Teller Machine");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposite");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for Exit");
            System.out.println("Choose the operation do you want perform");
            int choice =sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter money for Withdrawing:");
                    Withdraw=sc.nextInt();
                    if(mybalance>=Withdraw){
                        mybalance=mybalance-Withdraw;
                        System.out.println("Please collect your money");
                    }
                    else {
                        System.out.println("Your balance is not sufficient for Withdrawing");
                    }
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.println("Enter money for Deposited");
                    Deposite=sc.nextInt();
                    mybalance=mybalance+Deposite;
                    System.out.println("Your money has been deposited successfully");
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.println("Your Balance is:"+mybalance);
                    System.out.println(" ");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
public class ATMInterface {
    public static void main(String[] args) {
        ATM a =new ATM();
        userAccount account=new userAccount();
        a.ATMDisplay();
        account.myAccount();
    }
}
