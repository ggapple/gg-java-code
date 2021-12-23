package TH_tree;

public class node {

        node right;
        node left;
        int data;
        public node () {
        
            this.right = null;
            this.left = null;
        }
        
        public node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    
}
