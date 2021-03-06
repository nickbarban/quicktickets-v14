package com.vaadin.demo.dashboard.view;

import com.google.common.eventbus.Subscribe;
import com.vaadin.demo.dashboard.event.DashboardEvent;
import com.vaadin.demo.dashboard.event.DashboardEventBus;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.server.VaadinSession;

@JsModule("@vaadin/vaadin-lumo-styles/presets/compact.js")
@CssImport("./styles/shared-styles.css")
@CssImport("./styles/main-layout.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        DashboardEventBus.register(this);
        addDetachListener(e -> DashboardEventBus.unregister(this));

        addToDrawer(new DashboardMenu());
        addToNavbar(new DashboardHeader());
    }

}
