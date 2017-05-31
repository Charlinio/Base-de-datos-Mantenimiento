/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.de.datos.mantenimiento;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Toro
 */
public class Reportes {
    
    private static String FILE = " ";
        private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 30,
                        Font.BOLD);
        private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                        Font.NORMAL, BaseColor.RED);
        private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
                        Font.BOLD);
        private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                        Font.BOLD);

    private static PdfPCell c1(Font font) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        public  void generarReporte(){
            try {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                  File file = fileChooser.getSelectedFile();
                   FILE=file.getAbsolutePath();
                  //JOptionPane.showMessageDialog(null,ruta);
                  // save to file
                }
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(FILE));
                        document.open();
                        addMetaData(document);
                        addTitlePage(document);
                        //addContent(document);
                        document.close();
                        
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,e.getMessage());
                }
        }
       
        private static void addMetaData(Document document) {
                document.addTitle("Departamento de Mantenimiento");
                document.addSubject("Reporte de Pedidos");
               
        }
        
        private static void addTitlePage(Document repedido) throws DocumentException {
                Paragraph preface = new Paragraph();
                addEmptyLine(preface, 1);
               
                preface.add(new Paragraph("Departamento de Mantenimiento", catFont));

                addEmptyLine(preface, 1);
                
                preface.add(new Paragraph(
                                "Reporte de Pedidos"+ " , "+ new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                                smallBold));
                addEmptyLine(preface, 3);
                PdfPTable table = new PdfPTable(5);
                PdfPCell c1 = new PdfPCell();
                
                
                table.setTotalWidth(repedido.getPageSize().getWidth()-10);
                table.setLockedWidth(true);
                
               c1 = new PdfPCell(new Phrase("ID Pedido"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Refaccion"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Cantidad"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);
                
                c1 = new PdfPCell(new Phrase("Fecha"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);
                
                c1 = new PdfPCell(new Phrase("Estado"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);
                
                int[] row = josuellorona.tablapedidos.getSelectedRows();
                
              for(int i =0;i<josuellorona.tablapedidos.getRowCount();i++){
                    for(int j =0;j< josuellorona.tablapedidos.getColumnCount();j++){
                        if(josuellorona.tablapedidos.getSelectedRowCount()>0){
                        if(josuellorona.tablapedidos.getValueAt(row[i], j) != null){
                table.addCell(new Phrase(josuellorona.tablapedidos.getValueAt(row[i], j).toString()));
                    }
                    }else{
                            
                        JOptionPane.showMessageDialog(null, "Seleccione un Producto para Crear un Reporte","Advertencia",JOptionPane.WARNING_MESSAGE);
                        }
                        }
                }
                

                repedido.add(preface);
                // Start a new page
                repedido.add(table);
                repedido.newPage();
        }
        
         private static void addEmptyLine(Paragraph paragraph, int number) {
                for (int i = 0; i < number; i++) {
                        paragraph.add(new Paragraph(" "));
                }
}
}

    
        
