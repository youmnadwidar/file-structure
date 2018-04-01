package eg.edu.alexu.csd.filestructure.avl.cs72;

import eg.edu.alexu.csd.filestructure.avl.INode;

/**
 * Created by HP on 3/12/2018.
 */
public class Node<T extends Comparable<T>> implements INode<T> {
    /**
     * . left child.
     */
    private INode<T> leftChild;
    /**
     * . right child.
     */
    private INode<T> rightChild;

    /**
     * . value.
     */
    private Comparable<T> value;
    /**
     * . parent .
     */	private INode<T> parent;

    private int height;

    public Node() {
        leftChild = null;
        rightChild = null;
        height = 0 ;
    }

    int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean hasLeftChild (){
        return this.getLeftChild() != null;
    }

    public boolean hasRightChild (){
        return this.getRightChild() != null;
    }

    public final void setLeft(final Node<T> left) {
        this.leftChild = left;
    }

    public final void setRight(final Node<T> right) {
        this.rightChild = right;
    }

    @Override
    public final INode<T> getLeftChild() {
        return leftChild;
    }

    @Override
    public final INode<T> getRightChild() {
        return rightChild;
    }


    @SuppressWarnings("unchecked")
    @Override
    public final T getValue() {
        return  (T) value;
    }

    @Override
    public final void setValue(final T value) {
        this.value = value;
    }


    public INode<T> getParent() {
        return parent;
    }

    public void setParent(INode<T> parent) {
        this.parent = parent;
    }

    public void setNewChild (Node<T> old , Node<T> newNode) {

        if (getLeftChild() == (old)) {
            setLeft(newNode);
            if(newNode != null) {
                newNode.setParent(this);
            }

        } else {
            setRight(newNode);
            if(newNode != null) {
                newNode.setParent(this);
            }
        }
    }
}
