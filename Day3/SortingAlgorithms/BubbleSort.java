import java.util.Scanner;

public class BubbleSort {
    
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void displayMarks(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        
        int[] marks = new int[n];
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }
        
        System.out.println("\nStudent marks before sorting:");
        displayMarks(marks);
        
        bubbleSort(marks);
        
        System.out.println("\nStudent marks after sorting:");
        displayMarks(marks);
        
        scanner.close();
    }
}
