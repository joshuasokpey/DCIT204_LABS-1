import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

 
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] arr = new int[size];


        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }


        System.out.print("Enter the target value to search for: ");
        int target = input.nextInt();

        // Perform Linear Search
        int linearResult = Algorithm.linearSearch(arr, target);

        System.out.println("\n--- Linear Search Result ---");
        if (linearResult != -1) {
            System.out.println("Target found at index " + linearResult);
        } else {
            System.out.println("Target not found.");
        }

     
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        int[] originalIndex = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            originalIndex[i] = i;
        }

        for (int i = 0; i < sortedArr.length - 1; i++) {
            for (int j = 0; j < sortedArr.length - 1 - i; j++) {

                if (sortedArr[j] > sortedArr[j + 1]) {

                  
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;

                   
                    int tempIndex = originalIndex[j];
                    originalIndex[j] = originalIndex[j + 1];
                    originalIndex[j + 1] = tempIndex;
                }
            }
        }

    
        int binaryResult = Algorithm.binarySearch(sortedArr, target);

        System.out.println("\n--- Binary Search Result ---");
        if (binaryResult != -1) {
            System.out.println("Target found.");
            System.out.println("Position in sorted array: " + binaryResult);
            System.out.println("Original index position: " + originalIndex[binaryResult]);
        } else {
            System.out.println("Target not found.");
        }

        input.close();
    }
}
