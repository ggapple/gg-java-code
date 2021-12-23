/*
 * package customer;
 * 
 * import java.io.FileInputStream;
 * import java.io.FileNotFoundException;
 * import java.io.FileOutputStream;
 * import java.io.IOException;
 * import java.util.HashMap;
 * import java.util.Scanner;
 * 
 * import org.apache.poi.EncryptedDocumentException;
 * import org.apache.poi.ss.usermodel.Row;
 * import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook;
 * import org.apache.poi.ss.usermodel.WorkbookFactory;
 * 
 * public class Account {
 * private static Scanner scanner = new Scanner(System.in);
 * public static HashMap<String, String> accountMap = new HashMap<>();
 * private static FileInputStream fis;
 * private static FileOutputStream fos;
 * private static Workbook workbook;
 * private static Sheet sheet;
 * private static Row row;
 * 
 * static void readFileAccount() throws EncryptedDocumentException, IOException,
 * FileNotFoundException {
 * fis = new FileInputStream("Account.xlsx");
 * workbook = WorkbookFactory.create(fis);
 * sheet = workbook.getSheet("Sheet1");
 * int len = sheet.getLastRowNum();
 * for (int i = 1; i <= len; i++) {
 * accountMap.put(sheet.getRow(i).getCell(0).toString(),
 * sheet.getRow(i).getCell(1).toString());
 * }
 * fis.close();
 * 
 * }
 * 
 * static boolean logIn(String username, String password) {
 * try {
 * readFileAccount();
 * if (accountMap.containsKey(username)) {
 * 
 * if (accountMap.get(username).compareToIgnoreCase(password) == 0) {
 * System.out.println("Done");
 * return true;
 * } else {
 * System.out.println("Wrong password");
 * return false;
 * }
 * } else {
 * System.out.println("Account doesn't exist !!!");
 * }
 * 
 * } catch (EncryptedDocumentException | IOException e) {
 * e.printStackTrace();
 * }
 * return false;
 * }
 * 
 * static boolean signIn(String username, String password) {
 * try {
 * readFileAccount();
 * if (accountMap.containsKey(username)) {
 * System.out.println("Account already exist");
 * return false;
 * } else {
 * fos = new FileOutputStream("Account.xlsx");
 * // ghi file excel
 * sheet = workbook.getSheet("sheet1");
 * int len = sheet.getLastRowNum();
 * row = sheet.createRow(len+=1);
 * row.createCell(0).setCellValue(username);
 * row.createCell(1).setCellValue(password);
 * workbook.write(fos);
 * fos.close();
 * return true;
 * }
 * } catch (EncryptedDocumentException | IOException e) {
 * e.printStackTrace();
 * }
 * return true;
 * }
 * 
 * public static void main(String[] args, int i) {
 * 
 * if (i == 1) {
 * while (true) {
 * System.out.print("Enter username: ");
 * String username = scanner.nextLine();
 * System.out.print("Enter password: ");
 * String password = scanner.nextLine();
 * if (logIn(username, password)) {
 * if(username.compareToIgnoreCase("Admin") == 0)
 * Main.adminLogin = true;
 * Main.status = true;
 * break;
 * }
 * else {
 * break;
 * }
 * }
 * } else {
 * while(true) {
 * System.out.print("Enter username to create: ");
 * String username = scanner.nextLine();
 * System.out.print("Enter password: ");
 * String password = scanner.nextLine();
 * if(signIn(username, password)) {
 * System.out.println("Your account has been update to the system");
 * Main.status=true;
 * break;
 * }
 * }
 * }
 * }
 * }
 */