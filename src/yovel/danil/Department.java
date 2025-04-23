package yovel.danil;

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

    public Department(String name) {
        this(name, 0, new Lecturer[1]);
        this.lecturerCount = 0;
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
            Lecturer[] newLecturers = new Lecturer[this.lecturers.length * 2];
            for (int i = 0; i < this.lecturers.length; i++) {
                newLecturers[i] = this.lecturers[i];
            }
            this.lecturers = newLecturers;
        }

        this.lecturers[this.lecturerCount] = lecturer;
        this.lecturerCount++;
        return true;
    }
}
