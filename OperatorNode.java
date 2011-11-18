public class OperatorNode extends TreeNode{
	
	private TreeNode left;
	private TreeNode right;
	private String operator;
	
	public OperatorNode(){
		this(null, null);
	}
	public OperatorNode(String s){
		this(s, null);
	}
	public OperatorNode(String s, TreeNode child	){
		operator = s;
		setLeft(child);
	}
	public String getOperator(){
		return operator;
	}
	public void setOperator(String oper){
		operator = oper;
	}
	public TreeNode left(){
		return left;
	}
	public TreeNode right(){
		return right;
	}
	public void setLeft(TreeNode n){
		left = n;
	}
	public void setRight(TreeNode n){
		right = n;
	}
	public String toString(){
		return operator;
	}
}
