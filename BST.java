import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable<T>> implements Iterable<T> {
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
        levelOrderTraversal(root);
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

        if (r == null) {
            return h;
        }

        int leftHeight = height(r.getLeft());
        int rightHeight = height(r.getRight());
        h = Math.max(leftHeight, rightHeight) + 1;

        // TODO
        return h;
    }

    private Queue<T> bstQueue = new LinkedList<>();

    private void visit(BSTNode r) {
        if (r != null)
            bstQueue.add(r.getData());
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
        Queue<BSTNode> levelQueue = new LinkedList<>();
        levelQueue.add(r);
        while (levelQueue.isEmpty() != true) {
            BSTNode tempNode = levelQueue.poll();
            visit(tempNode);

            /* Enqueue left child */
            if (tempNode.left != null) {
                levelQueue.add(tempNode.left);
            }
            /* Enqueue right child */
            if (tempNode.right != null) {
                levelQueue.add(tempNode.right);
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new BSTIteratorInOrder();
    }

    private class BSTIteratorInOrder implements Iterator<T> {

        public BSTIteratorInOrder() {
            bstQueue.clear();
            inOrderTraversal(root);
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return !bstQueue.isEmpty();
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return bstQueue.remove();
        }

    }

}
