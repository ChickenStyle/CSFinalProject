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
                    "\n3 - Add Course " +
                    "\n4 - Assign a lecturer to a committee " +
                    "\n5 - Show college lecturer average salary " +
                    "\n6 - Show specific course's lecturers average salary " +
                    "\n7 - Show all lecturers info " +
                    "\n8 - Show all committees info\n" +
                    "\n9 - "




            ;

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

                        if (!college.hasLecturer(chairmanName)) {
                            System.out.println("This lecturer does not exist!");
                            continue;
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
                        System.out.print("Enter course name: ");
                        String course = scanner.nextLine();
                        if (course.isEmpty()) continue;
                        if (college.addCourse(course)) {
                            System.out.println("Course added successfully!");
                            break;
                        } else {
                            System.out.println("Course already exists!");
                        }
                    }
                    break;

                case "4":
                    while (true) {
                        System.out.print("Enter lecturer name: ");
                        String lecturer = scanner.nextLine();
                        if (!college.hasLecturer(lecturer)) {
                            System.out.println("Lecturer doesn't exist!");
                            break;
                        }

                        System.out.print("Enter committee name: ");
                        String committee = scanner.nextLine();
                        if (!college.hasCommittee(committee)) {
                            System.out.println("Committee doesn't exist!");
                            break;
                        }


                        break;
                    }
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    System.out.print(college.getName() + "'s Lecturers:\n");
                    college.printLecturers();
                    break;
                case "8":
                    System.out.print(college.getName() + "'s Committees:\n");
                    college.printCommittees();
                    break;

                default:
                    System.out.println("Invalid function!");
                    break;
            }


            System.out.println(" ");
        }

    }
}


