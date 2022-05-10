package farahalkarrad;

import javax.swing.*;

public class Doctor extends JFrame {

    JTabbedPane tab;
    Add_student add_student_tab;
    Insert_degree student_degree_tab;
    Print_degree print_degree_tab;
    Update_student update_student_tab;
    Update_degree update_degree_tab;
    String depart;

    public Doctor(String depart) {
        //constructor
        this.depart = depart;
    }

    public void show_doctor_screen() {

        add_student_tab = new Add_student();
        student_degree_tab = new Insert_degree(this.depart);
        print_degree_tab = new Print_degree();
        update_student_tab = new Update_student();
        update_degree_tab = new Update_degree();

        //initialized main form
        setTitle("Dashboard");
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 336);

        tab = new JTabbedPane();
        tab.addTab("Add New Student", add_student_tab);
        tab.addTab("Insert Student Degree", student_degree_tab);
        tab.addTab("Show Total Degree", print_degree_tab);
        tab.addTab("Update Student Information", update_student_tab);
        tab.addTab("Update Degree", update_degree_tab);
        this.add(tab);
    }
}
