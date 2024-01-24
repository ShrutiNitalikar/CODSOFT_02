import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");
        System.out.println("Enter marks (out of 100) for each subject:");

        // Constants
        int totalSubjects = 5;
        int maxMarksPerSubject = 100;

        // Input marks for each subject
        int[] subjectMarks = new int[totalSubjects];
        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            subjectMarks[i] = getValidMarks(scanner, maxMarksPerSubject);
        }

        // Calculate total marks and average percentage
        int totalMarks = calculateTotalMarks(subjectMarks);
        double averagePercentage = calculateAveragePercentage(totalMarks, totalSubjects, maxMarksPerSubject);

        // Assign grade based on average percentage
        char grade = calculateGrade(averagePercentage);

        // Display results
        System.out.println("\nResults:");
        displaySubjectWiseMarks(subjectMarks);
        System.out.println("Total Marks: " + totalMarks + " out of " + (totalSubjects * maxMarksPerSubject));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        // Close the Scanner
        scanner.close();
    }

    // Helper method to get valid marks (between 0 and maxMarks)
    private static int getValidMarks(Scanner scanner, int maxMarks) {
        int marks;
        do {
            marks = scanner.nextInt();
            if (marks < 0 || marks > maxMarks) {
                System.out.println("Invalid input. Marks should be between 0 and " + maxMarks + ". Please enter again:");
            }
        } while (marks < 0 || marks > maxMarks);
        return marks;
    }

    // Helper method to calculate total marks
    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    // Helper method to calculate average percentage
    private static double calculateAveragePercentage(int totalMarks, int totalSubjects, int maxMarksPerSubject) {
        return (double) totalMarks / (totalSubjects * maxMarksPerSubject) * 100;
    }

    // Helper method to calculate grade based on average percentage
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Helper method to display subject-wise marks
    private static void displaySubjectWiseMarks(int[] marks) {
        System.out.println("Subject-wise Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }
    }
}
