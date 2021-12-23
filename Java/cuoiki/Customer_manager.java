package cuoiki;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer_manager {
    public static int stt = 0;
    public static Scanner sc = new Scanner(System.in);

    // xuat danh sach
    public void View_List_node(Customer_node tree) {
        if (tree == null)
            System.out.println("Cay rong");
        else {
            if (tree.left != null)
                View_List_node(tree.left);
            tree.output(stt++);
            if (tree.right != null)
                View_List_node(tree.right);
        }
    }

    // nhap node
    public Customer_node Input_node(Customer_node newnode) {
        boolean flag = true;
        while (flag) {
            try {
                System.out.print("input ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("input Name: ");
                String name = sc.nextLine();
                System.out.print("input Coin: ");
                double coin = sc.nextDouble();
                newnode.set_ID(id);
                newnode.set_Name(name);
                newnode.set_Coin(coin);
                flag = false;
            } catch (InputMismatchException exc) {
                System.out.println("Invalid Input");
            }
        }
        return newnode;
    }

    // them node
    public Customer_node BST_add_node(Customer_node tree, Customer_node newnode) {
        if (tree == null)
            return newnode;
        else {
            if (newnode.get_ID() < tree.get_ID()) {
                tree.left = BST_add_node(tree.left, newnode);
                return tree;
            } else {
                tree.right = BST_add_node(tree.right, newnode);
                return tree;
            }
        }
    }

    // tim node
    public Customer_node Search_node(Customer_node tree, int ID) {
        if (tree == null)
            return null;
        else if (tree.get_ID() == ID)
            return tree;
        else if (tree.get_ID() > ID)
            return Search_node(tree.left, ID);
        else
            return Search_node(tree.right, ID);
    }

    // node trai nhat
    public Customer_node TheLeftmost_node(Customer_node tree) {
        if (tree.left == null)
            return tree;
        else
            return TheLeftmost_node(tree.left);
    }

    // xoa node
    public Customer_node Delete_node(Customer_node tree, int ID) {
        if (tree == null)
            return null;
        if (ID < tree.get_ID())
            tree.left = Delete_node(tree.left, ID);
        else if (ID > tree.get_ID())
            tree.right = Delete_node(tree.right, ID);
        else {
            if (tree.right == null) {
                return tree.left;
            } else if (tree.left == null) {
                return tree.right;
            } else {
                Customer_node leftmost = TheLeftmost_node(tree.right);
                tree = leftmost;
                tree.right = Delete_node(tree.right, leftmost.get_ID());
            }
        }
        return tree;
    }

    // sua node
    public Customer_node Update_node(Customer_node tree) {
        System.out.println("Nhap ID can cap nhat: ");
        int newid = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap lua chon cap nhat (1 - Ho va ten 2 - So coin): ");
        int chon = sc.nextInt();
        sc.nextLine();
        if (chon == 1) {
            System.out.println("Nhap ho va ten: ");
            String newname = sc.nextLine();
            Search_node(tree, newid).set_Name(newname);
        } else if (chon == 2) {
            System.out.println("Nhap so coin: ");
            int newcoin = sc.nextInt();
            Search_node(tree, newid).set_Coin(newcoin);
        }
        return tree;
    }
}
