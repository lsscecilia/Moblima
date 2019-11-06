package Controller;

import Entity.Staff;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffController implements ControllerInterface {

    private ArrayList<Staff> staffArrayList;
    private HandlerInterface database;

    public StaffController(){
        this.staffArrayList = new ArrayList<>();
        this.database = new DataHandler();
    }


    @Override
    public void display() {

    }

    @Override
    public void updateDat() {

    }

    /**
     * Adds new Staff to access the system.
     * Remember to hash the password when creating new staff.
     * Staff newStaff = new Staff(Username, Staff.hashPassword(password))
     * @param staff
     * @return
     */
    public boolean addNewStaff(Staff staff){
        for(Staff s : staffArrayList){
            if(staff.getUserName().equals(s.getUserName())){
                return false;
            }
        }
        staffArrayList.add(staff);
        setArrayList(staffArrayList);
        return true;
    }

    /**
     * Checks whether the username and password is valid
     * @param
     * @return boolean on whether the Staff's credential is authentic
     */
    public boolean authenticateStaff(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Staff Login =====");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        Staff staff = new Staff(username, Staff.hashPassword(password));

        for(Staff s : staffArrayList){
            if(staff.getUserName().equals(s.getUserName()) && staff.getPassword().equals(s.getPassword())){
                System.out.println("Welcome back, " + staff.getUserName() + "!" + "\n");
                return true;
            }
        }
        return false;
    }
}
