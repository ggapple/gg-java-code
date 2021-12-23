package baithuchanh;
import java.util.Scanner;

public class lietkept {

    public static void main(String[] args) {
        int[] dayso = new int[100];
        int n;
        Scanner nhaplieu = new Scanner(System.in);
        System.out.print("Nhap so phan tu day so : ");
        n=nhaplieu.nextInt();
        for (int i=0;i<n;i++) {
            System.out.print("Nhap so phan tu thu "+(i+1)+" day so : ");
            dayso[i]=nhaplieu.nextInt();
        }
        nhaplieu.close();
        int[] lietke = new int[100];
        for (int i=0;i<n;i++) lietke[i]=1;
        for (int i=0;i<n-1;i++) {
            if (lietke[i]==1) {
                for (int j=i+1;j<n;j++) {
                if (dayso[j]==dayso[i]) {lietke[i]++;lietke[j]=0;}
                }
            }
        }
        System.out.println("XUAT THONG TIN LIET KE PHAN TU");
        for (int i=0;i<n;i++) {
            if (lietke[i]!=0) System.out.println("Gia tri "+dayso[i]+" co "+ lietke[i]+" phan tu");
        }
    }
}