


package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
	public void ModifyTree(Node Root,IntWrapper it){
		
		if(Root==null){
			return;
		}
		ModifyTree(Root.Rchild,it);
		it.sum=it.sum+Root.Value;
		Root.Value=it.sum;
		ModifyTree(Root.Lchild,it);
	}
	
	public IntWrapper FindSum(Node Root,int sum,IntWrapper it){
		if(Root==null){
			return it;
		}
		
		IntWrapper left=FindSum(Root.Lchild,sum,it);
		IntWrapper right=FindSum(Root.Rchild,sum,it);
		
		it.sum=left.sum+right.sum;
		it.count=left.count+right.count;
		if(it.sum==sum){
			it.count++;
		}
		return it;
		
	}
	/*
	public boolean IsBalanced(Node Root){
		
		if(Root==null){
			return true;
		}
		
		List<Integer> depths=new ArrayList<Integer>(3);
		
		Stack<NodeDepthPair> nodes=new Stack<NodeDepthPair>();
		nodes.push(new NodeDepthPair(Root,0));
		
		while(!nodes.empty()){
			
			//pop topmost nodedepthpair
			NodeDepthPair nodedepthpair=nodes.pop();
			Node node=nodedepthpair.Root;
			int depth=nodedepthpair.Depth;
			
			//incase of leaf node
			if(node.Lchild==null && node.Rchild==null){
				//Add the new depth to the list if it doesn't already exist
				if(!depths.contains(depth)){
					depths.add(depth);
					
					//incase there are more than 2 depths
					//incase there are exactly two depths but with a difference greater than 1
					if(depths.size()>2 || (depths.size()==2 && Math.abs((depths.get(0) - depths.get(1)))>1){
						return false;
					}
				}
			}
			
			//incase it is not a leaf node
			else{
				if(node.Lchild!=null){
					nodes.push(new NodeDepthPair(node.Lchild,depth+1));
				}
				if(node.Rchild!=null){
					nodes.push(new NodeDepthPair(node.Rchild,depth+1));
				}
				
			}
		}
		return true;
	}
	*/
	public int FindMax(Node Root){
		if(Root.Rchild!=null){
			 return FindMax(Root.Rchild);
		}
		return Root.Value;
	}
	public int FindSecondMax(Node Root){
		if(Root==null || (Root.Rchild==null && Root.Lchild==null)){
			throw new IllegalArgumentException("Too few nodes");
		}
		//When largest has left subtree
		//Largest in left subtree is second largest node
		if(Root.Lchild!=null && Root.Rchild==null){
			return FindMax(Root.Lchild);
		}
		//No left subtree
		//Current node is second largest
		if(Root.Rchild!=null && Root.Lchild==null && Root.Rchild.Rchild==null){
			return Root.Value;
		}
		//otherwise step right
		return FindSecondMax(Root.Rchild);
	}
	public Node LCA(Node Root, Node n1,Node n2){
		if(Root==null){
			return null;
		}
		if(Root.Value==n1.Value || Root.Value==n2.Value){
			return Root;
		}
		
		Node left=LCA(Root.Lchild,n1,n2);
		Node right=LCA(Root.Rchild,n1,n2);
		
		if(left!=null && right!=null){
			return Root;
		}
		if(left==null && right==null){
			return null;
		}
		
		return left!=null?left:right;
	}
	public boolean IsBST(Node Root,int Min,int Max){
		if(Root==null){
			return true;
		}
		if(Root.Value<Min || Root.Value>Max){
			return false;
		}
		return IsBST(Root.Lchild,Min,Root.Value) && IsBST(Root.Rchild,Root.Value,Max);
	}
	public ArrayList<ArrayList<Node>> ListAtDepths(Node Root){
		ArrayList<ArrayList<Node>> finallist=new ArrayList<ArrayList<Node>>();
		
		//For BFS
		
		ArrayList<Node> current=new ArrayList<Node>();
		if(Root!=null){
			current.add(Root);
		}

		while(current.size()>=0){
			finallist.add(current);
			
			ArrayList<Node> parents=current;
			
			current=new ArrayList<Node>();
			
			for(Node parent:parents){
				if(parent.Rchild!=null){
					current.add(parent.Rchild);
				}
				if(parent.Lchild!=null){
					current.add(parent.Lchild);
				}
			}
		}

		return finallist;
	}
	
	
	

}
