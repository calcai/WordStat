import org.junit.Test;
import org.junit.Assert;

public class TestHashTable {
    @Test
    /*
    This is testing all the methods in the HashTable class
     */
    public void TestHashTable() {
        HashTable table= new HashTable();
        table.put("Calvin",-1);
        table.put("Cai",5);
        table.put("JJ",0);
        table.put("CC",90);
        Assert.assertEquals("Testing the put method in Hashtable", -1, table.get("Calvin"));
        Assert.assertEquals("Testing the put method in Hashtable", 5, table.get("Cai"));
        Assert.assertEquals("Testing the put method in Hashtable", 0, table.get("JJ"));
        Assert.assertEquals("Testing the put method in Hashtable", 90, table.get("CC"));
        table.put("Calvin", 12, 1);
        table.put("Cai", 10, 2);
        table.put("JJ", -1, 3);
        table.put("CC", 6, 4);
        Assert.assertEquals("Testing the put method in Hashtable", 12, table.get("Calvin",1));
        Assert.assertEquals("Testing the put method in Hashtable", 10, table.get("Cai",2));
        Assert.assertEquals("Testing the put method in Hashtable", -1, table.get("JJ",3));
        Assert.assertEquals("Testing the put method in Hashtable", 6, table.get("CC",4));
        table.put("Another",10);
        Assert.assertEquals("Testing the put method in Hashtable", 10, table.get("Another"));
        table.put("Another",2);
        Assert.assertEquals("Testing the put method in Hashtable", 2, table.get("Another"));
        table.put("A", 4);
        Assert.assertEquals("Testing the put method in Hashtable", 4, table.get("A"));
        table.update("A",6);
        Assert.assertEquals("Testing the put method in Hashtable", 6, table.get("A"));


        /*
        Testing the edge case to see when we overflow the table
        In the occasion we put 3 elements in a table of size 1
         */
        HashTable table2 = new HashTable(1);
        table2.put("1", 11);
        table2.put("2", 12);
        table2.put("3", 13);
        Assert.assertEquals("Testing the put method in Hashtable", 11, table2.get("1"));
        Assert.assertEquals("Testing the put method in Hashtable", 12, table2.get("2"));
        Assert.assertEquals("Testing the put method in Hashtable", 13, table2.get("3"));

        HashTable table3 = new HashTable();
        table3.put("case", 15);
        Assert.assertEquals("Testing the put method in Hashtable", 15, table3.get("case"));
        table3.update("case",9);
        Assert.assertEquals("Testing the put method in Hashtable", 9, table3.get("case"));

    }
}
