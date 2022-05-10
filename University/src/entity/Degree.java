package entity;

public class Degree {
    private int id, assignment, mid_exam, final_exam;

    public Degree(int id, int assignment, int mid_exam, int final_exam) {
        this.id = id;
        this.assignment = assignment;
        this.mid_exam = mid_exam;
        this.final_exam = final_exam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssignment() {
        return assignment;
    }

    public void setAssignment(int assignment) {
        this.assignment = assignment;
    }

    public int getMid_exam() {
        return mid_exam;
    }

    public void setMid_exam(int mid_exam) {
        this.mid_exam = mid_exam;
    }

    public int getFinal_exam() {
        return final_exam;
    }

    public void setFinal_exam(int final_exam) {
        this.final_exam = final_exam;
    }
    
}
