package TH_sinhvien2;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Chuongtrinhquanlysinhvien {
	/*public static void writeToFileTxt(ArrayList<sinhvien> ds, String fileName) {
		File file = new File(fileName);
		try {
			FileOutputStream fos = new FileOutputStream(file); 
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(ds);
		} catch (IOException exc) {
			System.out.println("Can't write to file");
		}
	}

	public static ArrayList<sinhvien> readFromFileTxt(String fileName) {
		File file = new File(fileName);
		ArrayList<sinhvien> ds = new ArrayList<sinhvien>();
		try {
			FileInputStream fis = new FileInputStream(file); 
			ObjectInputStream is = new ObjectInputStream(fis);
			Object object = is.readObject();
			ds = (ArrayList<sinhvien>) object;
		} catch (IOException exc) {
			System.out.println("Done");
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		}
		return ds;
	}*/
	public static boolean write(ArrayList<sinhvien> s, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<sinhvien> read(String path) {
        ArrayList<sinhvien> ds = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            ds = (ArrayList<sinhvien>) o;
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }


	public static void main(String[] args) {
				
		ArrayList<sinhvien> ds = new ArrayList<sinhvien>();
		
		qlsv quanlyds = new qlsv();

		
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
		menu = qlsv.nhaplieu.nextInt();
		qlsv.nhaplieu.nextLine();
				
		switch (menu) {
		case 1: {quanlyds.nhapds(ds); break;}
		case 2: {quanlyds.xuatds(ds); break;}
		case 3: {quanlyds.nhapds(ds); break;}
		case 4: {quanlyds.xoasinhvien(ds); break;}
		case 5: {quanlyds.updateinfo(ds);break;}
		case 6: {quanlyds.sapxep(ds);break;}
		case 0: break;
		}
		}
		
		qlsv.nhaplieu.close();
		//writeToFileTxt(ds, "test3.txt");
		//write(ds, "E:\\Codelife\\test3.txt");
		ds = read("test3.txt");
		quanlyds.xuatds(ds);
		}
	}

