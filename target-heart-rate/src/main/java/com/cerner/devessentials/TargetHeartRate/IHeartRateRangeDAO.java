package com.cerner.devessentials.TargetHeartRate;

import com.cerner.system.exception.VerifyException;

public interface IHeartRateRangeDAO {
	/**
	 * Given an age of a person, this will return the recommended range for that
	 * person
	 * 
	 * @param age
	 *            -the age of the person. must be greater than 0.
	 * 
	 * @return a {@link heartRateRange} containing the recommended range.
	 * 
	 * @throws VerifyException
	 *             if parameter conditions are not met.
	 * @throws AgeOutOfBoundsException
	 *             if age is over 70.
	 */

	public heartRateRange getHeartRateRange(int age) throws AgeOutOfBoundsException;
}
