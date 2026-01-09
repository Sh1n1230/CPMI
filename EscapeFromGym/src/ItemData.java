import javax.swing.*;

public class ItemData {
    private String name;
    private String description;
    private ImageIcon image3D;
    private ImageIcon icon;

    public ItemData(String name, String description, ImageIcon image3D, ImageIcon icon) {
        this.name = name;
        this.description = description;
        this.image3D = image3D;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ImageIcon getImage3D() {
        return image3D;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
