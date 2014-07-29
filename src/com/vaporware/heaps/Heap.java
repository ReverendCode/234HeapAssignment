package com.vaporware.heaps;

/**
 * Created by Code on 7/29/14.
 */
public class Heap {
    private int[] theHeap;
    private int lastItem=-1;//points to last item added, starts before the array
    private static final int BIGNUM = 100;
    private int arraySize = BIGNUM;


    public Heap() {
        theHeap = new int[arraySize];
    }
    public void insertItem(int number) {
        if (isFull()) arrayDouble();
        theHeap[++lastItem] = number;
        bubbleUp();
    }
    public int getSmallest() {//the heap is weak sorted smallest first
        int temp = theHeap[0];
        filterDown();
        return temp;
    }
    private void bubbleUp() {
        //start at the last item added, go up the tree to it's proper spot
        //index/2-1 to get parent
    }
    private void filterDown() {//this will overwrite the 'root'
        //move last item up, then filter down
    }

    private void swap(int firstLoc, int secondLoc) {
        int temp = theHeap[firstLoc];
        theHeap[firstLoc]=theHeap[secondLoc];
        theHeap[secondLoc]=temp;
    }



    private boolean isFull() {
        if (lastItem==arraySize-1) return true;
        return false;
    }

    private void arrayDouble() {
        int[] temp = new int[arraySize*2];
        for (int i = 0; i<lastItem;i++) {
            temp[i] = theHeap[i];
        }
        theHeap=temp;
    }
}
