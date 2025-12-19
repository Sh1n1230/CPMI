import java.awt.Rectangle;

public class HitDetectionArea {
    private String name;
    private ItemData itemData;
    private Rectangle bounds;

    /**
     * itemの当たり判定生成コンストラクタ
     * nameはitemDataから直接取得
     * 
     * @param x 左上のx
     * @param y 左上のy
     * @param w 幅
     * @param h 高さ
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

    public String getName() {
        return name;
    }

    public ItemData getItemData() {
        return itemData;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
