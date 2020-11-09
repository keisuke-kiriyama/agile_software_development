package Chapter13_Command_Pattern;

public class SleepCommand  implements  Command {
    private Command wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;
    public SleepCommand(long milliseconds, ActiveObjectEngine e, Command wakeupCommand) {
        sleepTime = milliseconds;
        engine = e;
        this.wakeupCommand = wakeupCommand;
    }

    @Override
    public void execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (!started) {
            started = true;
            startTime = currentTime;
            engine.addCommand(this);
        } else if ((currentTime - startTime) < sleepTime){
            // executeメソッドが呼ばれて、まだ時間が経過していなかったら、再度登録
            engine.addCommand(this);
        } else {
            // 時間が立った段階のexecuteメソッド実行でwakeupCommandが実行される
            engine.addCommand(wakeupCommand);
        }
    }
}
