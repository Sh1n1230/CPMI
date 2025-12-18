import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class EscapeGameClickDemo extends JPanel {

    // クリック可能なエリアを管理するクラス（内部クラス）
    private class ClickableArea {
        String name; // アイテム名やアクション名
        Rectangle bounds; // 当たり判定の範囲

        public ClickableArea(String name, int x, int y, int w, int h) {
            this.name = name;
            this.bounds = new Rectangle(x, y, w, h);
        }
    }

    // エリアのリスト
    private List<ClickableArea> clickables = new ArrayList<>();
    private String message = "部屋があります。怪しいところをクリックしてください。";

    public EscapeGameClickDemo() {
        setPreferredSize(new Dimension(600, 400));

        // ★ここで「当たり判定」を登録します
        // 実際のゲームでは、背景画像の「鍵」や「窓」の位置に合わせます
        clickables.add(new ClickableArea("鍵", 50, 300, 40, 20)); // 床に落ちている鍵
        clickables.add(new ClickableArea("ドア", 200, 50, 150, 250)); // 大きなドア
        clickables.add(new ClickableArea("金庫", 450, 200, 80, 80)); // 机の上の金庫

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkClick(e.getX(), e.getY());
            }
        });
    }

    // クリック判定処理
    private void checkClick(int x, int y) {
        boolean hitSomething = false;

        // 登録されている全てのエリアを走査して、クリック位置が含まれるか確認
        for (ClickableArea area : clickables) {
            if (area.bounds.contains(x, y)) {
                // ヒットした場合の処理
                message = "「" + area.name + "」をクリックしました！";
                hitSomething = true;

                // 例：鍵ならアイテムリストに追加する処理などをここに書く
                if (area.name.equals("鍵")) {
                    // getKey();
                }
                break; // 重なりがなければ、見つかった時点でループを抜ける
            }
        }

        if (!hitSomething) {
            message = "そこには何もありません。";
        }
        repaint(); // 画面更新
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. 背景描画（ここでは仮に塗りつぶし）
        g.setColor(new Color(240, 240, 220));
        g.fillRect(0, 0, getWidth(), getHeight());

        // 2. デバッグ用：当たり判定を赤枠で表示
        // ※完成したゲームではこのブロックを削除またはコメントアウトして「透明」にします
        g.setColor(Color.RED);
        for (ClickableArea area : clickables) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2)); // 線を太く
            g2.draw(area.bounds);
            g2.drawString(area.name, area.bounds.x, area.bounds.y - 5);
        }

        // 3. メッセージ表示
        g.setColor(Color.BLACK);
        g.setFont(new Font("Meiryo", Font.BOLD, 16));
        g.drawString(message, 20, 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("脱出ゲーム クリック判定テスト");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new EscapeGameClickDemo());
        frame.pack();
        frame.setVisible(true);
    }
}
