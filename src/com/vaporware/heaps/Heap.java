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
        int parentLoc;
        //start at the last item added, go up the tree to it's proper spot
        //index/2-1 to get parent
        for (int index=lastItem;index>0;) {
            if ((index & 1) == 0) parentLoc = index/2;//even case
        else parentLoc = index/2 -1;//odd case
            
            if (theHeap[parentLoc] > theHeap[index]) {
                swap(index, parentLoc); 
                index=parentLoc;
            }
            else return;
        }

    }
    private void filterDown() {//this will overwrite the 'root'
        //move last item up, then filter down
        boolean smallerLeft;
        theHeap[0] = theHeap[lastItem--];
        for (int index = 0;index <= lastItem;) {
            int leftChild = index*2+1;
            int rightChild = index*2+2;
            if (leftChild >lastItem) return; //if left is out of range, right is Right out.
            if (rightChild > lastItem) {
                if (theHeap[leftChild] < theHeap[index]) {
                    swap(leftChild, index);
                    index = leftChild;
                }
                else return;
            }//end leftChild only case
            else {
                if (theHeap[leftChild] < theHeap[rightChild]) smallerLeft = true;
                else smallerLeft = false;

                if (smallerLeft) {
                    if (theHeap[leftChild] < theHeap[index]) {
                        swap(leftChild,index);
                        index = leftChild;
                    }
                }
                else {
                    if (theHeap[rightChild] <= theHeap[index]) {
                        swap(rightChild,index);
                        index=rightChild;
                    }

                }
            }
            
        }
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
