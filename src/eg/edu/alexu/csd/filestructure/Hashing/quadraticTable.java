package eg.edu.alexu.csd.filestructure.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class quadraticTable implements HashTable {
    private short[][] hashFunction;
    private int[] elements;
    private Hash hash;
    private int reHashing;

    public int getTableSize() {
        return elements.length;
    }

    @Override
    public boolean findKey(int key) {
        if (elements != null) {
            if (elements.length < 2) {
                return key == elements[0];
            }
            int index = hash.getHashedIndex(hashFunction, key);
            index %= elements.length;
            return elements[index] == key;
        }
        return false;
    }

    @Override
    public void insertList(Collection keys) {
        hash = new Hash();
        boolean flag;
        reHashing = -1;
        if (keys == null) {
            return;
        }
        int arraySize = (int) Math.pow(keys.size(), 2);
        elements = new int[arraySize];
        ArrayList keysElements = new ArrayList(keys);
        if (keys.size() == 1) {
            elements[0] = (int) keysElements.get(0);
            return;
        }
        do {
            hashFunction = hash.makeHashFunction(hash.getBits(arraySize));
            flag = hashElements(keysElements);
            reHashing++;
        } while (!flag);

    }


    private boolean hashElements(ArrayList keys) {
        Arrays.fill(elements, -1);
        for (int i = 0; i < keys.size(); i++) {
            int key = (int) keys.get(i);
            int index = hash.getHashedIndex(hashFunction, key);
            //   index %= keys.size();
            if ((elements[index] == -1) || key == elements[index]) {
                elements[index] = key;
            } else {
                return false;
            }
        }
        return true;
    }

    public int getReHashing() {
        return reHashing;
    }
}
