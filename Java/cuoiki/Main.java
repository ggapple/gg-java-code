/*
 * package customer;
 * 
 * import java.io.IOException;
 * import java.util.Scanner;
 * 
 * public class Main {
 * 
 * private static Scanner scanner = new Scanner(System.in);
 * public static boolean adminLogin = false;
 * public static boolean status = false;
 * 
 * public static void main(String[] args) {
 * while (!status) {
 * System.out.println("   _____________");
 * System.out.println("1. |__Log_in___|");
 * System.out.println("2. |__Sign_in__|");
 * System.out.print("Enter: ");
 * int logIn = scanner.nextInt();
 * Account.main(args, logIn);
 * }
 * if (adminLogin)
 * System.out.println("You are logged in as administrator !!!");
 * else
 * System.out.println("You are logged in as guest !!!");
 * Manager manager = new Manager();
 * boolean flag = true;
 * while (flag) {
 * // menu
 * System.out.println("    _________________________________________");
 * System.out.println("1.  |____________Add Customer_______________|");
 * System.out.println("2.  |_________Output Customer List__________|");
 * System.out.println("3.  |____________Find customer______________|");
 * System.out.println("4.  |_____Update Customer Information_______|");
 * System.out.println("5.  |___________Delete Customer_____________|");
 * System.out.println("6.  |________________Load File______________|");
 * System.out.println("10. |________________Exit___________________|");
 * System.out.print("Enter: ");
 * int choice = scanner.nextInt();
 * switch (choice) {
 * case 1:
 * if (!adminLogin) {
 * System.out.println("Only Admin have the permission to use this function !!!"
 * );
 * break;
 * }
 * manager.addCustomer();
 * break;
 * case 2:
 * manager.outputCustomer();
 * break;
 * case 3:
 * manager.findCustomer();
 * break;
 * case 4:
 * if (!adminLogin) {
 * System.out.println("Only Admin have the permission to use this function !!!"
 * );
 * break;
 * }
 * manager.updateCustomer();
 * break;
 * case 5:
 * if (!adminLogin) {
 * System.out.println("Only Admin have the permission to use this function !!!"
 * );
 * break;
 * }
 * manager.deleteCustomer();
 * break;
 * case 6:
 * try {
 * manager.load();
 * } catch (IOException e) {
 * System.out.println("Empty File");
 * }
 * break;
 * 
 * case 10:
 * if (adminLogin) {
 * System.out.println("save");
 * manager.save();
 * break;
 * }
 * flag = false;
 * break;
 * }
 * }
 * }
 * }
 */
