package com.sample;

public class DiagnosisMaster extends Thread {
	private String sex;
	private boolean overEighteeen; 
	private boolean chestPain = false;
	private boolean stomachPain = false;
	private boolean stuffiness = false;
	private boolean steppedUpBreath = false;
	
	public DiagnosisMaster(String sex, boolean overEighteeen) {
		super();
		this.sex = sex;
		this.overEighteeen = overEighteeen;
	}
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
	
}
