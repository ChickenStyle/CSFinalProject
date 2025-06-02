package yovel.danil;

import yovel.danil.lecturers.Lecturer;

public class College {
    private final String name;
    private Lecturer[] lecturers;
    private int lecturersCount;
    private Committee[] committees;
    private int committeesCount;
    private Department[] departments;
    private int departmentsCount;

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
                    "\n10 - Departments info\n";


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


    public void addLecturer(Lecturer lecturer) {
        if (lecturer == null) return;

        if (this.lecturersCount >= this.lecturers.length) {
            this.lecturers = Utils.expandStrArr(this.lecturers);
        }
        this.lecturers[this.lecturersCount] = lecturer;
        this.lecturersCount++;

    }

    public void addDepartment(Department department) {
        if (department == null) return;
        if (this.departmentsCount >= this.departments.length) {
            this.departments = Utils.expandStrArr(this.departments);
        }
        this.departments[this.departmentsCount] = department;
        this.departmentsCount++;
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

        if (this.committeesCount >= this.committees.length) {
            this.committees = Utils.expandStrArr(this.committees);
        }
        this.committees[this.committeesCount] = committee;
        this.committeesCount++;
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
