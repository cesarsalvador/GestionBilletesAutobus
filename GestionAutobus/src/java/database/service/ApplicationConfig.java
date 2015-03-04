/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author usuario0316
 */
@javax.ws.rs.ApplicationPath("gestionbus")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(database.service.AutobusFacadeREST.class);
        resources.add(database.service.ClientesFacadeREST.class);
        resources.add(database.service.EmpleadosFacadeREST.class);
        resources.add(database.service.ReservaFacadeREST.class);
        resources.add(database.service.RutaFacadeREST.class);
    }
    
}
