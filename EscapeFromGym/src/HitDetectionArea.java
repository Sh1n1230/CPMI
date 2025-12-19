import java.awt.Rectangle;

/**
 * 当たり判定はRectangleで表現している
 */
public class HitDetectionArea {
    private String name;
    private ItemData itemData;
    private Rectangle bounds;

    private ActionOnClick gameActionOnClick;

    /**
     * itemの当たり判定生成コンストラクタ
     * nameはitemDataから直接取得
     * 
     * @param itemData    ItemData
     * @param upperLeftX  左上のx
     * @param upperLeftY  左上のy
     * @param lowerRightX 右下のx
     * @param lowerRightY 右下のy
     */
    public HitDetectionArea(ItemData itemData, int upperLeftX, int upperLeftY, int lowerRightX, int lowerRightY,
            ActionOnClick gameActionOnClick) {
        this.itemData = itemData;
        this.bounds = new Rectangle(upperLeftX, upperLeftY, lowerRightX - upperLeftX, lowerRightY - upperLeftY);
        name = itemData.getName();
        this.gameActionOnClick = gameActionOnClick;
    }

    /**
     * 当たり判定生成コンストラクタ
     * 
     * @param name        名前
     * @param upperLeftX  左上のx
     * @param upperLeftY  左上のy
     * @param lowerRightX 右下のx
     * @param lowerRightY 右下のy
     */
    public HitDetectionArea(String name, int upperLeftX, int upperLeftY, int lowerRightX, int lowerRightY,
            ActionOnClick gameActionOnClick) {
        this.name = name;
        this.itemData = null;
        this.bounds = new Rectangle(upperLeftX, upperLeftY, lowerRightX - upperLeftX, lowerRightY - upperLeftY);
        this.gameActionOnClick = gameActionOnClick;
    }

    /**
     * 当たり判定を含んでいるかの2値
     */
    public boolean contains(int x, int y) {
        return bounds.contains(x, y);
    }

    public void onClick() {
        if (gameActionOnClick != null)
            gameActionOnClick.onClick();
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
