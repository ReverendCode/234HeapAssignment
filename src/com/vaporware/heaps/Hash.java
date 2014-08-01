package com.vaporware.heaps;

/**
 * Created by Code on 7/30/14.
 */
public class Hash {
    private static final int HASH_CODE=26;
    private static final int DEF_SIZE=100;
    private String[] hashTable;
    private int arraySize=DEF_SIZE;
    private int numElements=0;
    private final static String deleted ="************";
    public Hash () {
        hashTable = new String[arraySize];
        for (int i=0;i<arraySize;i++) {
            hashTable[i]=null;
        }
    }
    public void insert(String words) {
        if (numElements++ > arraySize/2) hashTableDouble();

        int index=hashIt(words);


        while (hashTable[index]!=null) {
           if (index++>=arraySize) index=0;
        }
        hashTable[index]=words;
    }

    public boolean find (String words) {
        int index = hashIt(words);
        while (hashTable[index]!=null) {
            if (hashTable[index++]==words)return true;
        }
        return false;
    }

    public boolean delete(String words) {
        int index = hashIt(words);
        while (hashTable[index]!=null) {
            if (hashTable[index++]==words) {
                hashTable[--index]=deleted;
                return true;
            }
        }
        return false;
    }

    public String displayTable() {
        String output="";
        for (int i=0;i<arraySize;i++) {
            if (hashTable[i]!=null && hashTable[i] != deleted) {
                output += hashTable[i]+" ";
            }
        }
        return output;
    }

   private void hashTableDouble() {
       arraySize*=2;
       String[] temp = new String[arraySize];

       for (int i=0;i<arraySize/2;i++) {
           if (hashTable[i]!=null && hashTable[i]!=deleted) {
               int index = hashIt(hashTable[i]);
               while (temp[index]!=null) {
                   if (index++>=arraySize) index=0;
               }
               temp[index]=hashTable[i];
           }
       }
       hashTable=temp;
   }


    private int hashIt(String words) {
        int hashInt=0;
        for (int i=0;i<words.length();i++) {
            hashInt += (int)words.charAt(i)*HASH_CODE;//do you need to multiply by 26?
            hashInt %= arraySize;
        }
        return hashInt;
    }
}
