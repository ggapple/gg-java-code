package TH_sinhvien2;

public class chuongtrinhquanlysinhvien2 {
    public static void main(String[] args) {
        quanlysv2 quanly = new quanlysv2();
        for (int i = 0; i < 100; i++) {
            quanly.dssv[i] = new sinhvien1();
        }
        int menu = 1;
		while (menu != 0) {
            System.out.println("CHUONG TRINH QUAN LY SINH VIEN - MENU CHUC NANG");
            System.out.println("1 - Tao moi danh sach sinh vien ");
            System.out.println("2 - Xem danh sach sinh vien ");
            System.out.println("3 - Them sinh vien vao danh sach");
            System.out.println("4 - Xoa sinh vien ra khoi danh sach");
            System.out.println("5 - Cap nhat thong tin sinh vien");
            System.out.println("6 - Sap xep danh sach sinh vien");
            System.out.println("0 - Thoat ");
            System.out.print("Lua chon: ");
            menu = quanlysv2.nhap.nextInt();
            quanlysv2.nhap.nextLine();
            switch (menu) {
                case 1: {quanly.nhapdssv(quanly.dssv); break;}
                case 2: {quanly.xuatdssv();break;}
                case 3: {quanly.themsv(quanly.dssv);break;}
                case 4: {quanly.xoasv(quanly.dssv);break;}
                case 5: {quanly.capnhatsv(quanly.dssv);break;}
                case 6: {quanly.sapxepdssv(quanly.dssv);break;}
                case 0: break;
            }
        }   
    }
}

