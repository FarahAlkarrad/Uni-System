package farahalkarrad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class First_screen extends JFrame implements ActionListener {

    Image i = new Image();
    JLabel user, pass;
    JTextField user_name;
    JPasswordField password;
    JButton signIn, signUp;

    public First_screen() {
        //constructor
    }

    public void show_first_screen() {
        //initialized user name and password label
        user = new JLabel("Doctor Name");
        pass = new JLabel("Password");
        user.setBounds(100, 70, 80, 25);
        pass.setBounds(100, 100, 80, 25);
        i.add(user);
        i.add(pass);

        //initialized user_name and password TextField
        user_name = new JTextField();
        password = new JPasswordField();
        user_name.setBounds(190, 70, 150, 20);
        password.setBounds(190, 103, 150, 20);
        i.add(user_name);
        i.add(password);

        //initialized signIn and signUp Button
        signIn = new JButton("Sign In");
        signUp = new JButton("Sign Up");
        signIn.setBounds(170, 160, 80, 20);
        signUp.setBounds(280, 160, 80, 20);
        i.add(signIn);
        i.add(signUp);
        signIn.addActionListener(this);
        signUp.addActionListener(this);

        //initialized main form
        setTitle("University System");
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(514, 336);
        add(i);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signIn) {
            //check user in (database->user_database) package.
            int i = database.User_database.check_user(user_name.getText(), password.getText());
            switch (i) {
                case 0:
                    JOptionPane.showMessageDialog(null, "User Not Found ", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("User not found");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Welcome back " + user_name.getText(), "Hello", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Correct User name and Password");
                    this.dispose();
                    {
                        try {
                            //first:  show dashboard screen
                            //second: show only student that his department same as doctor department,
                            //        the department of students should be same as doctor department in all taps in dashboard screen.
                            new Doctor(database.User_database.getDepartment(user_name.getText())).show_doctor_screen();
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Wrong Password ", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Wrong Password");
                    break;
            }
        } else if (e.getSource() == signUp) {
            this.dispose();
            new Second_screen().show_second_screen();
        }
    }
}
