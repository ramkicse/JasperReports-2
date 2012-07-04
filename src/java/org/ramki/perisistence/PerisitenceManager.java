/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ramki.perisistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ramki
 */
public class PerisitenceManager {
    
    private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("WebApplication1PU");
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    
}
