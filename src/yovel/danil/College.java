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
            this.lecturers = Utils.expandStrArr(this.lecturers);
        }
        this.lecturers[this.lecturersCount] = lecturer;
        this.lecturersCount++;
        return true;

    }

    public boolean addDepartment(Department department) {
        if (department == null) return false;
        if (hasDepartment(department.getName())) return false;
        if (this.departmentsCount >= this.departments.length) {
            this.departments = Utils.expandStrArr(this.departments);
        }
        this.departments[this.departmentsCount] = department;
        this.departmentsCount++;
        return true;
    }

    public Department getDepartmentByName(String name) {
        if (name == null) return null;
        Utils.printArr(this.departments);
        for (Department department : this.departments) {
            System.out.println(department);
            if (department == null) continue;
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    public boolean hasDepartment(String departmentName) {
        if (departmentName == null) return false;
        for (Department department : this.departments) {
            if (department == null) continue;
            if (department.getName().equals(departmentName)) return true;
        }
        return false;
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

    public boolean addCommittee(Committee committee) {
        if (committee == null) return false;
        if (hasCommittee(committee.getName())) return false;

        if (this.committeesCount >= this.committees.length) {
            this.committees = Utils.expandStrArr(this.committees);
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
