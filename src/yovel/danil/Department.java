package yovel.danil;

import yovel.danil.lecturers.DocDegLecturer;
import yovel.danil.lecturers.Lecturer;

import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable {

    private String name;
    private int studentCount;
    private final ArrayList<Lecturer> lecturers;

    public Department(String name, int studentCount, ArrayList<Lecturer> lecturers) {
        this.name = name;
        this.studentCount = studentCount;
        this.lecturers = lecturers;
    }

    public Department(String name, int studentCount) {
        this(name, studentCount, new ArrayList<>());
    }

    public int getLecturerCount() {
        return lecturers.size();
    }

    public int getAllPublishedArticlesCount() {
        int count = 0;
        for (Lecturer lecturer : lecturers) {
            if (lecturer == null) continue;
            if (lecturer instanceof DocDegLecturer doc) {
                count += doc.getPublishedArticlesCount();
            }
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }
    private boolean isLecturerInDepartment(Lecturer lecturer) {
        return lecturers.contains(lecturer);
    }

    public boolean addLecturer(Lecturer lecturer) {
        if (lecturer == null) {return false;}
        if (isLecturerInDepartment(lecturer)) { return false;}
        lecturers.add(lecturer);
        return true;
    }
}
