package com.sample;

public class DiagnosisMaster extends Thread {
	private String sex;
	private Question overEighteeen = Question.NOT_ASKED; 
	private Question chestPain = Question.NOT_ASKED;
	private Question stomachPain = Question.NOT_ASKED;
	private Question stuffiness = Question.NOT_ASKED;
	private Question sportStuffiness = Question.NOT_ASKED;
	private Question steppedUpBreath = Question.NOT_ASKED;
	

	public Question isStomachPain() {
		return stomachPain;
	}
	public void setStomachPain(boolean stomachPain) {
		if(stomachPain) {
			this.stomachPain = Question.TRUE;
		}
		else this.stomachPain = Question.FALSE;
	}
	public Question isSteppedUpBreath() {
		return steppedUpBreath;
	}
	public void setSteppedUpBreath(boolean steppedUpBreath) {
		if(steppedUpBreath) {
			this.steppedUpBreath = Question.TRUE;
		}
		else this.steppedUpBreath = Question.FALSE;
	}
	public Question isChestPain() {
		return chestPain;
	}
	public void setChestPain(boolean chestPain) {
		if(chestPain) {
			this.chestPain = Question.TRUE;
		}
		else this.chestPain = Question.FALSE;
	}
	public Question isStuffiness() {
		return stuffiness;
	}
	public void setSportStuffiness(boolean sportStuffiness) {
		if(sportStuffiness) {
			this.sportStuffiness = Question.TRUE;
		}
		else this.sportStuffiness = Question.FALSE;
	}
	public Question isSportStuffiness() {
		return sportStuffiness;
	}
	public void setStuffiness(boolean stuffiness) {
		if(stuffiness) {
			this.stuffiness = Question.TRUE;
		}
		else this.stuffiness = Question.FALSE;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Question isOverEighteeen() {
		return overEighteeen;
	}
	public void setOverEighteeen(boolean overEighteeen) {
		if(overEighteeen) {
			this.overEighteeen = Question.TRUE;
		}
		else this.overEighteeen = Question.FALSE;
	}
	
}
