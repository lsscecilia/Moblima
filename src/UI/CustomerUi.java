package UI;

import Controller.CustomerDisplayController;
import Controller.CustomerUIController;
import Entity.Cineplex;
import Entity.Movie;
import Entity.ShowTime;
import Entity.Ticket;

import javax.net.ssl.SNIHostName;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * modifier package-private
 */
class CustomerUi implements ConsoleBasedInterface{

    //put in constructor
    public Scanner sc = new Scanner(System.in);
    public CustomerUIController customerUIController = new CustomerUIController();

    @Override
    public void show() {
        //MovieController movieController = new MovieController();
        //CineplexController cineplexController = new CineplexController();
        //TransactionController transController = new TransactionController();

        MoblimaApp application = new MoblimaApp();
        //Movie movieUserChoice = null;


        int userChoice = 0;
        do {
            System.out.println("====================== Menu++++ =======================");
            System.out.println("|1. Show me some Movies!                              |");
            System.out.println("|2. Search Movies!                                    |");
            System.out.println("|3. Show me some Cinplex!                             |");
            System.out.println("|4. Buy Tickets                                       |");
            System.out.println("|5. View my Booking History                           |");
            System.out.println("|6. Rate and Review                                   |");
            System.out.println("|7. Click here if you need movie recommendation       |");
            System.out.println("|8. Back                                              |");
            System.out.println("|9. Quit                                             |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    showOption1();
                    break;
                case 2:
                    showOption2();
                    break;
                case 3:
                    showOption3();

                    break;
                case 4:
                    showOption4();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    MoblimaApp.main(null);
                    break;

                case 9:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 9);

    }

    public void showOption1()
    {
        //display list of movie
        //movieArrayList passed
        int userChoice = 0;
        do {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Menu --> Movie List");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println();
            customerUIController.showMovieList();
            System.out.println("test");
            System.out.println("====================== Option =========================");
            System.out.println("|1. Select movie for more details                     |");
            System.out.println("|2. Back                                              |");
            System.out.println("|3. Quit                                              |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    showOption1_1();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 3 | userChoice <= 0);
    }
    public void showOption1_1()
    {
        int userChoice = 0;
        do {
            System.out.println("Enter movie according to index: ");
            int index = sc.nextInt();
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Menu --> Movie List --> Movie information" );
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println();
            customerUIController.showMovieInformation(index-1);
            System.out.println("====================== Option =========================");
            System.out.println("|1. Back to movie list                                |");
            System.out.println("|2. Back to main menu                                 |");
            System.out.println("|3. Quit                                              |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    showOption1();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 3 | userChoice <= 0 );
    }
    public void showOption2()
    {
        System.out.println("Enter movie to search: ");
        sc.nextLine();
        String search = sc.nextLine();
        //search
        ArrayList<Movie> movieArrayList = customerUIController.showSearchMovieResult(search);
        boolean empty = customerUIController.noResultFound(movieArrayList);
        if (empty)
        {
            showOption2_2();
        }
        else {
            //display result (may be a list of movie) --> rmb nid to show movie status too!! if not user hav no idea
            int userChoice = 0;
            do {
                System.out.println("====================== Option =========================");
                System.out.println("|1. Select movie for more details                     |");
                System.out.println("|2. Back                                              |");
                System.out.println("|3. Quit                                              |");
                System.out.println("=======================================================");
                System.out.print("Please input your choice: ");

                if (sc.hasNextInt()) {
                    userChoice = sc.nextInt();
                    System.out.print("\n");
                } else {
                    sc.next();
                }

                switch (userChoice) {
                    case 1:
                        showOption2_1(movieArrayList);
                        break;
                    case 2:
                        show();
                        break;
                    case 3:
                        sc.close();
                        System.out.println("Program Terminating...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You have made an invalid selection! Please try again!");
                        break;
                }

            } while (userChoice > 3);
        }
    }


    public void showOption2_1(ArrayList<Movie> movieArrayList)
    {
        int userChoice = 0;
        do {
            int index;
            if (movieArrayList.size()==1)
                index = 1;
            else
            {
                System.out.println("Enter Movie according to index: ");
                index = sc.nextInt();
            }
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Menu --> Search Movie  --> Movie information" );
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println();
            customerUIController.showMovieInformation(movieArrayList, index-1);
            //customerUIController.showCineplexInformation(index-1);
            System.out.println("====================== Option =========================");
            System.out.println("|1. Back to Search Movie                              |");
            System.out.println("|2. Back to main menu                                 |");
            System.out.println("|3. Quit                                              |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    showOption2();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 3 | userChoice <= 0 );
    }
    public void showOption2_2()
    {
        int userChoice = 0;
        do {
            System.out.println("====================== Option =========================");
            System.out.println("|1. Back to Search Movie                              |");
            System.out.println("|2. Back to main menu                                 |");
            System.out.println("|3. Quit                                              |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    showOption2();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 3 | userChoice <= 0 );
    }

    public void showOption3(){
        int userChoice = 0;
        do {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Menu --> Cineplex List");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println();
            customerUIController.showCineplexList();
            System.out.println("====================== Option =========================");
            System.out.println("|1. Select cineplex for more details                  |");
            System.out.println("|2. Back                                              |");
            System.out.println("|3. Quit                                              |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    showOption3_1();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 3 | userChoice <= 0);
    } //similar to showOption1, just that now its for cineplex

    public void showOption3_1()
    {
        int userChoice = 0;
        do {
            System.out.println("Enter cineplex according to index: ");
            int index = sc.nextInt();
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Menu --> Cineplex List --> Cineplex information" );
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println();
            customerUIController.showCineplexInformation(index-1);
            System.out.println("====================== Option =========================");
            System.out.println("|1. Back to Cineplex list                             |");
            System.out.println("|2. Back to main menu                                 |");
            System.out.println("|3. Quit                                              |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
                System.out.print("\n");
            }
            else{
                sc.next();
            }

            switch (userChoice) {
                case 1:
                    showOption3();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    sc.close();
                    System.out.println("Program Terminating...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have made an invalid selection! Please try again!");
                    break;
            }

        } while (userChoice > 3 | userChoice <= 0 );
    }

    //for option4, give a option to go back /go back to main menu
    //-------------------------------------------------------------------------------------------------
    //get MOVIE ID pass it into customerUIController -> cineplexController -> cineplexShowing(int movieID)
    //display cineplex aval

    //display all show time for that cineplex
    //select showtime


    //show movie
    //ask which movie u want to watch?
    //get user input
    //display showtime from that list according to cineplex
    //choose showtime
    //choose num of seats
    // type of ticket for each seats (if day = weekday and time < 6pm** check for this tho and must put default)
    // choose seats
    // pass showtime, numSeats, seats, customerClass(arraylist for this) into makeBooking()
    // retreive buyers details (name, email, num etc etc)
    // confirmation display & payment
    // once confirm, add to transactions, update seat layout in showtime


    public void showOption4() //buy tickets --> split the thing up so can go back. so u select 1 shit in 1 class
    {
        ArrayList<Movie> movieArrayList = customerUIController.showMovieListAvalBooking();
        try
        {
            System.out.println("Select movie to watch: ");
            int movieIndex = sc.nextInt();
            showOption4_1(customerUIController.getMovieId(movieArrayList, movieIndex-1));
            sc.nextLine();
            showOption4_1(movieIndex);
        }
        catch (InputMismatchException mismatchInput)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            showOption4();
        }
        catch  (IndexOutOfBoundsException exception)
        {
            System.out.println("Sorry please enter a valid number");
            showOption4();
        }

    }

    public void showOption4_1(int movieId)
    {
        System.out.println("Cineplex avaliable: ");
        ArrayList<Cineplex> cineplexArrayList = customerUIController.showCineplexAval(movieId);
        try
        {
            System.out.println("Select cineplex: ");
            int cineplexIndex = sc.nextInt();
            showOption4_2(movieId, customerUIController.getCinplexId(cineplexArrayList, cineplexIndex-1));
        }
        catch (InputMismatchException mismatchInput)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            showOption4_1(movieId);
        }
        catch (IndexOutOfBoundsException exception)
        {
            System.out.println("Sorry please enter a valid number");
            sc.nextLine();
            showOption4_1(movieId);
        }
    }

    public void showOption4_2(int movieId, int cineplexId)
    {
        System.out.println("Showtime avaliable: ");
        ArrayList<ShowTime> showTimeArrayList = customerUIController.showShowTime(movieId, cineplexId);
        try
        {
            System.out.println("Select showtime: ");
            int showTimeIndex = sc.nextInt();
            ShowTime selectedShowTime = customerUIController.getShowTime(showTimeArrayList, showTimeIndex-1);
            showOption4_3(selectedShowTime);
        }
        catch (InputMismatchException mismatchInput)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            showOption4_2(movieId, cineplexId);
        }
        catch (IndexOutOfBoundsException exception)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            showOption4_2(movieId, cineplexId);
        }
        //java.util.InputMismatchException
        //IndexOutOfBoundsException2

    }

    //case for cancel booking --> go back to main menu, and then case for go back

    public void showOption4_3(ShowTime showTime)
    {
        try
        {
            System.out.println("How many tickets do u want to buy? ");
            int numTicket = sc.nextInt();
            showOption4_4(showTime, numTicket);
        }
        catch (InputMismatchException mismatchInput)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            showOption4_3(showTime);
        }
        catch (IndexOutOfBoundsException exception)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            showOption4_3(showTime);
        }
    }

    //can combine from 4_4 onwards
    public void showOption4_4(ShowTime showTime, int numTickets)
    {
        LocalTime time = LocalTime.of(18, 0);
        int numStudent=0, numSC=0;
        if (customerUIController.studentSeniorCitizenCheck(showTime))   //and not weekend / public holiday
        {
            //check if its public holiday or weekend or after 6
            try {
                while (true) {
                    System.out.println("If there is any student/senior citizen. else enter zero. ");
                    System.out.println("Number of student: ");
                    numStudent = sc.nextInt();
                    System.out.println("Number of Senior Ciziten: ");
                    numSC = sc.nextInt();
                    if (numTickets < (numStudent + numSC))
                        System.out.println("Number of students and/or senior citizen cannot exceed the number of tickets. Please re-enter again");
                    else
                        break;
                }
            }
            catch (InputMismatchException mismatchInput) {
                System.out.println("Sorry, your input is not valid. Please enter according to requirement.");
                showOption4_4(showTime, numTickets);
            }
            catch (IndexOutOfBoundsException exception) {
                System.out.println("Sorry, your input is not valid. Please enter according to requirement.");
                showOption4_4(showTime, numTickets);
            }

        }
        showOption4_5(showTime, numTickets, numStudent, numSC);
    }


    public void showOption4_5(ShowTime showTime, int numTickets, int numStudent, int numSC)
    {
        String[] seatSelected= new String[numTickets];
        char selectRow;
        int selectColumn;
        customerUIController.showLayout(showTime);
        System.out.println("Please note that the system will not allow you to leave a single occupied seat bewtween selected seats");
        try{
            for (int i=1; i<numTickets+1;i++)
            {
                System.out.println("Choose seat for ticket "+i+": ");
                sc.nextLine();
                System.out.println("Enter row (Eg. A): ");
                selectRow = sc.nextLine().charAt(0);
                System.out.println("Enter column (Eg 1): ");
                selectColumn = sc.nextInt();
                if (customerUIController.checkSeatAval(showTime, selectRow, selectColumn))
                {
                    seatSelected[i-1] = selectRow + String.valueOf(selectColumn);
                    System.out.println("seat sucessfully selected");
                    continue;
                }
                else
                    System.out.println("seat occupied, please enter again");
            }
            showOption4_6(showTime, numTickets, numStudent, numSC, seatSelected);
        }
        catch (InputMismatchException mismatchInput)
        {
            System.out.println("Sorry, your input is not valid. Please re-enter ALL seat according to requirement.");
            showOption4_5(showTime, numTickets, numStudent, numSC);
        }
        catch (IndexOutOfBoundsException exception)
        {
            System.out.println("Sorry, your input is not valid. Please re-enter ALL seat according to requirement.");
            showOption4_5(showTime, numTickets, numStudent, numSC);
        }
        //check if thr is like unoccupied seat between selected seat
       // System.out.println("All seats sucessfully selected:");
        //print out all the seats again?

    }

    //option to cancel booking
    public void showOption4_6(ShowTime showTime, int numTickets, int numStudent, int numSC, String[] seatSelected)
    {
        ArrayList<Ticket> ticketArrayList = customerUIController.generateTicket(showTime, numTickets, numStudent, numSC, seatSelected);
        //display ticket
        double totalPrice = customerUIController.calculateTotalPrice(ticketArrayList);
        System.out.printf("Total price: $ %.2f \n", totalPrice);

        //case statement

        System.out.println("Make payment: ");
        sc.nextLine();
        showOption4_7(ticketArrayList, totalPrice, seatSelected);
    }

    public void showOption4_7(ArrayList<Ticket> ticketArrayList, double totalPrice, String[] seatSelected)
    {
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter mobile number: ");
        long number = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter email address: ");
        String email = sc.nextLine();
        //ask for payment by? then total price decrease
        System.out.println("Payment in progress.....");
        System.out.println("Payment sucessful! ");
        //uncomment the next line to update dat file
        //customerUIController.updateSuccessfulPayment(name, number, email, totalPrice, ticketArrayList, seatSelected);
        //put into transaction, update showtimelayout
        show();

    }

    public void showOption5() //view booking history
    {
        //in transaction, find using user's phone num or smth
        //but for here because its a single user, can just print transaction history
    }

    public void showOption6() //rate and review --> only for movies that they watch
    {
        //find history --> how to ensure that user only review and rate once? hav a counter or smth isit --> means nid to store data?
        //rate movie OR write review for that movie
    }

    public void showOption7()
    {
        //list top5 ranking by ticket sales
        //list top5 ranking by overall reviewer's rating
    }
}
