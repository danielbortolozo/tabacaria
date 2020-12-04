/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import model.CategoriaProduto;

/**
 *
 * @author daniel
 */
public class CategoriaListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof CategoriaProduto) {
            CategoriaProduto cat = (CategoriaProduto) value;
            setText(cat.getDescricao());
        }
        return this;
    }
    
    
    
}
