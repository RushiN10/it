public class bubblesort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        
        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place, so no need to check them
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is greater than the next element, swap them
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        // Sort the array using bubble sort
        bubbleSort(array);
        
        // Print the sorted array
        System.out.println("Sorted array:");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
