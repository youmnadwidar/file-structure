package eg.edu.alexu.csd.filestructure.avl.cs72;

import eg.edu.alexu.csd.filestructure.avl.IAVLTree;
import eg.edu.alexu.csd.filestructure.avl.INode;

/**
 * Created by HP on 3/12/2018.
 */
/**
 * @author HP.
 *
 * @param <T> in .
 */
public class AvlTree<T extends Comparable<T>> implements IAVLTree<T> {

     /**
      * * Root of the avl tree.
      */
    private INode<T> root;
    /**
     * number of nodes in an avl tree.
     */
    private int numberOfNodes;



    /**
     * Insert the given value using the key
     * @param key the value to be inserted in the tree
     */
    @Override
    public final void insert(final T key) {
        if (root == null) {
            root = new Node<T>();
            root.setValue(key);
        } else {
        insertNode(key, (Node<T>) root);
        }

        numberOfNodes++;
     }

    /**
     * @param main rotated node.
     */
    private void rotateRight(final Node<T> main) {

        Node<T> x = (Node<T>) main.getLeftChild();
        Node<T> y = (Node<T>) x.getRightChild();
        Node<T> p = (Node<T>) main.getParent();
        if (p == null) {
            root = x;
        } else {
            p.setNewChild(main, x);
        }
        x.setParent(p);
        x.setRight(main);
        main.setParent(x);
        main.setLeft(y);
        if (y != null) {
            y.setParent(main);
        }
        SetNewHeight(main);
        SetNewHeight(x);



    }

    /**
     * @param key value inserted.
     * @param startNode root at first.then the root of the su
     * tree.
     */
    private void insertNode(final T key, final Node<T> startNode) {


        int compare = key.compareTo(startNode.getValue());
        if (compare <= 0) {
            if (startNode.getLeftChild() == null) {
                Node<T> newNode = new Node<T>();
                newNode.setValue(key);
                startNode.setLeft(newNode);
                newNode.setParent(startNode);

            } else {
            	insertNode(key,
            			(Node<T>) startNode.getLeftChild());
            }

        } else if (compare > 0) {
            if (startNode.getRightChild() == null) {
                Node<T> newNode = new Node<T>();
                newNode.setValue(key);
                startNode.setRight(newNode);
                newNode.setParent(startNode);
            } else {
            	insertNode(key,
            			(Node<T>)startNode.getRightChild());
			}
        }

       SetNewHeight(startNode);
        if (isBalanced(startNode)) {
            Rotate(startNode);
        }

    }

    /**
     * @param node update the new height
     */
    private void SetNewHeight(final Node<T> node) {

        int rightChildHeight = -1;
        int leftChildHeight = -1;
        if (node.getRightChild() != null) {
            rightChildHeight = ((Node<T>) node.getRightChild()).getHeight();
        }
        if (node.getLeftChild() != null) {
            leftChildHeight = ((Node<T>) node.getLeftChild()).getHeight();
        }
        int nodeHeight = Math.max(rightChildHeight
                ,leftChildHeight );
        node.setHeight(nodeHeight + 1);
    }
    /**
     * 
     * @param wantedNode
     */
    private void DeletedBalance(Node<T> wantedNode) {

        while (wantedNode != null){

            SetNewHeight(wantedNode);
            if (!isBalanced(wantedNode)) {
                Rotate(wantedNode);
            }
            wantedNode = (Node<T>) wantedNode.getParent();
        }


    }

    /**
     * @param node rotation root.
     */
    private void Rotate(final Node<T> node) {
        int rightChildHeight = -1;
        int leftChildHeight = -1;
        if (node.getRightChild() != null){
            rightChildHeight = ((Node<T>)
            		node.getRightChild()).getHeight();
        }
        if (node.getLeftChild() != null){
            leftChildHeight = ((Node<T>)
            		node.getLeftChild()).getHeight();
        }
        int comparison =  leftChildHeight - rightChildHeight;
        if (comparison > 0) {
            Node<T> nodeLeft = (Node<T>) node.getLeftChild();
            rightChildHeight = -1;
            leftChildHeight = -1;
            if (nodeLeft.getRightChild() != null) {
                rightChildHeight = ((Node<T>)
                		nodeLeft.getRightChild()).getHeight();
            }
            if (nodeLeft.getLeftChild() != null) {
                leftChildHeight = ((Node<T>)
                		nodeLeft.getLeftChild()).getHeight();
            }
            int compare  = leftChildHeight - rightChildHeight;
           if (compare > 0) {
               rotateRight(node);
           } else {
              rotateLeft(nodeLeft);
              rotateRight(node);
           }
        }else {
            Node<T> nodeRight = (Node<T>) node.getRightChild();
            rightChildHeight = -1;
            leftChildHeight = -1;
            if(nodeRight.getRightChild() != null){
                rightChildHeight = ((Node<T>)nodeRight.getRightChild()).getHeight();
            }
            if(nodeRight.getLeftChild() != null){
                leftChildHeight = ((Node<T>)nodeRight.getLeftChild()).getHeight();
            }
            int compare  = leftChildHeight - rightChildHeight ;
            if(compare < 0){
                rotateLeft(node);
            }else {
                rotateRight(nodeRight);
                rotateLeft(node);

            }
        }

    }

