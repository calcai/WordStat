import java.lang.String;

public class HashTable{
    private HashEntry[] table;
    private int hashTableSize;

    //Helper getter  and setter method
    public int getHashTableSize(){
        return this.hashTableSize;
    }
    public void setHashTableSize(int size){
        this.hashTableSize = size;
    }
    public HashEntry firstNode(int hash){
        return table[hash];
    }
    public HashEntry findHash(String key){
        for(int i = 0; i < this.getHashTableSize(); i++) {
            HashEntry currNode = this.firstNode(i);
            while (currNode != null) {
                if (currNode.getKey() == key) {
                    return currNode;
                }
                else {
                    currNode = currNode.getNext();
                }
            }
        }
        return null;
    }
    /*
    This is the constructor that takes an integer that indicates the size of the table
     */
    public HashTable(int size){
        table = new HashEntry[size];
        hashTableSize = size;
    }

    /*
    This is the constructor with no input which creates an array of size 100
     */
    public HashTable(){
        table = new HashEntry[100];
        hashTableSize = 100;
    }


    /*
    This method will put a key-value pair in the hash table
     */
    public void put(String key, int value){
        int hash = Math.abs(key.hashCode()) % hashTableSize;
        if(table[hash] == null){
            table[hash] = new HashEntry(key,value);
        }
        else{
            HashEntry currNode = table[hash];
            while(currNode.getNext() != null && currNode.getKey() != key){
                currNode = currNode.getNext();
            }
            if(currNode.getKey() == key){
                currNode.setValue(value);
            }
            else {
                currNode.setNext(new HashEntry(key, value));
            }
        }
    }


    /*
    This method is the same as the other put function but uses the input hash code instead of the built in java method
     */
    public void put(String key, int value, int hashCode){
        int hash = Math.abs(hashCode) % hashTableSize;
        if(table[hash] == null){
            table[hash] = new HashEntry(key,value);
        }
        else{
            HashEntry currNode = table[hash];
            while(currNode.getNext() != null && currNode.getKey() != key){
                currNode = currNode.getNext();
            }
            if(currNode.getKey() == key){
                currNode.setValue(value);
            }
            else{
                currNode.setNext(new HashEntry(key,value));
            }
        }
    }


    /*
    This method will update the value of the key to the inputted value in the parameter
     */
    public void update(String key, int value){
        int hash = Math.abs(key.hashCode()) % hashTableSize;
        HashEntry currNode = table[hash];
        while(currNode != null){
            if(currNode.getKey().equals(key) && currNode.hashCode() == key.hashCode()){
                currNode.setValue(value);
                return;
            }
            currNode = currNode.getNext();
        }
        put(key, value);
    }

    /*
   This method will return the value and the inputted String key
    */
    public int get(String key) {
        int hash = Math.abs(key.hashCode()) % hashTableSize;
        if(table[hash] == null){
            return -1;
        }
        else {
            HashEntry currNode = table[hash];
            while (currNode != null && currNode.getKey() != null) {
                if (currNode != null && key.equals(currNode.getKey())){
                    return currNode.getValue();
                }
                currNode = currNode.getNext();
            }
        }
        return -1;
    }

    /*
    This method will return the value and the inputted String key and hashCode
    We use the provided hashCode for direct testing of collisions.
     */
    public int get(String key, int hashCode) {
        int hash = Math.abs(hashCode) % hashTableSize;
        if (table[hash] == null) {
            return -1;
        } else {
            HashEntry entry = table[hash];
            while (entry != null && entry.getKey() != null) {
                if (entry != null && key.equals(entry.getKey())) {
                    return entry.getValue();
                }
                entry = entry.getNext();
            }
        }
        return -1;
    }
}