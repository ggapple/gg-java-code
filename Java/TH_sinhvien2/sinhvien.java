package TH_sinhvien2;

import java.io.Serializable;
public class sinhvien implements Serializable{
private int masosv;
private String hovaten;
private int namsinh;
private float diemtb;
public sinhvien() {
	this.masosv=0;
	this.hovaten="";
	this.namsinh=0;
	this.diemtb=0;
}
public sinhvien(int maso,String ten, int namsinh, float diemso){
	this.masosv=maso;
	this.hovaten=ten;
	this.namsinh=namsinh;
	this.diemtb=diemso;
	
}
public void nhapthongtinsinhvien(int maso,String ten, int namsinh, float diemso){
	this.masosv=maso;
	this.hovaten=ten;
	this.namsinh=namsinh;
	this.diemtb=diemso;
	
}
public void xuatthongtinsinhvien(int i) {
	System.out.printf("%-20s %-20d %-20s %-20d %-20f %-20s %n",i+1,this.masosv,this.hovaten,this.namsinh,this.diemtb,this.hocluc());
	}
public int getmasosv() {
	return this.masosv;
}
public void setmasosv(int maso) {
	this.masosv=maso;
}
public String gethovaten() {
	return this.hovaten;
}
public void sethovaten(String ten) {
	this.hovaten=ten;
}
public int getnamsinh() {
	return this.namsinh;
}
public void setnamsinh(int namsinh) {
	this.namsinh=namsinh;
}
public float getdiemtb() {
	return this.diemtb;
}
public void setdiemtb(float diem) {
	this.diemtb=diem;
}
public String hocluc() {
	if (this.diemtb<5) return "Yeu";
	else if (this.diemtb<6) return "Trung Binh";
	else if (this.diemtb<7) return "Trung Binh Kha";
	else if (this.diemtb<8) return "Kha";
	else if (this.diemtb<9) return "Gioi";
	else return "Xuat Sac";
}
}