    private boolean isBalanced (final Node<T> node){
        int rightChildHeight = -1;
        int leftChildHeight = -1;
        if(node.getRightChild() != null){
            rightChildHeight = ((Node<T>)node.getRightChild()).getHeight();
        }
        if(node.getLeftChild() != null){
            leftChildHeight = ((Node<T>)node.getLeftChild()).getHeight();
        }
        int difference = Math.abs(rightChildHeight - leftChildHeight);
        return difference  < 2 ;
    }


    private Node<T> searchNode (final T key, final Node<T> starPoint) {
    	if(starPoint == null) {
    		return null;
    	}
        int compare = key.compareTo(starPoint.getValue());
        if (compare == 0) {
            return starPoint;
        } else if (compare < 0) {
            if (starPoint.hasLeftChild()) {
              return  searchNode(key, (Node<T>) starPoint.getLeftChild());
            }
        }else {
                if (starPoint.hasRightChild()) {
                    return searchNode(key, (Node<T>) starPoint.getRightChild());
                }
            }


        return null;

    }


    @Override
	public final boolean delete(final T key) {


        Node<T> node = new Node<T>();

        node = searchNode(key, (Node<T>) root);



        if (node != null) {
            if(numberOfNodes == 1){
                root = null ;
                numberOfNodes -- ;
                return true;
            }
            if(!node.hasLeftChild() && !node.hasRightChild()){
                Node<T> parentNode = (Node<T>) node.getParent();
                if(parentNode.hasLeftChild() &&
                        parentNode.getLeftChild().getValue().equals(key)){
                    parentNode.setLeft(null);
                    DeletedBalance(parentNode);
                }else if(parentNode.hasRightChild() &&
                        parentNode.getRightChild().getValue().equals(key)) {
                    parentNode.setRight(null);
                    DeletedBalance(parentNode);

                }

            }else {
                swap(node);
            }
            numberOfNodes -- ;
            return true;

        }
        return false;
    }
    /**
     * @param n the root of the rotated subtree.
     */
    public final void rotateLeft(final Node<T> n) {
        Node<T> r = (Node<T>) n.getRightChild();
        Node<T> p = (Node<T>) n.getParent();
        Node<T> l = (Node<T>) r.getLeftChild();
        if (p == null) {
            root = r;
        } else {
            p.setNewChild(n, r);
        }
        r.setParent(p);
        r.setLeft(n);
        n.setParent(r);
        n.setRight(l);
        if (l != null) {
            l.setParent(n);
        }
        SetNewHeight(n);
        SetNewHeight(r);
    }

    /**
     * @return size.
     */
        public final int size() {
        return numberOfNodes;
    }
        /**
         * @param node input.
         */
    private void swap(final Node<T> node) {

        Node<T> wantedNode = new Node<T>();
        if (node.hasLeftChild()) {

            wantedNode = (Node<T>) node.getLeftChild();
            while (wantedNode.hasRightChild()) {
                wantedNode = (Node<T>) wantedNode.getRightChild();
            }

            ((Node<T>) wantedNode.getParent()).setNewChild(wantedNode,
            		(Node<T>) wantedNode.getLeftChild());

        } else if (node.hasRightChild()) {

            wantedNode = (Node<T>) node.getRightChild();
            while (wantedNode.hasLeftChild()) {
                wantedNode = (Node<T>) wantedNode.getLeftChild();
            }

            ((Node<T>) wantedNode.getParent()).setNewChild(wantedNode, null);

        }
        node.setValue(wantedNode.getValue());
        DeletedBalance((Node<T>) wantedNode.getParent());


    }



    @Override
	public final boolean search(final T key) {
      if(searchNode(key , (Node<T>) root) == null){
          return false;
      }
          return true;
    }

    @Override
	public final int height() {
        if(root == null){
            return 0 ;
        }
        return ((Node<T>)root).getHeight() +1 ;
    }

    @Override
	public final INode<T> getTree() {
        return root;
    }
}
