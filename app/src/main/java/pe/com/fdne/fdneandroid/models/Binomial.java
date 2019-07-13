package pe.com.fdne.fdneandroid.models;

public class Binomial {
    private String horseName;
    private String riderName;
    private int position;
    private double points;
    private String urlImage;

    public Binomial() {
    }

    public Binomial(String horseName, String riderName, int position, double points, String urlImage) {
        this.horseName = horseName;
        this.riderName = riderName;
        this.position = position;
        this.points = points;
        this.urlImage = urlImage;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
