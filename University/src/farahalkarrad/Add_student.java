package farahalkarrad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Add_student extends JPanel implements ActionListener {

    JLabel LFirstName, LLastName, LAddress, LDepartment;
    JTextField TFirstName, TLastName, TAddress, TDepartment;
    JButton send;

    public Add_student() {
        
        this.setLayout(null);
        
        //initalize student information Label
        LFirstName = new JLabel("First Name");
        LLastName = new JLabel("Last Name");
        LAddress = new JLabel("Address");
        LDepartment = new JLabel("Department");
        LFirstName.setBounds(100, 20, 80, 25);
        LLastName.setBounds(100, 50, 80, 25);
        LAddress.setBounds(100, 80, 80, 25);
        LDepartment.setBounds(100, 110, 80, 25);
        add(LFirstName);
        add(LLastName);
        add(LAddress);
        add(LDepartment);

        //initalize student information TextField
        TFirstName = new JTextField();
        TLastName = new JTextField();
        TAddress = new JTextField();
        TDepartment = new JTextField();
        TFirstName.setBounds(190, 20, 150, 20);
        TLastName.setBounds(190, 50, 150, 20);
        TAddress.setBounds(190, 80, 150, 20);
        TDepartment.setBounds(190, 110, 150, 20);
        add(TFirstName);
        add(TLastName);
        add(TAddress);
        add(TDepartment);

        //send data via Button
        send = new JButton("Send Data");
        send.setBounds(170, 160, 100, 30);
        add(send);
        send.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == send){
            database.Student_database.insert_student(TFirstName.getText(), TLastName.getText(), TAddress.getText(), TDepartment.getText());
            JOptionPane.showMessageDialog(null, TFirstName.getText()+" was inserted", "Insert New Student", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
