package com.cerner.devessentials.TargetHearRate;

import org.junit.Assert;
import org.junit.Test;

import com.cerner.devessentials.TargetHeartRate.heartRateRange;
import com.cerner.system.exception.VerifyException;

public class heartRateRangeTest {

	// test to have a constructor take min and max at the same time
	@Test
	public void constructor() {
		int min = 1;
		int max = 2;
		heartRateRange range = new heartRateRange(min, max);

		Assert.assertEquals(range.getMinimum(), min);
		Assert.assertEquals(range.getMaximum(), max);
	}

	@Test
	public void minLessThanMax() {
		int min = 1;
		int max = 2;
		heartRateRange range = new heartRateRange(min, max);

		Assert.assertEquals(range.getMinimum(), min);
		Assert.assertEquals(range.getMaximum(), max);
	}

	@Test(expected = VerifyException.class)
	public void minEqualToMax() {
		int min = 1;
		int max = 1;
		heartRateRange range = new heartRateRange(min, max);
	}

	@Test(expected = VerifyException.class)
	public void minBiggerThanMax() {
		int min = 2;
		int max = 1;
		heartRateRange range = new heartRateRange(min, max);
	}
}
