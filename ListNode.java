public class ListNode {

	private Object info;
	private ListNode pointer;
	
	public ListNode(Object obj){
		info = obj;
		pointer = null;
	}
	public ListNode(Object obj, ListNode node){
		info = obj;
		pointer = node;
	}
	public Object getNode(){
		return info;
	}
	public void setNode(Object obj){
		info = obj;
	}
	public ListNode getNextNode(){
		return pointer;
	}
	public void pointTo(ListNode node){
		pointer = node;
	}
	public boolean hasNext(){
		return (pointer != null) ?true :false;
	}
	public String toString(){
		return (info.toString() + " ");
	}
	public boolean isOperator(){
		if(info.equals("*") || info.equals("/") || info.equals("+") || info.equals("-"))
			return true;
		else
			return false;
	}
	public boolean equals(ListNode n){
		if(n.isOperator() && isOperator())
			return true;
			
		return (info == n.getNode());
	}
}