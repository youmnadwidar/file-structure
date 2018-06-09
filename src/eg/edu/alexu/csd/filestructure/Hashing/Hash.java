package eg.edu.alexu.csd.filestructure.Hashing;

import java.util.Random;

public class Hash {

    public int getHashedIndex(short[][] hashFunction, int key) {
        String binary = this.binaryString(key);
        short[][] hashedKey = this.toBinary(binary);
        short[][] indexHashed = this.getHashedKey(hashedKey, hashFunction, binary.length());
        return this.getIndex(indexHashed);

    }

    public int getBits(int size) {

        return (int) Math.floor(Math.log(size) / Math.log(2));

    }

    private String binaryString(int x) {
        String binaryString = Integer.toBinaryString(x);
        return binaryString;
    }

    private short[][] toBinary(String binaryString) {
        short[][] binaryKey = new short[32][1];


        for (int i = 0; i < binaryString.length(); i++) {
            int index = 32 - binaryString.length() + i;
            binaryKey[index][0] = Short.valueOf(Character.toString(binaryString.charAt(i)));
        }

        return binaryKey;
    }

    private int getIndex(short[][] hashedKey) {

        StringBuilder hashedString = new StringBuilder();
        for (int i = 0; i < hashedKey.length; i++) {
            String digit = Short.toString(hashedKey[i][0]);
            hashedString.append(digit);

        }
        int index = Integer.parseInt(hashedString.toString(), 2);

        return index;

    }

    public short[][] makeHashFunction(int bits) {

        short[][] hashFunction = new short[bits][32];
        for (int i = 0; i < bits; i++) {
            for (int j = 0; j < 32; j++) {
                Random random = new Random();
                hashFunction[i][j] = (short) random.nextInt(2);
            }
        }
        return hashFunction;
    }

    private short[][] getHashedKey(short[][] key, short[][] hashFunction, int size) {

        short[][] hashedKey = new short[hashFunction.length][1];
        for (int i = 0; i < hashFunction.length; i++) {
            short element = 0;
            for (int j = 0; j < size; j++) {
                element += hashFunction[i][31 - j] * key[31 - j][0];
            }
            hashedKey[i][0] = (short) (element % 2);

        }
        return hashedKey;
    }
}
