package Entity;
import java.io.Serializable;

/**
 * @version 1
 * @since 2019-11-13
 * @typeofclass entity
 */
public class Staff implements Serializable{

    /**
     * userName for this staff
     */
    private String userName;
    /**
     * password for this staff
     */
    private String password;

    /**
     * creates staff with given userName and password
     * @param userName
     * @param password
     */
    public Staff(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * encryption of password with a secret hash function
     * @param userPassword
     * @return hashed password
     */
    public static String hashPassword(String userPassword){
        int k = userPassword.length();
        int sum = 0;
        for(int i = 0 ; i < k-1 ; i++){
            sum += userPassword.charAt(i)<<(5*i);
        }
        return String.valueOf(Math.abs(sum));
    }

    /**
     * serial version ID to match file i/o, ensures the right version is used
     */
    private static final long serialVersionUID = 4386879467427227749L;

    /**
     * get userName of this staff
     * @return userName of this staff
     */
    public String getUserName() {
        return userName;
    }

    /**
     * get password of this staff
     * @return password of this staff
     */
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
