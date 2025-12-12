import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextPanel extends JPanel {

    private JLabel textLabel;
    private JLabel cornerLabel;
    private Timer cursorTimer;
    private boolean isCursorDown = false;

    private String[] currentMessages; // 現在表示中のメッセージ配列
    private int currentIndex; // 現在表示中のメッセージのインデックス

    // allScenarios のフィールド変数は不要になりました。

    public TextPanel() {
        // --- データ定義は EventText.java に移動しました ---

        // パネルの見た目設定
        setPreferredSize(new Dimension(800, 120));

        setBackground(new Color(10, 0, 0));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setVisible(false);

        // 1. 中央のメインテキスト設定
        textLabel = new JLabel();
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("MS Gothic", Font.BOLD, 18));
        textLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        textLabel.setVerticalAlignment(JLabel.TOP);
        add(textLabel, BorderLayout.CENTER);

        // 2. 右下の固定文字ラベル設定
        cornerLabel = new JLabel("Click here💪");
        cornerLabel.setForeground(Color.WHITE);
        cornerLabel.setFont(new Font("MS Gothic", Font.PLAIN, 24));
        cornerLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // 初期位置（上:0, 下:10）
        cornerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 15));

        add(cornerLabel, BorderLayout.SOUTH);

        // 3. アニメーション用タイマーの作成
        // 500ミリ秒（0.5秒）ごとに波括弧の中を実行
        cursorTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isCursorDown) {
                    // 上に戻す (元の位置)
                    cornerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 15));
                } else {
                    // 下にずらす (上余白を増やして、下余白を減らす)
                    cornerLabel.setBorder(BorderFactory.createEmptyBorder(6, 0, 4, 15));
                }
                // 状態を反転
                isCursorDown = !isCursorDown;
            }
        });

        // クリックで次のメッセージへ
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextMessage();
            }
        });
    }

    /**
     * 指定されたシナリオIDのメッセージを表示開始します。
     * EventText.java に定義された定数（例: EventText.SCENARIO_EVENT_ROOM）を使用します。
     * 
     * @param scenarioIndex EventText.java に定義されたシナリオID
     */
    public void showMessages(int scenarioIndex) {
        // EventText クラスからメッセージを取得
        this.currentMessages = EventText.getScenarioMessages(scenarioIndex);
        this.currentIndex = 0;

        if (this.currentMessages != null && this.currentMessages.length > 0) {
            textLabel.setText(this.currentMessages[currentIndex]);
            setVisible(true);

            // パネルが表示されたらアニメーション開始
            cursorTimer.start();
        } else {
            System.out.println("エラー: 指定されたシナリオ番号 " + scenarioIndex + " にはメッセージが存在しません。");
            closePanel(); // メッセージがない場合はパネルを閉じます
        }
    }

    public void showMessage2(String[] messages) {
        this.currentMessages = messages;
        this.currentIndex = 0;

        if (this.currentMessages != null && this.currentMessages.length > 0) {
            textLabel.setText(this.currentMessages[currentIndex]);
            setVisible(true);

            // パネルが表示されたらアニメーション開始
            cursorTimer.start();
        } else {
            closePanel(); // メッセージがない場合はパネルを閉じます
        }
    }

    private void nextMessage() {
        currentIndex++;
        if (currentMessages != null && currentIndex < currentMessages.length) {
            textLabel.setText(currentMessages[currentIndex]);
        } else {
            // 全てのメッセージを表示し終えたらパネルを閉じる
            closePanel();
        }
    }

    private void closePanel() {
        setVisible(false);
        textLabel.setText("");

        // パネルが閉じたらアニメーション停止
        cursorTimer.stop();
    }

    // 【補足】もし背景透過バグ（色が濃くなる）が再発した場合は、
    // 以下の paintComponent メソッドを有効にしてください。
    /*
     * @Override
     * protected void paintComponent(Graphics g) {
     * // 親クラスの処理を呼ぶことで背景を初期化します。
     * // setOpaque(true) の場合のみ必要です。
     * // super.paintComponent(g);
     * 
     * // 背景色を指定
     * g.setColor(getBackground());
     * g.fillRect(0, 0, getWidth(), getHeight());
     * }
     */
}