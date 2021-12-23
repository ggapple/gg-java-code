package cuoiki;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Customer_program {
    static Scanner nhaplieu = new Scanner(System.in);

    public static boolean save_to_file(Customer_node Tree, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Tree);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Customer_node read_from_file(String path) {

        Customer_node Tree = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            Tree = (Customer_node) o;
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Tree;
    }

    public static void show() {
        System.out.println("CHUONG TRINH QUAN LY - MENU CHUC NANG");
        System.out.println("1-Xem thong tin khach hang");
        System.out.println("2-Tim kiem khach hang");
        System.out.println("3-Them khach hang moi");
        System.out.println("4-Xoa khach hang");
        System.out.println("5-Cap nhat thong tin khach hang");
        System.out.println("0-Save/Exit");
        System.out.println("Please choose: ");
    }

    public void programcus() {
        Customer_node BST_Tree = read_from_file("customerlist.dat");
        Customer_manager Manager = new Customer_manager();
        int menu = 1;
        while (menu != 0) {
            System.out.println("1-Xem thong tin khach hang");
            System.out.println("2-Tim kiem thong tin khach hang");
            System.out.println("0-Exit");
            menu = nhaplieu.nextInt();
            nhaplieu.nextLine();
            Manager.stt = 0;
            switch (menu) {
                case 1: {
                    System.out.println("Danh sach khach hang");
                    Manager.View_List_node(BST_Tree);
                    break;
                }
                case 2: {
                    System.out.println("Nhap ID can tim");
                    int ID = nhaplieu.nextInt();
                    Manager.Search_node(BST_Tree, ID).output(0);
                    break;
                }
                case 0:
            }
        }

    }

    public void programadmin() {

        Customer_node BST_Tree = read_from_file("customerlist.dat");
        Customer_manager Manager = new Customer_manager();
        /*
         * Customer_node n1 = new Customer_node(107, "Nguyen Van Dung", 90);
         * Customer_node n2 = new Customer_node(104, "Nguyen Thi Hanh", 120);
         * Customer_node n3 = new Customer_node(106, "Tran Thi Hai", 350);
         * Customer_node n4 = new Customer_node(109, "Le Van Phuoc", 700);
         * Customer_node n5 = new Customer_node(101, "Quach Thanh Danh", 410);
         * Customer_node n6 = new Customer_node(105, "Vu Van Hung", 970);
         * Customer_node n7 = new Customer_node(102, "Le Tien Loc", 950);
         * Customer_node n8 = new Customer_node(100, "Pham Quang Minh", 50);
         * Customer_node n9 = new Customer_node(108, "Ho Van Mui", 340);
         * Customer_node n10 = new Customer_node(103, "Nguyen Van Dat ", 470);
         * 
         * BST_Tree = Manager.BST_add_node(BST_Tree, n1);
         * BST_Tree = Manager.BST_add_node(BST_Tree, n2);
         * BST_Tree = Manager.BST_add_node(BST_Tree, n3);
         * BST_Tree = Manager.BST_add_node(BST_Tree, n4);
         * BST_Tree = Manager.BST_add_node(BST_Tree, n5);
         * BST_Tree = Manager.BST_add_node(BST_Tree, n6);
         * BST_Tree = Manager.BST_add_node(BST_Tree, n7);
         * BST_Tree = Manager.BST_add_node(BST_Tree, n8);
         * BST_Tree = Manager.BST_add_node(BST_Tree, n9);
         * BST_Tree = Manager.BST_add_node(BST_Tree, n10);
         * save_to_file(BST_Tree, "customerlist.dat");
         */
        int menu = 1;
        while (menu != 0) {
            show();
            menu = nhaplieu.nextInt();
            nhaplieu.nextLine();
            Manager.stt = 0;
            switch (menu) {
                case 1: {
                    System.out.println("Danh sach khach hang");
                    Manager.View_List_node(BST_Tree);
                    break;
                }
                case 2: {
                    System.out.println("Nhap ID can tim");
                    int ID = nhaplieu.nextInt();
                    Manager.Search_node(BST_Tree, ID).output(0);
                    break;
                }
                case 3: {
                    System.out.println("Them khach hang");
                    Customer_node newnode = new Customer_node();
                    Manager.Input_node(newnode);
                    BST_Tree = Manager.BST_add_node(BST_Tree, newnode);
                    break;
                }
                case 4: {
                    System.out.println("Nhap ID can xoa");
                    int ID = nhaplieu.nextInt();
                    Manager.Delete_node(BST_Tree, ID);
                    break;
                }
                case 5: {
                    Manager.Update_node(BST_Tree);
                    break;
                }
                case 0: {
                    save_to_file(BST_Tree, "customerlist.dat");
                }
            }
        }

    }
}
