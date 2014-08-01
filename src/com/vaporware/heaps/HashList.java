package com.vaporware.heaps;

/**
 * Created by Code on 7/31/14.
 */
public class HashList {

    private final static int HASH_CODE=26;
    private HashLink hashMarker;
    private HashLink previous;
    private HashLink[] theHashTable;
    private final static int HASH_SIZE=42;
    private int arraySize = HASH_SIZE;

    public HashList() {
    theHashTable = new HashLink[HASH_SIZE];
    }
    public HashList(int size) {
        theHashTable = new HashLink[arraySize=size];
    }

    public void insertWord(String words) {
        int hashLoc = hashCode(words);
        if (theHashTable[hashLoc]==null) {
            theHashTable[hashLoc]= new HashLink(words);
            theHashTable[hashLoc].next=theHashTable[hashLoc];
        }
        else {
            HashLink temp = new HashLink(words);
            temp.next=theHashTable[hashLoc].next;
            theHashTable[hashLoc].next=temp;


            /*
            while (temp.next!=null) {
                temp=temp.next;
            }
            temp.next = new HashLink(words);
            */
        }
    }

    public boolean findWord(String words) {
        hashMarker=null;
        previous = null;
        int hashLoc = hashCode(words);
        if (theHashTable[hashLoc]==null) return false;

        HashLink temp = theHashTable[hashLoc];
        do {
            previous=temp;
            temp=temp.next;
            if (temp.datum==words) {
                hashMarker=temp;
                return true;
            }
        } while (temp!=theHashTable[hashLoc]);

        return false;
    }
    public boolean deleteWord(String words) {

        if (findWord(words)) {
            previous.next=hashMarker.next;
            return true;
        }

        return false;
    }
    public String displayTable() {
        String output="";
        for (int i=0;i<arraySize;i++) {//step vertical
            if (theHashTable[i]!=null) {
                HashLink temp = theHashTable[i];
                do {//step horizontal
                    output += temp.datum+" ";
                    temp = temp.next;
                }while (temp!=theHashTable[i]);//stop when you get back to the front
            }
        }
        return output;
    }

    private int hashCode(String words) {
        int hashInt=0;
        for (int i=0;i<words.length();i++) {
            hashInt += (int)words.charAt(i)*HASH_CODE;
            hashInt %= arraySize;
        }
        return hashInt;
    }

}
