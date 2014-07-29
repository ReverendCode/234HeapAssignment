package com.vaporware.heaps;

/**
 * Created by Code on 7/28/14.
 */
public class LeafTwoThree {
    public int[] data;
    private static final int MAX = 4;

    public LeafTwoThree[] childArray;


    public LeafTwoThree() {
        childArray = new LeafTwoThree[MAX+1];
        data = new int[MAX];
    }


}
