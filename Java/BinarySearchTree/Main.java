package BinarySearchTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void writeToFile(Tree classTree, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream os = new ObjectOutputStream(fos)) {
            os.writeObject(classTree);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static Tree readFile(String filepath) {
        Tree newClassTree = null;
        try (FileInputStream fis = new FileInputStream(filepath); ObjectInputStream is = new ObjectInputStream(fis)) {
            newClassTree = (Tree) is.readObject();
        } catch (IOException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }
        return newClassTree;
    }

    public static void Show() {
        System.out.println("1. Add Student");
        System.out.println("2. Print Tree");
        System.out.println("3. Find Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Save Tree");
        System.out.println("6. Load Tree");
        System.out.println("0. Exit");
    }

    public static void main(String... args) {
        Tree classTree = new Tree();
        Student n1 = new Student(100, "Nguyen Van Dung", 6.7);
        Student n2 = new Student(104, "Nguyen Thi Hanh", 4.8);
        Student n3 = new Student(106, "Tran Thi Hai", 7.6);
        Student n4 = new Student(109, "Le Van Phuoc", 8.8);
        Student n5 = new Student(101, "Quach Thanh Danh", 5.3);
        Student n6 = new Student(105, "Vu Van Hung", 6.2);
        Student n7 = new Student(102, "Le Tien Loc", 9.5);
        Student n8 = new Student(107, "Pham Quang Minh", 8.7);
        Student n9 = new Student(108, "Ho Van Mui", 3.5);
        Student n10 = new Student(103, "Nguyen Van Dat ", 4.7);
        classTree.addStudent(n1);
        classTree.addStudent(n2);
        classTree.addStudent(n3);
        classTree.addStudent(n4);
        classTree.addStudent(n5);
        classTree.addStudent(n6);
        classTree.addStudent(n7);
        classTree.addStudent(n8);
        classTree.addStudent(n9);
        classTree.addStudent(n10);
        boolean check = true;
        int choice;
        while (check) {
            Show();
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                System.out.print("Enter Number Of Student You Want To Add: ");
                int number = sc.nextInt();
                for (int i = 0; i < number; i++) {
                    System.out.println("Enter student number " + (i + 1) + ": ");
                    Student newStudent = new Student();
                    newStudent.input(sc);
                    classTree.addStudent(newStudent);
                }
                break;
            case 2:
                System.out.printf("%-10s %-10s %-20s %-20s", "Index", "ID", "Name", "Mark");
                System.out.println();
                classTree.printTree();
                System.out.println("The Number Of Node: " + classTree.getNumberOfNode());
                System.out.println("The Heigh Of Tree Is: " + classTree.heightOfTree());
                break;
            case 3:
                System.out.print("Enter ID You Want To Find: ");
                int ID = sc.nextInt();
                classTree.findStudent(ID);
                break;
            case 4:
                System.out.print("Enter ID You Want To Delete: ");
                int newID = sc.nextInt();
                classTree.deleteStudent(newID);
                break;
            case 5:
                writeToFile(classTree, "Tran Hoang Viet _ Tree.txt");
                break;
            case 6:
                classTree = readFile("Tran Hoang Viet _ Tree.txt");
                classTree.printTree();
                break;
            case 7:
                classTree.printBFS();
            case 0:
                check = false;
                break;
            }
        }
    }
}
