package proj3;

/**
 * The LinkedList class models the list itself, comprised of ListNodes.
 */
public class LinkedList{

    public static final int HEAD_NODE_INDEX = 0;

    private int length;
    private ListNode firstNode;


    /**
     * Constructor. Has a length of 0 and the head of the list points to null.
     */
    public LinkedList(){
        length=0;
        firstNode=null;
    }


    /**
     * Gets the length of the linkedList.
     * @return the length of the linkedList.
     */
    public int getLength(){
        return length;
    }


    /**
     * Iterates through the LinkedList in search of a specified ListNode.
     * @param target the Node we are looking for.
     * @return the Node we have "targeted".
     */
    private ListNode loopHelper(int target){

        ListNode runner = firstNode; // starts head as runner

        for (int index = HEAD_NODE_INDEX; index < target; index++) {
            if (runner.next != null){
                runner = runner.next;
            }
        }
        return runner;
    }


    /**
     * Returns the data stored in a node.
     * @param target the node you are aiming to extract data from.
     * @return The data of a node, usually a string.
     */
    public String getData(int target) {
        ListNode runner = loopHelper(target);
        return runner.data;
    }


    /**
     * Removes a node from the linkedList.
     */
    public void removeNode(int target){
        ListNode prev = loopHelper(target - 1);
        ListNode current = loopHelper(target);

        prev.next = current.next;
    }


    /**
     * Inserts Node before another node.
     * @param data The data of the Node we are inserting.
     * @param insertionPosition the position of the Node we are inserting a node before.
     */
    public void insertBefore(String data, int insertionPosition){
        ListNode newNode = new ListNode(data);
        if (getLength() == 0){
            firstNode = newNode;
        }
        else if (getLength() == 1){
            newNode.next = firstNode;
            firstNode = newNode;
        }
        else {
            if (insertionPosition == 0){ // if insertion is not on the edge of a Sequence
                ListNode current = loopHelper(insertionPosition);
                newNode.next = current;
                firstNode = newNode;
            }
            else {
                ListNode current = loopHelper(insertionPosition); // the node with CE
                ListNode prev = loopHelper(insertionPosition - 1);
                newNode.next = current;
                prev.next = newNode;
            }
        }
        length += 1;
    }


    /**
     * Inserts a Node after another.
     * @param data the data of the node we are inserting.
     * @param insertionPosition the position of the node we are inserting our node after.
     */
    public void insertAfter(String data, int insertionPosition){
        ListNode newNode = new ListNode(data);
        if (getLength() == 0){
            firstNode = newNode;
        }
        else{
            if(insertionPosition == 0){// not in middle of Sequence
                ListNode current = loopHelper(insertionPosition); // the node with CE
                current.next = newNode;
            }
            else {
                ListNode current = loopHelper(insertionPosition); // the node with CE
                ListNode next = loopHelper(insertionPosition + 1);

                newNode.next = next;
                current.next = newNode;
            }
        }
        length += 1;
    }


    /**
     * Inserts a node at the head of a linkedList.
     * @param data The data contained in the node you are inserting.
     */
    public void insertAtHead(String data){
    	ListNode newnode = new ListNode(data);
        if (getLength() == 0){
            firstNode = newnode;
        }
        else {
            newnode.next = firstNode;
            firstNode = newnode;
        }
        length++;
    }


    /**
     * Returns the linkedList as a string.
     * @return The linkedList as a string.
     */
	public String toString(){ 
		String toReturn = "(";
		ListNode runner = firstNode;
		while(runner != null){
			toReturn = toReturn + runner;
			runner = runner.next;
			if(runner != null){
				toReturn = toReturn + ", ";
			}
		}
		toReturn = toReturn + ")";
		return toReturn;
	}

}
