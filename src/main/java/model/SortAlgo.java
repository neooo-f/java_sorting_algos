package model;

public interface SortAlgo {
    public void setValueToSort(String[] arrayToSort);
    public String[] getSortedValue();
    public void doSort();
    public void reset();
    public void getStatistic();
}
