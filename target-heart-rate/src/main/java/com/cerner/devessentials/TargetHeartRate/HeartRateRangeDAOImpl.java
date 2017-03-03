package com.cerner.devessentials.TargetHeartRate;

import com.cerner.system.exception.Verifier;

public class HeartRateRangeDAOImpl implements IHeartRateRangeDAO {

	public heartRateRange getHeartRateRange(int age) throws AgeOutOfBoundsException {

		// perform verification that age <=0
		Verifier.verifyPositive(age);

		int minimumHeartRate = 0;
		int maximumHeartRate = 0;

		if (age < 30) {
			minimumHeartRate = 100;
			maximumHeartRate = 170;
		} else if (age < 35) {
			minimumHeartRate = 95;
			maximumHeartRate = 162;
		} else if (age < 40) {
			minimumHeartRate = 93;
			maximumHeartRate = 157;
		} else if (age < 45) {
			minimumHeartRate = 90;
			maximumHeartRate = 153;
		} else if (age < 50) {
			minimumHeartRate = 88;
			maximumHeartRate = 149;
		} else if (age < 55) {
			minimumHeartRate = 85;
			maximumHeartRate = 145;
		} else if (age < 60) {
			minimumHeartRate = 83;
			maximumHeartRate = 140;
		} else if (age < 65) {
			minimumHeartRate = 80;
			maximumHeartRate = 136;
		} else if (age < 70) {
			minimumHeartRate = 78;
			maximumHeartRate = 132;
		} else if (age == 70) {
			minimumHeartRate = 75;
			maximumHeartRate = 128;
		} else {
			throw new AgeOutOfBoundsException();
		}

		heartRateRange range = new heartRateRange(minimumHeartRate, maximumHeartRate);
		return range;
	}

}
