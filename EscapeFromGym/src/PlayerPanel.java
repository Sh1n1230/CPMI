import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
    private JLabel lblShoulderVal;
    private JLabel lblBackVal;
    private JLabel lblChestVal;
    private JLabel lblArmVal;
    private JLabel lblLegVal;

    public PlayerPanel() {
        setLayout(new GridLayout(5, 2, 10, 10));
        setBorder(BorderFactory.createTitledBorder("Player Status"));

        add(new JLabel("肩: "));
        lblShoulderVal = createStatusLabel();
        add(lblShoulderVal);

        add(new JLabel("背中: "));
        lblBackVal = createStatusLabel();
        add(lblBackVal);

        add(new JLabel("胸: "));
        lblChestVal = createStatusLabel();
        add(lblChestVal);

        add(new JLabel("腕: "));
        lblArmVal = createStatusLabel();
        add(lblArmVal);

        add(new JLabel("脚: "));
        lblLegVal = createStatusLabel();
        add(lblLegVal);
    }

    private JLabel createStatusLabel() {
        JLabel label = new JLabel("");
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(Color.LIGHT_GRAY);
        return label;
    }

    /**
     * PlayerStatusオブジェクトを受け取り、画面を更新する
     * 
     * @param status PlayerStatus
     */
    public void updateView(PlayerStatus status) {
        setStatusStyle(lblShoulderVal, status.getShoulderVal());
        setStatusStyle(lblBackVal, status.getBackVal());
        setStatusStyle(lblChestVal, status.getChestVal());
        setStatusStyle(lblArmVal, status.getArmVal());
        setStatusStyle(lblLegVal, status.getLegVal());
    }

    private void setStatusStyle(JLabel label, boolean isActive) {
        if (isActive) {
            label.setText("強い");
            label.setBackground(new Color(144, 238, 144));
            label.setForeground(new Color(0, 100, 0));
        } else {
            label.setText("弱い");
            label.setBackground(Color.LIGHT_GRAY);
            label.setForeground(Color.DARK_GRAY);
        }
    }
}
