package TH_tree;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Student_manager {
	public static int stt = 0;
	public static int countA = 0;
	public static int countB = 0;
	public static int countC = 0;
	public static int countD = 0;

	public void read_student_tree(Student_node T) {
		if (T == null)
			System.out.println("Cay rong");
		else {
			if (T.Left != null)
				read_student_tree(T.Left);
			T.output(stt++);
			if (T.Right != null)
				read_student_tree(T.Right);
		}
	}

	// 1-Ham dem so nut cua cay
	public int count_nodes(Student_node T) {
		if (T == null)
			return 0;
		else
			return 1 + count_nodes(T.Left) + count_nodes(T.Right);
	}

	// 2-Tim nut ben trai nhat, nut ben phai nhat
	public Student_node TheLeftmost_node(Student_node T) {
		if (T.Left == null)
			return T;
		else
			return TheLeftmost_node(T.Left);
	}

	public Student_node TheRightmost_node(Student_node T) {
		if (T.Left == null)
			return T;
		else
			return TheRightmost_node(T.Left);
	}

	// 3-Tim node sinh vien theo ma so sinh vien
	public Student_node FindStudentNode(Student_node T, int ID) {
		if (T == null)
			return null;
		else if (T.get_Id() == ID)
			return T;
		else if (FindStudentNode(T.Left, ID) != null)
			return FindStudentNode(T.Left, ID);
		else
			return FindStudentNode(T.Right, ID);
	}

	// 4-Xac dinh chieu cao cua cay
	public int Tree_Hight(Student_node T) {
		if (T == null)
			return 0;
		else {
			int a = Tree_Hight(T.Left);
			int b = Tree_Hight(T.Right);
			int c = (a > b) ? a : b;
			return 1 + c;
		}
	}

	// 5-Dem va xuat thong tin so nut goc, nut nhanh, nut la
	public int count_leafs(Student_node T) {
		if (T == null)
			return 0;
		else if ((T.Left == null) && (T.Right == null))
			return 1;
		else
			return count_leafs(T.Left) + count_leafs(T.Right);
	}

	public void Info_Tree(Student_node T) {
		if (count_nodes(T) == 0)
			System.out.println("Tree is null ");
		else if (count_nodes(T) == 1)
			System.out.println("Tree has only one node");
		else
			System.out.println("Tree has one root and " + (count_nodes(T) - count_leafs(T) - 1) + " branch nodes and "
					+ count_leafs(T) + " leafs");

	}
	// 6-Them mot node theo huong cay can bang
	/*
	 * public Student_node add_node(Student_node T,Student_node newnode) { if
	 * (T==null) { T=newnode; return T;} else if (T.Left==null)
	 * {T.Left=newnode;return T;} else if (T.Right==null) {T.Right=newnode;return
	 * T;} else if (count_nodes(T.Left)<count_nodes(T.Right))
	 * {T.Left=add_node(T.Left,newnode);return T;} else
	 * {T.Right=add_node(T.Right,newnode);return T;} }
	 */
	// 7-Xoa mot node

	public Student_node delete_node(Student_node T, int ID) {

		if (T == null)
			return null;
		else if (T.get_Id() == ID) {
			Student_node T1 = T.Left;
			Student_node T2 = T.Right;
			if ((T1 == null) && (T2 == null))
				return null;
			else if (T2 == null)
				return T1;
			else if (T1 == null)
				return T2;
			else {
				T = T1;
				while (T1.Left != null) {
					T1 = T1.Left;
				}
				T1.Left = T2;
				return T;
			}

		} else {
			T.Left = delete_node(T.Left, ID);
			T.Right = delete_node(T.Right, ID);
			return T;
		}

	}

	// 8-Them mot node cay nhi phan tim kiem
	public Student_node BST_add_node(Student_node T, Student_node newnode) {
		if (T == null)
			return newnode;
		else {
			if (newnode.get_Id() < T.get_Id()) {
				T.Left = BST_add_node(T.Left, newnode);
				return T;
			} else {
				T.Right = BST_add_node(T.Right, newnode);
				return T;
			}
		}
	}

	//
	// 9-Tim kiem tren cay nhi phan tim kiem
	public Student_node BST_Search_node(Student_node T, int ID) {
		if (T == null)
			return null;
		else if (T.get_Id() == ID)
			return T;
		else if (T.get_Id() > ID)
			return BST_Search_node(T.Left, ID);
		else
			return BST_Search_node(T.Right, ID);
	}

	// 10-Xoa node cay nhi phan tim kiem
	public Student_node BST_delete_node(Student_node T, int ID) {
		if (T == null)
			return null;
		else if (T.get_Id() == ID) {
			if (T.Left == null)
				return T.Right;
			else if (T.Right == null)
				return T.Left;
			else {
				Student_node LeftMost = TheLeftmost_node(T.Right);
				T.input(LeftMost.get_Id(), LeftMost.get_Name(), LeftMost.get_Class(), LeftMost.get_Result());
				T.Right = delete_node(T.Right, LeftMost.get_Id());
				return T;
			}
		} else {
			if (T.get_Id() > ID)
				T.Left = BST_delete_node(T.Left, ID);
			else
				T.Right = BST_delete_node(T.Right, ID);
			return T;
		}
	}

	// xuat danh danh hoc sinh gioi
	public void Output_student_excellent(Student_node T) {
		if (T == null)
			System.out.println("cay rong");
		else {
			if (T.get_Result() > 8)
				T.output(stt++);
			if (T.Left != null)
				Output_student_excellent(T.Left);
			if (T.Right != null)
				Output_student_excellent(T.Right);
		}
	}

	// tim sinh vien co diem cao nhat
	public Student_node Highest_Result(Student_node T) {
		if (T == null)
			return null;

		else {
			Student_node T1 = Highest_Result(T.Left);
			Student_node T2 = Highest_Result(T.Right);
			if (T1 == null && T2 == null)
				return T;
			else if (T1 == null) {
				if (T.get_Result() >= T2.get_Result())
					return T;
				return T2;
			} else if (T2 == null) {
				if (T.get_Result() >= T1.get_Result())
					return T;
				return T1;
			} else {
				if (T.get_Result() >= T1.get_Result()) {
					if (T2.get_Result() >= T.get_Result())
						return T2;
					return T;
				} else {
					if (T2.get_Result() >= T1.get_Result())
						return T2;
					return T1;
				}
			}
		}
	}

	// tim sinh vien co diem thap nhat
	public Student_node Lowest_Result(Student_node T) {
		Student_node Min;
		Student_node MinLeft;
		Student_node MinRight;
		if (T == null)
			return null;
		else {
			Min = T;
			MinLeft = Lowest_Result(T.Left);
			MinRight = Lowest_Result(T.Right);
			if ((MinLeft == null) && (MinRight == null))
				return Min;
			else if (MinLeft == null) {
				if (Min.get_Result() <= MinRight.get_Result())
					return Min;
				else
					return Min.Right;
			} else if (Min.Right == null) {
				if (Min.get_Result() <= MinLeft.get_Result())
					return Min;
				else
					return MinLeft;
			} else {
				MinLeft = Lowest_Result(T.Left);
				MinRight = Lowest_Result(T.Right);
				if (Min.get_Result() <= MinLeft.get_Result()) {
					if (MinRight.get_Result() <= Min.get_Result())
						return MinRight;
					else
						return Min;
				} else if (MinRight.get_Result() <= MinLeft.get_Result())
					return MinRight;
				else
					return MinLeft;
			}
		}
	}

	// dem so sinh vien gioi
	public int CountStudent_A(Student_node T) {
		if (T == null)
			return 0;
		else {

			if (T.get_Result() >= 8)
				countA++;
			if (T.Left != null)
				CountStudent_A(T.Left);
			if (T.Right != null)
				CountStudent_A(T.Right);
			return countA;
		}
	}

	// dem so sinh vien kha
	public int CountStudent_B(Student_node T) {
		if (T == null)
			return 0;
		else {
			if (T.get_Result() >= 6.5 && T.get_Result() < 8)
				countB++;
			if (T.Left != null)
				CountStudent_B(T.Left);
			if (T.Right != null)
				CountStudent_B(T.Right);
			return countB;
		}

	}

	// dem so sinh vien trung binh
	public int CountStudent_C(Student_node T) {
		if (T == null)
			return 0;
		else {
			if (T.get_Result() >= 5 && T.get_Result() < 6.5)
				countC++;
			if (T.Left != null)
				CountStudent_C(T.Left);
			if (T.Right != null)
				CountStudent_C(T.Right);
			return countC;
		}

	}

	// dem so sinh vien kem
	public int CountStudent_D(Student_node T) {
		if (T == null)
			return 0;
		else {
			if (T.get_Result() < 5)
				countD++;
			if (T.Left != null)
				CountStudent_D(T.Left);
			if (T.Right != null)
				CountStudent_D(T.Right);
			return countD;
		}
	}

	// xuat ti le sinh vien
	public void Studen_Ratio(Student_node T) {
		int countA = CountStudent_A(T);
		int countB = CountStudent_B(T);
		int countC = CountStudent_C(T);
		int countD = CountStudent_D(T);
		int total = count_nodes(T);
		System.out.printf("%-20s %-20s %-20s %n", "Xep loai", "So luong", "Ty le");
		System.out.printf("%-20s %-20d %.2f%s %n", "Gioi", countA, (double) countA * 100 / total, "%");
		System.out.printf("%-20s %-20d %.2f%s %n", "Kha", countB, (double) countB * 100 / total, "%");
		System.out.printf("%-20s %-20d %.2f%s %n", "Trung binh", countC, (double) countC * 100 / total, "%");
		System.out.printf("%-20s %-20d %.2f%s %n", "Kem", countD, (double) countD * 100 / total, "%");
	}

	//
	public void xapsep(Student_node T) {
		Queue<Student_node> myQueue = new LinkedList<>();
		myQueue.add(T);
		while (!myQueue.isEmpty()) {
			Student_node discoveredNode = myQueue.poll();
			discoveredNode.output(stt++);
			System.out.println();
			if (discoveredNode.Left != null)
				myQueue.add(discoveredNode.Left);
			if (discoveredNode.Right != null)
				myQueue.add(discoveredNode.Right);
		}
	}

}
