
public class BinaryTree {
	private BinaryNode root;
	
	public BinaryTree(){
		root = null;
	}

	public BinaryTree(Object x){
		root = new BinaryNode(x);
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	public void makeEmpty(){
		root = null;
	}
	public int nodeCount(){
		return BinaryNode.nodeCount(root);
	}
	public int height(){
		return BinaryNode.height(root);
	}
	
	public Object getRootObj() throws BinaryTreeException{
		if(root == null) throw new BinaryTreeException("empty tree");
		else
			return root.element;
	}
	
	public void setRootObj(Object x)throws BinaryTreeException{
		if(root == null) throw new BinaryTreeException ("empty tree");
		else
			root.element=x;
	}
	
	public BinaryTree getLeft() throws BinaryTreeException{
		if(root == null)throw new BinaryTreeException("empty tree");
		else{
			BinaryTree t = new BinaryTree ();
			t.root=root.left;
			return t;
		}
	}
	
	public void setLeft(BinaryTree t)throws BinaryTreeException{
		if(root == null) throw new BinaryTreeException("empty tree");
		else
			root.left = t.root;
		}

	public BinaryTree getRight() throws BinaryTreeException{
		if(root == null)throw new BinaryTreeException("empty tree");
		else{
			BinaryTree t = new BinaryTree ();
			t.root = root.right;
			return t;
		}
	}
	
	public void setRight(BinaryTree t)throws BinaryTreeException{
		if(root == null) throw new BinaryTreeException("empty tree");
		else
			root.right = t.root;
		}

	public static void inorder(BinaryTree t) throws BinaryTreeException{
	
		if(!t.isEmpty()){
			inorder(t.getLeft());
			System.out.print((t.getRootObj()) + " ");
			inorder(t.getRight());
		}
	}
	public class BinaryTreeException extends RuntimeException {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public BinaryTreeException(String err){
			super(err);
		}
	}
	
	public BinaryTree append(BinaryTree t,Object n){
		if(t.isEmpty())
			return new BinaryTree(n);
		else if((int)n<(int)t.getRootObj())
			t.setLeft(append(t.getLeft(),n));
		else
			t.setRight(append(t.getRight(),n));
		return t;
	}
	
	
	public char [][] plotTree(char[][] c, BinaryTree T,char x, int row, int col,int offset,boolean n){
		if(!T.isEmpty()){
			//System.out.println(col);
		String s = T.getRootObj().toString();
		if(n==false)
			if(row!=0)
				c[row-1][col+(offset)+1]=x;
				//System.out.println(offset);}
		if(n==true)
			if(row!=0)
				c[row-1][col-(offset)-1]=x;
					
		if(s.length()>1){
			c[row][col]=s.charAt(0);
			c[row][col+1]=s.charAt(1);
		}
		else
			c[row][col]=s.charAt(0);
		
	
		plotTree(c,T.getLeft(),'/',row+2,(col-offset)-1,offset/2,false);
		plotTree(c,T.getRight(),'\\',row+2,(col+offset)+1,offset/2,true);
		}
		return c;
		
	}
	public void printTree(char c[][],int row, int col){
		for(int i= 0; i<row; i++){
			for(int j = 0; j<col; j++){
				if(c[i][j]==0){
					System.out.print(' ');
				}
				else
				 System.out.print(c[i][j]);
			}
			System.out.println();
		}
	}
}
				
		
	




