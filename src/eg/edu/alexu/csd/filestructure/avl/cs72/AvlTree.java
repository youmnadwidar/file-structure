package eg.edu.alexu.csd.filestructure.avl.cs72;

import eg.edu.alexu.csd.filestructure.avl.IAVLTree;
import eg.edu.alexu.csd.filestructure.avl.INode;

/**
 * Created by HP on 3/12/2018.
 */
public class AvlTree implements IAVLTree {

    private INode root ;
    private int numberOfNodes ;

    public AvlTree() {
        numberOfNodes = 0;
    }


    @Override
    public void insert(Comparable key) {
        if(numberOfNodes == 0){
            root = new Node();
            root.setValue(key);
        }
        InsertNode(key ,(Node)root);
        numberOfNodes ++;
        Rotate();

        }

    private void Rotate() {
    }

    private void InsertNode(Comparable key ,Node startNode) {



        int compare = key.compareTo(startNode.getValue());
        if( compare < 0){
            if(startNode.getLeftChild() == null){
                Node newNode = new Node();
                newNode.setValue(key);
                startNode.setLeft(newNode);
                newNode.setParent(startNode);
                return;
            }
            InsertNode(key , (Node) startNode.getLeftChild());
        }else if(compare > 0 ){
            if(startNode.getRightChild() == null){
                Node newNode = new Node();
                newNode.setValue(key);
                startNode.setRight(newNode);
                newNode.setParent(startNode);
                return;
            }
            InsertNode(key , (Node) startNode.getRightChild());
        }



    }


    private Node searchNode (Comparable key, Node starPoint) {
        int compare = key.compareTo(starPoint.getValue());
        if (compare == 0) {
            return starPoint;
        } else if (compare < 0) {
            if (starPoint.hasLeftChild()) {
              return  searchNode(key, (Node) starPoint.getLeftChild());
            }
        }else {
                if (starPoint.hasRightChild()) {
                    return searchNode(key, (Node) starPoint.getRightChild());
                }
            }


        return null;

    }
    @Override
    public boolean delete(Comparable key) {
            Node node = new Node();
            node = searchNode(key, (Node) root);


        if (node != null) {
            if(!node.hasLeftChild() && !node.hasRightChild()){
              Node parentNode = (Node) node.getParent();
              if(parentNode.hasLeftChild() &&
                      parentNode.getLeftChild().getValue().equals(key)){
                  parentNode.setLeft(null);
              }else if(parentNode.hasRightChild() &&
                      parentNode.getRightChild().getValue().equals(key)) {
                  parentNode.setRight(null);
              }

            }else {
                swap(node);
            }
            numberOfNodes -- ;
            return true;

        }
        return false;
    }

    private void swap (Node node) {

        Node wantedNode = new Node() ;
        if(node.hasLeftChild()) {

             wantedNode = (Node) node.getLeftChild();
            while(wantedNode.hasRightChild()){
                wantedNode = (Node) wantedNode.getRightChild();
            }

        }else if(node.hasRightChild()) {

            wantedNode = (Node) node.getRightChild();
            while(wantedNode.hasLeftChild()){
                wantedNode = (Node) wantedNode.getLeftChild();
            }


        }
        node.setValue(wantedNode.getValue());
        wantedNode = null ;

    }

    @Override
    public boolean search(Comparable key) {
      if(searchNode(key , (Node) root) == null){
          return false;
      }
          return true;
    }

    @Override
    public int height() {
        if(numberOfNodes == 0){
            return  0 ;
        }
        return (int) (Math.log(numberOfNodes) / Math.log(2)) +1 ;
    }

    @Override
    public INode getTree() {
        return root;
    }
}
