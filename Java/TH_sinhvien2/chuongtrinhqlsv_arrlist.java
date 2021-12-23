package TH_sinhvien2;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//
public class chuongtrinhqlsv_arrlist {
    public static void writeFile(ArrayList<sinhvien> ds, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ds);
            oos.close();
            fos.close();
            //return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return false;
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<sinhvien> readFile(String path) {
        ArrayList<sinhvien> ds = new ArrayList<sinhvien>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ds = (ArrayList<sinhvien>) ois.readObject();
            //Object ds = ois.readObject();
            //dssv = (ArrayList<sinhvien>) ds;
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public static void main(String[] args) {
        ArrayList<sinhvien> dssv = readFile("E:\\Code life\\Java\\TH_sinhvien2\\danhsach3.txt");
        qlsv_arrlist quanly = new qlsv_arrlist();
        int menu = 1;
		
		while (menu != 0) {
            System.out.println("CHUONG TRINH QUAN LY SINH VIEN - MENU CHUC NANG");
            System.out.println("1 - Tao moi danh sach");
            System.out.println("2 - Xuat danh sach");
            System.out.println("3 - Them sinh vien");
            System.out.println("4 - Xoa sinh vien");
            System.out.println("5 - Cap nhat danh sach");
            System.out.println("6 - Sap xep danh sach ");
            System.out.println("0 - Thoat");
            System.out.println("Chon: ");
            menu = qlsv_arrlist.nhap.nextInt();
            qlsv_arrlist.nhap.nextLine();
				
            switch (menu) {
                case 1: {
                    dssv = new ArrayList<sinhvien>();
                    quanly.nhapdssv(dssv);break;
                }
                case 2: {quanly.xuatdssv(dssv); break;}
                case 3: {quanly.nhapdssv(dssv); break;}
                case 4: {quanly.xoasv(dssv); break;}
                case 5: {quanly.capnhatdssv(dssv);break;}
                case 6: {quanly.sapxepdssv(dssv);break;}
                case 0: break;
            }
		}
        writeFile(dssv, "E:\\Code life\\Java\\TH_sinhvien2\\danhsach3.txt");
		qlsv_arrlist.nhap.close();
    }
}
