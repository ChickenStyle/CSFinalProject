package yovel.danil;

public class Lecturer {

    private String name;
    private int id;
    private Degree degree;
    private String major;
    private int salary;
    private Department department;


    public Lecturer(String name, int id, Degree degree, String major, int salary, Department department) {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.major = major;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public Degree getDegree() {
        return degree;
    }

    public String getMajor() {
        return major;
    }

    public int getSalary() {
        return salary;
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

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecturer lecturer = (Lecturer) o;
        return id == lecturer.id;
    }
}
