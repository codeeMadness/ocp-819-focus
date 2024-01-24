package Chapter5.ArraysAndCollections.bJavaArrayList;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxingAndUnBoxing {
    public static void main(String[] args) {
         List<Integer> weights = new ArrayList<>();
         Integer w = 50; //autobox from int to Integer
         weights.add(w); // [50]
         weights.add(Integer.valueOf(60)); // [50, 60]
         weights.remove(50); // [60] //autobox
         double first = weights.get(0); // 60.0 //unbox Integer to int and cast to double

         List<Integer> heights = new ArrayList<>();
         heights.add(null);
         int h = heights.get(0); // NullPointerException

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.remove(1); //remove index not item
        System.out.println(numbers);
    }
}
