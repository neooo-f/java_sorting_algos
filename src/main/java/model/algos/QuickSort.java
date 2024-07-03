package model.algos;

import model.SortAlgo;

public class QuickSort implements SortAlgo {
    
    String[] arrayToSort;

    @Override
    public void setValueToSort(String[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Override
    public void doSort() {
        quickSort(arrayToSort, 0, arrayToSort.length-1);
    }
    
    private static void quickSort(String[] arr, int start, int end) {
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }
    
    private static int partition(String[] arr, int start, int end){
        String pivot = arr[end];
 
        for(int i=start; i<end; i++){
            if(arr[i].compareTo(pivot) < 0){
                String temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
 
        String temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
 
        return start;
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
