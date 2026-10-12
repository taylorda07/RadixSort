package radixsort;

import java.util.Arrays;

public class RadixSortTest {

    public static void main(String[] args) {

        Integer[] numbers = {
            783, 99, 472, 182, 264, 543,
            356, 295, 692, 491, 94
        };

        System.out.println("CSC 400 - Module 5");
        System.out.println("Radix Sort - Integer Objects");
        System.out.println("-----------------------------");

        RadixSort.sort(numbers);

        System.out.println("-----------------------------");
        System.out.println("Final Sorted Result:");
        
System.out.println(Arrays.toString(numbers));
    }
}
