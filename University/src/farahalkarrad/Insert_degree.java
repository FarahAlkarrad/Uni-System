package farahalkarrad;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Insert_degree extends JPanel implements ActionListener {

    String depart;
    JTable table;
    JScrollPane scroll;
    String data[][], header[] = {"id", "fname", "lname"};
    JLabel Label_First_Assignment, Label_mid_exam, Label_Final_Exam;
    JTextField Tfirst_assigment, Tmid_exam, Tfinal_exam;
    JButton add_degree;
    ArrayList<entity.Student> list;
    int row_number = 0, id_number = 0;

    public Insert_degree(String depart) {
        this.setLayout(null);
        //this.setBackground(Color.red);
        this.depart = depart;
        show_table();
    }

    public void show_table() {
        list = database.Student_database.get_data_student_and_degree();

        //show student data from database into screen via table
        data = new String[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = "" + list.get(i).getId();
            data[i][1] = "" + list.get(i).getFirst_name();
            data[i][2] = "" + list.get(i).getLast_name();
        }
        table = new JTable(data, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 350, 269);
        add(scroll);

        //initialized label, textField and Button degree.
        Label_First_Assignment = new JLabel("Assignment");
        Label_mid_exam = new JLabel("Mid Exam");
        Label_Final_Exam = new JLabel("Final Exam");
        Label_First_Assignment.setBounds(380, 20, 80, 25);
        Label_mid_exam.setBounds(380, 50, 80, 25);
        Label_Final_Exam.setBounds(380, 80, 80, 25);
        add(Label_First_Assignment);
        add(Label_mid_exam);
        add(Label_Final_Exam);

        Tfirst_assigment = new JTextField();
        Tmid_exam = new JTextField();
        Tfinal_exam = new JTextField();
        Tfirst_assigment.setBounds(470, 20, 80, 25);
        Tmid_exam.setBounds(470, 50, 80, 25);
        Tfinal_exam.setBounds(470, 80, 80, 25);
        add(Tfirst_assigment);
        add(Tmid_exam);
        add(Tfinal_exam);

        add_degree = new JButton("Add Degree");
        add_degree.setBounds(400, 120, 100, 25);
        add(add_degree);
        add_degree.addActionListener(this);

        //i want the text be in the center of the column.
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);

        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //initalized event table
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMouseClicked(evt);
            }
        });
    }

    private void tMouseClicked(java.awt.event.MouseEvent evt) {
        //get selected row number
        row_number = table.getSelectedRow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //insert new degree
        id_number = list.get(row_number).getId();
        database.Degree_database.insert_degree(id_number, Integer.parseInt(Tfirst_assigment.getText()), Integer.parseInt(Tmid_exam.getText()), Integer.parseInt(Tfinal_exam.getText()));
        System.out.println("degree inserted");
        JOptionPane.showMessageDialog(null, "Degree Inserted", "OK", JOptionPane.INFORMATION_MESSAGE);

    }
}
