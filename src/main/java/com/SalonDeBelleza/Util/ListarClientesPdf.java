package com.SalonDeBelleza.Util;

import com.SalonDeBelleza.entity.Estudiante;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
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
        PdfPTable tablaEstudiantes = new PdfPTable(4);
        listadoEstudiantes.forEach(Estudiante -> {
            tablaEstudiantes.addCell(Estudiante.getId().toString());
            tablaEstudiantes.addCell(Estudiante.getNombre());
            tablaEstudiantes.addCell(Estudiante.getApellido());
            tablaEstudiantes.addCell(Estudiante.getEmail());
        });
        document.add(tablaEstudiantes);
    }
}
