/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableCellRenderer;
import model.CaixaItens;

/**
 *
 * @author daniel
 */
public class JTableCaixaCellRenderes extends DefaultTableCellRenderer{
    
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object valor, boolean isSelected,
            boolean hasFocus, int row, int col) {
        super.getTableCellRendererComponent(jtable, valor, isSelected, hasFocus, row, col);
//        CaixaItens obj = (CaixaItens) ((TableModel)jtable.getModel()).getPagar(row);
//        
//        if (obj.getPag_dt_pag() != null) {
//            setBackground(new Color(215,252,252));
//        } else {
//            Date hoje = new Date();
//            if (hoje.before(obj.getPag_dt_venc())) {
//                setBackground(new Color(225, 255, 167));
//            } else {
//                setBackground(new Color(252, 212, 252));
//            }
//        }
        //Linha selecionada
        if (isSelected) {
            setBackground(Color.BLACK); //Amarelo
            setForeground(Color.WHITE);
        } else {
            setForeground(Color.BLACK);
        }
        //Alinhamento dos dados
        switch (col) {
            case 2:
            case 3:
            case 6:
                setHorizontalAlignment(CENTER);
                break;
            case 0:
            case 4:
            case 5:
            case 7:
                setHorizontalAlignment(RIGHT);
                break;
            default:
                setHorizontalAlignment(LEFT);
                break;
        }
        //Largura das colunas
//        jtable.setSelectionMode(0); //seleciona apenas uma linha
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtable.getColumnModel().getColumn(0).setPreferredWidth(70);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(80);
        jtable.getColumnModel().getColumn(5).setPreferredWidth(80);
        jtable.getColumnModel().getColumn(6).setPreferredWidth(80);
        jtable.getColumnModel().getColumn(7).setPreferredWidth(80);
        jtable.getColumnModel().getColumn(8).setPreferredWidth(120);
        //Ocultas as linhas da grade
//        jtable.setShowGrid(false);
        // Alinhamento dos títulos da coluna
        DefaultTableCellRenderer vHeaderRenderer = (DefaultTableCellRenderer) jtable.getTableHeader().getDefaultRenderer();
        vHeaderRenderer.setHorizontalAlignment(SwingUtilities.CENTER);
        return this;
    }
    
    
    
    
}
