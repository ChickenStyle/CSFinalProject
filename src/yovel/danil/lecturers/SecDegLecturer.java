package yovel.danil.lecturers;

import yovel.danil.Degree;
import yovel.danil.Department;

public class SecDegLecturer extends FirstDegLecturer {
    public SecDegLecturer(String name, int id,  String major, float salary, Department department) {
        super(name, id, major, salary, department);
    }
    @Override
    public Degree getDegree(){
        return Degree.SECOND;
    }
}
