import java.util.Scanner;

public class CountingSort {

    public static void countingSort(int[] ages) {
        int maxAge = 18;
        int minAge = 10;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void displayAges(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter student ages (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }

        System.out.println("\nAges before sorting:");
        displayAges(ages);

        countingSort(ages);

        System.out.println("\nAges after sorting:");
        displayAges(ages);

        scanner.close();
    }
}
