public class LinkedList {

	private ListNode firstNode;
	private ListNode lastNode;
	
	public LinkedList(Object obj){
		firstNode = createList(obj);
		lastNode = firstNode;
	}
	public LinkedList(){
		firstNode = null;
		lastNode = firstNode;
	}
	private ListNode createList(Object obj){
		ListNode first = new ListNode(obj);
		return first;
	}
	public void add(Object obj){
		ListNode newNode = new ListNode(obj);
		if(firstNode != null){
			lastNode.pointTo(newNode);
			lastNode = newNode;
		} else {
			firstNode = newNode;
			lastNode = firstNode;
		}
	}
	public Object findAndPop(Object o){
		ListNode target = new ListNode(o);
		ListNode prev = firstNode;
		ListNode next = prev.getNextNode();//I FOUND YOU!
		while(next != null && !(next.equals(target))){
			prev = next;
			next = next.getNextNode();
		}
		if(next != null){
			prev.pointTo(next.getNextNode());
			return next.getNode();
		} else
			return null;
	}

	public void addFirst(Object obj){
		ListNode newListNode = new ListNode(obj, firstNode);
		firstNode = newListNode;
	}	
	public ListNode getFirst(){
		return firstNode;
	}
	public void remove(){
		firstNode = firstNode.getNextNode();
	}
	public void removeLast(){
		ListNode n = firstNode;
		while(n.getNextNode()!=lastNode)
			n = n.getNextNode();
		n = lastNode;
	}
	public String toString(){
		ListNode n = firstNode;
		String str = "";
		
		while(n != null){
			str += n.toString();
			n = n.getNextNode();
		}
		
		return str;
	}
}