package tppe.campeonato;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestResultProcessorByRound.class, TestScheduleRounds.class, TestTeamClass.class})
public class AllTests {
    
}
