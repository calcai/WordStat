public class HashEntry {
    private String key;
    private int value;
    private HashEntry next;

    public HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    //Getter and setter methods
    public String getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public HashEntry getNext(){
        return next;
    }

    public void setNext(HashEntry next){
        this.next = next;
    }
}