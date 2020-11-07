package Chapter15_Mediator_Pattern;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * QuickEntryMediator:このクラスはJTextFieldとJListを受け取る。
 * ユーザーが文字をJTextFieldに打ち込むことを仮定している。
 * JTextFieldに撃ち込まれた頭文字に一致するJListの最初の要素を自動的に見つけ出す。
 * JTextFieldがnullだったり、打ち込まれた文字列がJListに登録されていない場合は、
 * JListの選択肢はクリアされる。このオブジェクトを呼び出すメソッドは存在しない。
 * オブジェクトを作成した後は忘れてしまって良い(しかしガベージコレクションされて
 * しまわない様にしよう)
 *
 * 例:
 * JTextField t = new JTextField();
 * JList l = new JList();
 * QuickEntryMediator qem = new QuickEntryMediator(t, 1); // これで全て
 */

/**
 * JListとJTextFieldのユーザーはQuickEntryMediatorの存在を知らない。
 * ひっそりと陰でJListとJTextFieldに方針を課している
 *
 * 方針が大きく見える様にしておく必要があって上から方針を課したい→Facadeパターン
 * 日明示的に方針を課したい→Mediatorパターン
 *
 * Facadeの場合は、Facade以下のオブジェクトは必ずFacadeを経由して扱わなくてはだめ
 * Mediatorは約束事というより、すでに起こってしまっていて、強制的に受け入れなければならない事実
 */

public class QuickEntryMediator {
    public QuickEntryMediator(JTextField t, JList l) {
        itsTextField = t;
        itsList = l;
        itsTextField.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        textFieldChanged();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        textFieldChanged();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        textFieldChanged();
                    }
                }
        );
    }

    private void textFieldChanged() {
        String prefix = itsTextField.getText();
        if (prefix.length() == 0) {
            itsList.clearSelection();
            return;
        }
        ListModel m = itsList.getModel();
        boolean found = false;
        for ( int i = 0; found == false && i < m.getSize(); i++) {
            Object o = m.getElementAt(i);
            String s = o.toString();
            if (s.startsWith(prefix)) {
                itsList.setSelectedValue(o, true);
                found = true;
            }
            if (!found) {
                itsList.clearSelection();
            }
        }
    }

    private JTextField itsTextField;
    private JList itsList;
}
