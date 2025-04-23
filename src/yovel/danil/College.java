package yovel.danil;

public class College {
    private final String name;
    private Lecturer[] lecturers;
    private int lecturersCount;
    private Committee[] committees;
    private int committeesCount;
    private Course[] courses;
    private int coursesCount;


    public College(String name) {
        this.name = name;
        this.courses = new Course[1];
        this.committees = new Committee[1];
        this.lecturers = new Lecturer[1];
        this.lecturersCount = 0;
        this.committeesCount = 0;
        this.coursesCount = 0;
    }

    public String getName() {
        return name;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public Committee[] getCommittees() {
        return committees;
    }

    public Course[] getCourses() {
        return courses;
    }

    public boolean addCourse(String course){
        if (course == null) return false;
        if (hasCourse(course)) return false;


        if (this.lecturersCount >= this.courses.length) {
            Course[] newCourses = new Course[courses.length *2];
            for (int i = 0; i < courses.length; i++) {
                newCourses[i] = courses[i];
            }
            this.courses = newCourses;
        }
        this.courses[this.coursesCount] = new Course(course);
        this.coursesCount++;
        return true;

    }

    public boolean addLecturer(Lecturer lecturer) {
        if (lecturer == null) return false;
        if (hasLecturer(lecturer.getName())) return false;

        if (this.lecturersCount >= this.lecturers.length) {
            Lecturer[] newLecturers = new Lecturer[lecturers.length + 1];
            for (int i = 0; i < lecturers.length; i++) {
                newLecturers[i] = this.lecturers[i];
            }
            this.lecturers = newLecturers;
        }
        this.lecturers[this.lecturersCount] = lecturer;
        this.lecturersCount++;
        return true;

    }

    public Lecturer getLecturerByName(String lecturerName) {
        for (Lecturer lecturer : this.lecturers) {
            if (lecturer.getName().equals(lecturerName)) return lecturer;
        }
        return null;
    }

    public boolean addCommittee(Committee committee) {
        if (committee == null) return false;
        if (hasCommittee(committee.getName())) return false;

        if (this.committeesCount >= this.committees.length) {
            Committee[] newCommittees = new Committee[committees.length + 1];
            for (int i = 0; i < committees.length; i++) {
                newCommittees[i] = committees[i];
            }
            this.committees = newCommittees;
        }
        this.committees[this.committeesCount] = committee;
        this.committeesCount++;
        return true;
    }

    public boolean hasCourse(String course){
        for (Course c : courses) {
            if (c == null) continue;
            if (c.getName().equals(course)) return true;
        }
        return false;
    }

    public boolean hasLecturer(String lecturerName){
        for (Lecturer l : lecturers) {
            if (l == null) continue;
            if (l.getName().equals(lecturerName)) return true;
        }
        return false;
    }

    public boolean hasCommittee(String committee){
        for (Committee c : committees) {
            if (c == null) continue;
            if (c.getName().equals(committee)) return true;
        }
        return false;
    }

    private void printInfo(Object... arr){
        for (int i = 0; i < arr.length; i++){
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
                break;
            }
            System.out.print(arr[i] + ", ");
        }
    }

    public void printLecturers(){
        printInfo(this.lecturers);
    }

    public void printCourses(){
        printInfo(this.courses);
    }

    public void printCommittees(){
        printInfo(this.committees);
    }

}
