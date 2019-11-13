package UI;

import Controller.CustomerUIController;
import Entity.*;

import java.time.LocalTime;
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
        MoblimaApp application = new MoblimaApp();
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
            System.out.println("|9. Quit                                              |");
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
                    showMovie();
                    break;
                case 2:
                    searchMovie();
                    break;
                case 3:
                    showCineplex();
                    break;
                case 4:
                    bookTicket();
                    break;
                case 5:
                    viewBookingHistory();
                    break;
                case 6:
                    reviewMovie();
                    break;
                case 7:
                    movieRecommendation();
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

        } while (userChoice > 9 || userChoice<1);

    }

    public void showMovie()
    {
        listMovie();
    }

    public void listMovie()
    {
        try
        {
            int userChoice = 0;
            do {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Menu --> Movie List");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println();
            customerUIController.showMovieList();
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
                    selectMovie();
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
        } catch (InputMismatchException | IndexOutOfBoundsException mismatchInput)
        {
            System.out.println("You have made an invalid selection! Please try again!");
            sc.nextLine();
            listMovie();
        }
    }

    public void selectMovie()
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
                    listMovie();
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

    private void searchMovie()
    {
        inputSearchMovie();
    }

    private void inputSearchMovie()
    {
        System.out.println("Enter movie to search: ");
        sc.nextLine();
        String search = sc.nextLine();
        //search
        ArrayList<Movie> movieArrayList = customerUIController.showSearchMovieResult(search);
        boolean empty = customerUIController.noResultFound(movieArrayList);
        if (empty)
        {
            emptySearchResult();
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
                        selectMovieSearchResult(movieArrayList);
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

            } while (userChoice > 3 | userChoice < 1);
        }
    }


    private void selectMovieSearchResult(ArrayList<Movie> movieArrayList)
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
                    inputSearchMovie();
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
    private void emptySearchResult()
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
                    inputSearchMovie();
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


    private void showCineplex()
    {
        listCineplex();
    }

    private void listCineplex(){
        int userChoice = 0;
        try
        {
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
                        selectCineplex();
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
        }catch (InputMismatchException | IndexOutOfBoundsException mismatchInput)
        {
            System.out.println("You have made an invalid selection! Please try again!");
            sc.nextLine();
            listCineplex();
        }

    } //similar to showOption1, just that now its for cineplex

    private void selectCineplex()
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
                    listCineplex();
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

    private void bookTicket()
    {
        selectMovieBookTicket();
    }

    private void selectMovieBookTicket() //buy tickets --> split the thing up so can go back. so u select 1 shit in 1 class
    {
        ArrayList<Movie> movieArrayList = customerUIController.showMovieListAvalBooking();
        try
        {
            System.out.println("Select movie to watch: ");
            int movieIndex = sc.nextInt();
            sc.nextLine();
            selectCineplexBookTicket(customerUIController.getMovieId(movieArrayList, movieIndex-1));

        }
        catch (InputMismatchException mismatchInput)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            selectMovieBookTicket();
        }
        catch  (IndexOutOfBoundsException exception)
        {
            System.out.println("Sorry please enter a valid number");
            selectMovieBookTicket();
        }
    }


    private void selectCineplexBookTicket(int movieId)
    {
        System.out.println("Cineplex avaliable: ");
        ArrayList<Cineplex> cineplexArrayList = customerUIController.showCineplexAval(movieId);

        try
        {
            System.out.println("Select cineplex: ");
            int cineplexIndex = sc.nextInt();
            selectShowTimeBookTicket(movieId,customerUIController.getCineplexId(cineplexArrayList, cineplexIndex-1));
        }
        catch (InputMismatchException mismatchInput)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            selectCineplexBookTicket(movieId);
        }
        catch (IndexOutOfBoundsException exception)
        {
            System.out.println("Sorry please enter a valid number");
            sc.nextLine();
            selectCineplexBookTicket(movieId);
        }
    }

    private void selectShowTimeBookTicket(int movieId, int cineplexId)
    {
        int userChoice = 0;
        System.out.println("Showtime avaliable: ");
        ArrayList<ShowTime> showTimeArrayList = customerUIController.showShowTime(movieId,cineplexId);
        try
        {
            do {
                System.out.println("====================== Option =========================");
                System.out.println("|1. Continue to order tickets                         |");
                System.out.println("|2. Back to choose different cineplex                 |");
                System.out.println("|3. Back to main menu                                 |");
                System.out.println("|4. Quit                                              |");
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
                        System.out.println("Select showtime: ");
                        int showTimeIndex = sc.nextInt();
                        ShowTime selectedShowTime = customerUIController.getShowTime(showTimeArrayList, showTimeIndex-1);
                        selectNumOfTicketBookTicket(selectedShowTime);
                        break;
                    case 2:
                        selectCineplexBookTicket(movieId);
                    case 3:
                        show();
                        break;
                    case 4:
                        sc.close();
                        System.out.println("Program Terminating...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You have made an invalid selection! Please try again!");
                        break;
                }

            } while (userChoice > 4 | userChoice <= 0 );
        }
        catch (InputMismatchException | IndexOutOfBoundsException mismatchInput)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            selectShowTimeBookTicket(movieId, cineplexId);
        }
    }

    //case for cancel booking --> go back to main menu, and then case for go back

    public void selectNumOfTicketBookTicket(ShowTime showTime)
    {
        try
        {
            System.out.println("How many tickets do u want to buy? ");
            int numTicket = sc.nextInt();
            int numSeatAval = customerUIController.numAvalSeats(showTime);
            if (numTicket > numSeatAval)
            {
                System.out.println("Sorry, there are not enough seats. (only " + numSeatAval+") Please choose a different showtime.");
                selectShowTimeBookTicket(showTime.getMovie().getMovieId(), showTime.getCineplex().getCineplexID());
            }
            enterStudentOrSeniorCitizenBookTicket(showTime, numTicket);
            //check
        }
        catch (InputMismatchException mismatchInput)
        {
            System.out.println("Sorry, please enter a valid number");
            sc.nextLine();
            selectNumOfTicketBookTicket(showTime);
        }
        catch (IndexOutOfBoundsException exception)
        {
            int numSeatAval = customerUIController.numAvalSeats(showTime);
            System.out.println("Sorry, there are not enough seats. (only )" + numSeatAval+" Please choose a different showtime.");
            sc.nextLine();
            selectNumOfTicketBookTicket(showTime);
        }
    }

    //can combine from 4_4 onwards
    public void enterStudentOrSeniorCitizenBookTicket(ShowTime showTime, int numTickets)
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
            catch (InputMismatchException | IndexOutOfBoundsException mismatchInput) {
                System.out.println("Sorry, your input is not valid. Please enter according to requirement.");
                enterStudentOrSeniorCitizenBookTicket(showTime, numTickets);
            }

        }
        sc.nextLine();
        chooseSeatBookTicket(showTime, numTickets, numStudent, numSC);
    }


    private void chooseSeatBookTicket(ShowTime showTime, int numTickets, int numStudent, int numSC)
    {
        String[] seatSelected= new String[numTickets];
        char selectRow;
        int selectColumn;
        String checker;
        customerUIController.showLayout(showTime);
        System.out.println("Please note that the system will not allow you to leave a single seat bewtween selected seats");
        try{
            for (int i=1; i<numTickets+1;i++)
            {
                while (true)
                {
                    System.out.println("Choose seat for ticket "+i+": ");
                    System.out.println("Enter row (Eg. A): ");
                    checker = sc.nextLine();
                    if (checker.length()!=1)
                    {
                        throw new InputMismatchException();
                    }
                    selectRow = checker.charAt(0);
                    selectRow = Character.toUpperCase(selectRow);
                    System.out.println("Enter column (Eg 1): ");
                    selectColumn = sc.nextInt();
                    if (customerUIController.checkSeatAval(showTime, selectRow, selectColumn))
                    {
                        seatSelected[i-1] = selectRow + String.valueOf(selectColumn);
                        if (i+1!=numTickets+1)
                            sc.nextLine();
                        break;
                    }
                    else
                        System.out.println("seat occupied, please enter again");
                    sc.nextLine();
                }

            }
            if (!customerUIController.checkNoDuplicateSeat(seatSelected))
            {
                System.out.println("Sorry, u cannot book a seat twice. Please re-choose seats ");
                sc.nextLine();
                chooseSeatBookTicket(showTime, numTickets, numStudent, numSC);
            }

            if (customerUIController.checkSingleSeat(seatSelected, showTime, numTickets))
            {
                System.out.println("seat sucessfully selected. ('u' represents the seats u selected) ");
                showTicketBookTicket(showTime, numTickets, numStudent, numSC, seatSelected);
            }
            else
            {
                System.out.println("Please re-choose seats. System will not allow you to leave a single seat bewtween " +
                        "selected seats");
                sc.nextLine();
                chooseSeatBookTicket(showTime, numTickets, numStudent, numSC);
            }
        }
        catch (InputMismatchException | IndexOutOfBoundsException mismatchInput)
        {
            System.out.println("Sorry, your input is not valid. Please re-enter ALL seat according to requirement.");
            chooseSeatBookTicket(showTime, numTickets, numStudent, numSC);
        }
    }


    public void showTicketBookTicket(ShowTime showTime, int numTickets, int numStudent, int numSC, String[] seatSelected)
    {
        ArrayList<Ticket> ticketArrayList = customerUIController.generateTicket(showTime, numTickets, numStudent, numSC, seatSelected);
        //display ticket
        double totalPrice = customerUIController.calculateTotalPrice(ticketArrayList);
        System.out.printf("Total price: $ %.2f \n", totalPrice);
        int userChoice = 0;
        do {
            System.out.println("====================== Option =========================");
            System.out.println("|1. Proceed to payment                                |");
            System.out.println("|2. Cancel booking (Back to main menu)                |");
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
                    sc.nextLine();
                    enterPurchaserDetailsBookTicket(ticketArrayList, totalPrice, seatSelected);
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

        //case statement
    }

    public void enterPurchaserDetailsBookTicket(ArrayList<Ticket> ticketArrayList, double totalPrice, String[] seatSelected)
    {
        try{
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
            customerUIController.updateSuccessfulPayment(name, number, email, totalPrice, ticketArrayList, seatSelected);
            //put into transaction, update showtimelayout
            show();
        }
        catch (InputMismatchException | IndexOutOfBoundsException mismatchInput)
        {
            System.out.println("Sorry, your input is not valid. Please enter ur name/mobile number/email correctly");
            sc.nextLine();
            enterPurchaserDetailsBookTicket(ticketArrayList, totalPrice, seatSelected);
        }
    }


    public void viewBookingHistory() //view booking history
    {
        System.out.println("Please enter ur phone number: ");
        try
        {
            Long num = sc.nextLong();
            customerUIController.showBookingHistory(num);
            show();
        } catch (InputMismatchException mismatchInput)
        {
            System.out.println("Number invalid, please re-enter");
            sc.nextLine();
            viewBookingHistory();
        }
    }

    public void reviewMovie()
    {
        inputNumberReviewMovie();
    }

    public void inputNumberReviewMovie() //rate and review --> only for movies that they watch
    {
        System.out.println("Please enter ur phone number: ");
        try
        {
            Long num = sc.nextLong();
            ArrayList<Transaction> transactionArrayList = customerUIController.retrieveMovieToReview(num);
            if (transactionArrayList.isEmpty())
                show();
            else
                selectMovieReview(num, transactionArrayList);
        }
        catch (InputMismatchException mismatchInput)
        {
            System.out.println("Number invalid, please re-enter");
            sc.nextLine();
            inputNumberReviewMovie();
        }
    }

    public void selectMovieReview(long num, ArrayList<Transaction> transactions)
    {
        try
        {
            System.out.println("Please select which movie to review: ");
            int index = sc.nextInt();
            if (customerUIController.eligibleToReview(transactions.get(index-1)))
            {
                sc.nextLine();
                enterReview(transactions.get(index-1).getTicketArrayList().get(0).getShowTime().getMovie().getMovieId());
            }
            else
                System.out.println("Sorry, u had already submit review (with n tickets, u can submit a max of n reviews only)");

        }catch (InputMismatchException | IndexOutOfBoundsException mismatchInput)
        {
            System.out.println("Number invalid, please re-enter");
            sc.nextLine();
            selectMovieReview(num, transactions);
        }
    }

    public void enterReview(int movieId)
    {
        int ratings;
        System.out.println("Please enter ur review: ");
        String reviewComment = sc.nextLine();
        try
        {
            while (true)
            {
                System.out.println("Enter ratings (1-5) ");
                ratings = sc.nextInt();
                if ((ratings>0) & (ratings <=5))
                {
                    break;
                }
                else
                    System.out.println("Sorry please enter in the range of 1-5");
            }
            customerUIController.submitReview(movieId, reviewComment, ratings);
            System.out.println("Review submitted! ");
        }catch (InputMismatchException | IndexOutOfBoundsException mismatchInput)
        {
            System.out.println("Sorry, your input is invalid, please re-according to the requirements");
            enterReview(movieId);
        }
        show();
    }

    public void movieRecommendation()
    {
        System.out.println("Top 5 ranking by ticket sales!");
        customerUIController.showTop5MovieByTicketSales();
        System.out.println();
        System.out.println("Top 5 ranking by overall reviewer's rating! ");
        customerUIController.showTop5MovieByRatings();
        show();
    }
}