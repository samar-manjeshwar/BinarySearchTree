public class MainClass {

	public static void main(String[] args) {
		Tree Root = new Tree();
		Root.Insert(4);
		Root.Insert(5);
		Root.Insert(2);
		Root.Insert(1);
		Root.Insert(3);
		Root.Display();
		System.out.println("----------------------------------------");
		Root.ModifiedInorder();
		System.out.println("----------------------------------------");
		Root.PostOrder();
		System.out.println("----------------------------------------");
		Root.PreOrder();

	}

}
