package examen.gui;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import examen.modelo.Coche;

public class TableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6112205562326517127L;
	private List<Coche> listaCoches;

	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	public TableModel() {
		listaCoches = new ArrayList<>();
	}

	@Override
	public int getRowCount() {

		return listaCoches.size();
	}

	@Override
	public int getColumnCount() {

		return 4;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Brand";
		} else if (column == 1) {
			return "Model";
		} else if (column == 2) {
			return "Last revision";
		} else
			return "Age";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Coche coche = listaCoches.get(rowIndex);
		if (columnIndex == 0) {
			return coche.getMarca();
		}
		if (columnIndex == 1) {
			return coche.getModelo();
		}
		if (columnIndex == 2) {
			return coche.getFechaUltimaRevision().format(formato);
		} else {
			if (coche.getAntiguedad() == 1) {
				return coche.getAntiguedad() + " year";
			} else
				return coche.getAntiguedad() + " years";
		}

	}

}
