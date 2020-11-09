package Chapter13_Command_Pattern;

/**
 * Commandパターン。
 *
 * Commandパターンに則ったクラスであれば、そのクラスのことを完全に知らなくても、
 * execute()を呼び出すだけで、処理を実行できる。
 */
public interface Command {
    public void execute() throws Exception;
}
