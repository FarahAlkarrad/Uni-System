package farahalkarrad;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Print_degree extends JPanel implements ActionListener {

    JTable table;
    JScrollPane scroll;
    String data[][], header[] = {"id", "First name", "Last name", "Total degree"};
    JButton print;
    ArrayList<entity.Student> list;

    public Print_degree() {
        this.setLayout(null);
        show_table();
    }

    public void show_table() {
        list = database.Student_database.get_data_student_and_degree();

        //show student data from database into screen via table
        data = new String[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = "" + list.get(i).getId();
            data[i][1] = "" + list.get(i).getFirst_name();
            data[i][2] = "" + list.get(i).getLast_name();
            data[i][3] = "" + list.get(i).getTotal_degree();
        }
        table = new JTable(data, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(100, 0, 495, 200);
        add(scroll);

        //initalized print button
        print = new JButton("Print Table");
        print.setBounds(200, 220, 100, 30);
        add(print);
        print.addActionListener(this);

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //When you print the table you will see the (h) as a header and (f) as a number of pages on your pages.
        MessageFormat h = new MessageFormat("Student Degree ");
        MessageFormat f = new MessageFormat("Page [1]");
        try {
            table.print(JTable.PrintMode.NORMAL, h, f);
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
    }

}
