package TH_tree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Student_Program {
	public static boolean save_to_file(Student_node Tree, String path) {
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

	public static Student_node read_from_file(String path) {

		Student_node Tree = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			Tree = (Student_node) o;
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Tree;
	}

	public static void main(String[] args) {
		// Student_node Tree=null;
		Student_node BST_Tree = null;

		Student_manager Manager = new Student_manager();

		Student_node n1 = new Student_node(107, "Nguyen Van Dung", "DHCNTT16A", 6.7);
		Student_node n2 = new Student_node(104, "Nguyen Thi Hanh", "DHCNTT16A", 4.8);
		Student_node n3 = new Student_node(106, "Tran Thi Hai", "DHCNTT16B", 7.6);
		Student_node n4 = new Student_node(109, "Le Van Phuoc", "DHCNTT16B", 8.8);
		Student_node n5 = new Student_node(101, "Quach Thanh Danh", "DHCNTT16D", 5.3);
		Student_node n6 = new Student_node(105, "Vu Van Hung", "DHCNTT16A", 6.2);
		Student_node n7 = new Student_node(102, "Le Tien Loc", "DHCNTT16C", 9.5);
		Student_node n8 = new Student_node(100, "Pham Quang Minh", "DHCNTT16C", 8.7);
		Student_node n9 = new Student_node(108, "Ho Van Mui", "DHCNTT16D", 3.5);
		Student_node n10 = new Student_node(103, "Nguyen Van Dat ", "DHCNTT16A", 4.7);
		/*
		 * Tree=n1; n1.Left=n2; n1.Right=n3; n2.Left=n4; n2.Right=n5; n3.Left=n6;
		 * n3.Right=n7; n4.Left=n8; n4.Right=n9; n5.Left=n10;
		 */
		BST_Tree = Manager.BST_add_node(BST_Tree, n1);
		BST_Tree = Manager.BST_add_node(BST_Tree, n2);
		BST_Tree = Manager.BST_add_node(BST_Tree, n3);
		BST_Tree = Manager.BST_add_node(BST_Tree, n4);
		BST_Tree = Manager.BST_add_node(BST_Tree, n5);
		BST_Tree = Manager.BST_add_node(BST_Tree, n6);
		BST_Tree = Manager.BST_add_node(BST_Tree, n7);
		BST_Tree = Manager.BST_add_node(BST_Tree, n8);
		BST_Tree = Manager.BST_add_node(BST_Tree, n9);
		BST_Tree = Manager.BST_add_node(BST_Tree, n10);

		// save_to_file(BST_Tree,"BST_Student_node1.dat");
		int menu = 1;
		Scanner nhaplieu = new Scanner(System.in);

		while (menu != 0) {
			System.out.println("CHUONG TRINH QUAN LY SINH VIEN SU DUNG DANH SACH LIEN KET- MENU CHUC NANG");
			System.out.println("1-Open Student List from File");
			System.out.println("2-View Student List ");
			System.out.println("3-View list of excellent student ");
			System.out.println("4-Find Student with highest result ");
			System.out.println("5-Find Student with lowest result ");
			System.out.println("6-Student Ratio");
			System.out.println("0-Save/Exit");
			System.out.println("Please choose: ");
			menu = nhaplieu.nextInt();
			nhaplieu.nextLine();
			Manager.stt = 0;
			switch (menu) {
			case 1: {
				BST_Tree = read_from_file("BST_Student_node1.dat");
			}
			case 2: {
				System.out.println("Danh sach sinh vien");
				Manager.read_student_tree(BST_Tree);
				break;
			}
			case 3: {
				System.out.println("Danh sach sinh vien loai gioi");
				Manager.Output_student_excellent(BST_Tree);
				break;
			}
			case 4: {
				System.out.println("Sinh vien co diem cao nhat");
				Manager.Highest_Result(BST_Tree).output(0);
				break;
			}
			case 5: {
				System.out.println("Sinh vien co diem thap nhat");
				Manager.Lowest_Result(BST_Tree).output(0);
				break;
			}
			case 6: {
				Manager.countA = 0;
				Manager.countB = 0;
				Manager.countC = 0;
				Manager.countD = 0;
				System.out.println("Ty le sinh vien theo hoc luc");
				Manager.Studen_Ratio(BST_Tree);
				break;
			}
			case 7: {
				Manager.xapsep(BST_Tree);
				break;
			}
			case 0: {
				save_to_file(BST_Tree, "BST_Student_node1.dat");
				break;
			}
			}
		}

		nhaplieu.close();
	}

}
