package BinarySearchTree;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student implements Serializable {
    private int ID;
    private String name;
    private float mark;

    public Student() {
        this.ID = 0;
        this.name = " ";
    }

    public Student(int ID, String name, double mark) {
        setID(ID);
        setName(name);
        setMark((float) mark);
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public float getMark() {
        return mark;
    }

    public String getRankedAccademy() {
        if (getMark() >= 9)
            return "Exellent";
        else if (getMark() >= 8 && getMark() < 9)
            return "Very Good";
        else if (getMark() >= 6.5 && getMark() < 8)
            return "Good";
        else if (getMark() >= 5 && getMark() < 6.5)
            return "Average";
        else
            return "Below Average";
    }

    public String getFirstName() {
        String[] separatedName = name.split(" ");
        return separatedName[separatedName.length - 1];
    }

    public void input(Scanner sc) {
        boolean flag = true;
        while (flag) {
            try {
                sc = new Scanner(System.in);
                System.out.print("Input ID: ");
                int ID = sc.nextInt();
                sc.nextLine();
                System.out.print("Input Name: ");
                String name = sc.nextLine();
                System.out.print("Input Mark: ");
                float mark = sc.nextFloat();
                setID(ID);
                setName(name);
                setMark(mark);
                flag = false;
            } catch (InputMismatchException exc) {
                System.out.println("Invalid Input");
            }
        }
    }

    public void ouput(int index) {
        System.out.printf("%-10d %-10d %-20s %-20.2f", index, getID(), getName(), getMark());

    }
}
