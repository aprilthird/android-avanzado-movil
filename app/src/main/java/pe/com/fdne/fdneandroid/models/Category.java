package pe.com.fdne.fdneandroid.models;

public class Category {
    private String title;
    private String urlImage;

    public Category() {
    }

    public Category(String title, String urlImage) {
        this.title = title;
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
