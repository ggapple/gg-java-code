package TH_sinhvien2;

import java.util.Scanner;
import java.util.ArrayList;
public class qlsv_arrlist {
    static Scanner nhap = new Scanner(System.in);
    public void nhapdssv(ArrayList<sinhvien> dssv) {
        int chon = 1;
        int maso = 0;
        int namsinh = 0;
        String hoten = "";
        float diemtb = 0;
        System.out.println("Nhap thong tin sinh vien: ");
        while (chon == 1) {
            System.out.println("MSSV: ");
            maso = qlsv_arrlist.nhap.nextInt();
            qlsv_arrlist.nhap.nextLine();
            System.out.println("Ho va ten: ");
            hoten = qlsv_arrlist.nhap.nextLine();
            System.out.println("Nam sinh: ");
            namsinh = qlsv_arrlist.nhap.nextInt();
            System.out.println("Diem trung binh: ");
            diemtb = qlsv_arrlist.nhap.nextFloat();
            //
            sinhvien sv = new sinhvien(maso, hoten, namsinh, diemtb);
            dssv.add(sv);
            System.out.println("Nhap them chon 1 / Dung lai chon 0: ");
            int kt = qlsv_arrlist.nhap.nextInt();
            qlsv_arrlist.nhap.nextLine();
            if (kt == 0) {chon = 0;}
        }
    }
    public void xuatds(ArrayList<sinhvien> dssv) {
        System.out.println("Thong tin sinh vien");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %n","STT","MSSV","Ho va ten","Nam sinh","Diem TB","Hoc luc");
        for (int i = 0; i < dssv.size(); i++) {
            dssv.get(i).xuatthongtinsinhvien(i);
        }
    }
    public void xuatdssv(ArrayList<sinhvien> dssv) {
        System.out.println("Nhap lua chon: (1 - Xuat dssv. 2 - Xuat dssv diem yeu. 3 - Xuat dssv diem gioi");
        int chon = nhap.nextInt();
        System.out.println("Thong tin sinh vien");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %n","STT","MSSV","Ho va ten","Nam sinh","Diem TB","Hoc luc");
        if (chon == 1) {
            for (int i = 0; i < dssv.size(); i++) {
                dssv.get(i).xuatthongtinsinhvien(i);
            }
        }
        else if (chon == 2) {
            for (int i = 0; i < dssv.size(); i++) {
                if (dssv.get(i).hocluc().compareTo("Yeu") == 0) {
                    dssv.get(i).xuatthongtinsinhvien(i);
                }
            }
        }
        else if (chon == 3) {
            for (int i = 0; i < dssv.size(); i++) {
                if (dssv.get(i).hocluc().compareTo("Gioi") == 0 || dssv.get(i).hocluc().compareTo("Xuat Sac") == 0) {
                    dssv.get(i).xuatthongtinsinhvien(i);
                }
            }
        }
    }
    public void sapxepdssv(ArrayList<sinhvien> dssv) {
        sinhvien temp;
        System.out.println("Nhap lua chon sap xep: (1 - Xep theo MSSV. 2 - Xep theo diem trung binh. 3 - Xep theo ten) ");
        int chon = qlsv_arrlist.nhap.nextInt();
        if (chon == 1) {
            for (int i = 0; i < dssv.size()-1; i++) {
                for (int j = 1; j < dssv.size(); j++) {
                    if (dssv.get(i).getmasosv() > dssv.get(j).getmasosv()) {
                        temp = dssv.get(i);
                        dssv.set(i, dssv.get(j));
                        dssv.set(j, temp);
                    }
                }
            }
        }
        else if (chon == 2) {
            for (int i = 0; i < dssv.size()-1; i++) {
                for (int j = 1; j < dssv.size(); j++) {
                    if (dssv.get(i).getdiemtb() < dssv.get(j).getdiemtb()) {
                        temp = dssv.get(i);
                        dssv.set(i, dssv.get(j));
                        dssv.set(j, temp);
                    }
                }
            }
        }
        else if (chon ==3) {
            for (int i = 0; i < dssv.size()-1; i++) {
                for (int j = 1; j < dssv.size(); j++) {
                    if (dssv.get(i).gethovaten().compareTo(dssv.get(i).gethovaten()) > 0) {
                        temp = dssv.get(i);
                        dssv.set(i, dssv.get(j));
                        dssv.set(j, temp);
                    }
                }
            }
        }
        xuatds(dssv);
    }
    public int timkiemsv(int mstk, ArrayList<sinhvien> dssv) {
        int vt = -1;
        for (int i = 0; i < dssv.size(); i++) {
            if (dssv.get(i).getmasosv() == mstk) {vt = i;}
        }
        return vt;
    }
    public int timkiemsv(String tentk, ArrayList<sinhvien> dssv) {
        int vt = -1;
        for (int i = 0; i < dssv.size(); i++) {
            if (dssv.get(i).gethovaten().compareTo(tentk) == 0) {vt = i;}
        }
        return vt;
    }
    public void xoasv(ArrayList<sinhvien> dssv) {
        System.out.println("Nhap lua chon: (1 - Xoa theo mssv. 2 - Xoa theo ten)");
        int chon = nhap.nextInt();
        nhap.nextLine();
        if (chon == 1) {
            System.out.println("Nhap mssv can xoa: ");
            int msxoa = nhap.nextInt();
            nhap.nextLine();
            dssv.remove(timkiemsv(msxoa, dssv));
        }
        else if (chon == 2) {
            System.out.println("Nhap ten can xoa: ");
            String tenxoa = nhap.nextLine();
            dssv.remove(timkiemsv(tenxoa, dssv));
        }
        xuatds(dssv);
    }
    public void capnhatdssv(ArrayList<sinhvien> dssv) {
        System.out.println("Nhap MSSV can cap nhat: ");
        int mscn = nhap.nextInt();
        nhap.nextLine();
        System.out.println("Nhap lua chon: (1 - Ho ten. 2 - Nam sinh. 3 - Diem TB)");
        int chon = nhap.nextInt();
        if (chon == 1) {
            System.out.println("Nhap ho ten moi: ");
            String tenmoi = nhap.nextLine();
            dssv.get(timkiemsv(mscn, dssv)).sethovaten(tenmoi);
        }
        else if (chon == 2) {
            System.out.println("Nhap nam sinh moi: ");
            int namsinhmoi = nhap.nextInt();
            dssv.get(timkiemsv(mscn, dssv)).setnamsinh(namsinhmoi);
        }
        else if (chon ==3) {
            System.out.println("Nhap diem moi: ");
            float diemmoi = nhap.nextFloat();
            dssv.get(timkiemsv(mscn, dssv)).setdiemtb(diemmoi);
        }
        xuatds(dssv);
    }

}
