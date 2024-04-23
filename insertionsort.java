public class insertionsort {
    public static void insertionsort(int[] array) {
        int n = array.length;

        // Iterate through the array
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements to the right until finding the correct position for the key
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key; // Place the key in its correct position
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        // Sort the array using insertion sort
        insertionsort(array);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
