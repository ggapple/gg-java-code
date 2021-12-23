package BinarySearchTree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Tree implements Serializable {

    class Node implements Serializable {
        Student student;
        Node left, right;

        public Node() {

        }

        public Node(Student data) {
            this.student = data;
            this.left = null;
            this.right = null;
        }
    }

    static int index = 1;
    private Node root = null;
    private static int nodeCount = 0;

    

    public void setRootNode(Student myStudent) {
        this.root.student = myStudent;
    }

    public void addStudent(Student myStudent) {
        root = addNode(this.root, myStudent);
        nodeCount++;
    }

    public int getNumberOfNode() {

        return nodeCount;
    }

    public void printTree() {
        Tree.setIndex();
        inorderTraversal(this.root);

    }

    public void printBFS() {
        Tree.setIndex();
        BFS(root);
    }

    public void findStudent(int ID) {
        Node tempRoot = searchNode(root, ID);
        if (tempRoot != null)
            tempRoot.student.ouput(0);
        else
            System.out.println("Can't Find That Student");
        System.out.println();
    }

    public void deleteStudent(int ID) {
        Node tempRoot = searchNode(root, ID);
        if (tempRoot != null) {
            tempRoot = deleteNode(root, ID);
            printTree();
        } else
            System.out.println("Can't Find That Student");
    }

    public int numberOfNode() {
        return nodeCount;
    }

    public int heightOfTree() {
        return depthOfNode(root);
    }

    public Node addNode(Node node, Student myStudent) {

        if (node == null) {
            node = new Node(myStudent);
            return node;

        } else {
            if (myStudent.getID() < node.student.getID()) {
                node.left = addNode(node.left, myStudent);
            } else if (myStudent.getID() > node.student.getID()) {
                node.right = addNode(node.right, myStudent);
            }
        }
        return node;
    }

    public Node searchNode(Node node, int ID) {
        if (node == null || node.student.getID() == ID)
            return node;
        if (node.student.getID() > ID)
            return searchNode(node.left, ID);
        else
            return searchNode(node.right, ID);
    }

    public Node deleteNode(Node node, int ID) {
        if (node == null)
            return null;
        if (ID < node.student.getID())
            node.left = deleteNode(node.left, ID);
        else if (ID > node.student.getID())
            node.right = deleteNode(node.right, ID);
        else {
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else {
                Node successorNode = findSuccessor(node.right);
                node.student = successorNode.student;
                node.right = deleteNode(node.right, successorNode.student.getID());
            }
        }
        return node;
    }

    public Node findSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void inorderTraversal(Node node) {
        if (node.left != null) {
            inorderTraversal(node.left);
        }
        node.student.ouput(index++);
        System.out.println();
        if (node.right != null) {
            inorderTraversal(node.right);
        }
    }

    public int depthOfNode(Node node) {
        if (node == null)
            return 0;
        return Math.max(depthOfNode(node.left), depthOfNode(node.right)) + 1;
    }

    public void BFS(Node node) {
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.add(node);
        while (!myQueue.isEmpty()) {
            Node discoveredNode = myQueue.poll();
            discoveredNode.student.ouput(index++);
            System.out.println();
            if (discoveredNode.left != null)
                myQueue.add(discoveredNode.left);
            if (discoveredNode.right != null)
                myQueue.add(discoveredNode.right);
        }
    }

    public static void setIndex() {
        Tree.index = 1;
    }
}
