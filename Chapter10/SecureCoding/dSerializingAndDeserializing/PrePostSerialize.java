package Chapter10.SecureCoding.dSerializingAndDeserializing;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PrePostSerialize {
    public class Employee implements Serializable {
        private String name;
        private String ssn;
        private Map<String,Employee> pool = new ConcurrentHashMap<>();

        //it is run after the readObject()
        public synchronized Object readResolve() throws ObjectStreamException {
            var existingEmployee = pool.get(name);
            if(pool.get(name) == null) {
                // New employee not in memory
                pool.put(name, this);
                return this;
            } else {
                // Existing user already in memory
                existingEmployee.name = this.name;
                existingEmployee.ssn = this.ssn;
                return existingEmployee;
            }
        }

        //it is run before writeObject()
        public Object writeReplace() throws ObjectStreamException {
            var e = pool.get(name);
            return e != null ? e : this;
        }
    }
}
