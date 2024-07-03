package model.algos;

import model.SortAlgo;

public class BubbleSort implements SortAlgo {
    
    String[] arrayToSort;
    int swaps = 0;
    
    @Override
    public void setValueToSort(String[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Override
    public void doSort() {
        boolean swappedSmth = true;
        while (swappedSmth) {
            swappedSmth = false;
            
            for (int i = 0; i < arrayToSort.length - 1; i++) {
                if (arrayToSort[i].compareTo(arrayToSort[i + 1]) > 0) {
                    swappedSmth = true;
                    String temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = temp;
                    swaps++;
                }
            }
        }
    }

    @Override
    public void reset() {
        this.arrayToSort = null;
    }

    @Override
    public void getStatistic() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return swaps;
    }

    @Override
    public String[] getSortedValue() {
        return this.arrayToSort;
    }
    
}
