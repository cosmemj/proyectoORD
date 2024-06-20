package org.vaadin.example;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Route
public class MainView extends VerticalLayout {

    public MainView(@Autowired GreetService service) throws URISyntaxException, IOException, InterruptedException {
        List<Nave> listaNaves = service.getAllNaves();

        Grid<Nave> navesGrid = new Grid<>(Nave.class);
        navesGrid.setColumns("name", "model", "cost_in_credits", "crew", "cargo_capacity", "consumables", "hyperdrive_rating", "starship_class", "pilots", "films");
        navesGrid.getColumnByKey("name").setAutoWidth(true).setFlexGrow(0);
        navesGrid.getColumnByKey("model").setAutoWidth(true).setFlexGrow(0);
        navesGrid.getColumnByKey("cost_in_credits").setAutoWidth(true).setFlexGrow(0);
        navesGrid.getColumnByKey("crew").setAutoWidth(true).setFlexGrow(0);
        navesGrid.getColumnByKey("cargo_capacity").setAutoWidth(true).setFlexGrow(0);
        navesGrid.getColumnByKey("consumables").setAutoWidth(true).setFlexGrow(0);
        navesGrid.getColumnByKey("hyperdrive_rating").setAutoWidth(true).setFlexGrow(0);
        navesGrid.getColumnByKey("starship_class").setAutoWidth(true).setFlexGrow(0);
        navesGrid.getColumnByKey("pilots").setAutoWidth(true).setFlexGrow(0);
        navesGrid.getColumnByKey("films").setAutoWidth(true).setFlexGrow(0);
        navesGrid.setSizeFull();
        navesGrid.addColumn(
                new NativeButtonRenderer<>("Generar",
                        clickedItem -> {
                            EscritorPDF pdf = new EscritorPDF();
                            pdf.escribirNavePDF(clickedItem);
                        })
        );

    }
}
