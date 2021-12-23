package baithuchanh;
import java.util.Scanner;
public class dayso {
    static int[] arr = new int[100];
    static int n;
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
    public static void xuat(int[] arr, int n) {
        for (int i = 0; i < n; i++) 
            System.out.print("  "+arr[i]);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap n: ");
        n = nhap.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("nhap phan tu thu "+(i+1)+": ");
            arr[i] = nhap.nextInt();
        }
        sapxep(arr, n);
        xuat(arr, n);
        //tim kiem phan tu va xoa
        System.out.println("nhap gia tri can tim: ");
        int tk = nhap.nextInt();
        int timthay = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i]==tk) 
                timthay = i;
            
        }
        if (timthay == -1)
                System.out.println("khong tim thay ");
        if (timthay > -1) {
            System.out.println("tim thay "+tk+" trong day so");
            System.out.println("xoa gia tri "+tk+" trong day so");
            for (int i = timthay; i < n-1; i++)
                arr[i] = arr[i+1];
            n--;
            }
            xuat(arr, n);
        //
        /*int j=0;
        for (int i = 0; i < n; i++) {
                if(arr[i]!=tk){
                    arr[j]=arr[i];
                    j++;
                }
            }
        n=j;*/
        //them phan tu
        System.out.println("nhap gia tri can them");
        int them = nhap.nextInt();
        n++;
        arr[n-1] = them;
        sapxep(arr, n);
        System.out.println("day so moi: ");
        xuat(arr, n);
        nhap.close();
    }
}
