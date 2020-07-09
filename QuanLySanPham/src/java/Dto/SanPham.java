/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author ASUS
 */
public class SanPham implements Serializable{

    private int id;
    private String tensp;
    private String quycach;
    private BigDecimal gia;
    private String nhasx;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tensp
     */
    public String getTensp() {
        return tensp;
    }

    /**
     * @param tensp the tensp to set
     */
    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    /**
     * @return the quycach
     */
    public String getQuycach() {
        return quycach;
    }

    /**
     * @param quycach the quycach to set
     */
    public void setQuycach(String quycach) {
        this.quycach = quycach;
    }

    /**
     * @return the gia
     */
    public BigDecimal getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    /**
     * @return the nhasx
     */
    public String getNhasx() {
        return nhasx;
    }

    /**
     * @param nhasx the nhasx to set
     */
    public void setNhasx(String nhasx) {
        this.nhasx = nhasx;
    }
}
