package BST;

//Write a function that takes in a potentially invalid Binary Search Tree (BST) and returns a boolean representing whether the BST is valid.
//
//Each BST node has an integer value, a left child node, and a right child node. A node is said to be a valid BST node if and only if it satisfies the BST property: its value is strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST nodes themselves or None / null.
//
//A BST is valid if and only if all of its nodes are valid BST nodes.
public class ValidateBST {
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return traverse(tree,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean traverse(BST node,int minValue, int maxValue){
        if(node.value < minValue || node.value >= maxValue){
            return false;
        }

        if(node.left != null && !traverse(node.left, minValue, node.value)){
            return false;
        }
        if(node.right != null && !traverse(node.right,node.value,maxValue)){
            return false;
        }
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // create test case
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        System.out.println(validateBst(root));

    }
}
