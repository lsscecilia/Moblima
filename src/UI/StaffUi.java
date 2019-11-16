package UI;

//import controller.StaffController;

import Controller.CineplexController;
import Controller.MovieController;
import Controller.PublicHolidayController;
import Controller.ShowTimeController;
import Entity.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class StaffUi implements ConsoleBasedInterface
 * StaffUi is a boundary class used as the boundary between a User's action and the program logic
 */
class StaffUi implements ConsoleBasedInterface {
    private MovieController movieController;
    private CineplexController cineplexController;
    private ShowTimeController showTimeController;
    private PublicHolidayController publicHolidayController;

    public StaffUi(){
        this.movieController = new MovieController();
        this.cineplexController = new CineplexController();
        this.showTimeController = new ShowTimeController();
        this.publicHolidayController = new PublicHolidayController();
    }

    /**
     * Serves as the Main Page for StaffUI
     * Allows the Staff to choose the different options to do different things
     * It branches off into 5 different options:
     * 1. Setting for Individual Cineplex
     * 2. Settings across All Cineplex
     * 3. Configure System Setting
     * 4. Back
     * 5. Quit
     */
    @Override
    public void show() {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("======================== STAFF ========================");
            System.out.println("| 1.  Settings for Individual Cineplex                |");
            System.out.println("| 2.  Settings across All Cineplex                    |");
            System.out.println("| 3.  Configure System Setting                        |");
            System.out.println("| 4.  Back                                            |");
            System.out.println("| 5.  Quit                                            |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();
            System.out.print("\n");

            switch (choice) {
                case 1:
                    showAllCineplex();
                    break;
                case 2:
                    showSettingForAllCineplex();
                    break;
                case 3:
                    showSettingForSystemSetting();
                    break;
                case 4:
                    //break
                    break;
                case 5:
                    sc.close();
                    System.out.println("Program terminating...");
                    System.exit(0);
                    break;

                default:
                    break;
            }

        } while (choice != 4);
    }


    // -------------------------------------------------------OPTION 1:View All Cineplex-------------------------------------------------------

