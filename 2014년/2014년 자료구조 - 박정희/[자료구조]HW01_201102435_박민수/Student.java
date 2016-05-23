package sub01;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {
	int id;	//�й�
	String name;	//�̸�
	ArrayList< Section> section;	//��������

	Student(String name, int id)
	{
		this.id = id;
		this.name = name;
	}
	Student(String name, int id,ArrayList< Section> section)
	{
		this.id = id;
		this.name = name;
		this.section = section;
	}
	/*Getter & Setter*/
	public int getID(){
		return id;
	}
	public void setID(int id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public ArrayList<Section> getSection(){
		return section;
	}
	public void setSection(ArrayList<Section> section){
		this.section = section;
	}
	/*���������� �������*/
	public void printSubjectScore(){
		System.out.println("****************************************************");
		System.out.println("�й�: "+id+" �̸� : "+name);
		System.out.println("****************************************************");
		
		Iterator <Section>it = section.iterator();
		while(it.hasNext())
		{
			it.next().printInfo();
		}
	}
	
}
