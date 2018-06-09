package eg.edu.alexu.csd.filestructure.Hashing;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String args[]) {
        reader read = new reader();
        linearTable table = new linearTable();

        List list = new ArrayList();
        list = read.readFile("D:/CSED/term 4/Data Structure/Hashing/testCases_lab3/testCases_lab4/keys100001000000.txt");
        table.insertList(list);
//    table.fin
//int[] keys = {3,5,2,7,6,9};
//Hash hash = new Hash() ;
////short [][] tobinary = new short[32][0];
////    tobinary = hash.toBinary(5);
////    tobinary = hash.toBinary(7689);
////    tobinary = hash.toBinary(908);
////    tobinary = hash.toBinary(8);
////    tobinary = hash.toBinary(25);
//ArrayList list = new ArrayList();
//    for (int i = 0; i < 1000000; i++) {
//        list.add(i);
//    }
//
//    long startTime = System.nanoTime();
//    table.insertList(list);
//
//    for (int i = 0; i < 1000000; i++) {
//
//        table.findKey(i);
//    }
//    long endTime = System.nanoTime();
//    System.out.println((endTime - startTime)/1000000.0/1000.0 );

//
//
//HashTable table = new linearTable();
//table.insertList(list);
//System.out.println(table.findKey(71));
//System.out.println(table.findKey(65));
//System.out.println(((linearTable) table).getSumN2());
//}


    }
}
