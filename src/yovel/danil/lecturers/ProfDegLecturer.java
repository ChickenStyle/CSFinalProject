package yovel.danil.lecturers;

import yovel.danil.Degree;
import yovel.danil.Department;

public class ProfDegLecturer extends DocDegLecturer{

    private String professionAssignedBody;
    ProfDegLecturer(String name, int id, String major, float salary, Department department, String professionAssignedBody) {
        super(name, id, major, salary, department);
        this.professionAssignedBody = professionAssignedBody;
    }

    public ProfDegLecturer(String name, int id, String major, float salary, Department department) {
        this(name, id, major, salary, department, "");
    }

    @Override
    public Degree getDegree(){
        return Degree.PROFESSOR;
    }


    public void setBodyWhoAssignedProfession(String body) {
        this.professionAssignedBody = body;
    }
    public String getBodyWhoAssignedProfession() {
        return professionAssignedBody;
    }
}
