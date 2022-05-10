package database;

import entity.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Student_database {

    //I make all methods static because I didn't want to implements any objects in other classes.
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_student(String fname, String lname, String address, String depart) {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("insert into student(fname,lname,address,department) values(?,?,?,?)");) {
            p.setString(1, fname);
            p.setString(2, lname);
            p.setString(3, address);
            p.setString(4, depart);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Student> get_data_student_and_degree() {
        ArrayList<Student> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from student, degree where degree.id = student.id");) {
            ResultSet result = p.executeQuery();
            while (result.next()) {
                list.add(new Student(result.getInt("id"), result.getString("fname"), result.getString("lname"), result.getInt("sum")+"", result.getString("department")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static void update_student(int id, String fname, String lname, String address, String depart){
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("update student set fname=?, lname=?, address=?, department=? where id=?");) {
            p.setString(1, fname);
            p.setString(2, lname);
            p.setString(3, address);
            p.setString(4, depart);
            p.setInt(5,id);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
