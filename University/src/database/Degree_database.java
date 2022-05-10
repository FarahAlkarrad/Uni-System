package database;

import entity.Degree;
import entity.Student;
import static database.Student_database.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Degree_database {

    //I make all methods static because I didn't want to implements any objects in other classes.
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_degree(int id, int assignment, int mid_exam, int final_exam) {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("insert into degree values(?,?,?,?,?)");) {
            p.setInt(1, id);
            p.setInt(2, assignment);
            p.setInt(3, mid_exam);
            p.setInt(4, final_exam);
            p.setInt(5, assignment + mid_exam + final_exam);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<entity.Degree> get_degree(int id) {
        ArrayList<entity.Degree> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from degree where id = ?");) {
            p.setInt(1, id);
            ResultSet result = p.executeQuery();
            while (result.next()) {
                list.add(new Degree(result.getInt("id"), result.getInt("assignment"), result.getInt("mid_exam"), result.getInt("final_exam")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void update_degree(int id, int assignment, int mid, int final_exam) {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("update degree set assignment=?, mid_exam=?, final_exam=?, sum=? where id=?");) {
            p.setInt(1, assignment);
            p.setInt(2, mid);
            p.setInt(3, final_exam);
            p.setInt(4, assignment+mid+final_exam);
            p.setInt(5, id);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
