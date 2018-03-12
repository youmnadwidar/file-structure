package eg.edu.alexu.csd.filestructure.avl;

/**
 * Created by HP on 3/12/2018.
 */
public interface INode<T extends Comparable<T>> {
    /**
     * Returns the left child of the current element/node in the heap tree
     * @return INode wrapper to the left child of the current element/node
     */
    INode<T> getLeftChild();
    /**
     * Returns the right child of the current element/node in the heap tree
     * @return INode wrapper to the right child of the current element/node
     */
    INode<T> getRightChild();
    /**
     * Set/Get the value of the current node
     * @return Value of the current node
     */
    T getValue();
    void setValue(T value);
}
