package Chapter10.SecureCoding.aSecureObject;

import java.util.ArrayList;

public class Immutable {

    /**
    1. Mark the class as final.
    2. Mark all the instance variables private and final.
    3. Don't define any setter methods.
    4. Don't allow referenced mutable objects to be modified.
    5. Use a constructor to set all properties of the object, making a copy if needed.
    * */

     public final class Animal implements Cloneable {
         private final ArrayList<String> favoriteFoods;

         public Animal(ArrayList<String> favoriteFoods) {
             if(favoriteFoods == null)
                 throw new RuntimeException("favoriteFoods is required");
             this.favoriteFoods = new ArrayList<>(favoriteFoods);
         }
         public int getFavoriteFoodsCount() {
             return favoriteFoods.size();
         }
         public String getFavoriteFoodsElement(int index) {
             return favoriteFoods.get(index);
         }
    }
}
