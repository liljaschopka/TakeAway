package hi.verkefni.takeaway;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    PONTUN("pontun-view.fxml"),
    GREIDSLA("greidsla-view.fxml"),
    VIDSKIPTAVINUR("vidskiptavinur-view.fxml");

    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
