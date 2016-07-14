
package com.managerwarehouse.util.styles;


public class Stylo_Frame extends javax.swing.JInternalFrame{
    
    public Stylo_Frame(String title) {
        super(title, true, true, true, true);
        
    }

    public void setIcon(javax.swing.Icon anIcon){
        setFrameIcon(anIcon);
    }
    
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        g.setColor(new java.awt.Color(100, 0, 4, 85));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }
    
}
