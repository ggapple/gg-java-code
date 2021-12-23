package baithuchanh;
import java.util.Scanner;
//
public class fibonace {
    public static int fibo(int n) {
        if (n==1)
            return 1;
        else if (n==2)
            return 2;
        else return fibo(n-1)+fibo(n-2);
    }
    public static void main(String[] args) {
        int n;
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap vao n: ");
        n = nhap.nextInt();
        System.out.println("Day fibonance: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo(i)+"  ");
        }
        nhap.close();
    }
    
}