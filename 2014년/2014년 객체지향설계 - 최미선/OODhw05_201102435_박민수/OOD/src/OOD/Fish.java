package OOD;

public class Fish extends Animal implements Pet{

	private String name;
	
	public Fish() {
		super(0);
		// TODO Auto-generated constructor stub
	}
	
	public Fish(String name){
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("����Ⱑ ���ġ�� ��ϴ�.");
	}
	
	public void walk(){
		System.out.println("�� ������ ���Ĩ�ϴ�.");
	}
	
	public void eat(){
		System.out.println("������ ���̸� �Խ��ϴ�.");
	}

}
