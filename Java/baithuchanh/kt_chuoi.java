/**
 * kt_chuoi
 */
package baithuchanh;
import java.util.Scanner;
public class kt_chuoi {
    public static void main(String[] args) {
        String st1, st2;
        int ch, kt;
        int cout = 0;
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap vao chuoi");
        st1 = nhap.nextLine();
        System.out.println("chuoi da nhap "+st1);
        //dem so chu cai trong chuoi
        for (int i = 0; i < st1.length(); i++) {
            ch = st1.codePointAt(i);// lay ma ASCII
            if (ch>=65 && ch<=90 || ch>=97 && ch<=122) {
                cout++;
            }
        }
        System.out.println("So chu cai co trong chuoi: "+cout);
        //tim chuoi con
        System.out.println("nhap vao chuoi can tim: ");
        st2 = nhap.nextLine();
        System.out.println("chuoi da nhap: "+st2);
        kt = st1.indexOf(st2);//ham tim chuoi st2 trong st1
        if (kt!=-1)
            System.out.println("co chuoi can tim");
        else System.out.println("khong tim thay chuoi");
        nhap.close();
    }
}