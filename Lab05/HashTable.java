/*
 * Authors: Nicholas Kang, Brandon Arriaga
 * Group 10 JAVA
 *
 * Lab 5
 *
 * Purpose: Creates a Hash Table of type Dollar that inserts dollar objects based off a specific Hash Scheme.
 * Hash table also allows for index searching to find dollar objects.
 *
 */

public class HashTable {

    private Dollar[] hashTable;

    private int totalBuckets;

    private int currentSize;

    private int collisions;
    private Dollar key;

    public HashTable(int totalBuckets) {
        this.totalBuckets = totalBuckets;
        this.hashTable = new Dollar[totalBuckets];
        this.key = null;
        this.currentSize = 0;
    }

    /*
    *Pre: key value of type Dollar
    *
    * Post: gets the whole and fractional value of key to get the total of the Hash Scheme which is used
    * to insert dollar values
    *
    * Return: Integer result
     */
    private int hashScheme(Dollar key) {
        int m = 2;
        int n = 3;
        int whole = key.getWhole();
        int fraction = key.getFraction();
        return (m * whole + n * fraction) % totalBuckets;
    }

    /*
    *Pre: Key value of type dollar
    *
    *Post: Checks key value first if it exists in table, otherwise it finds its spot using hash scheme
    *
    * Return: None, type void
     */
    public void hashInsert(Dollar key) {
        if (getIndex(key) != -1) {
            System.out.println("Dollar amount $" + key+ " Already in Hash Table.");
            return;
        }


        int index = hashScheme(key);
        int refIndex = index;
        int count = 0;

        while (hashTable[index] != null) {

            count++;
            // Probing in order to find an empty slot
            index = (refIndex + count * count) % totalBuckets;

        }

        hashTable[index] = key;
        currentSize++;
        collisions += count;
    }

    /*
    *Pre: dollar of type Dollar
    *
    *Post: Gets the index of a given dollar value, using hash scheme
    *
    * Return: Integer value
     */
    public int getIndex(Dollar dollar) {
        int index = hashScheme(dollar);
        int ogIndex = index;
        int count = 0;



        while (hashTable[index] != null) {
            if (hashTable[index].isEqual(dollar)) {
                return index;
            }

            count ++;
            index = (ogIndex + count* count) % totalBuckets;
        }

        return -1;
    }

    /*
    *Pre: NO parameters
    *
    *Post: Constructs a string by iterating through every index
    *
    * Return: None, type void.
     */
    public void printHashTable() {
        for (int i = 0; i < totalBuckets; i++) {
            if (hashTable[i] != null) {
                System.out.println(hashTable[i]);
            }
        }
    }
     //Getters
    public int getCurrentSize() {
    	return currentSize;
    }
    
    public int getCollisions() {
    	return collisions;
    }
    
    public double getLoadFactor() {
    	return (double) currentSize /29;
    }

}
