package LIFEGAME;

public class StoreDTO {
	// storetbl 테이블 스키마
	
	private int health;
	private int property; //money에서 property
	private int balance;
	private int happy;
	private int love;
	private String mid;
	
	
	private int uphappy;
	
	public int getUphappy() {
		return uphappy;
	}
	public void setUphappy(int uphappy) {
		this.uphappy = uphappy;
	}
	private String sId;
	private String simfo;
	private String stype;
	private int sPrice;
	private int sOwn;
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
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getSimfo() {
		return simfo;
	}
	public void setSimfo(String simfo) {
		this.simfo = simfo;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public int getsPrice() {
		return sPrice;
	}
	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}
	public int getsOwn() {
		return sOwn;
	}
	public void setsOwn(int sOwn) {
		this.sOwn = sOwn;
	}
	@Override
	public String toString() {
		return "StoreDTO [health=" + health + ", property=" + property + ", balance=" + balance + ", happy=" + happy
				+ ", love=" + love + ", mid=" + mid + ", uphappy=" + uphappy + ", sId=" + sId + ", simfo=" + simfo
				+ ", stype=" + stype + ", sPrice=" + sPrice + ", sOwn=" + sOwn + "]";
	}
	
	
	
	
	

}
