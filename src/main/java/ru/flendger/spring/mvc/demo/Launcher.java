package ru.flendger.spring.mvc.demo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.security.ProtectionDomain;

public class Launcher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/app");
        // http://localhost:8080/app/
        webAppContext.setWar(location.toExternalForm());

        server.setHandler(webAppContext);
        server.start();
        server.join();
    }
}