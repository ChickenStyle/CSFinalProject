package yovel.danil;

public class College {
    private final String name;
    private Lecturer[] lecturers;
    private Committee[] committees;
    private Course[] courses;


    public College(String name) {
        this.name = name;
        this.courses = new Course[0];
        this.committees = new Committee[0];
        this.lecturers = new Lecturer[0];
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

        Course[] newCourses = new Course[courses.length + 1];
        for (int i = 0; i < courses.length; i++) {
            newCourses[i] = courses[i];
        }
        newCourses[courses.length] = new Course(course);
        this.courses = newCourses;
        return true;
    }

    public boolean addLecturer(String lecturer) {
        if (lecturer == null) return false;
        if (hasLecturer(lecturer)) return false;

        Lecturer[] newLecturers = new Lecturer[lecturers.length + 1];
        for (int i = 0; i < lecturers.length; i++) {
            newLecturers[i] = this.lecturers[i];
        }
        newLecturers[lecturers.length] = new Lecturer(lecturer);
        this.lecturers = newLecturers;
        return true;

    }

    public boolean addCommittee(String committee) {
        if (committee == null) return false;
        if (hasCommittee(committee)) return false;

        Committee[] newCommittees = new Committee[committees.length + 1];
        for (int i = 0; i < committees.length; i++) {
            newCommittees[i] = committees[i];
        }
        newCommittees[committees.length] = new Committee(committee);
        this.committees = newCommittees;
        return true;
    }

    public boolean hasCourse(String course){
        for (Course c : courses) {
            if (c.getName().equals(course)) return true;
        }
        return false;
    }

    public boolean hasLecturer(String lecturer){
        for (Lecturer l : lecturers) {
            if (l.getName().equals(lecturer)) return true;
        }
        return false;
    }

    public boolean hasCommittee(String committee){
        for (Committee c : committees) {
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
