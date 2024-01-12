package Chapter10.SecureCoding.aSecureObject;

import java.util.ArrayList;

public class Cloning {
    public static final class Animal implements Cloneable {
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

        //an implementation that does a deep copy and clones the objects inside
        public Animal clone() {
            ArrayList<String> listClone = (ArrayList) favoriteFoods.clone();
            return new Animal(listClone);
        }

        public static void main(String[] args) throws Exception {
            ArrayList<String> food = new ArrayList<>();
            food.add("grass");
            Animal sheep = new Animal(food);
            Animal clone = (Animal) sheep.clone(); //shallow copy: only the top-level object references and primitives are copied
            System.out.println(sheep == clone); //false
            System.out.println(sheep.favoriteFoods == clone.favoriteFoods); //true if no deep copy apply
        }
    }

}
