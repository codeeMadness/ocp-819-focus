package Chapter10.SecureCoding.SerializingAndDeserializing;

import java.io.ObjectStreamField;
import java.io.Serializable;

public class FieldSerialize implements Serializable {
    private transient int age; //marking a field as transient prevents it from being serialized

    //specify fields to be serialized in an array
    private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("name", String.class) };

}
