package model.algos;

import java.util.Arrays;
import java.util.Collections;
import model.SortAlgo;

public class BogoSort implements SortAlgo {
    
    String[] arrayToSort;

    @Override
    public void setValueToSort(String[] arrayToSort) {
        this.arrayToSort = Arrays.copyOf(arrayToSort, arrayToSort.length);
    }

    @Override
    public void doSort() {
        
        while(!isSorted()) {
            Collections.shuffle(Arrays.asList(arrayToSort));
        }
        
    }
    
    private boolean isSorted() {
        for (int i = 1; i < arrayToSort.length; i++)
            if (arrayToSort[i].compareTo(arrayToSort[i - 1]) < 0)
                return false;
        return true;
    }

    @Override
    public void reset() {
        this.arrayToSort = null;
    }

    @Override
    public void getStatistic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getSortedValue() {
        return this.arrayToSort;
    }
    
}
