package eg.edu.alexu.csd.filestructure.avl.cs72;

import eg.edu.alexu.csd.filestructure.avl.IDictionary;

import java.io.File;

/**
 * Created by HP on 3/12/2018.
 */
public class Dictionary implements IDictionary {
    @Override
    public void load(File file) {

    }

    @Override
    public boolean insert(String word) {
        return false;
    }

    @Override
    public boolean exists(String word) {
        return false;
    }

    @Override
    public boolean delete(String word) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }
}
