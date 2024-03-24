package Chapter5.ArraysAndCollections.bJavaArrayList;

import java.util.HashMap;
import java.util.Map;

public class ConvertMap {

    static class Student {
         private int age;
         private String name;

         public Student(int age, String name) {
              this.age = age;
              this.name = name;
         }

         public int getAge() {
              return age;
         }

         public void setAge(int age) {
              this.age = age;
         }

         public String getName() {
              return name;
         }

         public void setName(String name) {
              this.name = name;
         }

         public String getKey() {
              return age + "-" + name;
         }
    }

    public static void main(String[] args) {
         Student student1 = new Student(10, "John");
         Student student2 = new Student(18, "Harry");
         Student student3 = new Student(12, "Mary");

         System.out.println("===============ONE================");
         Map<Integer, Student> originalMap = new HashMap<>();
         originalMap.put(1, student1);
         originalMap.put(2, student2);
         originalMap.forEach((k,v) -> System.out.println(v.getAge() + " " + v.getName()));

         System.out.println("================TWO===============");
         Map<Integer, Student> map2 = new HashMap<>(originalMap);
         map2.remove(1);
         map2.put(3, student3);
         map2.forEach((k,v) -> System.out.println(v.getAge() + " " + v.getName()));
         originalMap.forEach((k,v) -> System.out.println(v.getAge() + " " + v.getName()));

         System.out.println("================THREE===============");
         Map<Integer, Student> map3 = Map.copyOf(originalMap);
//         map3.remove(1); //throws UnsupportedOperationException
//         map3.put(3, student3); //throws UnsupportedOperationException
         map3.forEach((k,v) -> System.out.println(v.getAge() + " " + v.getName()));
         originalMap.forEach((k,v) -> System.out.println(v.getAge() + " " + v.getName()));

         System.out.println("===============FOUR================");
         //Immutable Map
         Map<Integer, Student> map4 = Map.of(1, student1, 2, student2);
//         map4.remove(1); //throws UnsupportedOperationException
//         map4.put(3, student3); //throws UnsupportedOperationException
         map4.forEach((k,v) -> System.out.println(v.getAge() + " " + v.getName()));
         originalMap.forEach((k,v) -> System.out.println(v.getAge() + " " + v.getName()));

         System.out.println("===============FIVE================");
         Map<Student, Integer> originalMap2 = new HashMap<>();
         originalMap2.put(student1, student1.getAge());
         originalMap2.put(student2, student2.getAge());
         Map<Student, Integer> copy1 = new HashMap<>(originalMap2);
         Map<Student, Integer> copy2 = Map.copyOf(originalMap2);
         Map<Student, Integer> copy3 = Map.of(student1, student1.getAge(), student2, student2.getAge());

         for(Map.Entry<Student, Integer> entry : originalMap2.entrySet()) {
              Student key = entry.getKey();
              key.setName("Random");
         }
         originalMap2.forEach((k,v) -> System.out.println(k.getAge() + " " + k.getName() + " " + v));
         copy1.forEach((k,v) -> System.out.println(k.getAge() + " " + k.getName() + " " + v));
         copy2.forEach((k,v) -> System.out.println(k.getAge() + " " + k.getName() + " " + v));
         copy3.forEach((k,v) -> System.out.println(k.getAge() + " " + k.getName() + " " + v));
    }

     /**
      * new HashMap<>() => Map
      * Allow to insert/remove items: yes
      * Affect Original: no
      *
      * **/

     /**
      * Map.copyOf() => Map
      * Allow to insert/remove items: no
      * Affect Original: n/a
      *
      * **/

     /** Immutable Map
      *
      * Map.of() => Map
      * Allow to insert/remove items: no
      * Affect Original: n/a
      *
      * **/


}
