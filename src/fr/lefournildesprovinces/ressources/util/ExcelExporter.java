package fr.lefournildesprovinces.ressources.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ExcelExporter {
	public ExcelExporter() {
	}

	public void exportTable(final JTable table, final File file)
			throws IOException {

		final TableModel model = table.getModel();
//		final FileWriter out = new FileWriter(file);
		final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"Windows-1252"));
		for (int i = 0; i < model.getColumnCount(); i++) {
			out.write(model.getColumnName(i) + "\t");
		}
		out.write("\n");

		for (int i = 0; i < model.getRowCount(); i++) {
			for (int j = 0; j < model.getColumnCount(); j++) {
				if (model.getValueAt(i, j) == null) {
					out.write("" + "\t");
				} else {
					out.write(model.getValueAt(i, j).toString() + "\t");
				}
			}
			out.write("\n");

		}

		out.close();
		System.out.println("write out to: " + file);
	}
}