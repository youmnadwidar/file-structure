package eg.edu.alexu.csd.filestructure.sort.cs72;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        int[] at = {5,6,7,8,9,10};
        Collection a = new ArrayList<Integer>();
        a.add(33);
        a.add(6);
        a.add(72);
        a.add(85);
        a.add(0);
        a.add(4);
        a.add(100);

        Heap h = new Heap();
        h.build(a);
        h.insert(90);

        h.extract();

        h.sort();
    }

}
