import java.util.Arrays;

public class MergeSortChallenge {

    
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr; // Base case
        }

        int mid = arr.length / 2;

        
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        
        left = mergeSort(left);
        right = mergeSort(right);

      
        return merge(left, right);
    }


    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

       
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

   
    public static void printSorted(int[] arr) {
        int[] sortedArr = mergeSort(arr);
        System.out.println("Sorted: " + Arrays.toString(sortedArr));
    }

    
    public static void main(String[] args) {
        int[][] datasets = {
            {3, 0, -2, 7, 4, -5, 0},
            {5, 1, 3, 3, 2, 5, 1},
            {-4, -1, 0, 2, 6, 9},
            {10, 7, 5, 3, 1, 0, -1},
            {0, 0, -1, -1, -3, 0, 2},
            {12, -8, 4, 0, 19, 7, -3, 7, 2, -10, 5, 5, 14, 0, -1, 9, 3, -6, 8, 11}
        };

        for (int i = 0; i < datasets.length; i++) {
            System.out.println("\nTest " + (i + 1) + " Input: " + Arrays.toString(datasets[i]));
            printSorted(datasets[i]);
        }
    }
}
