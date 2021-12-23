package TH_sinhvien2;

import java.util.Scanner;
public class quanlysv2 {
    sinhvien1[] dssv;
    int slsv;
    static Scanner nhap = new Scanner(System.in);
    public quanlysv2(){
        this.dssv = new sinhvien1[100];
    }
    public void nhapsv(sinhvien1 sv) {
        System.out.println("nhap thong tin sinh vien: ");
        System.out.println("MSSV: ");
        sv.setmasosv(nhap.nextInt());// masosv=nhap.nextInt; sv.setmasosv(masosv);
        nhap.nextLine();
        System.out.println("Ho va ten: ");
        sv.sethovaten(nhap.nextLine());
        System.out.println("Nam sinh: ");
        sv.setnamsinh(nhap.nextInt());
        System.out.println("Diem trung binh: ");
        sv.setdiemtb(nhap.nextFloat());
    }
    public void nhapdssv(sinhvien1[] dssv) {
        System.out.println("nhap so sinh vien");
        slsv = nhap.nextInt();
        for (int i = 0; i < slsv; i++) {
            nhapsv(dssv[i]);
        }
    }
    public void xuatsv(sinhvien1 sv) {
        System.out.printf("%-20d %-20s %-20d %-20f %-20s %n", sv.getmasosv(), sv.gethovaten(), sv.getnamsinh(), sv.getdiemtb(), sv.hocluc() );
    }
    public void xuatdssv() {
        System.out.println("Thong tin sinh vien");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %n","STT","MSSV","Ho va ten","Nam sinh","Diem tb","Hoc luc");
        for (int i = 0; i < slsv; i++) {
            System.out.printf("%-20s", i+1);
            xuatsv(dssv[i]);
        }
    }
    public void themsv(sinhvien1[] dssv) {
        sinhvien1 svmoi = new sinhvien1();
        nhapsv(svmoi);
        dssv[slsv] = svmoi;
        slsv++;
        xuatdssv();
    }
    public int timkiemsv(int masotk) {
        int vt = -1;
        for (int i = 0; i < slsv; i++) {
            if (this.dssv[i].getmasosv() == masotk) {vt=i;}
        }
        return vt;
    }
    public int timkiemsv(String tentk) {
        int vt = -1;
        for (int i = 0; i < slsv; i++) {
            if (this.dssv[i].gethovaten() == tentk) {vt=i;}
        }
        return vt;
    }
    public void xoasv(sinhvien1[] dssv) {
        int vtxoa = -1;
        System.out.println("1 - xoa theo MSSV");
        System.out.println("2 - xoa theo ten");
        System.out.println("nhap lua chon: ");
        int choice = nhap.nextInt();
        nhap.nextLine();
        if (choice == 1) {
            System.out.println("nhap MSSV can xoa: ");
            int masotk = nhap.nextInt();
            nhap.nextLine();
            vtxoa = this.timkiemsv(masotk);
        }
        else {
            System.out.println("nhap ten can xoa");
            String tentk = nhap.nextLine();
            vtxoa = this.timkiemsv(tentk);
        }
        if (vtxoa == -1) {System.out.println("khong tim thay trong danh sach");}
        else {
            for (int i = vtxoa; i < slsv; i++) {dssv[i]=dssv[i+1];}
            slsv--; 
        }
        xuatdssv();
    }
    public void sapxepdssv(sinhvien1[] dssv) {
        sinhvien1 temp = new sinhvien1();
        for (int i = 0; i < slsv-1; i++) {
            for (int j = i+1; j < slsv; j++) {
                if (dssv[i].gethovaten().compareTo(dssv[j].gethovaten()) > 0) {
                    temp = dssv[i];
                    dssv[i] = dssv[j];
                    dssv[j] = temp;
                }
            }
        }
        xuatdssv();
    }
    public void capnhatsv(sinhvien1[] dssv) {
        System.out.println("nhap ma so sinh vien can cap nhat: ");
        int masocn = nhap.nextInt();
        int vtcn = this.timkiemsv(masocn);
        System.out.println("Nhap lua chon cap nhat (1 - Ho va ten 2 - Nam sinh 3 - Diem trung binh): ");
        int chon = nhap.nextInt();
        if (chon == 1) { 
            nhap.nextLine();
            System.out.println("Nhap ho ten moi: "); 
            String ten = nhap.nextLine();
            dssv[vtcn].sethovaten(ten);
        }
        else if (chon == 2) {
            System.out.println("Nhap nam sinh moi: "); 
            int namsinh = nhap.nextInt();
            dssv[vtcn].setnamsinh(namsinh);
        }
        else if (chon == 3) {
            System.out.println("Nhap diem trung binh moi: "); 
            int dtb = nhap.nextInt();
            dssv[vtcn].setdiemtb(dtb);
        }
        xuatdssv();
    }
}
