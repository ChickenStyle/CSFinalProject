package yovel.danil;

import yovel.danil.lecturers.DocDegLecturer;
import yovel.danil.lecturers.Lecturer;

public class Department {

    private String name;
    private int studentCount;
    private Lecturer[] lecturers;
    private int lecturerCount;

    public Department(String name, int studentCount, Lecturer[] lecturers) {
        this.name = name;
        this.studentCount = studentCount;
        this.lecturers = lecturers;
        this.lecturerCount = lecturers.length;
    }

    public Department(String name, int studentCount) {
        this(name, studentCount, new Lecturer[1]);
        this.lecturerCount = 0;
    }

    public int getLecturerCount() {
        return lecturerCount;
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

    public Lecturer[] getLecturers() {
        return lecturers;
    }
    private boolean isLecturerInDepartment(Lecturer lecturer) {
        for (int i = 0; i < lecturers.length; i++) {
            if (lecturers[i] == null) continue;
            if (lecturers[i].equals(lecturer)) {
                return true;
            }
        }
        return false;
    }

    public boolean addLecturer(Lecturer lecturer) {
        if (lecturer == null) {return false;}
        if (isLecturerInDepartment(lecturer)) { return false;}


        if (this.lecturerCount >= this.lecturers.length) {
            this.lecturers = Utils.expandStrArr(this.lecturers);
        }

        this.lecturers[this.lecturerCount] = lecturer;
        this.lecturerCount++;
        return true;
    }
}
