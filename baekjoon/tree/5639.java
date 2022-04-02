import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int key;
    Node left;
    Node right;
    Node(int key) {
        this.key = key;
    }
}
class Tree {
    public Node root;
    public void createNode(int key) {
        if (root==null) {
            root = new Node(key);
        } else {
            searchNode(root, key);
        }
    }
    public void searchNode(Node node, int key) {
        if (node.key >= key) {
            if (node.left == null) {
                node.left = new Node(key);
            } else {
                searchNode(node.left, key);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(key);
            } else {
                searchNode(node.right, key);
            }
        }
    }
    public void postOrder(Node node) {
        if (node != null) {
            if (node.left != null) postOrder(node.left);
            if (node.right != null) postOrder(node.right);
            System.out.println(node.key);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree t = new Tree();
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            t.createNode(Integer.parseInt(input));
        }
        t.postOrder(t.root);
    }
}