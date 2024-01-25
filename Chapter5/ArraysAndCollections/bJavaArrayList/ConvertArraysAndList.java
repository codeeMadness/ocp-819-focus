package Chapter5.ArraysAndCollections.bJavaArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertArraysAndList {
    public static void main(String[] args) {
         /**Convert List to Array**/
         List<String> list = new ArrayList<>();
         list.add("hawk");
         list.add("robin");
         Object[] objectArray = list.toArray();

         //The advantage of specifying a size of 0 for the parameter is that Java will create a new array of the proper
         //size for the return value
         String[] stringArray = list.toArray(new String[0]);

         //toArray() This does not affect either array
         //no relationship to the original List. It is simply a copy
         list.clear();

         System.out.println(objectArray.length); // 2
         System.out.println(stringArray.length); // 2

         /**Convert Array to List**/
         String[] array = { "hawk", "robin" }; // [hawk, robin]
         //Note that it isn’t the java.util.ArrayList we’ve
         //grown used to. It is a fixed-size, backed version of a List
         List<String> list2 = Arrays.asList(array); // returns fixed size list

         System.out.println(list2.size()); // 2
         //It updates both array and list because they point to the same data store
         list2.set(1, "test"); // [hawk, test]
         array[0] = "new"; // [new, test]
         System.out.print(Arrays.toString(array));// [new, test]

         //we are not allowed to change the size of the list
         list2.remove(1); // throws UnsupportedOperationException

         /**immutable List**/
         String[] array2 = { "hawk", "robin" }; // [hawk, robin]
         List<String> list3 = List.of(array); // returns immutable list
         System.out.println(list3.size()); // 2
         array2[0] = "new";
         System.out.println(Arrays.toString(array2)); // [new, robin]
         System.out.println(list3); // [hawk, robin]
         list3.set(1, "test"); // throws UnsupportedOperationException
    }

    /**
     * List.toArray() => Array
     * Allow to remove items: x
     * Allow to update items: v
     * Affect Original: x
     *
     * **/

     /**
      * Arrays.asList() => List
      * Allow to remove items: x
      * Allow to update items: v
      * Affect Original: v
      *
      * **/

     /** immutable list
      *
      * List.of() => List
      * Allow to remove items: x
      * Allow to update items: x
      * Affect Original: n/a
      *
      * **/
}
