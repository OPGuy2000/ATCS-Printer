import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> list; 

    public Queue() {
        list = new LinkedList<T>();
    }

    public void offer(T val) {
        list.add(val);
    }

    public T poll() {
        return list.remove(0);
    }

    public T peek() {
        System.out.println();
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
