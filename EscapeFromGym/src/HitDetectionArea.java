import java.awt.Rectangle;

public class HitDetectionArea {
    private String name;
    private ItemData itemData;
    private Rectangle bounds;

    /**
     * itemの当たり判定生成コンストラクタ
     */
    public HitDetectionArea(ItemData itemData, int x, int y, int w, int h) {
        this.itemData = itemData;
        this.bounds = new Rectangle(x, y, w, h);
        name = itemData.getName();
    }

    /**
     * 当たり判定生成コンストラクタ
     */
    public HitDetectionArea(String name, int x, int y, int w, int h) {
        this.name = name;
        this.itemData = null;
        this.bounds = new Rectangle(x, y, w, h);
    }

    /**
     * 当たり判定を含んでいるかの2値
     */
    public boolean contains(int x, int y) {
        return bounds.contains(x, y);
    }
}
