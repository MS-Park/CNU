package sub01;

import java.util.ArrayList;
import java.util.Iterator;


public class Run {

	public static void main(String[] args) {
		

		
		/* �л� 1  */
		ArrayList<Section> student1 = new ArrayList<Section>();
		
		DS ds1 = new DS("�ڷᱸ��", 10.0, 10.0, 10.0);
		CP cp1 = new CP("��ǻ�� ���α׷���", 20.0, 20.0, 20.0);
		Statistics st1 = new Statistics("���", 40.0, 40.0);
		
		student1.add(ds1);
		student1.add(cp1);
		student1.add(st1);	
		
		/*�����ο� �Է�*/
		ds1.setNum(3);
		cp1.setNum(3);
		st1.setNum(3);
	
		
		
		/*	�л�2 */
		ArrayList<Section> student2 = new ArrayList<Section>();
		
		DS ds2 = new DS("�ڷᱸ��", 15.0, 20.0, 50.0);
		CP cp2 = new CP("��ǻ�� ���α׷���", 60.0, 70.0, 60.0);
		Statistics st2 = new Statistics("���", 80.0, 70.0);
		
		student2.add(ds2);
		student2.add(cp2);
		student2.add(st2);	
		
		/*�����ο� �Է�*/
		ds2.setNum(3);
		cp2.setNum(3);
		st2.setNum(3);
		
	
		/*	�л�3  */

		ArrayList<Section> student3 = new ArrayList<Section>();
		
		DS ds3 = new DS("�ڷᱸ��", 80.0, 70.0, 90.0);
		CP cp3 = new CP("��ǻ�� ���α׷���", 70.0, 90.0, 80.0);
		Statistics st3 = new Statistics("���", 80.0, 90.0);
		
		student3.add(ds3);
		student3.add(cp3);
		student3.add(st3);		
		
		/*�����ο� �Է�*/
		ds3.setNum(3);
		cp3.setNum(3);
		st3.setNum(3);

			
		/*	Student Arraylist*/
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("ȫ�浿", 201400001, student1));
		studentList.add(new Student("�Ӳ���", 201400002, student2));
		studentList.add(new Student("�ڹμ�", 201102435, student3));
	
		
			
				
		/*	iterator �� �̿��Ͽ� ���	*/
		Iterator <Student>it = studentList.iterator();
		while(it.hasNext())
		{
			it.next().printSubjectScore();
			System.out.println(" ");
		}
	}
	/*PPT���� ���ȭ�鿡�� �����ο��ϰ� �򰡱����� ��¾ȵ��ִ� ȭ������ �����ִµ�PPT�ȿ� �����߿� 
	   �����϶�� �̾߱Ⱑ �����־ �����߽��ϴ�.*/

}
