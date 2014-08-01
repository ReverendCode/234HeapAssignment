package com.vaporware.heaps;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.EmptyStackException;

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
        System.out.println("**Testing Empty Queue**");
        try {
            System.out.print(testQ.removeSmallest());
        }catch (EmptyStackException emp){
            System.err.print("Empty Queue, nothing to remove.");
        }

        Hash linearHash = new Hash();
        linearHash.insert("dog");
        linearHash.insert("cat");
        linearHash.insert("airplane");
        linearHash.insert("x");
        linearHash.insert("xx");
        linearHash.insert("horse");
        linearHash.insert("god");
        linearHash.insert("number");
        linearHash.insert("aaa");

        System.out.println("\n**Testing linear hash**");
        System.out.println(linearHash.displayTable());
        System.out.println("**Looking for 'cow' in the table**");
        if (linearHash.find("cow")) System.out.println("cow was found");
        else System.out.println("Sorry, cow not found");//what an amazing error message
        if (linearHash.find("horse")) System.out.println("horse was found");
        else System.out.println("Sorry, horse not found");
        System.out.println("**Deleting horse**");
        linearHash.delete("horse");
        if (linearHash.find("horse")) System.out.println("horse was still found in the table");
        else System.out.println("horse no longer found in table");
        System.out.println(linearHash.displayTable());
        System.out.println("\n\n**Testing listHash**");//fix the name, dummy

        HashList theList = new HashList();
        theList.insertWord("dog");
        theList.insertWord("cat");
        theList.insertWord("airplane");
        theList.insertWord("x");
        theList.insertWord("xx");
        theList.insertWord("horse");
        theList.insertWord("god");
        theList.insertWord("number");
        theList.insertWord("aaa");
       // System.out.print(theList.displayTable());


        System.out.println(theList.displayTable());
        System.out.println("**Looking for 'cow' in the table**");
        if (theList.findWord("cow")) System.out.println("cow was found");
        else System.out.println("Sorry, cow not found");//what an amazing error message
        if (theList.findWord("horse")) System.out.println("horse was found");
        else System.out.println("Sorry, horse not found");
        System.out.println("**Deleting horse**");
        theList.deleteWord("horse");
        if (theList.findWord("horse")) System.out.println("horse was still found in the table");
        else System.out.println("horse no longer found in table");
        System.out.println(theList.displayTable());





    }
}
