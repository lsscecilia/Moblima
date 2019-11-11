package UI;

//import controller.StaffController;

import Controller.CineplexController;
import Controller.MovieController;
import Controller.ShowTimeController;
import Entity.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * modifier package-private
 */
class StaffUi implements ConsoleBasedInterface {
    private MovieController movieController;
    private CineplexController cineplexController;
    private ShowTimeController showTimeController;

    public StaffUi(){
        this.movieController = new MovieController();
        this.cineplexController = new CineplexController();
        this.showTimeController = new ShowTimeController();
    }

    /**
     * Allows the Staff to choose the different options
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

        //ShowTime(cineplex, movie, cinemaId, column, row, dateTime[i],layOut)
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

    public void chooseDateToAddToShowTime(int cineplexId, int cinemaId, int movieId, String time){
        Scanner sc = new Scanner(System.in);

        System.out.println("============== Choose Date For ShowTime ===============");
        System.out.println("Please enter the date in: yyyy,dd,mm");
        System.out.println("=======================================================");
        System.out.print("Please input your choice: ");

        String choice = sc.nextLine();
        System.out.print("\n");

        if(showTimeController.checkSlotAvailable(cineplexController.returnCineplexFromId(cineplexId),cineplexId,cinemaId
        ,movieId,time,choice)){
            System.out.println("Successful! New ShowTime has been added!");
        }
        else{
            System.out.println("This ShowTime slot has already been taken! :(");
        }
    }

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
            System.out.println("\n" + "To: (hhmm)");
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

    // -------------------------------------------------------OPTION 1:View All Cineplex-------------------------------------------------------


    // -------------------------------------------------------OPTION 2:Setting for All Cineplex-------------------------------------------------------
    /**
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

    /**
     * Allows user to input new movie and it's details!
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
        System.out.println("Please enter the movie type: (2D, 3D)");
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
    // -------------------------------------------------------OPTION 2:Setting for All Cineplex-------------------------------------------------------


    // -------------------------------------------------------OPTION 3:Configure System Setting-------------------------------------------------------
    public void showSettingForSystemSetting(){

    }
    // -------------------------------------------------------OPTION 3:Configure System Setting-------------------------------------------------------
}
