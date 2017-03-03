package com.cerner.devessentials.TargetHeartRate;

import com.cerner.system.exception.Verifier;

public class ExerciseLevelDeterminerImpl implements IExerciseLevelDeterminer {

	public ExerciseLevel determineExerciseLevel(int currentHeartRate, heartRateRange Range) {
		// if current heart rate <min, im blow
		//
		// TODO Auto-generated method stub

		Verifier.verifyPositive(currentHeartRate);
		Verifier.verifyNotNull(Range);

		if (currentHeartRate < Range.getMinimum())
			return ExerciseLevel.BELOW;
		else if (currentHeartRate > Range.getMaximum())
			return ExerciseLevel.ABOVE;
		else
			return ExerciseLevel.WITHIN;
	}

}
