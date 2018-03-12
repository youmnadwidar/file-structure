package eg.edu.alexu.csd.filestructure.avl.cs72;

import eg.edu.alexu.csd.filestructure.avl.INode;

/**
 * Created by HP on 3/12/2018.
 */
public class Node implements INode {
    /**
     * . left child.
     */
    private INode leftChild;
    /**
     * . right child.
     */
    private INode rightChild;

    /**
     * . value.
     */
    private Comparable value;
    /**
     * . parent .
     */	private INode parent;



    public Node() {
        leftChild = null;
        rightChild = null;
    }

    public boolean hasLeftChild (){
        if (this.getLeftChild() == null) {
            return false;
        }
        return true;
    }

    public boolean hasRightChild (){
        if (this.getRightChild() == null) {
            return false;
        }
        return true;
    }

    public final void setLeft(final Node left) {
        this.leftChild = left;
    }

    public final void setRight(final Node right) {
        this.rightChild = right;
    }

    @Override
    public final INode getLeftChild() {
        return leftChild;
    }

    @Override
    public final INode getRightChild() {
        return rightChild;
    }


    @Override
    public final Comparable getValue() {
        return value;
    }

    @Override
    public final void setValue(final Comparable value) {
        this.value = value;
    }


    public INode getParent() {
        return parent;
    }

    public void setParent(INode parent) {
        this.parent = parent;
    }
}
