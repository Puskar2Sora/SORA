/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppppppp;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.table.TableModel;
/**
 *
 * @author PUSAKR
 */
public class pdf {
    public static void exportTable(JTable table, String filename) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            document.add(new Paragraph("JTable Data Export\n\n"));

            TableModel model = table.getModel();

            // Create PDF table with same number of columns
            PdfPTable pdfTable = new PdfPTable(model.getColumnCount());

            // Add column headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                pdfTable.addCell(new PdfPCell(new Paragraph(model.getColumnName(i))));
            }

            // Add rows
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    pdfTable.addCell(new PdfPCell(new Paragraph(value != null ? value.toString() : "")));
                }
            }
             
            document.add(pdfTable);
            document.close();
            System.out.println("PDF created successfully: " + filename);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
