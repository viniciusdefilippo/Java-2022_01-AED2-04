package arvore.binarytree;

public class TesteBT {
    public static void main(String[] args) {

        Binary_Tree a = new Binary_Tree();
        a.insert(27);
        a.insert(13);
        a.insert(6);
        a.insert(17);
        a.insert(42);
        a.insert(33);
        a.insert(48);

        System.out.println(a.toString());

    }
}


