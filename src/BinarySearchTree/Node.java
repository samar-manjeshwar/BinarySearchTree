
package BinarySearchTree;

public class Node {
	
	public int Value;
	public Node Rchild;
	public Node Lchild;
	
	public Node(int num){
		this.Rchild=null;
		this.Lchild=null;
		this.Value=num;
	}
	
	public boolean IsLeaf(Node Root){
		
		if(Root.Rchild==null && Root.Lchild==null){
			return true;
		}
		else
			return false;
	}
	public void Display(Node Root){
		if(Root!=null){
		Display(Root.Lchild);
		System.out.println(Root.Value);
		Display(Root.Rchild);
		}
	}
	public boolean Search(Node Root,int num){
		
		if(Root==null){  }
		else if(Root.Value==num){
			return true;
		}
		else if(num>Root.Value){
			Search(Root.Rchild,num);
		}
		else if(num<Root.Value){
			Search(Root.Lchild,num);
		}
		return false;
	}
	public void Insert(Node Root,int num){
		if(Root==null){
			Root=new Node(num);
		}
		Node Current=Root;
		Node Parent=null;
		while(true){
			if(num>Current.Value){
				Parent=Current;
				Current=Current.Rchild;
				if(Current==null){
					Parent.Rchild=new Node(num);
					return;
				}
			}
			else if(num<Current.Value){
				Parent=Current;
				Current=Current.Lchild;
				if(Current==null){
					Parent.Lchild=new Node(num);
					return;
				}
			}
		}
		
	}
	public void ModifiedInorder(Node Root){
		if(Root!=null){
			ModifiedInorder(Root.Rchild);
			System.out.println(Root.Value);
			ModifiedInorder(Root.Lchild);
			
		}
	}
	public void PostOrder(Node Root){
		if(Root!=null){
			PostOrder(Root.Lchild);
			PostOrder(Root.Rchild);
			System.out.println(Root.Value);
		}
	}
	public void PreOrder(Node Root){
		if(Root!=null){
			System.out.println(Root.Value);
			PreOrder(Root.Lchild);
			PreOrder(Root.Rchild);
		}
	}
	


}
