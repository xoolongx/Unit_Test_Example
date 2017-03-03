#include <string>

using namespace std;

// Base clase for a TargetHeartRateAvisor.
// 
// author FS022367
class TargetHeartRateAdvisor
{
    // Determines the appropriate exercise level based on the persons age and
    // current heart rate. This function will advise the person to either
    // increase, decrease, or maintain their level of exertion based on these
    // numbers.
    // 
    // @return A string telling the person what to do.
    public :
		string adviseExerciseLevel()
			{
				if (_currentHeartRate < _minimumHeartRate)
				{
					return "You need to go faster!";
				}
				else if (_currentHeartRate > _maximumHeartRate)
				{
					return "Unable to determine exercise level.";
				}
				else
				{
					return "Stay at this pace!";
				}
			}
	
	// Instructors note
    // Lots of global state variables are generally a warning sign.
	protected: 
	    int _currentHeartRate;
		int _minimumHeartRate;
		int _maximumHeartRate;
};

// Implementation of a {@link TargetHeartRateAdvisor}.
// 
// @author FS022367
class TargetHeartRateAdvisorImpl: public TargetHeartRateAdvisor
{
    // Constructor for {@link TargetHeartRateAdvisorImpl}.
    public:
		TargetHeartRateAdvisorImpl(int age, int currentHeartRate)
		{
			_currentHeartRate = currentHeartRate;

			// Instructors note
			// Constructor does a lot of heavy lifting here.
			if (age < 30)
			{
				_minimumHeartRate = 100;
				_maximumHeartRate = 170;
			}
			else if (age < 35)
			{
				_minimumHeartRate = 95;
				_maximumHeartRate = 162;
			}
			else if (age < 40)
			{
				_minimumHeartRate = 93;
				_maximumHeartRate = 157;
			}
			else if (age < 45)
			{
				_minimumHeartRate = 90;
				_maximumHeartRate = 153;
			}
			else if (age < 50)
			{
				_minimumHeartRate = 88;
				_maximumHeartRate = 149;
			}
			else if (age < 55)
			{
				_minimumHeartRate = 85;
				_maximumHeartRate = 145;
			}
			else if (age < 60)
			{
				_minimumHeartRate = 83;
				_maximumHeartRate = 140;
			}
			else if (age < 65)
			{
				_minimumHeartRate = 80;
				_maximumHeartRate = 136;
			}
			else if (age < 70)
			{
				_minimumHeartRate = 78;
				_maximumHeartRate = 132;
			}
			else if (age == 70)
			{
				_minimumHeartRate = 75;
				_maximumHeartRate = 128;
			}
		}		
};
