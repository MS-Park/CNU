package HW01;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;


public class PrintMain {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = null;
		PrintWriter out = null;
		
		// ������ �����ϱ����� Table �̶�� Ŭ������ ���.
		Table table = new Table();
		int i;
		try {
			// test.cw ������ �о�´�.
			fr = new FileReader("test.cw");
			// test.c ���Ͽ� �����Ѵ�.
			out = new PrintWriter("test.c");
			BufferedReader br = new BufferedReader(fr);
			// test.cw ������ ���پ� �о�´�.
			String source= br.readLine();
			
			// �⺻������ �����Ǿ�� �ϴ� �κ�.
			out.println("#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n");
			out.println("void main() {");
			out.println("		int i;");
			
			// ������� �о�ö����� �ݺ�.
			while(source != null){
				// �о�� ������ split�� �̿��Ͽ� ����� �迭�� ����.
				String[] tmp = source.split(" ");
				// ����ġ���� ����Ͽ� �� ��ɾ�� ó��.
				switch(tmp[0]){
				// def�� ���Ǿ����� 
				case "def":
					// �������� ���� �Ǿ����� ���� �޽����� �߻��ϰ� ���α׷��� �����Ѵ�.
					if(tmp[3].equals("\"\\n\""))
					{
						System.out.println("newline�� ������ �� �����ϴ�.");
						return;
					}
					// �ش��ϴ� c�ڵ�� ��ȯ�ϰ� �װ��� c���Ͽ� �ۼ��Ѵ�.
					out.println("		char "+tmp[1]+"[] = "+tmp[3]+";");
					// ������ table�� ���� ����.
					table.insertTable(tmp[1], tmp[3]);
					break;
				// show�� ���Ǿ�����
				case "show":
					// show ������ ���� ���� ���̺� �����ϴ� ������ ���.  
					if(table.lookupTable(tmp[1]) != null && tmp.length == 2){
						out.println("		printf(\"%s\\n\", "+tmp[1]+");");
						break;
					}
					// �׷��� �������.
					else{
						// show ������ ������ ������, �迭�� ũ�Ⱑ 3�ΰ��.
						if(tmp[1].matches("-*[0-9]+") && tmp.length == 3){
							// ������ �ԷµǾ������ ���� �޼����� ����ϰ� ���α׷��� �����Ѵ�.							
							if(Integer.parseInt(tmp[1])<0)
							{
								System.out.println("������ �Է��Ҽ� �����ϴ�.");
								return;
							}
							out.println("		for (i = 0; i < "+tmp[1]+"; i++)");
							out.println("			printf(\"%s\", "+tmp[2]+");");
							out.println("		printf(\"\\n\");");
							break;
						}else if (tmp.length == 2){	// �� ���� ������ ������ ��찡 �ɷ����Ƿ�, ������ �ƴ� ""�� �̷���� ��¹�.
							out.println(" 		printf("+tmp[1]+");");
							out.println("		printf(\"\\n\");");
							break;
						}else {
							// show item1,item2,.......,itmeN�� ���.
							for(i=1; i<tmp.length; i++){
								String[] tmp2 = tmp[i].split(",");
								if(table.lookupTable(tmp2[0]) != null) {
									out.println("		printf(\"%s\", "+tmp2[0]+");"); 
								}else {
									out.println("		printf("+tmp2[0]+");"); 
								}
							}
							out.println("		printf(\"\\n\");"); 
							break;
						}
					}
				// showD �� ���Ǿ�����
				case "showD":
					// showD N Delimiter Item �ΰ��.
					if(tmp[1].matches("-*[0-9]+") && tmp.length == 4){
						// �����϶� �����޽����� ����ϰ� ���α׷��� ����.
						if(Integer.parseInt(tmp[1])<0)
						{
							System.out.println("������ �Է��Ҽ� �����ϴ�.");
							return;
						}
						out.println("		for (i = 0; i < "+tmp[1]+"; i++) {");
						out.println("			printf(\"%s\", "+tmp[3]+");");
						out.println("			if(i<"+tmp[1]+"-1)");
						out.println("				printf("+tmp[2]+");");
						out.println("		}");
						out.println("		printf(\"\\n\");");
						break;
					}
					// showD Delimiter Item1,Item2,....,ItemN �϶�
					else{
						for(i=2; i<tmp.length; i++){
							String[] tmp2 = tmp[i].split(",");
							if(table.lookupTable(tmp2[0]) != null) {
								out.println("		printf(\"%s\", "+tmp2[0]+");"); 
							}else {
								out.println("		printf("+tmp2[0]+");"); 
							}
							if(i<tmp.length - 1){
								out.println("		printf("+tmp[1]+");"); 
							}
						}
						out.println("		printf(\"\\n\");"); 
					}
					break;
				}
				// �������� �о�´�.
				source= br.readLine();
			}
			out.println("}");		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {	// ���� �� �ݾ���.
			if(fr != null)
				fr.close();
			if(out != null)
				out.close();
		}
	}

}
