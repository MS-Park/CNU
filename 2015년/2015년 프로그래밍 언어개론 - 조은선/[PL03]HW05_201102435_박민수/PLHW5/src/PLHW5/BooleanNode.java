package PLHW5;

public class BooleanNode extends Node{
	public boolean value;
	@Override
	public String toString(){
		return value ? "#T" : "#F";
	}
}
