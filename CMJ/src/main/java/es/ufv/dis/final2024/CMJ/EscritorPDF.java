package es.ufv.dis.final2024.CMJ;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class EscritorPDF {
    public void escribirUsuarioPDF(Nave usuPDF){
        try {
            String fileName = "naves/nave_"+usuPDF.getName()+".pdf";
            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
            PdfWriter writer = PdfWriter.getInstance(doc,
                    new FileOutputStream(fileName));
            doc.open();
            // Strings que quieres guardar en el PDF
            String name = "Name: " + usuPDF.getName();
            String model = "Model: " + usuPDF.getModel();
            String cost_in_credits = "Cost in Credits: " + usuPDF.getCost_in_credits();
            String crew = "Crew: " + usuPDF.getCrew();
            String cargo_capacity = "Cargo Capacity: " + usuPDF.getCargo_capacity();
            String consumables = "Consumables: " + usuPDF.getConsumables();
            String hyperdrive_rating = "Hyperdrive Rating: " + usuPDF.getHyperdrive_rating();
            String starship_class = "Starship Class: " + usuPDF.getStarship_class();
            String [] pilots = usuPDF.getPilots();
            String [] films = usuPDF.getFilms();


            // Añadir contenido al PDF
            doc.add(new Paragraph(name));
            doc.add(new Paragraph(model));
            doc.add(new Paragraph(cost_in_credits));
            doc.add(new Paragraph(crew));
            doc.add(new Paragraph(cargo_capacity));
            doc.add(new Paragraph(consumables));
            doc.add(new Paragraph(hyperdrive_rating));
            doc.add(new Paragraph(starship_class));

            // Añadir los arrays al PDF
            doc.add(new Paragraph("Pilots:"));
            for (String pilot : pilots) {
                doc.add(new Paragraph(pilot));
            }

            doc.add(new Paragraph("Films:"));
            for (String film : films) {
                doc.add(new Paragraph(film));
            }

            doc.close();

        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
