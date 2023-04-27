package com.SalonDeBelleza.Util;

import com.SalonDeBelleza.entity.Estudiante;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

@Component("estudiantes")
public class ListarClientesPdf extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Estudiante> listadoEstudiantes = (List<Estudiante>) model.get("estudiantes");

        /*Fuentes, tamaños y colores para cada seccion*/
        Font fuenteTitulo = FontFactory.getFont(FontFactory.COURIER_BOLD, 26, Color.WHITE);
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.black);
        Font fuenteDataCeldas = FontFactory.getFont(FontFactory.TIMES, 14, Color.BLACK);

        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-20, -20, 30, 20);
        document.open();
        PdfPCell celda = null;

        /*Tabla Para El Titulo del PDF*/
        PdfPTable tablaTitulo = new PdfPTable(1);

        celda = new PdfPCell(new Phrase("¡LISTADO GENERAL DE CLIENTES!", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(153, 0, 0));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(30);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        /*Tabla Para Mostrar Listado de Clientes*/
        PdfPTable tablaClientes = new PdfPTable(4);
        tablaClientes.setWidths(new float[]{0.8f, 2f, 2f, 2f});

        celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 255, 51));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);

        celda = new PdfPCell(new Phrase("Empresa", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 255, 51));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);

        celda = new PdfPCell(new Phrase("Número Telefónico", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 255, 51));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);

        celda = new PdfPCell(new Phrase("Correco Electrónico", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 255, 51));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);

        /*Bucle For, mostrar todos los datos de los clientes*/
        for (Estudiante estudiante : listadoEstudiantes) {
            celda = new PdfPCell(new Phrase(estudiante.getId().toString(), fuenteDataCeldas));
            celda.setBackgroundColor(new Color(255, 250, 240));
            celda.setPadding(5);
            tablaClientes.addCell(celda);

            celda = new PdfPCell(new Phrase(estudiante.getNombre(), fuenteDataCeldas));
            celda.setBackgroundColor(new Color(255, 250, 240));
            celda.setPadding(5);
            tablaClientes.addCell(celda);

            celda = new PdfPCell(new Phrase(estudiante.getApellido(), fuenteDataCeldas));
            celda.setBackgroundColor(new Color(255, 250, 240));
            celda.setPadding(5);
            tablaClientes.addCell(celda);

            celda = new PdfPCell(new Phrase(estudiante.getEmail(), fuenteDataCeldas));
            celda.setBackgroundColor(new Color(255, 250, 240));
            celda.setPadding(5);
            tablaClientes.addCell(celda);
        }
        
        /*Anexamos las Tablas al Documento*/
        document.add(tablaTitulo);
        document.add(tablaClientes);
    }
}
