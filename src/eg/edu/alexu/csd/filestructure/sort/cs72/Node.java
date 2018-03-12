package eg.edu.alexu.csd.filestructure.sort.cs72;

import eg.edu.alexu.csd.filestructure.sort.INode;

/**
 * Created by HP on 2/24/2018.
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
	 * . parent .
	 */	private INode parent;

	/**
	 * . value.
	 */
	private Comparable value;

	/**
	 * @param element
	 *            value of the node.
	 */
	public Node( Object element) {
		this.parent = null;
		this.value = (java.lang.Comparable) element;
		leftChild = null;
		rightChild = null;
	}



	public final void setLeft(final INode left) {
		this.leftChild = left;
	}

	public final void setRight(final INode right) {
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
	public final INode getParent() {
		return parent;
	}

	@Override
	public final Comparable getValue() {
		return value;
	}

	@Override
	public final void setValue(final Comparable value) {
		this.value = value;
	}

	/**
	 * @param iNode.
	 *            .
	 */
	public final void setParentChild(final INode iNode) {

		this.parent = iNode;
		if (iNode.getLeftChild() == (null)) {
			((Node) iNode).setLeft(this);
		} else {
			((Node) iNode).setRight(this);

		}
	}

	/**
	 * @param last.
	 *            input.
	 */
	public final void removeChild(final Node last) {
		if (this.getLeftChild() != null) {
			if (this.getLeftChild().equals(last)) {
				this.setLeft(null);
			} else {
				this.setRight(null);
			}
		}
	}

}
