package eg.edu.alexu.csd.filestructure.avl.cs72;

/**
 * Created by HP on 3/12/2018.
 */
public class Main {

    public static void main(String[] args){
        AvlTree tree = new AvlTree();

        tree.insert(3);
        tree.insert(7);
        tree.insert(22);
        tree.insert(5);
        tree.delete(22);
        System.out.println(tree.height());

    }
}
