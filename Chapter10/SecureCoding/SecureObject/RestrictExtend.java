package Chapter10.SecureCoding.SecureObject;

import java.util.Map;

public class RestrictExtend {
    //terrible
    public class EvilComboLocks extends ComboLocks {
        public boolean isComboValid(String animal, String combo) {
            var valid = super.isComboValid(animal, combo);
            if (valid) {
                // email the password to Hacker Harry
            }
            return valid;
        }
    }


//    public final class ComboLocks { //prevent extend using final
    public class ComboLocks {
        private Map<String, String> combos;
        // instantiate combos object
        public boolean isComboValid(String animal, String combo) {
            var correctCombo = combos.get(animal);
            return combo.equals(correctCombo);
        }
    }
}
