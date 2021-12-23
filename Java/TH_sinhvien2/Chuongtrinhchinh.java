package TH_sinhvien2;

import java.util.LinkedList;
import java.util.List;

public class Chuongtrinhchinh {

	public static void main(String[] args) {
		LinkedList<sinhvien> dslk = new LinkedList<sinhvien>();
		
		qldssv quanlyds = new qldssv();

		
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
		menu = qldssv.nhaplieu.nextInt();
		qldssv.nhaplieu.nextLine();
				
		switch (menu) {
		case 1: {quanlyds.nhapdsv(dslk); break;}
		case 2: {quanlyds.xuatdsv(dslk); break;}
		case 3: {quanlyds.nhapdsv(dslk); break;}
		case 4: {quanlyds.xoasinhvien(dslk); break;}
		case 5: {quanlyds.update(dslk);break;}
		case 6: {quanlyds.sapxep(dslk);break;}
		case 0: break;
		}
		}
		
		qldssv.nhaplieu.close();
		}

	}

