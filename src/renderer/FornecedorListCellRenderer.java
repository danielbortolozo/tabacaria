/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import model.Fornecedor;


/**
 *
 * @author daniel
 */
public class FornecedorListCellRenderer extends DefaultListCellRenderer {
    
     @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Fornecedor) {
            Fornecedor fornecedor = (Fornecedor) value;
            setText(fornecedor.getPessoa().getNome());
        }
        return this;
    }
    
    
}
