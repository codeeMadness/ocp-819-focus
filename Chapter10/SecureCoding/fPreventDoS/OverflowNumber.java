package Chapter10.SecureCoding.fPreventDoS;

public class OverflowNumber {
    public static void main(String[] args) {
        System.out.println(enoughRoomToAddLine(100)); //true
        System.out.println(enoughRoomToAddLine(2_000_000)); //false
        System.out.println(enoughRoomToAddLine(Integer.MAX_VALUE)); //true
    }

    //the input value requestedSize should have been checked before adding it to newLineSize.
    public static boolean enoughRoomToAddLine(int requestedSize) {
        int maxLength = 1_000_000;
        String newLine = "END OF FILE";
        int newLineSize = newLine.length();
        return requestedSize + newLineSize < maxLength;
    }
}
