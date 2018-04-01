package eg.edu.alexu.csd.filestructure.avl.cs72;

import eg.edu.alexu.csd.filestructure.avl.IDictionary;

import java.io.*;


public class Dictionary implements IDictionary {
    private AvlTree<String> tree;

    public Dictionary() {
        tree = new AvlTree<String>();
    }

    @Override
    public void load(File file) {
        String line = null;

        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                tree.insert(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file.getAbsolutePath() + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + file.getAbsolutePath() + "'");

        }
    }

    @Override
    public boolean insert(String word) {
        if (this.exists(word)) {
            return false;
        }
        tree.insert(word);
        return true;
    }

    @Override
    public boolean exists(String word) {
        return tree.search(word);
    }

    @Override
    public boolean delete(String word) {
        if (this.exists(word)) {
            tree.delete(word);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public int height() {
        return tree.height();
    }
}
