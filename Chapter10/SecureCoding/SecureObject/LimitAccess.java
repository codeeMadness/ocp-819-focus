package Chapter10.SecureCoding.SecureObject;

import java.util.Map;

public class LimitAccess {
    public static class ComboLocks {
        //terrible implementation
//        public Map<String, String> combos;
        private Map<String, String> combos;
        public boolean isComboValid(String animal, String combo) {
            var correctCombo = combos.get(animal);
            return combo.equals(correctCombo);
        }
    }
}
