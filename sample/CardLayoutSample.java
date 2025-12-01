package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutSample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 1. 親パネルを作り、CardLayoutを設定する
        CardLayout cardLayout = new CardLayout();
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(cardLayout);

        // 2. 切り替える中身のパネル（カード）を作る
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.CYAN);
        panel1.add(new JLabel("これは画面 1 です"));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.PINK);
        panel2.add(new JLabel("こちらは画面 2 です"));

        // 3. 親パネルに追加する (必ず「名前」をつける！)
        parentPanel.add(panel1, "Screen1");
        parentPanel.add(panel2, "Screen2");

        // --- 切り替えボタンの設置 ---
        JButton switchButton = new JButton("切り替え");
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 4. 次のカードへめくる
                cardLayout.next(parentPanel);

                // 特定の画面を指定したい場合はこう書きます：
                // cardLayout.show(parentPanel, "Screen2");
            }
        });

        // フレームへの配置
        frame.add(parentPanel, BorderLayout.CENTER);
        frame.add(switchButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}