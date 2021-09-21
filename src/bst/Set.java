package bst;

public interface Set<E> {
    void add(E e);

    int getSize();

    void remove(E e);

    boolean contains(E e);

    boolean isEmpty();

}
