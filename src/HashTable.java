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

    private int hashScheme(Dollar key) {
        int m = 2;
        int n = 3;
        int whole = key.getWhole();
        int fraction = key.getFraction();
        return (m * whole + n * fraction) % totalBuckets;
    }

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
            index = (refIndex + count * count) % totalBuckets;

        }

        hashTable[index] = key;
        currentSize++;
        collisions += count;
    }

    public int getIndex(Dollar dollar) {
        int index = hashScheme(dollar);
        int ogIndex = index;
        int count = 0;



        while (hashTable[index] != null) {
            if (hashTable[index].isEqual(dollar)) {
                return index;
            }else {
            }

            count ++;
            index = (ogIndex + count* count) % totalBuckets;
        }
        return -1;
    }

    public void printHashTable() {
        for (int i = 0; i < totalBuckets; i++) {
            if (hashTable[i] != null) {
                System.out.println(hashTable[i]);
            }
        }
    }
    
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
