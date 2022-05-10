package entity;

public class User {

    private String user_name, password, department;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public User(String user_name, String password, String department) {
        this.user_name = user_name;
        this.password = password;
        this.department = department;
    }
}
