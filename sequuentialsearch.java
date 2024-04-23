public class sequuentialsearch {
    public static int sequentialSearch(int[] array, int target) {
        // Iterate through each element in the array
        for (int i = 0; i < array.length; i++) {
            // If the current element is equal to the target, return its index
            if (array[i] == target) {
                return i;
            }
        }
        // If target is not found, return -1
        return -1;
    }
    
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int target = 30;
        
        int result = sequentialSearch(array, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
