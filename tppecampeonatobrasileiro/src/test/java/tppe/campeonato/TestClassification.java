package tppe.campeonato;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestTieBreakerByVictory.class, TestTieBreakerByDifferenceOfGoals.class, TestTieBreakerByCards.class})
public class TestClassification {

}