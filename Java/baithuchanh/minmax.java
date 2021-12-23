package baithuchanh;
import java.util.Scanner;
//
public class minmax {
    public static void main(String[] args) {
        //tim min max
        int a, b, c, max, min;
        Scanner nhap = new Scanner(System.in);
        //
        System.out.println("nhap vao a: ");
        a = nhap.nextInt();
        System.out.println("nhap vao b: ");
        b = nhap.nextInt();
        System.out.println("nhap vao c: ");
        c = nhap.nextInt();
        max = ((a>b)? (a>c)? a:c: (b>c)? b:c);
        System.out.println("max = "+max);
        min = ((a<b)? (a<c)? a:c: (b<c)? b:c);
        System.out.println("min = "+min);
        nhap.close();
        //ve thap
        for(int i=1; i<=10; i++)
            {
                for(int j=1; j<=i; j++)
                    System.out.print("*");
                System.out.println();    
            }
    }
    
}
