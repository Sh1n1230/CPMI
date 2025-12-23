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

    private String[] currentMessages;
    private int currentIndex;

    // 追加: MainViewPanelへの参照を保持するフィールド
    private MainViewPanel mainViewPanel;

    // 変更: コンストラクタでMainViewPanelを受け取る
    public TextPanel(MainViewPanel mainViewPanel) {
        this.mainViewPanel = mainViewPanel; // 参照を保持

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
        cornerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 15));
        add(cornerLabel, BorderLayout.SOUTH);

        // 3. アニメーション用タイマーの作成
        cursorTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isCursorDown) {
                    cornerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 15));
                } else {
                    cornerLabel.setBorder(BorderFactory.createEmptyBorder(6, 0, 4, 15));
                }
                isCursorDown = !isCursorDown;
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextMessage();
            }
        });
    }

    public void showMessages(int scenarioIndex) {
        this.currentMessages = EventText.getScenarioMessages(scenarioIndex);
        this.currentIndex = 0;

        if (this.currentMessages != null && this.currentMessages.length > 0) {
            textLabel.setText(this.currentMessages[currentIndex]);
            // 変更: MainViewPanel経由で表示を切り替える
            // setVisible(true);
            mainViewPanel.setTextPanelVisible(true);

            cursorTimer.start();
        } else {
            System.out.println("エラー: 指定されたシナリオ番号 " + scenarioIndex + " にはメッセージが存在しません。");
            closePanel();
        }
    }

    public void showMessage2(String[] messages) {
        this.currentMessages = messages;
        this.currentIndex = 0;

        if (this.currentMessages != null && this.currentMessages.length > 0) {
            textLabel.setText(this.currentMessages[currentIndex]);
            // 変更: MainViewPanel経由で表示を切り替える
            // setVisible(true);
            mainViewPanel.setTextPanelVisible(true);

            cursorTimer.start();
        } else {
            closePanel();
        }
    }

    private void nextMessage() {
        currentIndex++;
        if (currentMessages != null && currentIndex < currentMessages.length) {
            textLabel.setText(currentMessages[currentIndex]);
        } else {
            closePanel();
        }
    }

    private void closePanel() {
        // 変更: MainViewPanel経由で非表示にする
        // setVisible(false);
        mainViewPanel.setTextPanelVisible(false);

        textLabel.setText("");
        cursorTimer.stop();
    }
}