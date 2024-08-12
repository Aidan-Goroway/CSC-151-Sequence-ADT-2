package proj3;

import org.junit.*;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class LinkedListTest {

    @Rule // a test will fail if it takes longer than 10 seconds / 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);

    @Test // tests the getData function of linkedList
    public void testGetData1(){
        LinkedList l = new LinkedList();
        l.insertAtHead("C");
        l.insertAtHead("B");
        l.insertAtHead("A");
        System.out.println(l);
        String actual = l.getData(2);
        String expected = "C";
        assertEquals(expected,actual);
    }

}
