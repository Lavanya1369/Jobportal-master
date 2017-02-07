package com.l9ench.jobportal;

/**
 * Created by sai on 1/28/2017.
 */

public class Item_sub {
    private int id;
    private String ids;
    private String amount;
    private String discount;

    public Item_sub(int id, String ids, String amount, String discount) {
        this.id = id;
        this.ids = ids;
        this.amount = amount;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
