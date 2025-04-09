import java.util.Scanner;

public class MergeSort {

    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            merge(prices, left, mid, right);
        }
    }

    public static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = prices[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = prices[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void displayPrices(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }

        System.out.println("\nBook prices before sorting:");
        displayPrices(prices);

        mergeSort(prices, 0, prices.length - 1);

        System.out.println("\nBook prices after sorting:");
        displayPrices(prices);

        scanner.close();
    }
}
