package com.sakila.ui;

import com.sakila.domain.Actor;
import com.sakila.service.ActorService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class VaadinUI extends UI {

    @Autowired
    private ActorService actorService;

    private Grid<Actor> grid = new Grid<>(Actor.class);;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        grid.setHeight(300, Unit.PIXELS);
        grid.setColumns("actorId", "firstName", "lastName", "lastUpdate");
        grid.setItems(actorService.getAllActors());
        VerticalLayout mainLayout = new VerticalLayout(grid);
        setContent(mainLayout);
    }
}
