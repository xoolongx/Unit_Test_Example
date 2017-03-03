package com.cerner.devessentials.TargetHeartRate;

import com.cerner.system.exception.VerifyException;

public interface IExerciseLevelDeterminer {
	/**
	 * Determines where someone's exercise level is, based on their current
	 * heart rate and their recommended range.
	 * 
	 * @param currentHeartRate
	 *            - the person's current heart rate. must be greater than 0.
	 * 
	 * @param Range
	 *            - the recommended range for that person, must not be null.
	 * 
	 * @return A {@link ExerciseLevel} that tells them where they are with
	 *         respect to the range.
	 * @throws VerifyException
	 */
	public ExerciseLevel determineExerciseLevel(int currentHeartRate, heartRateRange Range);

}
