package baithuchanh;
import java.util.Scanner;
public class day_bit {
    static int[] arr = new int[100];// khai bao o day de dung cho toan bo bai
    static int n;// khai bao o main chi dung cho ham main
    public static void xuat(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
    //ham xuat bit
    public static void xet(int i) {
        if (i == n) {
            xuat(arr, n);
            System.out.println();
        }
        else for (int j = 0; j <= 1; j++) {
            arr[i]=j;
            xet(i+1);
        }
    }
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhap n");
        n = nhap.nextInt();   
        System.out.println("Cac chuoi nhi phan "+n+" bit: ");
        xet(0);
        nhap.close();
    }
    
}
