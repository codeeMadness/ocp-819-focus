package Chapter8.Concurrency.eConcurrentCollection;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWrite {
    public static void main(String[] args) {
        //These classes copy all of their elements
        //to a new underlying structure anytime an element is added, modified, or removed from the collection

        //The CopyOnWrite classes can use a lot of memory, since a new collection structure needs be allocated
        //anytime the collection is modified.

        List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4,3,42));
        for(var n: favNumbers) {
            System.out.print(n + " ");
            favNumbers.add(9);
        }
        System.out.println(); //4 3 42
        System.out.println("Size: " + favNumbers.size()); //6 ==> 4 9 3 9 42 9

        Set<Character> favLetters = new CopyOnWriteArraySet<>(List.of('a','t'));
        for(char c: favLetters) {
            System.out.print(c+" ");
            favLetters.add('s');
        }
        System.out.println(); //a t
        System.out.println("Size: "+ favLetters.size()); //3 a s t
    }
}
