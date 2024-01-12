package Chapter10.SecureCoding.eConstructSensitiveObject;

public class ConstructorPrivate {
    public class FoodOrder {
        private String item;
        private int count;
        private FoodOrder(String item, int count) {
            setItem(item);
            setCount(count);
        }public FoodOrder getOrder(String item, int count) {
            return new FoodOrder(item, count);
        }
        public String getItem() { return item; }
        public void setItem(String item) { this.item = item; }
        public int getCount() { return count; }
        public void setCount(int count) { this.count = count; }
    }
}
