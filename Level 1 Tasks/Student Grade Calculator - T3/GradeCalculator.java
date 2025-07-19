import java.util.*;

public class GradeCalculator {
    int grade;
    float avgGrade;

    public float AvgGradeCal(int[] grades) {
        int sum = 0;
        for (int grade : grades)
            sum += grade;
        return (float) sum / grades.length;
    }

    public static void main(String[] args) {
        GradeCalculator cal = new GradeCalculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of grades:");
        int numGrades = sc.nextInt();
        int[] grades = new int[numGrades];

        for (int i = 0; i < numGrades; i++){
            System.out.print("Enter grade " + (i + 1) + ": ");
             grades[i] = sc.nextInt();
        }

        float average = cal.AvgGradeCal(grades);
        System.out.println("Average grade: " + average);
    }
}
