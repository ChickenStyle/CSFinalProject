package yovel.danil.lecturers;

import yovel.danil.Committee;
import yovel.danil.Degree;
import yovel.danil.Department;
import yovel.danil.Utils;

public class FirstDegLecturer extends Lecturer {

    private String name;
    private final int id;
    private final String major;
    private float salary;
    private Department department;
    private Committee[] committees;
    private int committeesCount;

    public FirstDegLecturer(String name, int id, String major, float salary, Department department) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.salary = salary;
        this.department = department;
        this.committees = new Committee[1];
        this.committeesCount = 0;
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
        if (this.committeesCount >= this.committees.length) {
            this.committees = Utils.expandStrArr(this.committees);
        }
        this.committees[this.committeesCount] = committee;
        this.committeesCount++;
    }

    @Override
    public String toString() {
        String committeesString = "";
        for (int i = 0; i < committeesCount; i++) {
            committeesString += committees[i].getName() + " ";
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
