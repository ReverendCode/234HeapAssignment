package com.vaporware.heaps;

public class Main {

    public static void main(String[] args) {

        PriorityQ testQ = new PriorityQ();
        for (int i=0;i<20;i++) {//quick and dirty fill
            testQ.insert((int)(Math.random() * 50+1));
        }
        System.out.println("**Testing PriorityQ**");
        String accum = "";
        for (int i = 0; i<20;i++) {
            accum += testQ.removeSmallest()+" ";
        }
        System.out.println(accum);

    }
}
