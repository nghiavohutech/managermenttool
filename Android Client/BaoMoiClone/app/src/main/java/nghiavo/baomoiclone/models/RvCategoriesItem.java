package nghiavo.baomoiclone.models;

/**
 * Created by nghiavo on 12/29/16.
 */
public class RvCategoriesItem {
    private int icon;
    private String label;

    /**
     * Instantiates a new Rv categories item.
     *
     * @param icon  the icon
     * @param label the label
     */
    public RvCategoriesItem(int icon, String label) {
        this.icon = icon;
        this.label = label;
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets label.
     *
     * @param label the label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets icon.
     *
     * @return the icon
     */
    public int getIcon() {
        return icon;
    }

    /**
     * Sets icon.
     *
     * @param icon the icon
     */
    public void setIcon(int icon) {
        this.icon = icon;
    }
}
