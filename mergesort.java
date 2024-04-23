public class mergesort {
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return; // Array of size 1 or less is already sorted
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        // Split the array into left and right halves
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            rightArray[i - mid] = array[i];
        }

        // Recursively sort the left and right halves
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Merge the sorted halves
        merge(array, leftArray, rightArray);
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, j = 0, k = 0;

        // Merge leftArray and rightArray into array
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray, if any
        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray, if any
        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array);
        System.out.println("Sorted array:");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
