package com.sample;

public class DiagnosisMaster extends Thread {
	private String sex;
	private Question overEighteeen = Question.NOT_ASKED;
	private Question chestPain = Question.NOT_ASKED;
	private Question stomachPain = Question.NOT_ASKED;
	private Question stuffiness = Question.NOT_ASKED;
	private Question sportStuffiness = Question.NOT_ASKED;
	private Question bloodPressure = Question.NOT_ASKED;
	private Question steppedUpBreath = Question.NOT_ASKED;
	private Question abdomen = Question.NOT_ASKED;
	private Question meal = Question.NOT_ASKED;
	private Question nausea = Question.NOT_ASKED;
	private Question voiding = Question.NOT_ASKED;

	public Question isStomachPain() {
		return stomachPain;
	}

	public void setStomachPain(boolean stomachPain) {
		if (stomachPain) {
			this.stomachPain = Question.TRUE;
		} else
			this.stomachPain = Question.FALSE;
	}

	public Question isSteppedUpBreath() {
		return steppedUpBreath;
	}

	public void setSteppedUpBreath(boolean steppedUpBreath) {
		if (steppedUpBreath) {
			this.steppedUpBreath = Question.TRUE;
		} else
			this.steppedUpBreath = Question.FALSE;
	}

	public Question isChestPain() {
		return chestPain;
	}

	public void setChestPain(boolean chestPain) {
		if (chestPain) {
			this.chestPain = Question.TRUE;
		} else
			this.chestPain = Question.FALSE;
	}

	public Question isStuffiness() {
		return stuffiness;
	}

	public void setStuffiness(boolean stuffiness) {
		if (stuffiness) {
			this.stuffiness = Question.TRUE;
		} else
			this.stuffiness = Question.FALSE;
	}

	public void setSportStuffiness(boolean sportStuffiness) {
		if (sportStuffiness) {
			this.sportStuffiness = Question.TRUE;
		} else
			this.sportStuffiness = Question.FALSE;
	}

	public Question isSportStuffiness() {
		return sportStuffiness;
	}

	public void setBloodPressure(boolean bloodPressure) {
		if (bloodPressure) {
			this.bloodPressure = Question.TRUE;
		} else
			this.bloodPressure = Question.FALSE;
	}

	public Question isBloodPressure() {
		return bloodPressure;
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
		if (overEighteeen) {
			this.overEighteeen = Question.TRUE;
		} else
			this.overEighteeen = Question.FALSE;
	}

	public Question isAbdomen() {
		return abdomen;
	}

	public void setAbdomen(boolean abdomen) {
		if (abdomen) {
			this.abdomen = Question.TRUE;
		} else
			this.abdomen = Question.FALSE;
	}

	public Question isMeal() {
		return meal;
	}

	public void setMeal(boolean meal) {
		if (meal) {
			this.meal = Question.TRUE;
		} else
			this.meal = Question.FALSE;
	}

	public Question isNausea() {
		return nausea;
	}

	public void setNausea(boolean nausea) {
		if (nausea) {
			this.nausea = Question.TRUE;
		} else
			this.nausea = Question.FALSE;
	}

	public void setVoiding(boolean voiding) {
		if (voiding) {
			this.voiding = Question.TRUE;
		} else
			this.voiding = Question.FALSE;
	}

	public Question isVoiding() {
		return voiding;
	}

}
