
public class ListIterator {

	private LinkedList list;
	private ListNode prevNode;
	private ListNode nextNode;
	
	public ListIterator(LinkedList list){
		this.list = list;
		prevNode = list.getFirst();
		nextNode = list.getFirst().getNextNode();
	}
	
	public Object next(){
		/*if(nextNode == null || nextNode.getNextNode() == null)
			return null;*/

		prevNode = nextNode;
		nextNode = nextNode.getNextNode();
		return prevNode.getNode();
	}
	public int nextInt(){
		prevNode = nextNode;
		nextNode = nextNode.getNextNode();
		return Integer.parseInt((String)prevNode.getNode());
		/*return Integer.parseInt(prevNode.getNode());*/
	}
	
	public Object getNext(){
		return nextNode.getNode();
	}
	public Object getPrev(){
		return prevNode.getNode();
	}
	
	public void remove(Object obj){
		ListNode n = list.getFirst();
		ListNode p = n.getNextNode();
		while(p!=null){
			if(p.getNode() == obj)
				n.pointTo(n.getNextNode());
			n = p;
			p = p.getNextNode();
		}
	}
	
	public Object previous(){
		ListNode n = list.getFirst();
		while(n!=null){
			if(n.getNextNode() == prevNode){
				nextNode = n.getNextNode();
				prevNode = n;
				return prevNode.getNode();
			}
			
			n = n.getNextNode();
		}
		return prevNode.getNode();
	}
	
	public boolean hasNext(){
		return (nextNode != null);
	}
	public boolean hasNextInt(){
		/*return (nextNode.getNode() instanceof Integer);*/
		 try {   
		      Integer.parseInt((String)nextNode.getNode());   
		      return true;  
		 } catch( Exception e){   
		      return false;   
		 }   

	}
	public Object remove(){
		Object o = nextNode;
		prevNode.pointTo(nextNode.getNextNode());
		nextNode = prevNode.getNextNode();
		return o;
	}
	public void add(Object obj){
		ListNode node = new ListNode(obj, nextNode);
		prevNode.pointTo(node);
	}
	public void set(Object obj){
		prevNode.setNode(obj);
	}
}