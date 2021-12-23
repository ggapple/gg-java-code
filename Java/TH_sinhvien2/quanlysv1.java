package TH_sinhvien2;

import java.util.Scanner;
public class quanlysv1 {
    sinhvien1[] dssv;
    int soluongsv;
public quanlysv1() {
	this.dssv=new sinhvien1[100];
}
static Scanner nhaplieu = new Scanner(System.in);

public void nhapsinhvien(sinhvien1[] dssv) {
	
	System.out.println("Nhap thong tin sinh vien: ");
	System.out.println("MSSV: ");
	int maso = nhaplieu.nextInt();
	nhaplieu.nextLine();
	dssv[soluongsv].setmasosv(maso);
	System.out.println("Ho va ten: ");
	String ten = nhaplieu.nextLine();
	dssv[soluongsv].sethovaten(ten);
	System.out.println("Nam sinh: ");
	dssv[soluongsv].setnamsinh(nhaplieu.nextInt());
	System.out.println("Diem trung binh hoc tap: ");
	dssv[soluongsv].setdiemtb(nhaplieu.nextFloat());
	
	
}
public void nhapdanhsachsinhvien(sinhvien1[] dssv) {
	boolean nhapsv=true;
	//int soluongsv=0;
	
	while (nhapsv) {
		this.nhapsinhvien(dssv);
		System.out.println("Ban co muon nhap them ? Co nhap 1/ Khong nhap 0:");
		int kt = quanlysv1.nhaplieu.nextInt();
		if (kt==0) nhapsv=false;
	}
	
}
public void xuatdanhsachsinhvien() {
	System.out.println("XUAT THONG TIN DANH SACH SINH VIEN");
	System.out.printf("%-20s%-20s %-20s %-20s %-20s %n","STT","MSSV","Ho va ten","Nam sinh","Hoc luc");
	for (int i=0;i<this.soluongsv;i++)	this.dssv[i].xuatthongtinsinhvien(i+1);
	}


public void xoasinhvien(sinhvien1[] dssv) {
	int vitrixoa=-1;
	System.out.println("1-Xoa thong tin theo MSSV");
	System.out.println("2-Xoa thong tin theo Ho va ten");
	System.out.println("Nhap lua chon cua ban: ");
	int nhap=quanlysv1.nhaplieu.nextInt();
	quanlysv1.nhaplieu.nextLine();
	if (nhap==1) {
		System.out.println("Nhap vao MSSV can xoa: ");
		int masosv=quanlysv1.nhaplieu.nextInt();
		quanlysv1.nhaplieu.nextLine();
		vitrixoa=this.timsinhvien(masosv);
	}
	else {
		System.out.println("Nhap vao ho ten sinh vien can xoa: ");
		String ten=quanlysv1.nhaplieu.nextLine();
		vitrixoa=this.timsinhvien(ten);
	}
	if (vitrixoa==-1) {System.out.println("Khong tim thay trong danh sach hoac nhap sai thong tin");}
	else { for (int i=vitrixoa;i<soluongsv;i++) {dssv[i]=dssv[i+1]; } soluongsv--;}
}


public int timsinhvien(int masotk) {
	int i=0;int vitri=-1;
	for (i=0;i<soluongsv;i++) {
		if (this.dssv[i].getmasosv()==masotk) {vitri=i;i=this.soluongsv+100;}
			}
	return vitri;
	}
public int timsinhvien(String ten) {
	int i=0;int vitri=-1;
	for (i=0;i<soluongsv;i++) {
		if (this.dssv[i].gethovaten()==ten) {vitri=i;i=this.soluongsv+100;}
			}
	return vitri;
	}
public void xapxepdanhsachsinhvien(sinhvien1[] dssv) {
	for (int i=0;i<soluongsv-1;i++)
		for (int j=i+1;j<soluongsv;j++) {
			if (dssv[i].gethovaten().compareTo(dssv[j].gethovaten())>0)
			{sinhvien1 tam = new sinhvien1();
			tam=dssv[i];
			dssv[i]=dssv[j];
			dssv[j]=tam;
			}
		}
	
	}

public void capnhatthongtinsinhvien(sinhvien1[] dssv) {
	System.out.println("Nhap ma so sinh vien can cap nhat: ");
	int masosv = quanlysv1.nhaplieu.nextInt();
	int vitricapnhat=this.timsinhvien(masosv);
	System.out.println("Nhap lua chon cap nhat (1 - Ho va ten 2 - Nam sinh 3- Diem trung binh): ");
	int chon = quanlysv1.nhaplieu.nextInt();
	if (chon==1) { 
		System.out.println("Nhap ho va ten dung: "); 
		String ten = quanlysv1.nhaplieu.nextLine();
		dssv[vitricapnhat].sethovaten(ten);
	}
	else if (chon==2) {
		System.out.println("Nhap nam sinh dung: "); 
		int namsinh = quanlysv1.nhaplieu.nextInt();
		dssv[vitricapnhat].setnamsinh(namsinh);
	}
	else if (chon==3) {
		System.out.println("Nhap diem trung binh can sua: "); 
		int dtb = quanlysv1.nhaplieu.nextInt();
		dssv[vitricapnhat].setdiemtb(dtb);
	}
}

}
