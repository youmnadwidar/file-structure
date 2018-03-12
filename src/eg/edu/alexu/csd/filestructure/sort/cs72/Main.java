package eg.edu.alexu.csd.filestructure.sort.cs72;

import eg.edu.alexu.csd.filestructure.sort.ISort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        ISort sort = new Sort();
        ArrayList a = new ArrayList<Integer>();

        a.addAll(Arrays.asList(57	,64	,144	, 36 	,143	, 149, 	34,	 85	, 96	 ,
                165 , 99	,170	,9,	8,6	,132	,122	,121	,81	,148	,
                200	,188	,17	,183	,127	,16,	102,	172	,137	,83,	47	,123	,185	,
                156	,32	,124	,46	,56,	77,	151	,96,
                155	,37	,135	,131,	60,	65,	110	,51	,53,	4,	53,	153	,76	,160	,130	,163	,55	,95	,113	,77,
                10	,127	,122	,57	,121	,17,	172,	132,	16	,88	,194	,84	,164,	140,	176	,199	,
                107,	72,	73,	87,95,	149,	45,	152,	116,	90	,77));


        sort.heapSort(a);
        sort.sortFast(a);
        sort.sortSlow(a);
    }

}
