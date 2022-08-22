package utils;

import models.Test;

import java.util.ArrayList;
import java.util.List;

public class SortUtils {

    public static List<Test> sortListTestsByID(List<Test> list) {
        List<Test> testsAfterSort = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int last = list.get(i).getId() % 10;
            for (int prev = list.get(i).getId() / 10; prev > 0; prev /= 10)
                if (prev % 10 == last) {
                    testsAfterSort.add(list.get(i));
                }
        }
        List<Test> testsAfterSortSize10 = new ArrayList<>();
        for (int i = 0; i < Config.sizeSortList; i++) {
            testsAfterSortSize10.add(testsAfterSort.get(i));
        }
        return testsAfterSortSize10;
    }
}