    /**
     * From Branch 1
     * Shows All Cineplex available
     */
    public void showAllCineplex(){
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("=============== All Cineplex Information ==============");
            cineplexController.displayAllCineplexInfo();
            System.out.println("4.  Back");
            System.out.println("5.  Quit");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();
            System.out.print("\n");

            switch (choice) {
                case 1:
                    displayIndividualCineplex(choice);
                    break;
                case 2:
                    displayIndividualCineplex(choice);
                    break;
                case 3:
                    displayIndividualCineplex(choice);
                    break;
                case 4:
                    break;
                case 5:
                    sc.close();
                    System.out.println("Program terminating...");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (choice != 4);
    }

    /**
     * From Branch 1
     * Displays individual Cineplex
     * Allows Staff to change details in Cineplex such as:
     * 1. Add/Modify/Remove Movie
     * 2. Add/Modify/Remove ShowTime
     * @param cineplexId
     */
    public void displayIndividualCineplex(int cineplexId){
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("================= Cineplex Information ================");
            cineplexController.viewCineplex(cineplexId);
            System.out.println("\n" + "1.  Add new Movie.");
            System.out.println("2.  Remove Movie.");
            System.out.println("3.  Add new ShowTime!");
            System.out.println("4.  Modify ShowTime");
            System.out.println("5.  Remove ShowTime");
            System.out.println("6.  Back");
            System.out.println("7.  Quit");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();
            System.out.print("\n");

            switch (choice) {
                case 1:
                    addNewMovieInCineplex(cineplexId);
                    break;
                case 2:
                    removeExistingMovieInCineplex(cineplexId);
                    break;
                case 3:
                    addNewShowTimeInCineplex(cineplexId);
                    break;
                case 4:
                    modifyExistingShowTimeInCineplex(cineplexId);
                    break;
                case 5:
                    removeExistingShowTime(cineplexId);
                    break;
                case 6:
                    break;
                case 7:
                    sc.close();
                    System.out.println("Program terminating...");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (choice != 6);
    }
    // ------------------Add/Modify/Remove Movie------------------
    /**
     * From Branch 1
     * Allows Staff to choose to Add New Movie Inside Cineplex
     * @param cineplexID
     */
    public void addNewMovieInCineplex(int cineplexID){
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        System.out.println("======================= Add New Movie ======================");
        System.out.println("Choose a movie to add to this cineplex! (Enter the Movie ID!)");
        movieController.printMovieIdAndTitle();
        System.out.println("============================================================");
        System.out.print("Please input your choice: ");
        System.out.print("\n");

        choice = sc.nextInt();
        sc.nextLine();
        if(cineplexController.addMovieToCineplex(cineplexID, movieController.returnMovieFromId(choice))){
            System.out.println("Movie successfully added!");
        }
        else{
            System.out.println("Something went wrong :(");
        }
    }

    /**
     * From Branch 1
     * Allows Staff to choose to remove existing movie inside Cineplex
     * @param cineplexId
     */
    public void removeExistingMovieInCineplex(int cineplexId){
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        System.out.println("================ Remove Existing Movie ================");
        System.out.println("These are the following Movies Available: " + "\n");
        cineplexController.displayAllMoviesShowingInCineplex(cineplexId);
        System.out.println("============================================================");
        System.out.print("Please input your choice: ");
        System.out.print("\n");

        choice = sc.nextInt();
        sc.nextLine();
        if(cineplexController.removeMovieFromCineplex(choice,cineplexId)){
            System.out.println("Movie successfully removed!");
        }
        else{
            System.out.println("Something went wrong :(");
        }
    }

    // ------------------Add/Modify/Remove Movie------------------

    // ------------------Add/Modify/Remove ShowTime------------------
    /**
     * From Branch 1
     * Allows Staff to choose to add new ShowTime
     * @param cineplexId
     */
    public void addNewShowTimeInCineplex(int cineplexId){
        Scanner sc = new Scanner(System.in);

        System.out.println("================== Add New ShowTime! ==================");
        cineplexController.displayCinema(cineplexId);
        System.out.println("1.  Cinema ID 1");
        System.out.println("2.  Cinema ID 2");
        System.out.println("3.  Cinema ID 3");
        System.out.println("=======================================================");
        System.out.print("Please input your choice: ");

        int choice = sc.nextInt();
        System.out.print("\n");
        chooseMovieToAddToShowTime(cineplexId,choice);
    }

    /**
     * From Branch 1
     * Allows staff to choose what movies to add into Cineplex based on the company's movie collection
     * @param cineplexId
     * @param cinemaId
     */
    public void chooseMovieToAddToShowTime(int cineplexId, int cinemaId){
        Scanner sc = new Scanner(System.in);
        System.out.println("================= Choose Movie To Add =================");
        cineplexController.displayAllMoviesShowingInCineplex(cineplexId);
        System.out.println("0.  Back");
        System.out.println("=======================================================");
        System.out.print("Please input your choice: ");


        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("\n");

        if(choice == 0){

        }
        else{
            chooseTimeSlotToAddToShowTime(cineplexId,cinemaId,choice);
        }
    }

    /**
     * From Branch 1
     * Allows Staff to choose which TimeSlot for each showTime
     * @param cineplexId
     * @param cinemaId
     * @param movieId
     */
    public void chooseTimeSlotToAddToShowTime(int cineplexId, int cinemaId, int movieId){
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        System.out.println("================== Choose Time Slot! ==================");
        System.out.println("1.  10:00");
        System.out.println("2.  13:00");
        System.out.println("3.  16:00");
        System.out.println("4.  19:00");
        System.out.println("5.  22:00");
        System.out.println("=======================================================");
        System.out.print("Please input your choice: ");

        choice = sc.nextInt();
        System.out.print("\n");

        switch (choice) {
            case 1:
                chooseDateToAddToShowTime(cineplexId,cinemaId,movieId,",10,00");
                break;
            case 2:
                chooseDateToAddToShowTime(cineplexId,cinemaId,movieId,",13,00");
                break;
            case 3:
                chooseDateToAddToShowTime(cineplexId,cinemaId,movieId,",16,00");
                break;
            case 4:
                chooseDateToAddToShowTime(cineplexId,cinemaId,movieId,",19,00");
                break;
            case 5:
                chooseDateToAddToShowTime(cineplexId,cinemaId,movieId,",22,00");
                break;
            default:
                break;
        }
    }

    /**
     * From Branch 1
     * Allows Staff to choose the date for each showTime
     * @param cineplexId
     * @param cinemaId
     * @param movieId
     * @param time
     */
    public void chooseDateToAddToShowTime(int cineplexId, int cinemaId, int movieId, String time){
        Scanner sc = new Scanner(System.in);

        System.out.println("============== Choose Date For ShowTime ===============");
        System.out.println("Please enter the date in: yyyy,mm,dd");
        System.out.println("=======================================================");
        System.out.print("Please input your choice: ");

        String choice = sc.nextLine();
        System.out.print("\n");

        if(showTimeController.addNewShowTime(cineplexController.returnCineplexFromId(cineplexId),cineplexId,cinemaId
        ,movieId,time,choice)){
            System.out.println("Successful! New ShowTime has been added!");
        }
        else{
            System.out.println("This ShowTime slot has already been taken! :(");
        }
    }

    /**
     * From Branch 1
     * Allows Staff to choose which Hall to modify existing ShowTime
     * @param cineplexId
     */
    public void modifyExistingShowTimeInCineplex(int cineplexId){
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        System.out.println("============== Modify Existing ShowTime! =============");
        System.out.println("1.  Cinema Hall 1");
        System.out.println("2.  Cinema Hall 2");
        System.out.println("3.  Cinema Hall 3");
        System.out.println("4.  Back");
        System.out.println("5.  Quit");
        System.out.println("=======================================================");
        System.out.print("Please input your choice: ");

        choice = sc.nextInt();
        System.out.print("\n");

        switch (choice) {
            case 1:
            case 2:
            case 3:
                chooseShowTimeFromCinema(cineplexId,choice);
                break;
            case 4:
                break;
            case 5:
                sc.close();
                System.out.println("Program terminating...");
                System.exit(0);
            default:
                break;
        }
    }

    /**
     * From Branch 1
     * ALlows Staff to choose which ShowTime from which Cinema to modify
     * @param cineplexId
     * @param cinemaId
     */
    public void chooseShowTimeFromCinema(int cineplexId, int cinemaId){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("============== Choose ShowTime To Modify! =============");
        showTimeController.displayAllShowTime(cineplexId,cinemaId);
        System.out.println("=======================================================");
        System.out.println("Which ShowTime would you like to modify?");
        choice = sc.nextInt();
        System.out.print("\n");
        chooseAttributeToModifyShowTime(cineplexId,cinemaId,choice-1);

    }

    /**
     * From Branch 1
     * Allows Staff to choose which Attributes inside ShowTime to modify
     * @param cineplexId
     * @param cinemaId
     * @param showTimeIndex
     */
    public void chooseAttributeToModifyShowTime(int cineplexId, int cinemaId, int showTimeIndex){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("================ Choose Item To Modify! ===============");
        System.out.println("You have selected: " + "\n");
        showTimeController.displaySpecificShowTime(cineplexId,cinemaId,showTimeIndex);
        System.out.println("1. Change Movie");
        System.out.println("2. Change Date");
        System.out.println("3. Change Time");
        System.out.println("=======================================================");
        System.out.println("What would you like to change?");
        choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1){
            System.out.println("You are changing from: ");
            showTimeController.displaySpecificAttributeInShowTime(cineplexId, cinemaId, showTimeIndex,choice);
            System.out.println("\n" + "To: ");
            cineplexController.displayAllMoviesShowingInCineplex(cineplexId);
            int movieChoice = sc.nextInt();
            sc.nextLine();
            try{
                showTimeController.modifyMovieInShowTime(cineplexId, cinemaId, showTimeIndex, movieChoice);
                System.out.println("Successfully modified Movie!");
            }
            catch(Exception e){

            }

        }
        else if(choice == 2){ //change date
            System.out.println("You are changing from: ");
            showTimeController.displaySpecificAttributeInShowTime(cineplexId, cinemaId, showTimeIndex,choice);
            System.out.println("\n" + "To: (yyyy-dd-mm)");
            String date = sc.nextLine();
            try{
                showTimeController.modifyDateInShowTime(cineplexId, cinemaId, showTimeIndex, date);
                System.out.println("Successfully modified Date!");
            }
            catch(Exception e){

            }

        }
        else if(choice == 3){ //change time
            System.out.println("You are changing from: ");
            showTimeController.displaySpecificAttributeInShowTime(cineplexId, cinemaId, showTimeIndex,choice);
            System.out.println("\n" + "To: (hhmm) [1000, 1300, 1600, 1900, 2200]");
            String time = sc.nextLine();
            try {
                time = time.substring(0, 2) + "-" + time.substring(2,4);
                showTimeController.modifyTimeInShowTime(cineplexId,cinemaId,showTimeIndex,time);
                System.out.println("Successfully modified Time!");
            }
            catch(Exception e){

            }
        }
    }

    /**
     * From Branch 1
     * Allows Staff to choose which ShowTime to remove from which hall
     * @param cineplexId
     */
    public void removeExistingShowTime(int cineplexId){
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        System.out.println("============== Remove Existing ShowTime! =============");
        System.out.println("1.  Cinema Hall 1");
        System.out.println("2.  Cinema Hall 2");
        System.out.println("3.  Cinema Hall 3");
        System.out.println("4.  Back");
        System.out.println("5.  Quit");
        System.out.println("=======================================================");
        System.out.print("Please input your choice: ");

        choice = sc.nextInt();
        System.out.print("\n");

        switch (choice) {
            case 1:
            case 2:
            case 3:
                chooseShowTimeToRemoveFromCinema(cineplexId,choice);
                break;
            case 4:
                break;
            case 5:
                sc.close();
                System.out.println("Program terminating...");
                System.exit(0);
            default:
                break;
        }
    }

    /**
     * From Branch 1
     * Allows Staff to choose which ShowTime to remove from a selected cinema hall
     * @param cineplexId
     * @param cinemaId
     */
    public void chooseShowTimeToRemoveFromCinema(int cineplexId, int cinemaId){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("============== Choose ShowTime To Remove! =============");
        showTimeController.displayAllShowTime(cineplexId,cinemaId);
        System.out.println("=======================================================");
        System.out.println("Which ShowTime would you like to Remove?");
        choice = sc.nextInt();
        System.out.print("\n");
        removeShowTimePreview(cineplexId,cinemaId,choice-1);
    }

    /**
     * From Branch 1
     * Double checks with the Staff on whether he really wants to delete this ShowTime
     * @param cineplexId
     * @param cinemaId
     * @param showTimeIndex
     */
    public void removeShowTimePreview(int cineplexId, int cinemaId, int showTimeIndex){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("================ Confirm Removal! ===============");
        System.out.println("You have selected: " + "\n");
        showTimeController.displaySpecificShowTime(cineplexId,cinemaId,showTimeIndex);
        System.out.println("=======================================================");
        System.out.println("What would you like to remove it? (Warning! This move cannot be reversed!)");
        System.out.println("1. Delete");
        System.out.println("2. Cancel");
        choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1){
            try{
                showTimeController.removeShowTime(cineplexId,cinemaId,showTimeIndex);
                System.out.println("You have successfully removed this ShowTime!");
            }
            catch (Exception e){

            }
        }
        else{
            System.out.println("Removal Cancelled!");
        }
    }
    // ------------------Add/Modify/Remove ShowTime------------------
    // -------------------------------------------------------OPTION 1:View All Cineplex-------------------------------------------------------


