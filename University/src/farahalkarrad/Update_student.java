package farahalkarrad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update_student extends JPanel implements ActionListener{
    
    JLabel Lid, LFirstName, LLastName, LAddress, LDepartment;
    JTextField Tid, TFirstName, TLastName, TAddress, TDepartment;
    JButton update;

    public Update_student() {
        
        this.setLayout(null);
        
        //initalize student information Label
        Lid = new JLabel("ID Student");
        LFirstName = new JLabel("First Name");
        LLastName = new JLabel("Last Name");
        LAddress = new JLabel("Address");
        LDepartment = new JLabel("Department");
        Lid.setBounds(100, 20, 80, 25);
        LFirstName.setBounds(100, 50, 80, 25);
        LLastName.setBounds(100, 80, 80, 25);
        LAddress.setBounds(100, 110, 80, 25);
        LDepartment.setBounds(100, 140, 80, 25);
        add(Lid);
        add(LFirstName);
        add(LLastName);
        add(LAddress);
        add(LDepartment);

        //initalize student information TextField
        Tid = new JTextField();
        TFirstName = new JTextField();
        TLastName = new JTextField();
        TAddress = new JTextField();
        TDepartment = new JTextField();
        Tid.setBounds(190,20,150,20);
        TFirstName.setBounds(190, 50, 150, 20);
        TLastName.setBounds(190, 80, 150, 20);
        TAddress.setBounds(190, 110, 150, 20);
        TDepartment.setBounds(190, 140, 150, 20);
        add(Tid);
        add(TFirstName);
        add(TLastName);
        add(TAddress);
        add(TDepartment);

        //update data via Button
        update = new JButton("Update Student");
        update.setBounds(170, 190, 150, 30);
        add(update);
        update.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        database.Student_database.update_student(Integer.parseInt(Tid.getText()), TFirstName.getText(), TLastName.getText(), TAddress.getText(), TDepartment.getText());
        JOptionPane.showMessageDialog(null, "The information of student with id: "+Tid.getText()+" has been updated successfully.", "Update Student Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
