package yovel.danil;

import yovel.danil.lecturers.Lecturer;

import java.io.Serializable;
import java.util.ArrayList;

public class College implements Serializable {
    private final String name;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Committee> committees;
    private ArrayList<Department> departments;

    private static final String menu =
            "here are the functions:" +
                    "\n0 - Exit " +
                    "\n1 - Add a lecturer " +
                    "\n2 - Add a committee " +
                    "\n3 - Add a lecturer to a committee " +
                    "\n4 - Change committee's chairman " +
                    "\n5 - Remove committee's member " +
                    "\n6 - Add department" +
                    "\n7 - Average salary of lecturers in the college" +
                    "\n8 - Average salary of department's members" +
                    "\n9 - Lecturers info" +
                    "\n10 - Departments info" +
                    "\n11 - Compare Professor/Doctor based on amount of articles they published" +
                    "\n12 - Compare Departments based on amount lecturers" +
                    "\n13 - Compare Departments based on the amount of articles published by the lecturers" +
                    "\n14 - Copy Department (Creates new department with a '-new' suffix\n";


    public College(String name) {
        this.name = name;
        this.committees = new ArrayList<>();
        this.lecturers = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public ArrayList<Committee> getCommittees() {
        return committees;
    }


    public void addLecturer(Lecturer lecturer) {
        if (lecturer == null) return;
        this.lecturers.add(lecturer);

    }

    public void addDepartment(Department department) {
        if (department == null) return;
        departments.add(department);
    }

    public Department getDepartmentByName(String name) {
        if (name == null) return null;
        for (Department department : this.departments) {
            System.out.println(department);
            if (department == null) continue;
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    public void hasDepartment(String departmentName) throws ExistsException {
        if (departmentName == null) return;
        if (getDepartmentByName(departmentName) != null) throw new ExistsException(departmentName, "Department");
    }

    public Lecturer getLecturerByName(String lecturerName) {
        for (Lecturer lecturer : this.lecturers) {
            if (lecturer == null) continue;
            if (lecturer.getName().equals(lecturerName)) return lecturer;
        }
        return null;
    }

    public Committee getCommitteeByName(String committeeName) {
        for (Committee committee : this.committees) {
            if (committee == null) continue;
            if (committee.getName().equals(committeeName)) return committee;
        }
        return null;
    }

    public void addCommittee(Committee committee) {
        if (committee == null) return;
        committees.add(committee);
    }

    public void hasLecturer(String lecturerName) throws ExistsException {
        if (lecturerName == null) return;
        if (getLecturerByName(lecturerName) != null) throw new ExistsException(lecturerName, "Lecturer");
    }

    public void hasCommittee(String committee) throws ExistsException{
        if (committee == null) return;
        if (getCommitteeByName(committee) != null) throw new ExistsException(committee, "Committee");
    }

    public static String getMenu() {
        return menu;
    }



}
