package yovel.danil;

import yovel.danil.lecturers.DocDegLecturer;
import yovel.danil.lecturers.Lecturer;

import java.util.Scanner;

public class Main {
    // Daniel And Yovel

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter college name: ");

        String name = scanner.nextLine();

        College college = new College(name);
        System.out.println("College created successfully!");
        System.out.println("Welcome to " + name + " college!");


        while (true) {
            System.out.print("\n"+College.getMenu());
            String func = scanner.nextLine();

            switch (func) {
                case "0":
                    System.out.println("Goodbye!");
                    return;

                case "1":
                    while (true) {
                        System.out.println("Enter lecturer name: ");
                        String lecturerName = scanner.nextLine();


                        try {
                            college.hasLecturer(lecturerName);
                        } catch (ExistsException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                        System.out.println("Enter lecturer id: ");
                        int lecturerId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter Lecturer's Degree (First, Second, Doctor, Professor): ");
                        String degreeStr = scanner.nextLine();
                        if (!Degree.isValidDegree(degreeStr)) {
                            System.out.println("Invalid degree (Options: First, Second, Doctor, Professor)");
                            continue;
                        }

                        Degree degree = Degree.valueOf(degreeStr.toUpperCase());

                        System.out.println("Enter lecturer major: ");
                        String major = scanner.nextLine();

                        System.out.println("Enter lecturer salary: ");
                        int lecturerSalary = scanner.nextInt();

                        Lecturer newLecturer = Utils.createLecturer(name, lecturerId, degree, major, lecturerSalary, null);

                        college.addLecturer(newLecturer);
                        System.out.println("Lecturer added successfully!");
                        break;

                    }
                    break;


                case "2":
                    while (true) {
                        System.out.print("Enter committee name: ");
                        String committeeName = scanner.nextLine();


                        try {
                            college.hasCommittee(committeeName);
                        } catch (ExistsException ex) {
                            System.out.println(ex.getMessage());
                            continue;
                        }


                        Committee committee = new Committee(committeeName);


                        System.out.println("Enter Chairman name (Should be a valid lecturer with at least doctor degree): ");
                        String chairmanName = scanner.nextLine();

                        while(true) {
                            try {
                                college.hasLecturer(chairmanName);
                                System.out.println("This lecturer does not exist!");
                                System.out.println("Enter Chairman name (Should be a valid lecturer with at least doctor degree): ");
                                chairmanName = scanner.nextLine();
                            } catch (ExistsException ex) {
                                break;
                            }
                        }

                        Lecturer chairman = college.getLecturerByName(chairmanName);

                        if (!committee.setChairman(chairman)) {
                            System.out.println("Chairman doesn't meet the requirements! (At least Doctors Degree, and he can't be a member of this committee)");
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

                        try {
                            college.hasLecturer(lecturerName);
                            System.out.println("This lecturer does not exist!");
                            continue;
                        } catch (ExistsException ignored) {

                        }



                        String committeeName = null;
                        while(true) {
                            try {
                                System.out.println("Enter committee name: ");
                                committeeName = scanner.nextLine();
                                college.hasCommittee(committeeName);
                                System.out.println("This committee does not exist!");
                            } catch (ExistsException ex) {
                                break;
                            }

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

                        try {
                            college.hasCommittee(committeeName);
                            continue;
                        } catch (ExistsException ignored) {

                        }

                        System.out.println("Enter lecturer name to replace " + committeeName + "'s chairman (Should be a valid lecturer with at least doctor degree): ");
                        String lecturerName;

                        while (true) {
                            lecturerName = scanner.nextLine();
                            try {
                                college.hasLecturer(lecturerName);
                                System.out.println("This lecturer does not exist!");
                                System.out.println("Enter lecturer name to replace " + committeeName + "'s chairman: ");
                            } catch (ExistsException ex) {
                                break;
                            }
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

                        try {
                            college.hasLecturer(lecturerName);
                            System.out.println("This lecturer does not exist!");
                        } catch (ExistsException ex) {
                            continue;
                        }


                        String committeeName = null;
                        while (true) {
                            System.out.println("Enter committee name: ");
                            committeeName = scanner.nextLine();
                            try {
                                college.hasCommittee(committeeName);
                                System.out.println("This committee does not exist!");
                            } catch (ExistsException ex) {
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

                    try {
                        college.hasDepartment(departmentName);
                    } catch (ExistsException ex) {
                        System.out.println(ex.getMessage());
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


                        try {
                            college.hasLecturer(lecturerName);
                            System.out.println("This lecturer does not exist!");
                        } catch (ExistsException ex) {
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
                    float salariesCombined = 0;

                    for (Lecturer lecturer : college.getLecturers()) {
                        salariesCombined +=  lecturer.getSalary();
                    }
                    System.out.println(college.getName() + "'s average salary is: " + salariesCombined/college.getLecturers().length);

                    break;
                case "8":
                    System.out.println("Enter department name: ");
                    String departmentNam = scanner.nextLine();
                    Department department1 = college.getDepartmentByName(departmentNam);

                    if (department1 == null) {
                        System.out.println(departmentNam + " department does not exist!");
                        break;
                    }

                    float averageSalary = 0;

                    for (Lecturer lecturer : department1.getLecturers()) {
                        if (lecturer == null) continue;
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

                case "11":
                    System.out.println("Enter Prof/Doctor lecturer name 1: ");
                    String lec1Name = scanner.nextLine();

                    try {
                        college.hasLecturer(lec1Name);
                        continue;
                    } catch (ExistsException ignored) {}

                    Lecturer lecturer1 = college.getLecturerByName(lec1Name);

                    if (!(lecturer1 instanceof DocDegLecturer doc1)) {
                        System.out.println("Lecturer " + lec1Name +  " gotta have at least a Doctor degree!");
                        continue;
                    }

                    System.out.println("Enter Prof/Doctor lecturer name 2: ");
                    String lec2Name = scanner.nextLine();

                    try {
                        college.hasLecturer(lec2Name);
                        continue;
                    } catch (ExistsException ignored) {}

                    Lecturer lecturer2 = college.getLecturerByName(lec2Name);

                    if (!(lecturer2 instanceof DocDegLecturer doc2)) {
                        System.out.print("Lecturer " + lec2Name +  " gotta have at least a Doctor degree!");
                        continue;
                    }


                    if (doc1.getPublishedArticlesCount() == doc2.getPublishedArticlesCount()) {
                        System.out.println(doc1.getName() + " and " + doc2.getName() + " have the same amount of published articles!");
                    } else {
                        System.out.println(doc1.getName() + " and " + doc2.getName() + " have the different amount of published articles!");
                    }
                    break;

                case "12":
                    System.out.println("Enter department 1 name: ");

                    String department1Name = scanner.nextLine();
                    try {
                        college.hasDepartment(department1Name);
                    } catch (ExistsException ignored) {}

                    department1 = college.getDepartmentByName(department1Name);

                    System.out.println("Enter department 1 name: ");

                    String department2Name = scanner.nextLine();
                    try {
                        college.hasDepartment(department2Name);
                    } catch (ExistsException ignored) {}

                    Department department2 = college.getDepartmentByName(department1Name);

                    if (department1.getLecturerCount() == department2.getLecturerCount() ) {
                        System.out.println(department1Name + " & " + department2Name + " have the same amount of lecturers");
                    } else {
                        System.out.println(department1Name + " & " + department2Name + " have different amount of lecturers");
                    }


                    break;


                case "13":

                    System.out.println("Enter department 1 name: ");

                    String department3Name = scanner.nextLine();
                    try {
                        college.hasDepartment(department3Name);
                    } catch (ExistsException ignored) {}

                    Department department3 = college.getDepartmentByName(department3Name);

                    System.out.println("Enter department 1 name: ");

                    String department4Name = scanner.nextLine();
                    try {
                        college.hasDepartment(department4Name);
                    } catch (ExistsException ignored) {}

                    Department department4 = college.getDepartmentByName(department4Name);

                    if (department3.getAllPublishedArticlesCount() == department4.getAllPublishedArticlesCount()) {
                        System.out.println(department3Name + " & " + department4Name + " have the same amount of articles published by the lecturers");
                    } else {
                        System.out.println(department3Name + " & " + department4Name + " have different amount of articles published by the lecturers");
                    }
                    break;

                case "14":

                    Committee committee;
                    while(true) {
                        System.out.println("Enter committee name that u want to copy: ");
                        String committeeName = scanner.nextLine();
                        try {
                            college.hasCommittee(committeeName);
                            System.out.println(committeeName + " doesn't exist");
                        } catch (ExistsException ignored) {
                            committee = college.getCommitteeByName(committeeName);
                            break;
                        }
                    }
                    college.addCommittee(committee.copy());
                    System.out.println("Successfully copied the committee, new committee name is: " + committee.getName() + "-new");
                    break;


                default:
                    System.out.println("Invalid function!");
                    break;
            }


            System.out.println(" ");
        }

    }
}


