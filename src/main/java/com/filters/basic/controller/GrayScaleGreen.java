/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.filters.basic.controller;

import com.filters.main.Editor;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jcbru
 */
@ManagedBean(name="gsgreen")
@SessionScoped
public class GrayScaleGreen implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ManagedProperty(value = "#{editor}")
    private Editor editor;

    /**
     * @return the editor
     */
    public Editor getEditor() {
        return editor;
    }

    /**
     * @param editor the editor to set
     */
    public void setEditor(Editor editor) {
        this.editor = editor;
    }
    
    public void aplicar() {
        editor.setImg(grayScaleGreen(editor.getImg2()));
    }
    
    public BufferedImage grayScaleGreen(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Color c = new Color(img.getRGB(i, j));
                c = new Color(c.getGreen(), c.getGreen(), c.getGreen());
                bi.setRGB(i, j, c.getRGB());
            }
        }
        return bi;
    }
}
