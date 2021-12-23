package baithuchanh;
import java.util.Scanner;
public class tron_2mang {
    static int[] arr = new int[100];
    static int n;
    static Scanner nhap = new Scanner(System.in);
    //ham sap xep
    public static void sapxep(int[] arr, int n) {
        int temp;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i]>arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    //ham nhap
    public static void nhap(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("nhap phan tu thu "+(i+1)+": ");
            arr[i] = nhap.nextInt();
        }
    }
    //ham xuat
    public static void xuat(int[] arr, int n) {
        for (int i = 0; i < n; i++) 
            System.out.print("  "+arr[i]);
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a = new int[100];
        int[] b = new int[100];
        int[] c = new int[100];
        int n1, n2; //n3;
        //nhap gia tri 2 mang
        System.out.println("nhap so phan tu day a: ");
        n1 = nhap.nextInt();
        nhap(a, n1);
        sapxep(a, n1);
        System.out.println("day so a: ");
        xuat(a, n1);
        System.out.println("nhap so phan tu day b: ");
        n2 = nhap.nextInt();
        nhap(b, n2);
        sapxep(b, n2);
        System.out.println("day so b: ");
        xuat(b, n2);
        nhap.close();
        //gop 2 mang
        /*n3 = n1+n2;
        for (int i = 0; i < n3; i++) {
            if (i<n1) c[i] = a[i];
            else c[i] = b[i-n1];
        }
        sapxep(c, n3);
        System.out.println("day so da gop: ");
        xuat(c, n3);*/
        int i=0;
        int j=0;
        while (i+j<n1+n2-1)
        {
            int xet=(a[i]<=b[j])?1:0;
            c[i+j]=(a[i]<=b[j])?a[i]:b[j];
            if (xet==1) i++; else j++;
            if (i==n1) { 
                for (int k=j;k<n2;k++) 
                    c[i+k]=b[k];j=n2;
            }
            else if (j==n2) {
                for (int k=i;k<n1;k++) 
                    c[j+k]=a[k];i=n1;
            }
        }
        System.out.println("Day so gop lai la");
        for (int k=0;k<n1+n2;k++)  
            System.out.print(" "+c[k]);
    }

}
