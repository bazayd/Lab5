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
        int index = hashScheme(key);
        int refIndex = index;
        int count = 0;

        while (hashTable[index] != null) {
            if (getDollar(key) != null) {
                System.out.println("Dollar value $" + key + " already in table.");
                return;
            }
            count++;
            index = (refIndex + count * count) % totalBuckets;

        }

        hashTable[index] = key;
        currentSize++;
        collisions += count;
    }

    public Dollar getDollar(Dollar dollar) {
        int index = hashScheme(dollar);
        int ogIndex = index;
        int count = 0;



        while (hashTable[index] != null) {
            if (hashTable[index].isEqual(dollar)) {
                return hashTable[index];
            }

            count ++;
            index = (ogIndex + count* count) % totalBuckets;
        }
        return null;
    }

    public void printHashTable() {
        for (int i = 0; i < totalBuckets; i++) {
            if (hashTable[i] != null) {
                System.out.println(hashTable[i]);
            }
        }
    }

}