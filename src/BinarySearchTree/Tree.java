package BinarySearchTree;

import java.util.ArrayList;

public class Tree {
	
	public IntWrapper it=new IntWrapper();
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
	public void ModifyTree(){
		Root.ModifyTree(Root, it);
	}
	//public void FindSum(int sum) {
		//Root.FindSum(Root, sum, it);
		
	//}
	//public boolean IsBalanced(){
		//return Root.IsBalanced(Root);
		
	//}
	//public void FindMax(){
		//int ans=Root.FindMax(Root);
		//System.out.println(ans);
	//}
	public void FindSecondMax(){
		int ans=Root.FindSecondMax(Root);
		System.out.println(ans);
	}
	public void LCA(){
		Node ans=Root.LCA(Root,new Node(2), new Node(3));
		System.out.println(ans.Value);
	}
	public void IsBST(){
		int Min=Integer.MIN_VALUE;
		int Max=Integer.MAX_VALUE;
		boolean ans=Root.IsBST(Root, Min, Max);
		System.out.println(ans);
	}
	public void ListAtDepths(){
		ArrayList<ArrayList<Node>> ans=Root.ListAtDepths(Root);
		for(ArrayList<Node> temp:ans){
			for(Node n:temp){
				System.out.print(n.Value);
			}
			System.out.println("\n");
		}
	}
}
