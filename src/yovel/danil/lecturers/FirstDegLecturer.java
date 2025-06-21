package yovel.danil.lecturers;

import yovel.danil.Committee;
import yovel.danil.Degree;
import yovel.danil.Department;

import java.util.ArrayList;

public class FirstDegLecturer extends Lecturer {

    private String name;
    private final int id;
    private final String major;
    private float salary;
    private Department department;
    private ArrayList<Committee> committees;

    public FirstDegLecturer(String name, int id, String major, float salary, Department department) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.salary = salary;
        this.department = department;
        this.committees = new ArrayList<>();
    }

    public boolean hasDepartment() {
        return department != null;
    }

    public int getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        if (salary < 0) throw new RuntimeException("Salary can't be negative");
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addCommittee(Committee committee) {
        this.committees.add(committee);
    }

    @Override
    public String toString() {
        String committeesString = "";
        for (Committee comm : committees) {
            committeesString += comm.getName() + " ";
        }

        return "Name: " + name + "\n Current Committees: " + committeesString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FirstDegLecturer lecturer)) return false;
        return this.name.equals(lecturer.getName());
    }

    public Degree getDegree(){
        return Degree.FIRST;
    }


}
