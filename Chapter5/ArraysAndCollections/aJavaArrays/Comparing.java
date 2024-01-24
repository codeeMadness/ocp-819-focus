package Chapter5.ArraysAndCollections.aJavaArrays;

import java.util.Arrays;

public class Comparing {
    public static void main(String[] args) {
        Arrays.compare(new int[] {1,2}, new int[] {1}); //positive - first array is longer
        Arrays.compare(new int[] {1,2}, new int[] {1,2}); //==0 - equal
        Arrays.compare(new String[] {"a"}, new String[] {"aa"}); //negative - first element is substring
        Arrays.compare(new String[] {"a"}, new String[] {"A"}); //positiver - lower > UPPER
        Arrays.compare(new String[] {"a"}, new String[] {null}); //positiver - letters > null

        Arrays.mismatch(new int[] {1}, new int[] {1}); //-1 - equal
        Arrays.mismatch(new String[] {"a"}, new String[] {"A"}); //0 - first element different
        Arrays.mismatch(new int[] {1, 2}, new int[] {1}); //1 - second element different

    }
}
