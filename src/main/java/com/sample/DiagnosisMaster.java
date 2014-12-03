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
	private Question longLastingCold = Question.NOT_ASKED;
	private Question cough = Question.NOT_ASKED;
	private Question asthma = Question.NOT_ASKED;
	private Question pneumoniaOrBronchitis = Question.NOT_ASKED;
	private Question strongEmotions = Question.NOT_ASKED;
	private Question heartPalpitation = Question.NOT_ASKED;
	private Question chestQuestions = Question.NOT_ASKED;
	private Question stingingEyes = Question.NOT_ASKED;
	private Question rash = Question.NOT_ASKED;
	private Question stomachQuestions = Question.NOT_ASKED;
	private Question navel = Question.NOT_ASKED;
	private Question headAche = Question.NOT_ASKED;
	private Question soreThroat = Question.NOT_ASKED;
	private Question radiatingPain = Question.NOT_ASKED;
	private Question menstrualCycleDisorder = Question.NOT_ASKED;
	private Question genialTractBleeding = Question.NOT_ASKED;
	private Question headAcheQuestions = Question.NOT_ASKED;
	private Question sinusesAche = Question.NOT_ASKED;
	private Question earsAche = Question.NOT_ASKED;
	private Question blockedUpEars = Question.NOT_ASKED;
	private Question migraine = Question.NOT_ASKED;
	private Question neuralgia = Question.NOT_ASKED;
	private Question diabetes = Question.NOT_ASKED;
	
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
	public void setLongLastingCold(boolean longLastingCold) {
		if (longLastingCold) {
			this.longLastingCold = Question.TRUE;
		} else
			this.longLastingCold = Question.FALSE;
	}

	public Question isLongLastingCold() {
		return longLastingCold;
	}
	public void setCough(boolean cough) {
		if (cough) {
			this.cough = Question.TRUE;
		} else
			this.cough = Question.FALSE;
	}
	public Question isCough() {
		return cough;
	}
	public void setAsthma(boolean asthma) {
		if (asthma) {
			this.asthma = Question.TRUE;
		} else
			this.asthma = Question.FALSE;
	}
	public Question isAsthma() {
		return asthma;
	}
	public void setPneumoniaOrBronchitis(boolean pneumoniaOrBronchitis) {
		if (pneumoniaOrBronchitis) {
			this.pneumoniaOrBronchitis = Question.TRUE;
		} else
			this.pneumoniaOrBronchitis = Question.FALSE;
	}
	public Question isPneumoniaOrBronchitis() {
		return pneumoniaOrBronchitis;
	}
	public void setStrongEmotions(boolean strongEmotions) {
		if (strongEmotions) {
			this.strongEmotions = Question.TRUE;
		} else
			this.strongEmotions = Question.FALSE;
	}
	public Question isStrongEmotions() {
		return strongEmotions;
	}
	public void setHeartPalpitation(boolean heartPalpitation) {
		if (heartPalpitation) {
			this.heartPalpitation = Question.TRUE;
		} else
			this.heartPalpitation = Question.FALSE;
	}
	public Question isHeartPalpitation() {
		return heartPalpitation;
	}
	public void setChestQuestions(boolean chestQuestions) {
		if (chestQuestions) {
			this.chestQuestions = Question.TRUE;
		} else
			this.chestQuestions = Question.FALSE;
	}
	public Question isChestQuestions() {
		return chestQuestions;
	}
	public void setStingingEyes(boolean stingingEyes) {
		if (stingingEyes) {
			this.stingingEyes = Question.TRUE;
		} else
			this.stingingEyes = Question.FALSE;
	}
	public Question isStingingEyes() {
		return stingingEyes;
	}
	public void setRash(boolean rash) {
		if (rash) {
			this.rash = Question.TRUE;
		} else
			this.rash = Question.FALSE;
	}
	public Question isRash() {
		return rash;
	}
	public void setStomachQuestions(boolean stomachQuestions) {
		if (stomachQuestions) {
			this.stomachQuestions = Question.TRUE;
		} else
			this.stomachQuestions = Question.FALSE;
	}
	public Question isStomachQuestions() {
		return stomachQuestions;
	}
	public void setNavel(boolean navel) {
		if (navel) {
			this.navel = Question.TRUE;
		} else
			this.navel = Question.FALSE;
	}
	public Question isNavel() {
		return navel;
	}
	public void setHeadAche(boolean headAche) {
		if (headAche) {
			this.headAche = Question.TRUE;
		} else
			this.headAche = Question.FALSE;
	}
	public Question isHeadAche() {
		return headAche;
	}
	public void setSoreThroat(boolean soreThroat) {
		if (soreThroat) {
			this.soreThroat = Question.TRUE;
		} else
			this.soreThroat = Question.FALSE;
	}
	public Question isSoreThroat() {
		return soreThroat;
	}
	public void setRadiatingPain(boolean radiatingPain) {
		if (radiatingPain) {
			this.radiatingPain = Question.TRUE;
		} else
			this.radiatingPain = Question.FALSE;
	}
	public Question isRadiatingPain() {
		return radiatingPain;
	}
	public void setGenialTractBleeding(boolean genialTractBleeding) {
		if (genialTractBleeding) {
			this.genialTractBleeding = Question.TRUE;
		} else
			this.genialTractBleeding = Question.FALSE;
	}
	public Question isGenialTractBleeding() {
		return genialTractBleeding;
	}
	public void setMenstrualCycleDisorder(boolean menstrualCycleDisorder) {
		if (menstrualCycleDisorder) {
			this.menstrualCycleDisorder = Question.TRUE;
		} else
			this.menstrualCycleDisorder = Question.FALSE;
	}
	public Question isMenstrualCycleDisorder() {
		return menstrualCycleDisorder;
	}
	public void setHeadAcheQuestions(boolean headAcheQuestions) {
		if (headAcheQuestions) {
			this.headAcheQuestions = Question.TRUE;
		} else
			this.headAcheQuestions = Question.FALSE;
	}
	public Question isHeadAcheQuestions() {
		return headAcheQuestions;
	}
	public void setSinusesAche(boolean sinusesAche) {
		if (sinusesAche) {
			this.sinusesAche = Question.TRUE;
		} else
			this.sinusesAche = Question.FALSE;
	}
	public Question isSinusesAche() {
		return sinusesAche;
	}
	public void setEarsAche(boolean earsAche) {
		if (earsAche) {
			this.earsAche = Question.TRUE;
		} else
			this.earsAche = Question.FALSE;
	}
	public Question isEarsAche() {
		return earsAche;
	}
	public void setBlockedUpEars(boolean blockedUpEars) {
		if (blockedUpEars) {
			this.blockedUpEars = Question.TRUE;
		} else
			this.blockedUpEars = Question.FALSE;
	}
	public Question isBlockedUpEars() {
		return blockedUpEars;
	}
	public void setMigraine(boolean migraine) {
		if (migraine) {
			this.migraine = Question.TRUE;
		} else
			this.migraine = Question.FALSE;
	}
	public Question isMigraine() {
		return migraine;
	}
	public void setNeuralgia(boolean neuralgia) {
		if (neuralgia) {
			this.neuralgia = Question.TRUE;
		} else
			this.neuralgia = Question.FALSE;
	}
	public Question isNeuralgia() {
		return neuralgia;
	}
	public void setDiabetes(boolean diabetes) {
		if (diabetes) {
			this.diabetes = Question.TRUE;
		} else
			this.diabetes = Question.FALSE;
	}
	public Question isDiabetes() {
		return diabetes;
	}
	
}
