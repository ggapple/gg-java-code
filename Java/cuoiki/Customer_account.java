package cuoiki;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class Customer_account implements Serializable {
    private String account;
    private String password;

    Customer_account() {

    }

    Customer_account(String account, String passwword) {
        set_Account(account);
        set_Password(passwword);
    }

    public String get_Account() {
        return this.account;
    }

    public void set_Account(String acc) {
        this.account = acc;
    }

    public String get_Password() {
        return this.password;
    }

    public void set_Password(String pass) {
        this.password = pass;
    }

    public static Customer_account Input_Account(Customer_account newacc) {
        System.out.print("input Account: ");
        String acc = Customer_program.nhaplieu.nextLine();
        System.out.print("input Password: ");
        String pass = Customer_program.nhaplieu.nextLine();
        newacc.set_Account(acc);
        newacc.set_Password(pass);

        return newacc;
    }

    public static boolean save_to_file(LinkedList<Customer_account> acclist, String path) {
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
    public static LinkedList<Customer_account> read_from_file(String path) {

        LinkedList<Customer_account> acclist = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            acclist = (LinkedList<Customer_account>) o;
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acclist;
    }

    public static void main(String[] args) {
        Customer_program Program = new Customer_program();
        LinkedList<Customer_account> acclist = read_from_file("Acclist.dat");
        Customer_account admin = new Customer_account("admin123", "123456");
        Customer_account cus1 = new Customer_account("mvt111", "mvt12345");
        acclist.add(admin);
        acclist.add(cus1);

        int menu = 1;
        while (menu != 0) {
            System.out.println("1-Dang nhap");
            System.out.println("2-Dang ki");
            System.out.println("0-Exit");
            menu = Customer_program.nhaplieu.nextInt();
            Customer_program.nhaplieu.nextLine();
            switch (menu) {
                case 1: {
                    Customer_account newAcc = new Customer_account();
                    Input_Account(newAcc);

                    if (newAcc.get_Account().compareTo(admin.get_Account()) == 0) {
                        if (newAcc.get_Password().compareTo(admin.get_Password()) == 0)
                            Program.programadmin();
                        else
                            System.out.println("Nhap sai mat khau");

                    } else if (newAcc.get_Account().compareTo(admin.get_Account()) != 0) {
                        for (int i = 0; i < acclist.size(); i++) {
                            if (newAcc.get_Account().compareTo(acclist.get(i).get_Account()) == 0) {
                                if (newAcc.get_Password().compareTo(acclist.get(i).get_Password()) == 0)
                                    Program.programcus();
                                else
                                    System.out.println("Nhap sai mat khau");
                                break;
                            }
                        }
                    } else
                        System.out.println("khong tim thay tai khoan");
                    break;
                }
                case 2: {
                    Customer_account newAcc = new Customer_account();
                    Input_Account(newAcc);
                    acclist.add(newAcc);
                    save_to_file(acclist, "Acclist.dat");
                    break;
                }
                case 0:
            }
        }
        Customer_program.nhaplieu.close();
    }
}
