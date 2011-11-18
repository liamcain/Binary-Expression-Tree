public class BET {
	
	private OperatorNode root;
	
	public BET() {
		this(null);
	}
	public BET(Object obj){
		root = new OperatorNode((String)obj);
	}
	
	public boolean isEmpty(){
		return root == null;
	}

	public void add(Object obj){
		TreeNode newNode;
		
		 try {   
		      int val = Integer.parseInt((String)obj);
		      newNode = new IntNode(val);
		      add(newNode, root);
		 } catch( Exception e){
			newNode = new OperatorNode((String)obj, root);
			root = (OperatorNode)newNode;
		 }  
		
		/*if(obj instanceof Integer){
			newNode = new IntNode((Integer)obj);
			add(newNode, root);
		} else {
			newNode = new OperatorNode((String)obj, root);
			root = (OperatorNode)newNode;
		}*/
	}

	private void add(TreeNode tn, OperatorNode localRoot){
		if(isEmpty()){
			root = (OperatorNode)tn;
		} else {
			if(root.left() == null)
				root.setLeft(tn);
			else if(root.right() == null)
				root.setRight(tn);
		}
	}

/*	private void add(TreeNode tn, OperatorNode localRoot){
		if(isEmpty()){
			root = (OperatorNode)tn;
		} else {
			if(localRoot.left() == null)
				localRoot.setLeft(tn);
			else if(localRoot.right() == null)
				localRoot.setRight(tn);
		}
	}*/
	
	private double evaluate(TreeNode localRoot){
		if(localRoot instanceof IntNode)
			return (double)((IntNode)localRoot).getData();
		else {
			String rootStr = ((OperatorNode)localRoot).toString();
			TreeNode left = ((OperatorNode)localRoot).left();
			TreeNode right = ((OperatorNode)localRoot).right();

			System.out.println("LocalRoot: " + localRoot.toString());
			
			if(rootStr.equals("*"))
				return evaluate(left) * evaluate(right);
			else if(rootStr.equals("/"))
				return evaluate(left) / evaluate(right);
			else if(rootStr.equals("+"))
				return evaluate(left) + evaluate(right);
			else if(rootStr.equals("-"))
				return evaluate(left) - evaluate(right);
			else
				return 0;
			}
	}
	
	public double evaluate(){
		return evaluate(root);
	}
	
	private LinkedList inOrderTraverse(LinkedList list, TreeNode localRoot){
		if(localRoot instanceof OperatorNode){
			inOrderTraverse(list, ((OperatorNode) localRoot).left());
			list.add(localRoot);
			inOrderTraverse(list, ((OperatorNode) localRoot).right());
		} else
			list.add(localRoot);
		
		return list;
	}
	
	public String toString(){
		LinkedList list = new LinkedList();
		
		inOrderTraverse(list, root.left());
		list.add(root);
		inOrderTraverse(list, root.right());
		
		return list.toString();
	}
	public OperatorNode getRoot(){
		return root;
	}
}