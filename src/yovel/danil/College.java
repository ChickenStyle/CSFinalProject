package yovel.danil;

public class College {
    private final String name;
    private Lecturer[] lecturers;
    private int lecturersCount;
    private Committee[] committees;
    private int committeesCount;
    private Department[] departments;
    private int departmentsCount;


    public College(String name) {
        this.name = name;
        this.committees = new Committee[1];
        this.lecturers = new Lecturer[1];
        this.departments = new Department[1];
        this.departmentsCount = 0;
        this.lecturersCount = 0;
        this.committeesCount = 0;
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

    public boolean addDepartment(Department department) {
        if (department == null) return false;
        if (hasDepartment(department.getName())) return false;
        if (this.departmentsCount >= this.departments.length) {
            Department[] newDepartments = new Department[this.departments.length*2];
            for (int i = 0; i < this.departments.length; i++) {
                newDepartments[i] = this.departments[i];
            }
            this.departments = newDepartments;
        }
        this.departments[this.departmentsCount] = department;
        this.departmentsCount++;
        return true;
    }

    public Department getDepartmentByName(String name) {
        if (name == null) return null;
        for (Department department : this.departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    public boolean hasDepartment(String departmentName) {
        if (departmentName == null) return false;
        for (Department department : this.departments) {
            if (department.getName().equals(departmentName)) return true;
        }
        return false;
    }

    public Lecturer getLecturerByName(String lecturerName) {
        for (Lecturer lecturer : this.lecturers) {
            if (lecturer.getName().equals(lecturerName)) return lecturer;
        }
        return null;
    }

    public Committee getCommitteeByName(String committeeName) {
        for (Committee committee : this.committees) {
            if (committee.getName().equals(committeeName)) return committee;
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

}
