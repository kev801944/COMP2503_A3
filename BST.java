import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

public class BST<T extends Comparable<T>> {
    class BSTNode implements Comparable<BSTNode> {
        private T data;
        private BSTNode left;
        private BSTNode right;

        public BSTNode(T d) {
            setLeft(null);
            setRight(null);
            setData(d);
        }

        public T getData() {
            return data;
        }

        public void setData(T d) {
            data = d;
        }

        public void setLeft(BSTNode l) {
            left = l;
        }

        public void setRight(BSTNode r) {
            right = r;
        }

        public BSTNode getLeft() {
            return left;
        }

        public BSTNode getRight() {
            return right;
        }

        public boolean isLeaf() {
            return (getLeft() == null) && (getRight() == null);
        }

        public int compareTo(BSTNode o) {
            return this.getData().compareTo(o.getData());
        }
    }

    private BSTNode root;
    private int size;
    private Comparator<T> comparator;

    public BST() {
        root = null;
        size = 0;
        comparator = null;
    }

    public BST(Comparator<T> externalComparator) {
        root = null;
        size = 0;
        comparator = externalComparator;
    }

    /**
     * Return the number of nodes in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Return true if element d is present in the tree.
     */
    public T find(T d) {
        return find(d, root);
    }

    /**
     * Add element d to the tree.
     */
    public void add(T d) {
        BSTNode n = new BSTNode(d);
        if (root == null) {
            size++;
            root = n;
        } else {
            add(root, n);
        }
    }

    /**
     * Return the height of the tree.
     */
    public int height() {
        return height(root);
    }

    public void printInOrder() {
        inOrderTraversal(root);
    }

    public void printPreOrder() {
        preOrderTraversal(root);
    }

    public void printPostOrder() {
        postOrderTraversal(root);
    }

    public void printLevelOrder() {
        inOrderTraversal(root);
    }

    // Private methods.

    private T find(T d, BSTNode r) {
        if (r == null)
            return null;
        int c = d.compareTo(r.getData());
        if (c == 0)
            return r.getData();
        else if (c < 0)
            return find(d, r.getLeft());
        else
            return find(d, r.getRight());
    }

    /* Do the actual add of node n to tree rooted at r */
    private void add(BSTNode r, BSTNode n) {
        int c = n.compareTo(r);

        if (c < 0) {
            // TODO
            if (r.getLeft() == null) {
                r.setLeft(n);
                size++;
            } else {
                add(r.getLeft(), n);
            }
        } else if (c >= 0) {
            if (r.getRight() == null) {
                r.setRight(n);
                size++;
            } else {
                add(r.getRight(), n);
            }
        }
    }

    /* Implement a height method. */
    private int height(BSTNode r) {
        int h = -1;

        // TODO
        return h;
    }

    private void visit(BSTNode r) {
        if (r != null)
            System.out.println(r.getData());
    }

    private void inOrderTraversal(BSTNode r) {
        if (r == null)
            return;
        else {
            inOrderTraversal(r.getLeft());
            visit(r);
            inOrderTraversal(r.getRight());
        }
    }

    private void preOrderTraversal(BSTNode r) {
        // TODO:
        if (r == null)
            return;
        else {
            visit(r);
            preOrderTraversal(r.getLeft());
            preOrderTraversal(r.getRight());
        }
    }

    private void postOrderTraversal(BSTNode r) {
        // TODO:
        if (r == null)
            return;
        else {
            postOrderTraversal(r.getLeft());
            postOrderTraversal(r.getRight());
            visit(r);
        }
    }

    private void levelOrderTraversal(BSTNode r) {
        // TODO:
    }

    private class BTSIterator implements Iterator<T> {
        private BSTNode iterator;
        Queue<BSTNode> queue = new BST<T>();

        private BTSIterator() {
            iterator = root;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return root.isLeaf();
        }

        @Override
        public Object next() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'next'");
        }

    }

}
