package sub01;

public class Statistics extends Section
{
	String subject;
	double midterm;
	double finals;
	int num;
	int midPercent = 40;
	int finalPercent = 60;

	Statistics(String subject){
		this.subject = subject;		
	}
	Statistics(String subject, double mid, double finals)
	{
		this.subject = subject;
		this.midterm = mid;
		this.finals = finals;
	
	}
	/*Getter & Setter*/
	public int getNum(){
		return num;
	}
	public void setNum(int num){
		this.num = num;
	}
	public double getMidterm(){
		return midterm;
	}
	public void setMidterm(double mid){
		this.midterm = mid;
	}
	public double getFinals(){
		return finals;
	}
	public void setFinals(double finals){
		this.finals = finals;
	}	
	/*��ü ���� ���*/
	public void printInfo(){
		System.out.println("����� : " +subject);
		System.out.println("�����ο� : " +num);
		System.out.println("�н��򰡱��� : �߰���� 40% �⸻��� 60% ");
		
		calcScore();
		printScore();
	}
	/*���� ���� ���*/
	public void printScore(){
		System.out.println("�߰���� " +midterm+ " �⸻���"+finals+ " ȯ������ : "+(midPercent+finalPercent)+"\n");
	}
	/*���� ���*/
	public void calcScore(){
		midPercent = (int)(midterm*0.4);
		finalPercent = (int)(finals*0.6);
	}
		
}
