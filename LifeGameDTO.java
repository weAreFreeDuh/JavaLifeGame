package LIFEGAME;

public class LifeGameDTO {
	
	private int health;
	private int property; //money에서 property. 총 자산
	private int balance; //잔액이면서 실제 사용가능한 금액
	private int happy;
	private String mid;
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getProperty() {
		return property;
	}
	public void setProperty(int property) {
		this.property = property;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getHappy() {
		return happy;
	}
	public void setHappy(int happy) {
		this.happy = happy;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "LifeGameDTO [health=" + health + ", property=" + property + ", balance=" + balance + ", happy=" + happy
				+ ", mid=" + mid + "]";
	}
	
	
	
	
	
	
}