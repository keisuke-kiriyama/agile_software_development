package Chapter13;

import java.util.LinkedList;

public class ActiveObjectEngine {
    LinkedList<Command> itsCommands = new LinkedList<Command>();
    public void addCommand(Command c) {
        itsCommands.add(c);
    }

    public void run() {
        while(!itsCommands.isEmpty()) {
            Command c = itsCommands.getFirst();
            itsCommands.removeFirst();
        }
    }
}
