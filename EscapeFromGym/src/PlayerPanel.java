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

        add(new JLabel("Shoulder:"));
        lblShoulderVal = createStatusLabel();
        add(lblShoulderVal);

        add(new JLabel("Back:"));
        lblBackVal = createStatusLabel();
        add(lblBackVal);

        add(new JLabel("Chest:"));
        lblChestVal = createStatusLabel();
        add(lblChestVal);

        add(new JLabel("Arm:"));
        lblArmVal = createStatusLabel();
        add(lblArmVal);

        add(new JLabel("Leg:"));
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
            label.setText("ON");
            label.setBackground(new Color(144, 238, 144));
            label.setForeground(new Color(0, 100, 0));
        } else {
            label.setText("OFF");
            label.setBackground(Color.LIGHT_GRAY);
            label.setForeground(Color.DARK_GRAY);
        }
    }
}
