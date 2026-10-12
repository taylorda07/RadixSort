package radixsort;

import java.util.Arrays;

public class RadixSort {

    public static void sort(Integer[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }

        if (numbers.length == 0) {
            return;
        }

        int max = 0;

        for (Integer number : numbers) {
            if (number == null || number < 0) {
                throw new IllegalArgumentException(
                    "Only non-negative integers are supported.");
            }
            if (number > max) {
                max = number;
            }
        }

        System.out.println("Original Array: "
                + Arrays.toString(numbers));

        for (long place = 1; max / place > 0; place *= 10) {
            countingSort(numbers, place);

            System.out.println("After place " + place + ": "
                    + Arrays.toString(numbers));
        }

        System.out.println("Sorted Array: "
                + Arrays.toString(numbers));
    }

    private static void countingSort(Integer[] numbers, long place) {
        int n = numbers.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (int) ((numbers[i] / place) % 10);
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (int) ((numbers[i] / place) % 10);
            output[count[digit] - 1] = numbers[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, numbers, 0, n);
    }
}
