/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.RedSocial;
import entity.Usuario;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Invitado
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory managerFactory
                = Persistence.createEntityManagerFactory("RedesSocialesPU");
        EntityManager entityManager = 
                managerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        Usuario user=new Usuario();
        user.setNombre("Alfonso Felix");
        user.setEmail("alfonso@potros.itson.edu.mx");
        user.setFechaNac(new Date());
        user.setSexo(true);
        
        
        entityManager.persist(user);
        
        Usuario user2=new Usuario();
        user2.setNombre("Narda Loredo");
        user2.setEmail("nardao@uadeo.edu.mx");
        user2.setFechaNac(new Date());
        user2.setSexo(false);
        
        entityManager.persist(user2);
        
        RedSocial redSocial1=new RedSocial();
        redSocial1.setFechaInicio(new Date());
        redSocial1.setNombre("Facebook");
        redSocial1.setWebsite("facebook.com");
        redSocial1.agregarUsuario(user, "neil");
        
        redSocial1.agregarUsuario(user2, "NardaG");
        
        RedSocial redSocial2=new RedSocial();
        redSocial2.setFechaInicio(new Date());
        redSocial2.setNombre("Windows Live Messenger");
        redSocial2.setWebsite("msn.com");
        redSocial2.agregarUsuario(user, "poncho");
        
        entityManager.persist(redSocial2);
        entityManager.persist(redSocial1);
        
        entityManager.getTransaction().commit();
        
    }
    
}