    // -------------------------------------------------------OPTION 2:Setting for All Cineplex-------------------------------------------------------
    /**
     * From Branch 2
     * UI display for "Setting for all Cineplex"
     * Allows Staff to Add new movie, Remove existing movie, Update existing movie detail
     */
    public void showSettingForAllCineplex(){
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("=============== Setting for All Cineplex ==============");
            System.out.println("| 1.  Add new movie                                   |");
            System.out.println("| 2.  Remove existing movie                           |");
            System.out.println("| 3.  Update existing movie detail                    |");
            System.out.println("| 4.  Back                                            |");
            System.out.println("| 5.  Quit                                            |");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();
            System.out.print("\n");

            switch (choice) {
                case 1:
                    addNewMovie();
                    break;
                case 2:
                    removeExistingMovie();
                    break;
                case 3:
                    updateExistingMovieDetail();
                    break;
                case 4:
                    //back
                    break;
                case 5:
                    sc.close();
                    System.out.println("Program terminating...");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (choice != 4);
    }
    // ------------------Add/Modify/Remove Movie------------------
    /**
     * From branch 2
     * Allows user to input new movie to company and it's details!
     */
    public void addNewMovie(){
        Scanner sc = new Scanner(System.in);

        int movieId;
        String movieTitle;
        String movieStatus;
        String movieSynopsis;
        String movieDirector;
        String movieCast;
        String movieRating;
        String movieDuration;
        String movieType;
        ArrayList<Review> movieReviews = new ArrayList<>();

        System.out.println("==================== Add New Movie ====================");
        System.out.println("Please enter the Movie ID (Integer):");
        movieId = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the Movie Title:");
        movieTitle = sc.nextLine();
        System.out.println("Please enter the Movie Status (Coming Soon, Preview, Now Showing):");
        movieStatus = sc.nextLine();
        System.out.println("Please enter the Movie Synopsis:");
        movieSynopsis = sc.nextLine();
        System.out.println("Please enter the Movie Director:");
        movieDirector = sc.nextLine();
        System.out.println("Please enter the Movie Cast(s) (Split by comma):");
        movieCast = sc.nextLine();
        System.out.println("Please enter the Movie Rating [PG13, NC16, M18, R21]:");
        movieRating = sc.nextLine();
        System.out.println("Please enter the movie duration: (in mins)");
        movieDuration = sc.nextLine();
        System.out.println("Please enter the movie type: [2D, 3D, 2D Blockbuster, 3D Blockbuster]");
        movieType = sc.next();

         while(true){
             System.out.println("Do you wish to enter additional reviews? (Y/N)");
             if(sc.next().equalsIgnoreCase("Y")){
                 System.out.println("Enter your rating, (1-5):");
                 int userRating = sc.nextInt();
                 sc.nextLine();
                 System.out.println("Enter your review!:");
                 String userReview = sc.nextLine();

                 movieReviews.add(new Review(userReview, userRating));
             }
             else{
                 break;
             }
         }

        Movie movie = new Movie(movieId
                               , movieTitle
                               , movieStatus
                               , movieSynopsis
                               , movieDirector
                               , movieCast
                               , movieRating
                               , movieDuration
                               , movieType
                               , movieReviews);


        if(movieController.addNewMovie(movie)){
            System.out.println("\n" + "New Movie has been successfully created!");
        }
        else{
            System.out.println("\n" + "Sorry, something went wrong! :(");
        }
        System.out.println("========================================================" + "\n");
    }

    /**
     * From Branch 2
     * Allows Staff Admin to remove Movie based on MovieID or MovieTitle.
     */
    public void removeExistingMovie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("================ Remove Existing Movie ================");
        System.out.println("These are the following Movies Available: " + "\n");
        if(!movieController.isEmpty()){
            movieController.viewAllMovie();
            System.out.println("\n" + "Please enter the movie ID that you wish to delete! (Enter 0 to cancel)");
            int userChoice = sc.nextInt();
            if(userChoice != 0){
                if(movieController.removeMovieById(userChoice)){
                    System.out.println("The movie has been successfully removed!");
                }
                else{
                    System.out.println("Sorry, something went wrong! :(");
                }
            }
            else{
                System.out.println("You have chosen to exit!");
            }
            System.out.println("========================================================" + "\n");
        }
        else{
            System.out.println("There is no movie available! :( Please add new movies!" + "\n");
        }
    }

