package sub01;

public class DS extends Section
{
	String subject;	//�����
	double midterm;	//�߰�����
	double finals;	//�⸻����
	double practice_score;	//�ǽ�����
	int num;	//�ο���
	/*�н��򰡱���*/
	int midPercent = 40;		//�߰����
	int finalPercent = 40;	//�⸻���
	int paracPercent = 20;	//�ǽ���

	DS(String subject){
		this.subject = subject;		
	}
	DS(String subject, double mid, double finals,double prac)
	{
		this.subject = subject;
		this.midterm = mid;
		this.finals = finals;
		this.practice_score = prac;
		
	
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
	public double getPractice_score(){
		return practice_score;
	}
	public void setPractice_score(double practice_score){
		this.practice_score = practice_score;
	}
	/*��ü ���� ���*/
	public void printInfo(){
		System.out.println("����� : " +subject);
		System.out.println("�����ο� : " +num);
		System.out.println("�н��򰡱��� : �߰���� 40% �⸻��� 40% �ǽ��� 20%");
		
		calcScore();
		printScore();
	}
	/*���� ���� ���*/
	public void printScore(){
		System.out.println("�߰���� " +midterm+ " �⸻���"+finals+" �ǽ����� : " +practice_score+ " ȯ������ : "+(midPercent+finalPercent+paracPercent)+"\n");
	}
	/*���� ���*/
	public void calcScore(){
		midPercent = (int)(midterm*0.4);
		finalPercent = (int)(finals*0.4);
		paracPercent = (int)(practice_score*0.2);
	}
}
