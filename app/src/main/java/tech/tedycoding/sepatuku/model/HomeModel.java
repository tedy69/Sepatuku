package tech.tedycoding.sepatuku.model;

public class HomeModel {

    private int id_product;
    private String namaproduct;
    private String statusproduct;
    private String diskonproduct;
    private String imageproduct;

    public HomeModel(int id_product, String namaproduct, String statusproduct, String diskonproduct, String imageproduct) {
        this.id_product = id_product;
        this.namaproduct = namaproduct;
        this.statusproduct = statusproduct;
        this.diskonproduct = diskonproduct;
        this.imageproduct = imageproduct;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getNamaproduct() {
        return namaproduct;
    }

    public void setNamaproduct(String namaproduct) {
        this.namaproduct = namaproduct;
    }

    public String getStatusproduct() {
        return statusproduct;
    }

    public void setStatusproduct(String statusproduct) {
        this.statusproduct = statusproduct;
    }

    public String getDiskonproduct() {
        return diskonproduct;
    }

    public void setDiskonproduct(String diskonproduct) {
        this.diskonproduct = diskonproduct;
    }

    public String getImageproduct() {
        return imageproduct;
    }

    public void setImageproduct(String imageproduct) {
        this.imageproduct = imageproduct;
    }
}
