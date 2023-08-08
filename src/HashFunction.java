import java.util.Currency;

public class HashFunction extends Dollar {

    protected HashNode[] hashArray;
    protected int currentSize;
    protected int buckets;

    public HashFunction(int buckets) {
        this.buckets = buckets;
        this.currentSize = 0;
        this.hashArray = new HashNode[buckets];
    }

    public void HashInsert(Currency dollar, Integer key) {
        if (key == null || dollar == null) {
            throw new IllegalArgumentException("Key and/or value is null.");
        }
        int bucketIndex = key % buckets;
        HashNode head = hashArray[bucketIndex];
        while (head != null) {
            if(head.getKey().equals(key)) {
                head.value = dollar;
                return;
            }
            head = head.getNext();
        }
        currentSize++;
        head = hashArray[bucketIndex];
        HashNode node = new HashNode(key, dollar);
        node.next = head;
        hashArray[bucketIndex] = node;
    }


    public void HashRemove(int key) {

    }
    
    
    public Currency HashSearch(int key) {
    	int arrayKey = key % 29;
    	
    	while(hashArray[arrayKey] != null) {
    		
    		if (hashArray[arrayKey].getKey() == key) {
    			
    			System.out.println("Found key at: " + arrayKey);
    			return hashArray[arrayKey].getValue();
    			
    		}
    			
    			++arrayKey;
    			arrayKey %= currentSize;
    			
    	}
    	
    	System.out.println("Did not find key");
    	return null;

    }
    
    public void printData() {
    	for (int i = 0; i < hashArray.length; i++) {
    		System.out.println(hashArray[i]);
    	}
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }


    private class HashNode {
        protected Integer key;
        protected Currency value;
        protected HashNode next;

        public HashNode(Integer key, Currency value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getKey() {
            return key;
        }

        public void setValue(Currency value) {
            this.value = value;
        }

        public Currency getValue() {
            return value;
        }

        public void setNext(HashNode next) {
            this.next = next;
        }

        public HashNode getNext(){
            return next;
        }
    }
}
