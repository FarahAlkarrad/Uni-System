package entity;

public class Student {
    private int id;
    private String first_name, last_name, total_degree, department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTotal_degree() {
        return total_degree;
    }

    public void setTotal_degree(String degree) {
        this.total_degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student(int id, String first_name, String last_name, String total_degree, String department) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.total_degree = total_degree;
        this.department = department;
    }

}
