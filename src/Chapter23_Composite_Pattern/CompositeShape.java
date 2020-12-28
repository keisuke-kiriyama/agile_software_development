package Chapter23_Composite_Pattern;

import java.util.Vector;

/*
1対多の振る舞いを1対多の関係を用いずに扱うことができる。
Compositeパターンの候補になるのは、リスト中の全てのオブジェクトが全く等価に取り扱われるものだけに限られる。
 */
public class CompositeShape implements Shape {
    private Vector itsShapes = new Vector();
    public void add(Shape s) {
        itsShapes.add(s);
    }
    public void draw() {
        for (int i = 0; i < itsShapes.size(); i++) {
            Shape shape = (Shape) itsShapes.elementAt(i);
            shape.draw();
        }
    }
}
