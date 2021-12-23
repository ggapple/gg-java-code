package cuoiki;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Customer_account2 {
    public static HashMap<String, String> acclist = read_file("Accountlist.txt");
    public static Scanner nhap = new Scanner(System.in);

    public static boolean save_file(HashMap<String, String> acclist, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(acclist);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, String> read_file(String path) {

        HashMap<String, String> acclist = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            acclist = (HashMap<String, String>) o;
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acclist;
    }

    public static boolean logIn(String acc, String pass) {
        try {

            if (acclist.containsKey(acc)) {
                if (acclist.get(acc).compareToIgnoreCase(pass) == 0) {
                    System.out.println("Done");
                    return true;
                } else {
                    System.out.println("Wrong password");
                    return false;
                }
            } else {
                System.out.println("Account doesn't exist !!!");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    static boolean signIn(String acc, String pass) {
        try {
            if (acclist.containsKey(acc)) {
                System.out.println("Account already exist");
                return false;
            } else {
                acclist.put(acc, pass);
                save_file(acclist, "Accountlist.txt");
                return true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return true;
    }

    public static void main(String[] args) {
        Customer_program Program = new Customer_program();
        acclist.put("admin", "admin");
        acclist.put("abc", "123");
        save_file(acclist, "Accountlist.txt");
        System.out.println(acclist);
        int menu = 1;

        while (menu != 0) {
            System.out.println("1-Dang nhap");
            System.out.println("2-Dang ky");
            menu = nhap.nextInt();
            nhap.nextLine();
            if (menu == 1) {
                System.out.print("Nhap tai khoan: ");
                String acc = nhap.nextLine();
                System.out.print("Nhap mat khau: ");
                String pass = nhap.nextLine();
                if (logIn(acc, pass)) {
                    if (acc.compareToIgnoreCase("admin") == 0)
                        Program.programadmin();
                    else {
                        Program.programcus();
                    }
                }
            }
            if (menu == 2) {
                System.out.print("Khoi tao tai khoan: ");
                String acc = nhap.nextLine();
                System.out.print("Khoi tao mat khau: ");
                String pass = nhap.nextLine();
                if (signIn(acc, pass) == true) {
                    System.out.println("Your account has been update to the system");
                }
            } else
                break;
        }
        nhap.close();
    }
}
