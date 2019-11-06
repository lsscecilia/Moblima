package UI;
import Controller.StaffController;

import java.util.Scanner;


public class MoblimaApp {

    /**
     * helps implement Dependency Inversion Principle by reducing coupling between Moblima and Controller
     * @param consoleBasedInterface
     */
    private static void loadUi(ConsoleBasedInterface consoleBasedInterface){
        if(consoleBasedInterface != null){
            consoleBasedInterface.show();
        }
    }

    public static void main(String[] args) {
        StaffController staffController = new StaffController();
        Scanner sc = new Scanner(System.in);
        boolean login = false;
        int userChoice = 0;

        do {
            System.out.println("Welcome! Please choose your Login option");
            System.out.println("====================================================");
            System.out.println("|1. Customer                                        |");
            System.out.println("|2. Staff                                           |");
            System.out.println("|3. Quit                                            |");
            System.out.println("====================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            ConsoleBasedInterface consoleBasedInterface = null;
            switch(userChoice) {
                case 1:
                    consoleBasedInterface = new CustomerUi();
                    break;
                case 2:
                    boolean successful = false;
                    for (int authenticateCount = 3; authenticateCount > 0; authenticateCount--) {
                        if (staffController.authenticateStaff()) {
                            consoleBasedInterface = new StaffUi();
                            successful = true;
                            break;
                        } else {
                            System.out.println("You have entered a wrong username or password.");
                            System.out.println("You have " + (authenticateCount - 1) + " tries left!" + "\n");
                        }
                    }
                    if (!successful){
                        sc.close();
                        System.out.println("Program terminating...");
                        System.exit(0);
                    }
                    break;
                case 3:
                    sc.close();
                    System.out.println("You have chosen to terminate program! :(");
                    System.out.println("Program terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    System.out.print("\n");
            }
            loadUi(consoleBasedInterface);
        } while (userChoice != 3);
    }

}
