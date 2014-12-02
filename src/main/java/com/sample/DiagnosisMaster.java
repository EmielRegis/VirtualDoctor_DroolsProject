package com.sample;

public class DiagnosisMaster extends Thread {
	private String sex;
	private Question overEighteeen = Question.NOT_ASKED; 
	private Question chestPain = Question.NOT_ASKED;
	private Question stomachPain = Question.NOT_ASKED;
	private Question stuffiness = Question.NOT_ASKED;
	private Question steppedUpBreath = Question.NOT_ASKED;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Question getOverEighteeen() {
		return overEighteeen;
	}
	public void setOverEighteeen(Question overEighteeen) {
		this.overEighteeen = overEighteeen;
	}
	public Question getChestPain() {
		return chestPain;
	}
	public void setChestPain(Question chestPain) {
		this.chestPain = chestPain;
	}
	public Question getStomachPain() {
		return stomachPain;
	}
	public void setStomachPain(Question stomachPain) {
		this.stomachPain = stomachPain;
	}
	public Question getStuffiness() {
		return stuffiness;
	}
	public void setStuffiness(Question stuffiness) {
		this.stuffiness = stuffiness;
	}
	public Question getSteppedUpBreath() {
		return steppedUpBreath;
	}
	public void setSteppedUpBreath(Question steppedUpBreath) {
		this.steppedUpBreath = steppedUpBreath;
	}
	
}
