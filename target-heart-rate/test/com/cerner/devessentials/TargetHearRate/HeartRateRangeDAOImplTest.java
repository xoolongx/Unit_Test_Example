package com.cerner.devessentials.TargetHearRate;

import org.junit.Assert;
import org.junit.Test;

import com.cerner.devessentials.TargetHeartRate.AgeOutOfBoundsException;
import com.cerner.devessentials.TargetHeartRate.HeartRateRangeDAOImpl;
import com.cerner.devessentials.TargetHeartRate.heartRateRange;

public class HeartRateRangeDAOImplTest {
	// lots of boundaries
	// for age = 45 boundary, I need a 45 and a 44 test.
	// 44 would =minimumHeartRate = 90
	@Test
	public void getHeartRateRange_age45_lower() {
		int age = 44;
		heartRateRange expected = new heartRateRange(90, 153);

		HeartRateRangeDAOImpl dao = new HeartRateRangeDAOImpl();
		heartRateRange result;
		try {
			result = dao.getHeartRateRange(age);
			Assert.assertEquals(expected.getMaximum(), result.getMaximum());
			Assert.assertEquals(expected.getMinimum(), result.getMinimum());
		} catch (AgeOutOfBoundsException e) {
			Assert.fail();

		}

	}

	@Test
	public void getHeartRateRange_age70() throws AgeOutOfBoundsException {
		int age = 70;
		heartRateRange expected = new heartRateRange(75, 128);
		HeartRateRangeDAOImpl dao = new HeartRateRangeDAOImpl();
		heartRateRange result = dao.getHeartRateRange(age);
		Assert.assertEquals(expected.getMaximum(), result.getMaximum());
		Assert.assertEquals(expected.getMinimum(), result.getMinimum());

	}

	@Test(expected = AgeOutOfBoundsException.class)
	public void getHeartRateRange_ageOutOfBoundExeption() throws AgeOutOfBoundsException {
		int age = 71;
		// no expected range.

		HeartRateRangeDAOImpl dao = new HeartRateRangeDAOImpl();
		dao.getHeartRateRange(age);

	}

}
