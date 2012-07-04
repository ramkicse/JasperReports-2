/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ramki.entity.Item;
import org.ramki.entity.ShoppingCart;
import org.ramki.perisistence.PerisitenceManager;

/**
 *
 * @author ramki
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
                       
            ShoppingCart shoppingCart=new ShoppingCart();
             shoppingCart.setFirstName("Ramki");
             shoppingCart.setLastName("EP");
             shoppingCart.setDop(new SimpleDateFormat("dd/MM/yyyy").parse("16/06/1985"));
             
             List<Item> listOfItem=new  ArrayList<Item>();
             Item soap=new Item();
             soap.setItemName("Dettol");
             soap.setPrice(18.00F);
             soap.setNoOfUnits(5);
             
             listOfItem.add(soap);
                     
             Item soap1=new Item();
             soap1.setItemName("Hamam");
             soap1.setPrice(32.00F);
             soap1.setNoOfUnits(7);
             
             listOfItem.add(soap1);
             
             shoppingCart.setListOfItems(listOfItem);
             
              ShoppingCart shoppingCart1=new ShoppingCart();
             shoppingCart1.setFirstName("Sandeep");
             shoppingCart1.setLastName("Malviya");
             shoppingCart1.setDop(new SimpleDateFormat("dd/MM/yyyy").parse("10/04/1985"));
             
            listOfItem=new  ArrayList<Item>();
             soap=new Item();
             soap.setItemName("Soap ");
             soap.setPrice(25.00F);
             soap.setNoOfUnits(12);
            
             listOfItem.add(soap);
                     
              soap1=new Item();
             soap1.setItemName("Shampoo");
             soap1.setPrice(45.00F);
             soap1.setNoOfUnits(4);
             
             listOfItem.add(soap1);
             
             shoppingCart1.setListOfItems(listOfItem);
             
             EntityManager em=PerisitenceManager.getEntityManager();
             em.getTransaction().begin();
             em.persist(shoppingCart);
             em.persist(shoppingCart1);
             em.getTransaction().commit();
             em.close();
            
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
