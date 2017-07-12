package andreev.sort;

import java.util.ArrayList;

public class InsertionSort {

    public static void sortByInsertString(ArrayList<String> array) {
        for (int i = 1; i < array.size(); i++) {
            String temp = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j).compareToIgnoreCase(temp) > 0) {
                    array.set(j + 1, array.get(j));
                    j--;
            }
            array.set(j + 1, temp);
        }
    }

    public static void sortByInsertInteger(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            Integer temp = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > temp) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, temp);
        }
    }
}


