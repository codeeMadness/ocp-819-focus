package Chapter5.ArraysAndCollections.bJavaArrayList;

import java.util.ArrayList;

public class Creating {
    public static void main(String[] args) {
        //VALID declare
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList(10); //can expand
        ArrayList list3 = new ArrayList(list2); //make a copy of list 2

        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<>();

        //The type of var is ArrayList<String>
        var strings = new ArrayList<String>();
        strings.add("a");
        for (String s: strings) { }

        //The type of the var is ArrayList<Object>
        var list = new ArrayList<>();
        list.add("a");
//        for (String s: list) { } // DOES NOT COMPILE
    }
}
