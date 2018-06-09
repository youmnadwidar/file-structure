package eg.edu.alexu.csd.filestructure.Hashing;

import java.util.ArrayList;
import java.util.Collection;

public class linearTable implements HashTable {

    private short[][] hashFunction;
    private HashTable[] finalTable;
    private Hash hash;
    private int sumN2;

    public int getSumN2() {
        return sumN2;
    }

    @Override
    public boolean findKey(int key) {
        if (finalTable != null) {
            int index = hash.getHashedIndex(hashFunction, key);
            index %= finalTable.length;
            if (finalTable[index] != null) {
                return finalTable[index].findKey(key);
            }
        }
        return false;
    }

    @Override
    public void insertList(Collection keys) {
        ArrayList keysElements = new ArrayList(keys);
        ArrayList[] elements;
        hash = new Hash();
        elements = new ArrayList[keys.size()];
        hashFunction = hash.makeHashFunction(hash.getBits(keys.size()));
        for (int i = 0; i < keys.size(); i++) {

            int index = hash.getHashedIndex(hashFunction, (Integer) keysElements.get(i));
            index = index % keys.size();
            if (elements[index] == null) {
                elements[index] = new ArrayList();
            }
            if (!elements[index].contains(keysElements.get(i))) {
                elements[index].add(keysElements.get(i));
            }

        }
        reHash(elements);

    }

    private void reHash(ArrayList[] elements) {
        sumN2 = 0;
        finalTable = new HashTable[elements.length];
        for (int i = 0; i < elements.length; i++) {

            finalTable[i] = new quadraticTable();

            if (elements[i] != null) {
                finalTable[i].insertList(elements[i]);
                sumN2 += Math.pow(elements[i].size(), 2);
            }


        }

    }


}
