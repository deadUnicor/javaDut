public interface ICollection<T> {
    int size();
    void add(T o);
    void printContent();
    boolean contains(T val);
    void remove(int index);
    int capacity();
}
