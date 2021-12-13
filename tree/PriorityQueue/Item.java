package PriorityQueue;

public class Item {

    String key;
    int priority;

    Item(String key,int priority){
        this.key = key;
        this.priority = priority;
    }

    public String getKey() {
        return key;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Item{" +
                "key='" + key + '\'' +
                ", priority=" + priority +
                '}';
    }
}
