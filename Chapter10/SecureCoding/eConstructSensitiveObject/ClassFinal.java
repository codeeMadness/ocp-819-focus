package Chapter10.SecureCoding.eConstructSensitiveObject;

public class ClassFinal {
    //make methods final is extra work -> make class final instead
    public final class FoodOrder {
        private String item;
        private int count;
        public FoodOrder(String item, int count) {
            setItem(item);
            setCount(count);
        }
        public String getItem() { return item; }
        public void setItem(String item) { this.item = item; }
        public int getCount() { return count; }
        public void setCount(int count) { this.count = count; }
    }
}
