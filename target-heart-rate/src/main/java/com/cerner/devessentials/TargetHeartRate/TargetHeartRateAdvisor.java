package com.cerner.devessentials.TargetHeartRate;

/**
 * Interface for a TargetHeartRateAvisor.
 * 
 * @author FS022367
 *
 */
public interface TargetHeartRateAdvisor {
	/**
	 * Determines the appropriate exercise level based on the persons age and
	 * current heart rate. This function will advise the person to either
	 * increase, decrease, or maintain their level of exertion based on these
	 * numbers.
	 * 
	 * @param age
	 *            - the age of the person.
	 * 
	 * @param currentHeartRate
	 *            -the current heart rate of the person.
	 * 
	 * @return A string telling the person what to do.
	 * @throws AgeOutOfBoundsException
	 */
	public String adviseExerciseLevel(int age, int currentHeartRate) throws AgeOutOfBoundsException;
}
