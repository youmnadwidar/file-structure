package eg.edu.alexu.csd.filestructure.avl.cs72;

/**
 * Created by HP on 3/12/2018.
 */
public class Main {

    public static void main(String[] args){
        AvlTree tree = new AvlTree();

        for (int i = 1; i <  1000; ++i)
        tree.insert(i);
        System.out.println(tree.height());

    }
}
