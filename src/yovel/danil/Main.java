package yovel.danil;

import java.util.Scanner;

public class Main {
    // Daniel And Yovel

    private static final Scanner scanner = new Scanner(System.in);
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
                    "\n8 - Average salary of committee's members" +
                    "\n9 - Lecturers info" +
                    "\n10 - Departments info\n";

    public static void main(String[] args) {

        System.out.print("Enter college name: ");

        String name = scanner.nextLine();

        College college = new College(name);
        System.out.println("College created successfully!");
        System.out.println("Welcome to " + name + " college!");

        while (true) {
            System.out.print("\n"+menu);
            String func = scanner.nextLine();

            switch (func) {
                case "0":
                    System.out.println("Goodbye!");
                    return;

                case "1":
                    while (true) {
                        System.out.println("Enter lecturer name: ");
                        String lecturerName = scanner.nextLine();

                        if (college.hasLecturer(lecturerName)) {
                            System.out.println("This lecturer already exists!");
                            continue;
                        }

                        System.out.println("Enter lecturer id: ");
                        int lecturerId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter Lecturer's Degree (First, Second, Doctor, Professor): ");
                        String degreeStr = scanner.nextLine();
                        System.out.println(Degree.isValidDegree(degreeStr));
                        if (!Degree.isValidDegree(degreeStr)) {
                            System.out.println("Invalid degree (Options: First, Second, Doctor, Professor)");
                            continue;
                        }

                        Degree degree = Degree.valueOf(degreeStr.toUpperCase());

                        System.out.println("Enter lecturer major: ");
                        String major = scanner.nextLine();

                        System.out.println("Enter lecturer salary: ");
                        int lecturerSalary = scanner.nextInt();

                        Lecturer newLecturer = new Lecturer(lecturerName, lecturerId, degree, major, lecturerSalary, null);
                        college.addLecturer(newLecturer);
                        System.out.println("Lecturer added successfully!");
                        break;

                    }
                    break;


                case "2":
                    while (true) {
                        System.out.print("Enter committee name: ");
                        String committeeName = scanner.nextLine();

                        if (college.hasCommittee(committeeName)) {
                            System.out.println("This committee already exists!");
                            continue;
                        }

                        Committee committee = new Committee(committeeName);


                        System.out.println("Enter Chairman name (Should be a valid lecturer with at least doctor degree): ");
                        String chairmanName = scanner.nextLine();

                        while (!college.hasLecturer(chairmanName)) {
                            System.out.println("This lecturer does not exist!");
                            System.out.println("Enter Chairman name (Should be a valid lecturer with at least doctor degree): ");
                            chairmanName = scanner.nextLine();
                        }

                        Lecturer chairman = college.getLecturerByName(chairmanName);

                        if (!committee.setChairman(chairman)) {
                            System.out.println("Chairman doesn't meet the requirements! (At least Doctors Degree)");
                            continue;
                        }

                        System.out.println("Chairman set successfully!");

                        college.addCommittee(committee);
                        System.out.println("Committee added successfully!");
                        break;
                    }
                    break;

                case "3":
                    while (true) {
                        System.out.print("Enter lecturer name: ");
                        String lecturerName = scanner.nextLine();

                        if (!college.hasLecturer(lecturerName)) {
                            System.out.println("This lecturer does not exist!");
                            continue;
                        }

                        String committeeName = null;
                        while(true) {
                            System.out.println("Enter committee name: ");
                            committeeName = scanner.nextLine();
                            if (college.hasCommittee(committeeName)) {
                                break;
                            }
                            System.out.println("This committee does not exist!");
                        }

                        Lecturer lecturer = college.getLecturerByName(lecturerName);
                        Committee committee = college.getCommitteeByName(committeeName);

                        if (!committee.addMember(lecturer)) {
                            System.out.println(lecturerName + " is already member of this lecturer!");
                            break;
                        }

                        System.out.println(lecturerName + "has been added to " + committeeName+  " committee successfully!");

                        break;
                    }
                    break;

                case "4":
                    while (true) {
                        System.out.print("Enter committee name: ");
                        String committeeName = scanner.nextLine();

                        if (!college.hasCommittee(committeeName)) {
                            System.out.println("This committee does not exist!");
                            continue;
                        }

                        System.out.println("Enter lecturer name to replace " + committeeName + "'s chairman (Should be a valid lecturer with at least doctor degree): ");
                        String lecturerName = scanner.nextLine();
                        while (!college.hasLecturer(lecturerName)) {
                            System.out.println("This lecturer does not exist!");
                            System.out.println("Enter lecturer name to replace " + committeeName + "'s chairman: ");
                            lecturerName = scanner.nextLine();
                        }

                        Lecturer lecturer = college.getLecturerByName(lecturerName);
                        Committee committee = college.getCommitteeByName(committeeName);

                        while (!committee.setChairman(lecturer)) {
                            System.out.println("Chairman doesn't meet the requirements!");
                            System.out.println("Enter Chairman name to replace " + committeeName + "'s chairman: ");
                            lecturer = college.getLecturerByName(scanner.nextLine());
                        }

                        System.out.println(lecturer.getName() + " is now the chairman of " + committee.getName());
                        break;
                    }
                    break;
                case "5":
                    while (true) {

                        System.out.print("Enter lecturer name: ");
                        String lecturerName = scanner.nextLine();

                        if (!college.hasLecturer(lecturerName)) {
                            System.out.println("This lecturer does not exist!");
                            continue;
                        }

                        String committeeName = null;
                        while (true) {
                            System.out.println("Enter committee name: ");
                            committeeName = scanner.nextLine();
                            if (!college.hasCommittee(committeeName)) {
                                System.out.println("This committee does not exist!");
                                break;
                            }
                        }

                        Lecturer lecturer = college.getLecturerByName(lecturerName);
                        Committee committee = college.getCommitteeByName(committeeName);

                        if (!committee.removeMember(lecturer)) {
                            System.out.println(lecturerName + " isn't a member of " + committeeName + " committee!");
                            continue;
                        }

                        System.out.println(lecturerName + " has been removed from the committee successfully!");
                        break;

                    }

                    break;
                case "6":
                    System.out.print("Enter new department name: ");
                    String departmentName = scanner.nextLine();

                    if (college.hasDepartment(departmentName)) {
                        System.out.println(departmentName + " department already exist!");
                        continue;
                    }

                    System.out.println("Enter department's student amount: ");
                    int studentCount = scanner.nextInt();
                    scanner.nextLine();


                    Department department = new Department(departmentName, studentCount);

                    while (true) {
                        System.out.println("Enter lecturers for this department (press 0 if u want to stop): ");

                        String lecturerName = scanner.nextLine();

                        if (lecturerName.equals("0")) {
                            break;
                        }

                        if (!college.hasLecturer(lecturerName)) {
                            System.out.println("This lecturer does not exist!");
                            continue;
                        }

                        Lecturer lecturer = college.getLecturerByName(lecturerName);

                        if (lecturer.hasDepartment()){
                            System.out.println(lecturer.getName() + " has already has a department!");
                            continue;
                        }

                        department.addLecturer(lecturer);
                        System.out.println(lecturer.getName() + " has been added to the department!");
                    }

                    college.addDepartment(department);
                    System.out.println(department.getName() + " department has been added!");

                    break;
                case "7":
                    int salariesCombined = 0;

                    for (Lecturer lecturer : college.getLecturers()) {
                        salariesCombined += lecturer.getSalary();
                    }
                    System.out.println(college.getName() + "'s average salary is: " + salariesCombined/college.getLecturers().length);

                    break;
                case "8":
                    System.out.println("Enter department name: ");
                    String departmentNam = scanner.nextLine();
                    if (!college.hasDepartment(departmentNam)) {
                        System.out.println(departmentNam + " department does not exist!");
                    }

                    Department department1 = college.getDepartmentByName(departmentNam);
                    int averageSalary = 0;

                    for (Lecturer lecturer : department1.getLecturers()) {
                        averageSalary += lecturer.getSalary();
                    }

                    System.out.println(departmentNam + "'s average salary is: " + averageSalary/department1.getLecturers().length);

                    break;



                case "9":
                    System.out.println("College's lecturers info:");

                    for (Lecturer lecturer : college.getLecturers()) {
                        System.out.println(lecturer);
                    }

                    break;
                case "10":
                    System.out.println("College's committees info: ");
                    for (Committee committee : college.getCommittees()) {
                        System.out.println(committee);
                    }
                    break;

                default:
                    System.out.println("Invalid function!");
                    break;
            }


            System.out.println(" ");
        }

    }
}


