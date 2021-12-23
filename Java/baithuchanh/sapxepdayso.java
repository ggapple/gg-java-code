package baithuchanh;
import java.util.Scanner;
import java.util.Random;;
//
public class sapxepdayso {
    public static void xuat(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+"  ");
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[20];
        int n, min, max;
        double avg;
        Scanner nhap = new Scanner(System.in);
        Random random = new Random();
        //khoi tao mang
        System.out.println("nhap n: ");
        n = nhap.nextInt();
        System.out.print("Day so da tao: ");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100)+1;
        }
        nhap.close();
        xuat(arr, n);
        System.out.println();
        // tim min max average
        max = arr[0];
        min = arr[0];
        avg = 0;
        int sum = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i]>max) 
                max = arr[i];
            if(arr[i]<min)
                min = arr[i];
            sum += arr[i];
        }
        System.out.println("Max cua day so: "+max);
        System.out.println("Min cua day so: "+min);
        avg = (double)sum/n;
        System.out.println("Average cua day so: "+avg);
        //sap xep day so
        int temp;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("Day so tang dan: ");
        xuat(arr, n);
        System.out.println();
        System.out.print("Day so giam dan: ");
        for (int i = n-1; i >= 0; i--) {
            System.out.print(arr[i]+"  ");
        }
    }
    
}
