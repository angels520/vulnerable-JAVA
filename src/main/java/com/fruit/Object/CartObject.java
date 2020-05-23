package com.fruit.Object;

public class CartObject {
    private int id;
    private String cartname;
    private float cartprice;
    private String shopimg;

    public String getShopimg() {
        return shopimg;
    }

    public void setShopimg(String shopimg) {
        this.shopimg = shopimg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCartname() {
        return cartname;
    }

    public void setCartname(String cartname) {
        this.cartname = cartname;
    }

    public float getCartprice() {
        return cartprice;
    }

    public void setCartprice(float cartprice) {
        this.cartprice = cartprice;
    }
}
