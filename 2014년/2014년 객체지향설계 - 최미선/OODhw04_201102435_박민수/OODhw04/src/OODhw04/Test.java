package OODhw04;

import java.io.*;
import java.util.Scanner;

public class Test {

	private static Scanner sc;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		sc = new Scanner(System.in);
		int num;
		String name, number, phone, email;

			while (true) {
				System.out.println("**** 1:�Է�, 2: ���, etc:���� ****");
				num = sc.nextInt();
				
					switch (num) {
					case 1:
						BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt",
								true));
						System.out.print("��ȣ : ");
						number = reader.readLine();
						System.out.print("�̸� : ");
						name = reader.readLine();
						System.out.print("��ȭ��ȣ : ");
						phone = reader.readLine();
						System.out.print("�̸����ּ� : ");
						email = reader.readLine();
						String item = String.format("%s|%s|%s|%s\n", number,
								name, phone, email);
						writer.write(item);						
						writer.close();					
						break;
					case 2:
						String a;
						BufferedReader reader2 = new BufferedReader(
								new FileReader("test.txt"));
						String line = "";
						System.out.print("����� ��ȣ�Է� : ");
						a = sc.next();
						System.out.println("����� ��ȭ��ȣ : ");

						while ((line = reader2.readLine()) != null) {
							String[] temp = line.split("\\|");
							if (temp[0].equals(a)) {
								System.out.printf("%s\t\n", temp[2]);
							}
						}
						reader2.close();
						break;
					default:
						return;
					}
				
			}
		

	}
}
