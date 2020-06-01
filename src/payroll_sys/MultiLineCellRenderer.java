
package payroll_sys;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.*;

import java.awt.Component;
import java.awt.Color;
import java.awt.List;

public class MultiLineCellRenderer extends JTextArea implements
TableCellRenderer {
  protected static Border noFocusBorder;

  private Color unselectedForeground;
  private Color unselectedBackground;

  public MultiLineCellRenderer() {
    super();
    noFocusBorder = new EmptyBorder(1, 2, 1, 2);
    setLineWrap(false);
    setWrapStyleWord(false);
    setOpaque(true);
    setBorder(noFocusBorder);
  }

  public void setForeground(Color c) {
    super.setForeground(c);
    unselectedForeground = c;
  }

  public void setBackground(Color c) {
    super.setBackground(c);
    unselectedBackground = c;
  }

  public void updateUI() {
    super.updateUI();
    setForeground(null);
    setBackground(null);
  }

  public Component getTableCellRendererComponent(JTable table, Object
value,
                                                 boolean isSelected, boolean hasFocus,
                                                 int row, int column) {

    if (isSelected) {
      super.setForeground(table.getSelectionForeground());
      super.setBackground(table.getSelectionBackground());
    }
    else {
      super.setForeground((unselectedForeground != null) ?
unselectedForeground
                          : table.getForeground());
      super.setBackground((unselectedBackground != null) ?
unselectedBackground
                          : table.getBackground());
    }

    setFont(table.getFont());

    if (hasFocus) {
      setBorder( UIManager.getBorder("Table.focusCellHighlightBorder")
);
      if (table.isCellEditable(row, column)) {
        super.setForeground( UIManager.getColor("Table.focusCellForeground")
);
        super.setBackground( UIManager.getColor("Table.focusCellBackground")
);
      }
    } else {
      setBorder(noFocusBorder);
    }

    setValue(value);
        int rowHeight = (int)getPreferredSize().getHeight();
        if (table.getRowHeight(row) != rowHeight) table.setRowHeight(row,
        rowHeight);

    return this;
  }

  protected void setValue(Object value) {
    setText((value == null) ? "" : value.toString());
  }
}



/*
  
public class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
  
  public MultiLineCellRenderer() {
      
    setLineWrap(true);
    setWrapStyleWord(true);
    setOpaque(true);
  }
  
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
               boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }
    setFont(table.getFont());
    if (hasFocus) {
        setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
            if (table.isCellEditable(row, column)) {
                setForeground(UIManager.getColor("Table.focusCellForeground"));
                setBackground(UIManager.getColor("Table.focusCellBackground"));
            }
        }
        else {
            setBorder(new EmptyBorder(1, 2, 1, 2));
        }
        setText((value == "") ? "" : value.toString());
    return this;
  }
}*/