package TH_sinhvien2;

import java.util.ArrayList;
import java.util.Scanner;

public class qlsv {

static Scanner nhaplieu = new Scanner(System.in);
// Hàm nhập sinh viên vào danh sách-------------------------------------------------------------------------------------------------------
public void nhapds(ArrayList<sinhvien> ds) {
	boolean nhapsv=true;
	while (nhapsv) {
		System.out.println("Nhap thong tin sinh vien: ");
		int maso = 0, namsinh=0;
		String hoten="";
		float diemthi=0;
		boolean nhapkhongdungmaso=true;
				while (nhapkhongdungmaso) {
				try {
				nhapkhongdungmaso=false;
				System.out.println("MSSV: ");
				Scanner nhapmaso = new Scanner(System.in);
				maso = nhapmaso.nextInt();
				nhapmaso.nextLine();
				} catch (Exception e) {System.out.println("Nhap khong dung, nhap lai MSSV: "); nhapkhongdungmaso = true;}
		
			}
			System.out.println("Nhap ho va ten: ");
			hoten = nhaplieu.nextLine();
			System.out.println("Nam sinh: ");
			namsinh=nhaplieu.nextInt();
			nhaplieu.nextLine();
			System.out.println("Diem trung binh hoc tap: ");
			diemthi=nhaplieu.nextFloat();
			nhaplieu.nextLine();
			sinhvien newsv = new sinhvien(maso,hoten,namsinh,diemthi);
			ds.add(newsv);
		
			System.out.println("Ban co muon nhap them ? Co nhap 1/ Khong nhap 0:");
			int kt = nhaplieu.nextInt();
			nhaplieu.nextLine();
			if (kt==0) nhapsv=false;
	}
}
//----------------------------------------------------------------------------------------------------------------------------------
public void xuatds(ArrayList<sinhvien> ds) {
	System.out.println("XUAT THONG TIN DANH SACH SINH VIEN");
	System.out.printf("%-20s%-20s %-20s %-20s %-20s %n","STT","MSSV","Ho va ten","Nam sinh","Hoc luc");
	for (int i=0;i<ds.size();i++)	ds.get(i).xuatthongtinsinhvien(i);
}
// Hàm tìm sinh viên theo họ và tên, kết quả trả về 1 dãy các vị trí tìm thấy trong danh sách---------------------------------------
public int[] timsinhvien(String ten, ArrayList<sinhvien> ds) {
	int ketqua[] = new int[100];
	int j=1;
	int dem=0;
	for (int i=0;i<ds.size();i++) {
		if (ds.get(i).gethovaten().compareTo(ten)==0) 
		{ dem++;
		ketqua[j]=i;
		j++;
		}
		}
	ketqua[0]=dem;
	return ketqua;
	}
// Hàm tìm vị trí sinh viên có mã số sinh viên trong danh sách------------------------------------------------------------------------
public int timsinhvien(int mssv, ArrayList<sinhvien> ds) {
		int ketqua=-1;
		for (int i=0;i<ds.size();i++) {
		if (ds.get(i).getmasosv()==mssv) 
		{ 
		ketqua=i;
		i=ds.size()+1;
		}
		}
	return ketqua;
	}
// Hàm xoá sinh viên
public void xoasv(String ten, ArrayList<sinhvien> ds) {
	int[] timkiem = timsinhvien(ten,ds);
	if (timkiem[0]>0) for (int i=timkiem[0];i>=1;i--) ds.remove(timkiem[i]);
	}

public void xoasv(int mssv, ArrayList<sinhvien> ds) {
	ds.remove(timsinhvien(mssv,ds));
}
//-------------------------------------------------------------------------------------------------------------------------------------
public void xoasinhvien(ArrayList<sinhvien> ds) {
	System.out.println("1-Xoa thong tin theo MSSV");
	System.out.println("2-Xoa thong tin theo Ho va ten");
	System.out.println("Nhap lua chon cua ban: ");
	int nhap=qlsv.nhaplieu.nextInt();
	qlsv.nhaplieu.nextLine();
	if (nhap==1) {
		System.out.println("Nhap vao MSSV can xoa: ");
		int masosv=qlsv.nhaplieu.nextInt();
		qlsv.nhaplieu.nextLine();
		xoasv(masosv,ds);
	}
	else if (nhap==2) {
		System.out.println("Nhap vao ho ten sinh vien can xoa: ");
		String ten=qlsv.nhaplieu.nextLine();
		System.out.println("Da xoa "+timsinhvien(ten,ds)[0]+" sinh vien ten: "+ten+" trong danh sach");
		xoasv(ten,ds);
		}
		
		}
// Hàm cặp nhật thông tin
public void updateinfo(ArrayList<sinhvien> ds) {
	System.out.println("Nhap vao MSSV can cap nhat: ");
	int masosv=qlsv.nhaplieu.nextInt();
	qlsv.nhaplieu.nextLine();
	System.out.println("Nhap lua chon cap nhat (1 - Ho va ten 2 - Nam sinh 3- Diem trung binh): ");
	int chon = qlsv.nhaplieu.nextInt();
	if (chon==1) { 
		System.out.println("Nhap ho va ten can cap nhat: "); 
		String ten = qlsv.nhaplieu.nextLine();
		ds.get(timsinhvien(masosv,ds)).sethovaten(ten);
	}
	else if (chon==2) {
		System.out.println("Nhap nam sinh dung: "); 
		int namsinh = qlsv.nhaplieu.nextInt();
		ds.get(timsinhvien(masosv,ds)).setnamsinh(namsinh);
	}
	else if (chon==3) {
		System.out.println("Nhap diem trung binh can sua: "); 
		float dtb = qlsv.nhaplieu.nextFloat();
		ds.get(timsinhvien(masosv,ds)).setdiemtb(dtb);
	}
}

//Hàm sắp xếp danh sách theo ma so sinh vien
public void sapxep(ArrayList<sinhvien> ds) {
for (int i=0;i<ds.size()-1;i++)
	for (int j=i+1;j<ds.size();j++)
		if (ds.get(i).getmasosv()>ds.get(j).getmasosv()) {
			sinhvien temp = ds.get(i);
			ds.set(i, ds.get(j));
			ds.set(j, temp);
			}
			
	}
}

