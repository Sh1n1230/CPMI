package sample;

import javax.swing.*;

public class ImageDisplay {
    public static void main(String[] args) {
        // 1. フレームの作成
        JFrame frame = new JFrame("PNG Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // 2. 画像の読み込み (パスは適切に変更してください)
        // プロジェクト直下、または絶対パスを指定
        ImageIcon icon = new ImageIcon("./sample.png");

        // 3. ラベルに画像をセットしてフレームに追加
        JLabel label = new JLabel(icon);
        frame.add(label);

        // 4. 表示
        frame.setVisible(true);
    }
}