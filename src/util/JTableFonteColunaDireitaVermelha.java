/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author daniel
 */
public class JTableFonteColunaDireitaVermelha extends DefaultTableCellRenderer {
    
    
 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)

 {

         Component myself = super.getTableCellRendererComponent(table,value, isSelected, hasFocus, row, column);

         setForeground(Color.RED);
         setHorizontalAlignment(SwingConstants.RIGHT);

         return myself;

 }
    
    
    
}
