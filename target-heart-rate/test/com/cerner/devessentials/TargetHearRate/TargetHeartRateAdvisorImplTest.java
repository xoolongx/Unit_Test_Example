package com.cerner.devessentials.TargetHearRate;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.cerner.devessentials.TargetHeartRate.AgeOutOfBoundsException;
import com.cerner.devessentials.TargetHeartRate.ExerciseLevel;
import com.cerner.devessentials.TargetHeartRate.IExerciseLevelDeterminer;
import com.cerner.devessentials.TargetHeartRate.IHeartRateRangeDAO;
import com.cerner.devessentials.TargetHeartRate.TargetHeartRateAdvisorImpl;
import com.cerner.devessentials.TargetHeartRate.heartRateRange;

public class TargetHeartRateAdvisorImplTest {

	@Test
	public void adviseExerciseLevel_below() throws AgeOutOfBoundsException {
		String expected = "You need to go faster!";
		int age = 32;
		int currentHeartRate = 92;

		IHeartRateRangeDAO mockDAO = Mockito.mock(IHeartRateRangeDAO.class);
		heartRateRange range = new heartRateRange(90, 120);

		Mockito.when(mockDAO.getHeartRateRange(age)).thenReturn(range);
		IExerciseLevelDeterminer mockDeterminer = Mockito.mock(IExerciseLevelDeterminer.class);
		ExerciseLevel exerciseLevel = ExerciseLevel.BELOW;
		Mockito.when(mockDeterminer.determineExerciseLevel(currentHeartRate, range)).thenReturn(exerciseLevel);

		TargetHeartRateAdvisorImpl advisor = new TargetHeartRateAdvisorImpl(mockDAO, mockDeterminer);

		String result = advisor.adviseExerciseLevel(age, currentHeartRate);

		Assert.assertTrue(expected.equals(result));

	}

	@Test
	public void adviseExerciseLevel_above() throws AgeOutOfBoundsException {
		String expected = "Slow Down!";
		int age = 32;
		int currentHeartRate = 92;

		IHeartRateRangeDAO mockDAO = Mockito.mock(IHeartRateRangeDAO.class);
		heartRateRange range = new heartRateRange(90, 120);

		Mockito.when(mockDAO.getHeartRateRange(age)).thenReturn(range);
		IExerciseLevelDeterminer mockDeterminer = Mockito.mock(IExerciseLevelDeterminer.class);
		ExerciseLevel exerciseLevel = ExerciseLevel.ABOVE;
		Mockito.when(mockDeterminer.determineExerciseLevel(currentHeartRate, range)).thenReturn(exerciseLevel);

		TargetHeartRateAdvisorImpl advisor = new TargetHeartRateAdvisorImpl(mockDAO, mockDeterminer);

		String result = advisor.adviseExerciseLevel(age, currentHeartRate);

		Assert.assertTrue(expected.equals(result));

	}

	@Test
	public void adviseExerciseLevel_within() throws AgeOutOfBoundsException {
		String expected = "Stay at this pace!";
		int age = 32;
		int currentHeartRate = 92;

		IHeartRateRangeDAO mockDAO = Mockito.mock(IHeartRateRangeDAO.class);
		heartRateRange range = new heartRateRange(90, 120);

		Mockito.when(mockDAO.getHeartRateRange(age)).thenReturn(range);
		IExerciseLevelDeterminer mockDeterminer = Mockito.mock(IExerciseLevelDeterminer.class);
		ExerciseLevel exerciseLevel = ExerciseLevel.WITHIN;
		Mockito.when(mockDeterminer.determineExerciseLevel(currentHeartRate, range)).thenReturn(exerciseLevel);

		TargetHeartRateAdvisorImpl advisor = new TargetHeartRateAdvisorImpl(mockDAO, mockDeterminer);

		String result = advisor.adviseExerciseLevel(age, currentHeartRate);

		Assert.assertTrue(expected.equals(result));

	}

	@Test
	public void adviseExerciseLevel_unable() throws AgeOutOfBoundsException {

		String expected = "Unable to determine the exercise level";
		int age = 10;
		int currentHeartRate = 12;

		IHeartRateRangeDAO mockDAO = Mockito.mock(IHeartRateRangeDAO.class);
		heartRateRange range = Mockito.mock(heartRateRange.class);
		Mockito.when(mockDAO.getHeartRateRange(age)).thenReturn(range);

		IExerciseLevelDeterminer mockDeterminer = Mockito.mock(IExerciseLevelDeterminer.class);
		ExerciseLevel exerciseLevel = null;
		Mockito.when(mockDeterminer.determineExerciseLevel(currentHeartRate, range)).thenReturn(exerciseLevel);

		TargetHeartRateAdvisorImpl advisor = new TargetHeartRateAdvisorImpl(mockDAO, mockDeterminer);

		String result = advisor.adviseExerciseLevel(age, currentHeartRate);

		Assert.assertTrue(expected.equals(result));

	}

}
