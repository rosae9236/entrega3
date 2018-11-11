package com.example.rosa.enjoyarts;

public class PainterModel {

    private String painter, workTitle;
    private int imgPicture;

    public PainterModel() {
    }

    public String getPainter() {
        return painter;
    }

    public void setPainter(String painter) {
        this.painter = painter;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public int getImgPicture() {
        return imgPicture;
    }

    public void setImgPainter(int imgPicture) {
        this.imgPicture = imgPicture;
    }

    public PainterModel(String painter, String workTitle, int imgPainter) {
        this.painter = painter;
        this.workTitle = workTitle;
        this.imgPicture = getImgPicture();

    }
}
