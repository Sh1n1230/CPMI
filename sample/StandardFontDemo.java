import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class StandardFontDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("標準フォントの使い分け");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(3, 1));

        // 1. ホラー・ミステリー風 (SERIF / 太字)
        JLabel labelHorror = new JLabel("「助けてくれ...」 (Serif / 明朝体)");
        labelHorror.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        labelHorror.setForeground(new Color(150, 0, 0)); // 暗い赤色で恐怖感をプラス
        labelHorror.setHorizontalAlignment(SwingConstants.CENTER);

        // 2. SF・システム風 (SANS_SERIF / 普通)
        JLabel labelSF = new JLabel("ACCESS GRANTED (SansSerif / ゴシック体)");
        labelSF.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        labelSF.setForeground(Color.BLUE);
        labelSF.setHorizontalAlignment(SwingConstants.CENTER);

        // 3. レトロ・暗号風 (MONOSPACED / 太字)
        JLabel labelRetro = new JLabel("CODE: 4892 (Monospaced / 等幅)");
        labelRetro.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        labelRetro.setOpaque(true);
        labelRetro.setBackground(Color.BLACK); // 黒背景
        labelRetro.setForeground(Color.GREEN); // 緑文字でハッカー風
        labelRetro.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(labelHorror);
        frame.add(labelSF);
        frame.add(labelRetro);

        frame.setVisible(true);
    }
}
