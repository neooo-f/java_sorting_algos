package model.algos;

import model.SortAlgo;

public class InsertionSort implements SortAlgo {

    String[] arrayToSort;
    int swaps = 0;
    
    @Override
    public void setValueToSort(String[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Override
    public void doSort() {
        
        for (int i = 1; i < arrayToSort.length; i++) {
            String currentVal = arrayToSort[i];
            
            int j = i - 1;
            while(j >= 0 && arrayToSort[j].compareTo(currentVal) > 0) {
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
            }
            arrayToSort[j + 1] = currentVal;
        }
    }

    @Override
    public void reset() {
        this.arrayToSort = null;
    }

    @Override
    public void getStatistic() {
        
    }
    
    public String[] getSortedValues() {
        return arrayToSort;
    }

    @Override
    public String[] getSortedValue() {
        return this.arrayToSort;
    }
    
}
