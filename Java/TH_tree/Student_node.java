package TH_tree;

import java.io.Serializable;

public class Student_node implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private int Id;
	private String Name;
	private String Class;
	private double Result;
	Student_node Left;
	Student_node Right;
	public Student_node() {
		this.Id=0;
		this.Name="";
		this.Class="";
		this.Result=0;
		this.Left=null;
		this.Right=null;
	}
	public Student_node(int maso,String ten, String lop, double diemso){
		this.Id=maso;
		this.Name=ten;
		this.Class=lop;
		this.Result=diemso;
		this.Left=null;
		this.Right=null;
	}
	public void input(int maso,String ten, String lop, double diemso){
		this.Id=maso;
		this.Name=ten;
		this.Class=lop;
		this.Result=diemso;
		
	}
	public void output(int i) {
		System.out.printf("%-20s%-20d %-20s %-20s %-20.2f %n",i+1,this.Id,this.Name,this.Class,this.Result);
		}
	public int get_Id() {
		return this.Id;
	}
	public void set_Id(int maso) {
		this.Id=maso;
	}
	public String get_Name() {
		return this.Name;
	}
	public void set_Name(String ten) {
		this.Name=ten;
	}
	public String get_Class() {
		return this.Class;
	}
	public void set_Class(String lop) {
		this.Class=lop;
	}
	public double get_Result() {
		return this.Result;
	}
	public void set_Result(double diem) {
		this.Result=diem;
	}

	}


