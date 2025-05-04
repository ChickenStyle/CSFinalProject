package yovel.danil;

public class Lecturer {

    private String name;
    private int id;
    private Degree degree;
    private String major;
    private float salary;
    private Department department;
    private Committee[] committees;
    private int committeesCount;


    public Lecturer(String name, int id, Degree degree, String major, float salary, Department department) {
        this.name = name;
        this.id = id;
        this.degree = degree;
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

    public Degree getDegree() {
        return degree;
    }

    public String getMajor() {
        return major;
    }

    public float getSalary() {
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
        if (o == null || getClass() != o.getClass()) return false;
        Lecturer lecturer = (Lecturer) o;
        return this.name.equals(lecturer.name);
    }
}
