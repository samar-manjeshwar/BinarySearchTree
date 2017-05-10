
package BinarySearchTree;

public class Tree {
	
	public Node Root;
	public Tree(){
		Root=null;
	}
	public boolean IsEmpty(){
		if(Root==null){
			return true;
		}
		return false;
	}
	public void Insert(int num){
		if(IsEmpty()){
			Root=new Node(num);
		}
		else{
			Root.Insert(Root, num);
		}
	}
	public void Display(){
		Root.Display(Root);
	}
	public void ModifiedInorder() {
		Root.ModifiedInorder(Root); 
	}
	public void PostOrder(){
		Root.PostOrder(Root);
	}
	public void PreOrder(){
		Root.PreOrder(Root);
	}
}