    /**
     * From Branch 2
     * Allows staff to update existing movie details
     */
    public void updateExistingMovieDetail(){
        Scanner sc = new Scanner(System.in);
        System.out.println("================ Update Existing Movie ================");
        movieController.viewAllMovie();
        System.out.println("Which Movie would you like to update? (Enter 0 to cancel)");
        int chosenMovieId = sc.nextInt();
        sc.nextLine();
        if(chosenMovieId != 0){
            System.out.println("Which portion would you like to update? (Enter 0 to cancel)");
            System.out.println("1. Movie ID");
            System.out.println("2. Movie Title");
            System.out.println("3. Movie Status");
            System.out.println("4. Movie Synopsis");
            System.out.println("5. Movie Director");
            System.out.println("6. Movie Cast");
            System.out.println("7. Movie Rating");
            System.out.println("8. Movie Duration");
            System.out.println("9. Movie Type");
            int chosenIndex = sc.nextInt();
            sc.nextLine();

            if(chosenIndex != 0){
                System.out.println("You are changing: ");
                movieController.printIndex(chosenMovieId, chosenIndex);
                System.out.println("To: ");
                String changedString = sc.nextLine();
                movieController.updateExistingMovieDetail(chosenMovieId, chosenIndex, changedString);
                System.out.println("You have successfully updated Movie ID " + chosenMovieId + "!");
            }
            else{
                System.out.println("You have chosen to exit!");
            }
        }
        else{
            System.out.println("You have chosen to exit!");
        }
        System.out.println("========================================================" + "\n");
    }
    // ------------------Add/Modify/Remove Movie------------------
    // -------------------------------------------------------OPTION 2:Setting for All Cineplex-------------------------------------------------------


