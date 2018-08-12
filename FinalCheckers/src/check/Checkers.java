package check;

import javax.swing.*;
import java.awt.event.*;

public class Checkers extends JFrame {

    public Checkers() {
        initComp();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComp() {
        p = new JPanel();
        String[] options = {"8x8", "10x10"};
        cb = new JComboBox(options);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb.getSelectedIndex() == 0) {
                    new BoardFrame(8).setVisible(true); // 8x8
                    dispose(); // kleinei kai eksafanizei to arxiko JFrame 
                } else {
                    new BoardFrame(10).setVisible(true); // 10X10
                    dispose(); // kleinei kai eksafanizei to arxiko JFrame 
                }
            }
        });
        p.add(cb);
        add(p);
        pack();
    }

    public static void main(String[] args) {
        new Checkers().setVisible(true);
    }

    private JPanel p;
    private JComboBox cb;
}
