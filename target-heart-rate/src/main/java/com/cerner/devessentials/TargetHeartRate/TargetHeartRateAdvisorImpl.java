package com.cerner.devessentials.TargetHeartRate;

import com.cerner.system.exception.Verifier;

/**
 * Implementation of a {@link TargetHeartRateAdvisor}.
 * 
 * @author FS022367
 *
 */
public class TargetHeartRateAdvisorImpl implements TargetHeartRateAdvisor {
	/**
	 * Constructor for {@link TargetHeartRateAdvisorImpl}.
	 * 
	 */
	private final IHeartRateRangeDAO heartRateRangeDAO;
	private final IExerciseLevelDeterminer determiner;

	public TargetHeartRateAdvisorImpl(IHeartRateRangeDAO heartRateRangeDAO, IExerciseLevelDeterminer determiner) {
		this.heartRateRangeDAO = heartRateRangeDAO;
		this.determiner = determiner;
	}

	// TODO heart rate not updated--DONE
	// TODO internationalization

	public String adviseExerciseLevel(int age, int currentHeartRate) throws AgeOutOfBoundsException {
		Verifier.verifyPositive(age);
		Verifier.verifyPositive(currentHeartRate);
		// TODO repeated range set may not be necessary.
		// TODO new Operator! i dont like that
		// TODO interface? impl? which one is good? do i care?
		// TODO Dependency Injection
		heartRateRange range = heartRateRangeDAO.getHeartRateRange(age);
		ExerciseLevel exerciseLevel = determiner.determineExerciseLevel(currentHeartRate, range);

		if (exerciseLevel == ExerciseLevel.BELOW) {
			return "You need to go faster!";
		} else if (exerciseLevel == ExerciseLevel.ABOVE) {
			return "Slow Down!";
		} else if (exerciseLevel == ExerciseLevel.WITHIN) {
			return "Stay at this pace!";
		} else {
			return "Unable to determine the exercise level";
		}
	}

}
