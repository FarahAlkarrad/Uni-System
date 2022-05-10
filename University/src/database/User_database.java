package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.User;
import java.sql.ResultSet;

public class User_database {

    //I make all methods static because I didn't want to implements any objects in other classes.
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_user(String user, String pass, String depart) {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("insert into user values(?,?,?)");) {
            p.setString(1, user);
            p.setString(2, pass);
            p.setString(3, depart);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<User> get_data_user() {
        ArrayList<User> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from user");) {
            ResultSet result = p.executeQuery();
            while (result.next()) {
                list.add(new User(result.getString("user_name"), result.getString("password"), result.getString("department")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static int check_user(String user, String pass) {
        ArrayList<User> list = get_data_user();
        int n = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUser_name().equalsIgnoreCase(user)) {
                if (list.get(i).getPassword().equalsIgnoreCase(pass)) {
                    //correct user name and password
                    n = 1;
                    break;
                } else {
                    //error password
                    n = 2;
                    break;
                }
            }
        }
        return n;
    }

    public static String getDepartment(String user) throws SQLException {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select department from user where user_name = ?");) {
            p.setString(1, user);
            ResultSet r = p.executeQuery();
            return r.getString("department");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
