package arvore.binarytree;

public class Binary_Tree {

    private static class Node {

        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    public Binary_Tree() {
        root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node R, int key) {
        if (R == null) {
            return new Node(key);
        } else {
            if (key < R.key) {
                R.left = insert(R.left, key);
            } else if (key > R.key) {
                R.right = insert(R.right, key);
            }
            return R;
        }
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node R, int key) {
        if (R != null) {
            if (key == R.key) {
                R = deleteNode(R);
            } else if (key < R.key) {
                R.left = delete(R.left, key);
            } else {
                R.right = delete(R.right, key);
            }
        }
        return R;
    }

    public boolean contains(int key) {
        return contains(root, key);
    }

    private boolean contains(Node R, int key) {
        if (R == null) {
            return false;
        } else if (key == R.key) {
            return true;
        } else if (key < R.key) {
            return contains(R.left, key);
        } else {
            return contains(R.right, key);
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        toString(root, sb);
        return sb.toString();
    }

    private void toString(Node R, StringBuffer sb) {
        if (R != null) {
            toString(R.left, sb);
            sb.append(R.key).append(" ");
            toString(R.right, sb);
        }
    }

    private Node deleteNode(Node R) {
        if (R.left == null) {
            return R.right;
        } else if (R.right == null) {
            return R.left;
        } else {
            return deleteMax(R);
        }
    }

    private Node deleteMax(Node R) {
        if (R.left.right == null) {
            R.left.right = R.right;
            return R.left;
        } else {
            Node aux1 = R.left, aux2 = R.left.right;
            while (aux2.right != null) {
                aux1 = aux2;
                aux2 = aux2.right;
            }
            aux1.right = aux2.left;
            aux2.left = R.left;
            aux2.right = R.right;
            return aux2;
        }
    }
}

