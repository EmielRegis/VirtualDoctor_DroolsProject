package com.sample;

public class DiagnosisMaster extends Thread {
	private String sex;
	private boolean overEighteeen; 
	private boolean chestPain = false;
	private boolean stomachPain = false;
	private boolean stuffiness;
	private boolean steppedUpBreath = false;
	

	public boolean isStomachPain() {
		return stomachPain;
	}
	public void setStomachPain(boolean stomachPain) {
		this.stomachPain = stomachPain;
	}
	public boolean isSteppedUpBreath() {
		return steppedUpBreath;
	}
	public void setSteppedUpBreath(boolean steppedUpBreath) {
		this.steppedUpBreath = steppedUpBreath;
	}
	public boolean isChestPain() {
		return chestPain;
	}
	public void setChestPain(boolean chestPain) {
		this.chestPain = chestPain;
	}
	public boolean isStuffiness() {
		return stuffiness;
	}
	public void setStuffiness(boolean stuffiness) {
		this.stuffiness = stuffiness;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean isOverEighteeen() {
		return overEighteeen;
	}
	public void setOverEighteeen(boolean overEighteeen) {
		this.overEighteeen = overEighteeen;
	}
	
}
