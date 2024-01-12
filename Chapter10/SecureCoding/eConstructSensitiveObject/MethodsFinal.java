package Chapter10.SecureCoding.eConstructSensitiveObject;

//prevent override sensitive methods
public class MethodsFinal {
    public class FoodOrder {
        private String item;
        private int count;
        public FoodOrder(String item, int count) {
            setItem(item);
            setCount(count);
        }
        public final String getItem() { return item; }
        public final void setItem(String item) { this.item = item; }
        public final int getCount() { return count; }
        public final void setCount(int count) { this.count = count; }
    }
}
