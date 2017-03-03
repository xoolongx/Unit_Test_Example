package com.cerner.devessentials.TargetHeartRate;

import com.cerner.system.exception.Verifier;

public class heartRateRange {
	// constructor to take min and max.
	// remove setters
	// min and max should be positive
	// max >min
	private final int minimum;
	private final int maximum;

	public heartRateRange(int min, int max) {
		Verifier.verifyTrue(min < max);
		this.minimum = min;
		this.maximum = max;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}

}
