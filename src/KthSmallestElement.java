public class KthSmallestElement {

    public static int findKthSmallest(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k debe estar entre 1 y el tamaño del arreglo");
        }
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Ejemplos del enunciado
        System.out.println(findKthSmallest(new int[]{4, 2, 7, 10, 4, 17}, 3)); // 4
        System.out.println(findKthSmallest(new int[]{4, 2, 7, 10, 4, 1, 6}, 5)); // 6
        System.out.println(findKthSmallest(new int[]{4, 2, 7, 1, 4, 6}, 1)); // 1
        System.out.println(findKthSmallest(new int[]{9, 2, 7, 1, 7}, 4)); // 7
    }
}