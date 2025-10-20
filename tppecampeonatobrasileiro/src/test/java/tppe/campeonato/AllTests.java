package tppe.campeonato;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestResultProcessorByRound.class, 
    TestCompetition.class, 
    TestTeamClass.class, 
    TestClassification.class,
})
public class AllTests {
    
}
