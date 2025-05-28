package yovel.danil.lecturers;

import yovel.danil.Committee;
import yovel.danil.Degree;
import yovel.danil.Department;

public abstract class Lecturer {

    public abstract boolean hasDepartment();
    public abstract int getId();
    public abstract String getMajor();
    public abstract float getSalary();
    public abstract Department getDepartment();
    public abstract String getName();
    public abstract void setName(String name);
    public abstract void setDepartment(Department department);
    public abstract void addCommittee(Committee committee);
    public abstract Degree getDegree();

}
