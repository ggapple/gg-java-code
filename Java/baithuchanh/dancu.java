package baithuchanh;
import java.util.Scanner;
/**
 * dancu
 */
public class dancu {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int min, max, avg;
        int n;
        float young=0, adult=0, old=0;
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap so dan: ");
        n = nhap.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhap tuoi nguoi thu "+(i+1)+" ");
            arr[i] = nhap.nextInt();
        }
        min = max = arr[0];
        avg = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            avg += arr[i];
        }
        nhap.close();
        System.out.println("tuoi nho nhat: "+min);
        System.out.println("tuoi lon nhat: "+max);
        System.out.println("tuoi trung binh: "+(avg/n));
        for (int i = 0; i < n; i++) {
            if (arr[i]<18){
                young++;
            }
            else if (arr[i]<60){
                adult++;
            }
            else old++;
        }
        System.out.println("% do tuoi lop tre: "+(young*100)/n+"%");
        System.out.println("% do tuoi truong thanh: "+(adult*100)/n+"%");
        System.out.println("% do tuoi lop nguoi gia: "+(old*100)/n+"%");
        float A=young;
        A = ((young>adult)? (young>old)? young:old: (adult>old)? adult:old);
        if (A==young)   
            System.out.println("lop tre chiem lon nhat: ");
        if (A==adult)
            System.out.println("lop truong thanh chiem lon nhat: ");
        if (A==old)
            System.out.println("lop nguoi gia chiem lon nhat: ");
    }
    
}
