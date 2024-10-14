import java.util.Scanner;
class Student {
    private String usn;          // University Serial Number
    private String name;         // Student name
    private int[] credits;       // Array of credits for each subject
    private int[] marks;         // Array of marks for each subject

    // Constructor to initialize the student
    public Student(int numSubjects) {
        credits = new int[numSubjects];
        marks = new int[numSubjects];
    }

    // Method to accept student details
    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = scanner.nextLine();

        System.out.print("Enter Name: ");
        name = scanner.nextLine();

        for (int i = 0; i < credits.length; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Credits and Marks:");

        for (int i = 0; i < credits.length; i++) {
            System.out.println("Subject " + (i + 1) + " - Credits: " + credits[i] + ", Marks: " + marks[i]);
        }

        System.out.println("SGPA: " + calculateSGPA());
    }

    // Method to calculate SGPA
    public double calculateSGPA() {
        double totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < credits.length; i++) {
            // Assuming that the marks are out of 100 and grade points are out of 10
            int gradePoint = (marks[i] / 10); // Convert marks to grade points
            totalPoints += (gradePoint+1) * credits[i];
            totalCredits += credits[i];
        }

        if (totalCredits == 0) {
            return 0; // Avoid division by zero
        }
	System.out.println(totalPoints);
        return totalPoints / totalCredits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();

        Student student = new Student(numSubjects);
        student.acceptDetails();
        student.displayDetails();
    }
}
