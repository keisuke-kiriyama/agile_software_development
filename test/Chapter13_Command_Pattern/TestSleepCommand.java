package Chapter13_Command_Pattern;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestSleepCommand extends TestCase {
    public static void main(String[] args) {
        TestRunner.main(new String[]{"TestSleepCommand"});
    }
    public TestSleepCommand(String name) {
        super(name);
    }
    private boolean commandExecuted = false;
    public void testSleep() throws Exception {
        Command wakeup = new Command() {
            public void execute() {commandExecuted = true;}
        };
        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, e, wakeup);
        e.addCommand(c);
        long start = System.currentTimeMillis();
        e.run();
        long stop = System.currentTimeMillis();
        long sleepTime = (stop - start);
        assertThat("SleepTime " + sleepTime + " expected > 1000", sleepTime > 1000);
        assertThat("SleepTime " + sleepTime + " expected < 1100", sleepTime > 1100);
        assertThat("Command Executed", commandExecuted);
    }
}