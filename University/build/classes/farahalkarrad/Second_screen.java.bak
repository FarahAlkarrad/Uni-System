package farahalkarrad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Second_screen extends JFrame implements ActionListener {

    Image i = new Image();
    JLabel user, pass, depart, note;
    JTextField user_name, password, department;
    JButton send, back;

    public Second_screen() {

    }

    public void show_second_screen() {
        //initialized user name and password and department label
        user = new JLabel("User Name");
        pass = new JLabel("Password");
        depart = new JLabel("Department");
        note = new JLabel("Please enter department (cs, is, it) only.");
        user.setBounds(80, 50, 80, 25);
        pass.setBounds(80, 80, 80, 25);
        note.setBounds(80, 110, 500, 25);
        depart.setBounds(80, 140, 80, 25);
        i.add(user);
        i.add(pass);
        i.add(depart);
        i.add(note);

        //initialized user_name,password,department TextField
        user_name = new JTextField();
        password = new JTextField();
        department = new JTextField();
        user_name.setBounds(170, 50, 150, 20);
        password.setBounds(170, 80, 150, 20);
        department.setBounds(170, 140, 150, 20);
        i.add(user_name);
        i.add(password);
        i.add(department);

        //initialized sign Up and back Button
        send = new JButton("Sign Up");
        back = new JButton("Back");
        send.setBounds(160, 180, 100, 40);
        back.setBounds(0, 0, 70, 20);
        i.add(send);
        i.add(back);
        send.addActionListener(this);
        back.addActionListener(this);

        //initialized sign Up screen
        setTitle("Sign Up Screen");
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(514, 336);
        add(i);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            new First_screen().show_first_screen();
        } else if (e.getSource() == send) {
            String d = department.getText();
            if (d.equalsIgnoreCase("cs") || d.equalsIgnoreCase("is") || d.equalsIgnoreCase("it")) {
                //insert new user (new lecturer)
                database.User_database.insert_user(user_name.getText(), password.getText(), department.getText());
                JOptionPane.showMessageDialog(null, "Hello doctor " + user_name.getText(), "Ok new user", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Inserting new lecturer.");
                this.dispose();
                new First_screen().show_first_screen();
            } else {
                JOptionPane.showMessageDialog(null, "Department Not Found", "Error Department", JOptionPane.WARNING_MESSAGE);
                System.out.println("Department Not Found");
            }
        }
    }
}
