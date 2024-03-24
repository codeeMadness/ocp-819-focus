package Chapter5.ArraysAndCollections.bJavaArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertList {
    public static void main(String[] args) {
         System.out.println("================ONE===============");
         /**Convert List to Array**/
         List<String> originalList = new ArrayList<>();
         originalList.add("hawk");
         originalList.add("robin");
         //no relationship to the original List. It is simply a copy
         Object[] objectArray = originalList.toArray();

         originalList.clear();
         System.out.println(objectArray.length); // 2

         System.out.println("================TWO===============");
         /**Convert Array to List**/
         String[] originalArray = { "hawk", "robin" }; // [hawk, robin]
         List<String> list2 = Arrays.asList(originalArray); // returns fixed size list

         //It updates both array and list because they point to the same data store
         list2.set(1, "test");
         originalArray[0] = "new";
         System.out.println(Arrays.toString(originalArray));// [new, test]
         list2.forEach(System.out::println);// [new, test]

         //we are not allowed to change the size of the list
//         list2.remove(1); // throws UnsupportedOperationException

         System.out.println("=================THREE==============");
         /**Immutable List**/
         String[] array2 = { "hawk", "robin" }; // [hawk, robin]
         List<String> list3 = List.of(array2); // returns immutable list
         array2[0] = "new";
         System.out.println(Arrays.toString(array2)); // [new, robin]
         System.out.println(list3); // [hawk, robin]
//         list3.set(1, "test"); // throws UnsupportedOperationException
    }

    /**
     * List.toArray() => Array
     * Allow to remove items: no
     * Allow to update items: yes
     * Affect Original: no
     *
     * **/

     /**
      * Arrays.asList() => List
      * Allow to remove items: no
      * Allow to update items: yes
      * Affect Original: yes
      *
      * **/

     /** Immutable list
      *
      * List.of() => List
      * Allow to remove items: no
      * Allow to update items: no
      * Affect Original: n/a
      *
      * **/
}
