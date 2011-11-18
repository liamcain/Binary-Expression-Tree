public class IntNode extends TreeNode{

	private int data;
	
	public IntNode(int num){
		data = num;
	}
	public void setData(int num){
		data = num;
	}
	public int getData(){
		return data;
	}
	public String toString(){
		return data + "";
	}
}
