import java.util.Scanner;

// CIE Package
class CIE {
    static class Student {
        protected String usn;
        protected String name;
        protected int sem;

        public Student(String usn, String name, int sem) {
            this.usn = usn;
            this.name = name;
            this.sem = sem;
        }

        public String getUsn() {
            return usn;
        }

        public String getName() {
            return name;
        }

        public int getSem() {
            return sem;
        }
    }

    static class Internals {
        protected int[] internalMarks;

        public Internals(int[] internalMarks) {
            this.internalMarks = internalMarks;
        }

        public int[] getInternalMarks() {
            return internalMarks;
        }

        public void setInternalMarks(int[] internalMarks) {
            this.internalMarks = internalMarks;
        }
    }
}

// SEE Package
class SEE {
    static class External extends CIE.Student {
        private int[] externalMarks;
        private CIE.Internals internals;  // Reference to Internals class

        public External(String usn, String name, int sem, int[] internalMarks, int[] externalMarks) {
            super(usn, name, sem);  // Call the constructor of Student class
            this.externalMarks = externalMarks;
            this.internals = new CIE.Internals(internalMarks);  // Store internal marks in the Internals class
        }

        public int[] getExternalMarks() {
            return externalMarks;
        }

        public void setExternalMarks(int[] externalMarks) {
            this.externalMarks = externalMarks;
        }

        public int calculateFinalMarks() {
            int totalMarks = 0;
            int[] internalMarks = internals.getInternalMarks();  // Get internal marks from the Internals class
            for (int i = 0; i < 5; i++) {
                totalMarks += internalMarks[i] + externalMarks[i];  // Sum internal and external marks
            }
            return totalMarks;
        }
    }
}

// Main Program
public class ciepackage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after nextInt()

        for (int i = 0; i < n; i++) {
            // Input student personal details
            System.out.print("Enter USN for student " + (i + 1) + ": ");
            String usn = scanner.nextLine();
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter semester for student " + (i + 1) + ": ");
            int sem = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character after nextInt()

            // Input internal marks
            int[] internalMarks = new int[5];
            System.out.println("Enter internal marks for 5 courses for student " + (i + 1) + ": ");
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = scanner.nextInt();
            }
            scanner.nextLine();  // Consume the newline character after nextInt()

            // Input external marks
            int[] externalMarks = new int[5];
            System.out.println("Enter external marks for 5 courses for student " + (i + 1) + ": ");
            for (int j = 0; j < 5; j++) {
                externalMarks[j] = scanner.nextInt();
            }
            scanner.nextLine();  // Consume the newline character after nextInt()

            // Create External object to calculate final marks
            SEE.External student = new SEE.External(usn, name, sem, internalMarks, externalMarks);
            int finalMarks = student.calculateFinalMarks();  // No need to pass internalMarks here anymore

            System.out.println("\nFinal marks for " + student.getName() + " (" + student.getUsn() + "):");
            System.out.println("Total Marks: " + finalMarks);
        }

        scanner.close();
    }
}
