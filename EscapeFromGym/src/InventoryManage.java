public class InventoryManage {
    private final int capacity = 9;
    private int massitem = 0;
    private ItemData[] slots;

    public InventoryManage() {
        this.slots = new ItemData[capacity];
    }

    /**
     * 何も入っていないスペースを見つけてItemを追加する。
     */
    public void addItem(ItemData item) {
        for (int i = 0; i < capacity; i++) {
            if (slots[i] == null) {
                slots[i] = item;
                massitem++;
                break;
            }
        }
    }

    /**
     * Itemを取り出し、Inventoryを左詰めにする
     */
    public ItemData removeItem(int slotIndex) {
        if (slotIndex >= 0 && slotIndex < capacity && slots[slotIndex] != null) {
            ItemData removed = slots[slotIndex];
            slots[slotIndex] = null;
            // 左詰め処理
            for (int i = slotIndex; i < massitem; ++i) {
                if (i != capacity - 1) { // 8ではなくcapacity-1と書くのが安全
                    slots[i] = slots[i + 1];
                } else {
                    slots[i] = null;
                }
            }
            massitem--;
            return removed;
        }
        return null;
    }

    /**
     * 指定したインデックスのアイテムを取得する（UI表示用）
     * これがないとInventoryUIがデータを読めません。
     */
    public ItemData getItem(int index) {
        if (index >= 0 && index < capacity) {
            return slots[index];
        }
        return null;
    }

    public int getCapacity() {
        return capacity;
    }
}