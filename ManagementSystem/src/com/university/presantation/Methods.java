package com.university.presantation;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Methods {
	
	private Methods () {}
	
	public static void removeSelectedFromTable(JTable from) {
		int[] rows = from.getSelectedRows();
		TableModel tm =from.getModel();

		for (int row : rows) {
			((DefaultTableModel) tm).removeRow(from.convertRowIndexToModel(row));
		}

		from.clearSelection();
	}

}
