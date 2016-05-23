package OOD;

public class Cat extends Animal implements Pet {
	private String name;
	
	public Cat(){
		super(4);
	}
	
	public Cat(String name){
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void play() {
		System.out.println("����̴� ���� ������ ��ϴ�.");
	}
	
	public void eat(){
		System.out.println("����̴� ������ �� �Խ��ϴ�.");
	} 
}
