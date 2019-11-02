package entity;

public class Staff {
    private String userName;
    private String password;

    public Staff(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public static String hashPassword(String userPassword){
        int k = userPassword.length();
        int sum = 0;
        for(int i = 0 ; i < k-1 ; i++){
            sum += userPassword.charAt(i)<<(5*i);
        }
        return String.valueOf(Math.abs(sum));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Staff{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
