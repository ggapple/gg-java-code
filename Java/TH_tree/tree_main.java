package TH_tree;

public class tree_main {
    
    public static node test() {
        node root = new node(3);
        node n11 = new node(7);
        node n12 = new node(5);
        node n21 = new node(2);
        node n22 = new node(6);
        node n23 = new node(3);
        node n24 = new node(6);
        node n31 = new node(5);
        //node n32 = new node(8);
        node n33 = new node(4);
        node n34 = new node(5);
        //node n35 = new node(8);
        node n36 = new node(4);
        node n37 = new node(5);
        node n38 = new node(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n22.left = n33;
        n22.right = n34;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;
        return root;
    }

    public static void main(String[] args) {

        BTreePrinter.printNode(test());
        System.out.println(Treeprinter.traversePreOrder(test()));
        
    }
}