    // -------------------------------------------------------OPTION 3:Configure System Setting-------------------------------------------------------

    /**
     * From Branch 3
     */
    public void showSettingForSystemSetting(){
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("==================== System Setting ===================");
            System.out.println("1.  View All Public Holiday");
            System.out.println("2.  Add new Public Holiday.");
            System.out.println("3.  Remove Public Holiday");
            System.out.println("4.  Back");
            System.out.println("5.  Quit");
            System.out.println("=======================================================");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();
            System.out.print("\n");

            switch (choice) {
                case 1:
                    displayAllPublicHoliday();
                    break;
                case 2:
                    addNewPublicHoliday();
                    break;
                case 3:
                    removePublicHoliday();
                    break;
                case 4:
                    break;
                case 5:
                    sc.close();
                    System.out.println("Program terminating...");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (choice != 4);
    }

    /**
     * From Branch 3
     * Calls PublicHolidayController to displays all public holiday
     */
    public void displayAllPublicHoliday(){
        System.out.println("================ Display Public Holiday ===============");
        publicHolidayController.displayAllPublicHoliday();
        System.out.println("=======================================================");
        System.out.println();
    }

    /**
     * From Branch 3
     * Allows Staff to add new public holiday
     */
    public void addNewPublicHoliday(){
        Scanner sc = new Scanner(System.in);
        System.out.println("================ Add New Public Holiday ===============");
        System.out.println("Please enter the Holiday name!");
        String holidayName = sc.nextLine();
        System.out.println("Please enter the date! (yyyy,mm,dd)"); // LocalDate.of(year,month,dayOfMonth)
        String date = sc.nextLine();

        try{
            publicHolidayController.addNewPublicHoliday(holidayName,date);
            System.out.println("Successfully added Public Holiday!");
        }
        catch (Exception e){

        }
        System.out.println("=======================================================");
    }

    /**
     * From Branch 3
     * Calls PublicHolidayController to remove Public Holiday
     */
    public void removePublicHoliday(){
        Scanner sc = new Scanner(System.in);
        System.out.println("================ Remove Public Holiday ===============");
        publicHolidayController.displayAllPublicHoliday();
        System.out.println("=======================================================");
        int choice = sc.nextInt();
        try{
            if(publicHolidayController.removePublicHoliday(choice-1)){
                System.out.println("Successfully removed Public Holiday!");
            }
            else{
                System.out.println("An error occurred! ;(");
            }
        }
        catch (Exception e){

        }
    }

    // -------------------------------------------------------OPTION 3:Configure System Setting-------------------------------------------------------
}
