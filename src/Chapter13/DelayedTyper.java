package Chapter13;

public class DelayedTyper implements Command {
    private final long itsDelay;
    private final char itsChar;
    private static final ActiveObjectEngine engine = new ActiveObjectEngine();
    private static boolean stop = false;
    public static void main(String[] args) {
        engine.addCommand(new DelayedTyper(100, '1'));
        engine.addCommand(new DelayedTyper(300, '3'));
        engine.addCommand(new DelayedTyper(500, '5'));
        engine.addCommand(new DelayedTyper(700, '7'));
        Command stopCommand = new Command() {
            public void execute() {stop=true;}
        };
        engine.addCommand(new SleepCommand(2000, engine, stopCommand));

        // 1.この段階で[DelayedTyper(1),DelayedTyper(3),DelayedTyper(5),DelayedTyper(7),SleepCommand]

        // 2. 一つ目実行
        engine.run();
    }

    public DelayedTyper(long delay, char c) {
        itsDelay = delay;
        itsChar = c;
    }

    @Override
    public void execute() throws Exception {
        // 3. １文字目出力
        System.out.print(itsChar);
        if (!stop) {
            delayAndRepeat();
        }
    }

    private void delayAndRepeat() throws Exception {
        engine.addCommand(new SleepCommand(itsDelay, engine, this));
    }
}
