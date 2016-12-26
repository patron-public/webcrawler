package com.webcrawler.model;


/**
 * Created by Pavel on 26.12.2016.
 */
public class AdModel {

    private String comment;
    private Long datePosted;
    private String model;
    private String vendor;
    private Integer price;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDatePosted(Long datePosted) {
        this.datePosted = datePosted;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AdModel{" +
                "comment='" + comment + '\'' +
                ", datePosted=" + datePosted +
                ", model='" + model + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                '}';
    }
}
