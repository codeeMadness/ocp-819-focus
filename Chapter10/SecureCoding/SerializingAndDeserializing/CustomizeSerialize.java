package Chapter10.SecureCoding.SerializingAndDeserializing;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public class CustomizeSerialize {
    public static class Employee implements Serializable {
        private String name;
        private String ssn;
        private int age;
        // Constructors/getters/setters
        //  skips the age variable, without using the transient modifier
        private static final ObjectStreamField[] serialPersistentFields =
                { new ObjectStreamField("name", String.class),
                        new ObjectStreamField("ssn", String.class) };
        private static String encrypt(String input) {
            // Implementation omitted
            return "";
        }
        private static String decrypt(String input) {
            // Implementation omitted
            return "";
        }
        private void writeObject(ObjectOutputStream s) throws Exception {
            ObjectOutputStream.PutField fields = s.putFields();
            fields.put("name", name);
            fields.put("ssn", encrypt(ssn));

//            java.lang.IllegalArgumentException: no such field age with type int
//            fields.put("age", age);

            s.writeFields();
        }
        private void readObject(ObjectInputStream s) throws Exception {
            ObjectInputStream.GetField fields = s.readFields();
            this.name = (String)fields.get("name", null);
            this.ssn = decrypt((String)fields.get("ssn", null));
        }
    }
}
