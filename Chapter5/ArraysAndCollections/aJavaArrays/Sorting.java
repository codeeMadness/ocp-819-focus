package Chapter5.ArraysAndCollections.aJavaArrays;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] numbers = { 6, 9, 1 };
        Arrays.sort(numbers);

        /**
         * rules:
         * number < letters
         * UPPERCASE < lowercase
         * ***/

        String[] strings = { "10", "9", "100" };
        Arrays.sort(strings); //10 100 9


    }
}
