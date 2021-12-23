package TH_sinhvien2;

public class Chuongtrinhquanlysinhvien1 {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        quanlysv1 quanly = new quanlysv1();
		for (int i=0;i<100;i++) quanly.dssv[i]=new sinhvien1();
		int menu=1;
		while (menu!=0) {
		System.out.println("CHUONG TRINH QUAN LY SINH VIEN - MENU CHUC NANG");
		System.out.println("1-Create new Student List");
		System.out.println("2-View Student List ");
		System.out.println("3-Add a student to Student List");
		System.out.println("4-Delete a student from Student List");
		System.out.println("5-Modify student infor from Student List");
		System.out.println("6-Sort Student List");
		System.out.println("0-Exit");
		System.out.println("Please choose: ");
		menu = quanlysv1.nhaplieu.nextInt();
        quanlysv1.nhaplieu.nextLine();
		
		switch (menu) {
		case 1: {quanly.nhapdanhsachsinhvien(quanly.dssv); break;}
		case 2: {quanly.xuatdanhsachsinhvien();break;}
		case 3: {quanly.nhapsinhvien(quanly.dssv);break;}
		case 4: {quanly.xoasinhvien(quanly.dssv);break;}
		case 5: {quanly.capnhatthongtinsinhvien(quanly.dssv);break;}
		case 6: {quanly.xapxepdanhsachsinhvien(quanly.dssv);break;}
		case 0: break;
		}
		}
        quanlysv1.nhaplieu.close();
		
	}

}
