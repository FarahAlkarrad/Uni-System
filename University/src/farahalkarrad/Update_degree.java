package farahalkarrad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Update_degree extends JPanel implements ActionListener {
    
    JLabel Label_id, Label_First_Assignment, Label_mid_exam, Label_Final_Exam;
    JTextField Tid, Tfirst_assigment, Tmid_exam, Tfinal_exam;
    JButton search_id, update_degree;
    ArrayList<entity.Degree> list;
    
    public Update_degree() {
        
        this.setLayout(null);
        list = new ArrayList<>();

        //initialized label, textField and Button degree.
        Label_id = new JLabel("Enter student id");
        Label_First_Assignment = new JLabel("Assignment");
        Label_mid_exam = new JLabel("Mid Exam");
        Label_Final_Exam = new JLabel("Final Exam");
        Label_id.setBounds(150, 20, 100, 25);
        Label_First_Assignment.setBounds(60, 50, 80, 25);
        Label_mid_exam.setBounds(60, 80, 80, 25);
        Label_Final_Exam.setBounds(60, 110, 80, 25);
        add(Label_id);
        add(Label_First_Assignment);
        add(Label_mid_exam);
        add(Label_Final_Exam);
        
        Tid = new JTextField();
        Tfirst_assigment = new JTextField();
        Tmid_exam = new JTextField();
        Tfinal_exam = new JTextField();
        Tid.setBounds(260, 20, 80, 25);
        Tfirst_assigment.setBounds(150, 50, 80, 25);
        Tmid_exam.setBounds(150, 80, 80, 25);
        Tfinal_exam.setBounds(150, 110, 80, 25);
        add(Tid);
        add(Tfirst_assigment);
        add(Tmid_exam);
        add(Tfinal_exam);
        
        search_id = new JButton("Get Student Degree");
        search_id.setBounds(350, 20, 150, 30);
        add(search_id);
        search_id.addActionListener(this);
        update_degree = new JButton("Update");
        update_degree.setBounds(100, 150, 100, 30);
        add(update_degree);
        update_degree.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_id) {
            list = database.Degree_database.get_degree(Integer.parseInt(Tid.getText()));
            Tfirst_assigment.setText(list.get(0).getAssignment() + "");
            Tmid_exam.setText(list.get(0).getMid_exam() + "");
            Tfinal_exam.setText(list.get(0).getFinal_exam() + "");
        } else if (e.getSource() == update_degree) {
            database.Degree_database.update_degree(Integer.parseInt(Tid.getText()), Integer.parseInt(Tfirst_assigment.getText()), Integer.parseInt(Tmid_exam.getText()), Integer.parseInt(Tfinal_exam.getText()));
            JOptionPane.showMessageDialog(null, "Student Degree updated", "Update Degree", JOptionPane.INFORMATION_MESSAGE);
            Tid.setText("");
            Tfirst_assigment.setText("");
            Tmid_exam.setText("");
            Tfinal_exam.setText("");
        }
    }
    
}
