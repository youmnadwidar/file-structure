package eg.edu.alexu.csd.filestructure.Hashing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class reader {


    public List readFile(String file) {
        List<Integer> keys = new ArrayList<>();
        boolean[] inserted = new boolean[100000001];
        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split(",");
                for (int i = 0; i < numbers.length; i++) {
                    int number = Integer.valueOf(numbers[i]);
                    if (!inserted[number]) {
                        inserted[number] = true;
                        keys.add(number);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return keys;
    }

}
