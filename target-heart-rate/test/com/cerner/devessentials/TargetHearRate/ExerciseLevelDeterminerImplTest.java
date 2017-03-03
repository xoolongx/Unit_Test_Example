package com.cerner.devessentials.TargetHearRate;

import org.junit.Assert;
import org.junit.Test;

import com.cerner.devessentials.TargetHeartRate.ExerciseLevel;
import com.cerner.devessentials.TargetHeartRate.ExerciseLevelDeterminerImpl;
import com.cerner.devessentials.TargetHeartRate.heartRateRange;
import com.cerner.system.exception.VerifyException;

public class ExerciseLevelDeterminerImplTest {
	// Negative HR test
	@Test(expected = VerifyException.class)
	public void determineExerciseLevel_negativeCurrentHeartRate() {
		int currentHeartRate = -4;
		heartRateRange range = new heartRateRange(1, 2);

		ExerciseLevelDeterminerImpl determiner = new ExerciseLevelDeterminerImpl();
		ExerciseLevel result = determiner.determineExerciseLevel(currentHeartRate, range);

	}

	// 0 HR test

	// null range test
	// below test
	// within test

	// above test
	// given a current heart rate and a range,with current heart rate bigger
	// than the range maximum, then ABOVE is returned
	@Test
	public void determineExerciseLevel_above() {
		int currentHeartRate = 4;
		heartRateRange range = new heartRateRange(2, 3);

		ExerciseLevelDeterminerImpl determiner = new ExerciseLevelDeterminerImpl();
		ExerciseLevel result = determiner.determineExerciseLevel(currentHeartRate, range);

		ExerciseLevel expected = ExerciseLevel.ABOVE;

		Assert.assertEquals(expected, result);

	}

	@Test
	public void determineExerciseLevel_below() {
		int currentHeartRate = 1;
		heartRateRange range = new heartRateRange(2, 3);

		ExerciseLevelDeterminerImpl determiner = new ExerciseLevelDeterminerImpl();
		ExerciseLevel result = determiner.determineExerciseLevel(currentHeartRate, range);

		ExerciseLevel expected = ExerciseLevel.BELOW;

		Assert.assertEquals(expected, result);

	}

	@Test
	public void determineExerciseLevel_within() {
		int currentHeartRate = 3;
		heartRateRange range = new heartRateRange(2, 4);

		ExerciseLevelDeterminerImpl determiner = new ExerciseLevelDeterminerImpl();
		ExerciseLevel result = determiner.determineExerciseLevel(currentHeartRate, range);

		ExerciseLevel expected = ExerciseLevel.WITHIN;

		Assert.assertEquals(expected, result);

	}
}
