package cuoiki;

import java.io.Serializable;

public class Customer_node implements Serializable {
    private int ID;
    private String Name;
    private double Coin;
    Customer_node left;
    Customer_node right;

    public Customer_node() {
        this.ID = 0;
        this.Name = "";
        this.Coin = 0;
        this.left = null;
        this.right = null;
    }

    public Customer_node(int ID, String Name, double Coin) {
        set_ID(ID);
        set_Name(Name);
        set_Coin(Coin);
        this.left = null;
        this.right = null;
    }

    public void output(int i) {
        System.out.printf("%-20s%-20d %-20s %-20.2f %-20s %n", i + 1, get_ID(), get_Name(), get_Coin(), this.Rank());
    }

    public int get_ID() {
        return this.ID;
    }

    public void set_ID(int id) {
        this.ID = id;
    }

    public String get_Name() {
        return this.Name;
    }

    public void set_Name(String name) {
        this.Name = name;
    }

    public double get_Coin() {
        return this.Coin;
    }

    public void set_Coin(double coin) {
        this.Coin = coin;
    }

    public String Rank() {
        if (this.Coin < 200)
            return "Normal";
        else if (this.Coin < 500)
            return "Silver";
        else
            return "Gold";
    }

}
