package TH_sinhvien2;

import java.util.LinkedList;
import java.util.Scanner;

public class qldssv {
	static Scanner nhaplieu = new Scanner(System.in);
	// Hàm nhập sinh viên vào danh sách-------------------------------------------------------------------------------------------------------
	public void nhapdsv(LinkedList<sinhvien> dslk) {
		
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
				dslk.addLast(newsv);
						
				System.out.println("Ban co muon nhap them ? Co nhap 1/ Khong nhap 0:");
				int kt = nhaplieu.nextInt();
				nhaplieu.nextLine();
				if (kt==0) nhapsv=false;
		}
	}
	//----------------------------------------------------------------------------------------------------------------------------------
	public void xuatdsv(LinkedList<sinhvien> dslk) {
		System.out.println("XUAT THONG TIN DANH SACH SINH VIEN");
		System.out.printf("%-20s%-20s %-20s %-20s %-20s %n","STT","MSSV","Ho va ten","Nam sinh","Hoc luc");
		for (int i=0;i<dslk.size();i++)	dslk.get(i).xuatthongtinsinhvien(i);
	}
	// Hàm tìm sinh viên theo họ và tên, kết quả trả về 1 dãy các vị trí tìm thấy trong danh sách---------------------------------------
	public int[] timsv(String ten, LinkedList<sinhvien> dslk) {
		int ketqua[] = new int[100];
		int j=1;
		int dem=0;
		for (int i=0;i<dslk.size();i++) {
			if (dslk.get(i).gethovaten().compareTo(ten)==0) 
			{ dem++;
				ketqua[j]=i;
				j++;
			}
			}
		ketqua[0]=dem;
		return ketqua;
		}
	// Hàm tìm vị trí sinh viên có mã số sinh viên trong danh sách------------------------------------------------------------------------
	public int timsv(int mssv, LinkedList<sinhvien> dslk) {
			int ketqua=-1;
			for (int i=0;i<dslk.size();i++) {
			if (dslk.get(i).getmasosv()==mssv) 
			{ 
				ketqua=i;
				i=dslk.size()+1;
			}
			}
		return ketqua;
		}
	// Hàm xoá sinh viên
	public void xoasv(String ten, LinkedList<sinhvien> dslk) {
		int[] timkiem = timsv(ten,dslk);
		if (timkiem[0]>0) for (int i=timkiem[0];i>=1;i--) dslk.remove(timkiem[i]);
		}

	public void xoasv(int mssv, LinkedList<sinhvien> dslk) {
		dslk.remove(timsv(mssv,dslk));
	}
	//-------------------------------------------------------------------------------------------------------------------------------------
	public void xoasinhvien(LinkedList<sinhvien> dslk) {
		System.out.println("1-Xoa thong tin theo MSSV");
		System.out.println("2-Xoa thong tin theo Ho va ten");
		System.out.println("Nhap lua chon cua ban: ");
		int nhap=qlsv.nhaplieu.nextInt();
		qlsv.nhaplieu.nextLine();
		if (nhap==1) {
			System.out.println("Nhap vao MSSV can xoa: ");
			int masosv=qlsv.nhaplieu.nextInt();
			qlsv.nhaplieu.nextLine();
			xoasv(masosv,dslk);
		}
		else if (nhap==2) {
			System.out.println("Nhap vao ho ten sinh vien can xoa: ");
			String ten=qlsv.nhaplieu.nextLine();
			System.out.println("Da xoa "+timsv(ten,dslk)[0]+" sinh vien ten: "+ten+" trong danh sach");
			xoasv(ten,dslk);
			}
			
			}
	// Hàm cặp nhật thông tin
	public void update(LinkedList<sinhvien> dslk) {
		System.out.println("Nhap vao MSSV can cap nhat: ");
		int masosv=qlsv.nhaplieu.nextInt();
		qlsv.nhaplieu.nextLine();
		System.out.println("Nhap lua chon cap nhat (1 - Ho va ten 2 - Nam sinh 3- Diem trung binh): ");
		int chon = qlsv.nhaplieu.nextInt();
		if (chon==1) { 
			System.out.println("Nhap ho va ten can cap nhat: "); 
			String ten = qlsv.nhaplieu.nextLine();
			dslk.get(timsv(masosv,dslk)).sethovaten(ten);
		}
		else if (chon==2) {
			System.out.println("Nhap nam sinh dung: "); 
			int namsinh = qlsv.nhaplieu.nextInt();
			dslk.get(timsv(masosv,dslk)).setnamsinh(namsinh);
		}
		else if (chon==3) {
			System.out.println("Nhap diem trung binh can sua: "); 
			float dtb = qlsv.nhaplieu.nextFloat();
			dslk.get(timsv(masosv,dslk)).setdiemtb(dtb);
		}
	}

	//Hàm sắp xếp danh sách theo ma so sinh vien
	public void sapxep(LinkedList<sinhvien> dslk) {
	for (int i=0;i<dslk.size()-1;i++)
		for (int j=i+1;j<dslk.size();j++)
			if (dslk.get(i).getmasosv()>dslk.get(j).getmasosv()) {
				sinhvien temp = dslk.get(i);
				dslk.set(i, dslk.get(j));
				dslk.set(j, temp);
				}
				
	}
}
