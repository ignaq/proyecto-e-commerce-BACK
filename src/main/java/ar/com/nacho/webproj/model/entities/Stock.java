/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.nacho.webproj.model.entities;


public class Stock{
    
    private String nombreProducto;
    private int stockID;
    private int talleID;
    private String talle;
    private int colorID;
    private String color;
    private int cant;

    public Stock() {
    }

    public Stock(String nombreProducto, int stockID, int talleID, String talle, int colorID, String color, int cant) {
        this.nombreProducto = nombreProducto;
        this.stockID = stockID;
        this.talleID = talleID;
        this.talle = talle;
        this.colorID = colorID;
        this.color = color;
        this.cant = cant;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getTalleID() {
        return talleID;
    }

    public void setTalleID(int talleID) {
        this.talleID = talleID;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }


    


   
    
    
    
}
