
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.ramki.entity.Item;
import org.ramki.entity.ShoppingCart;
import org.ramki.perisistence.PerisitenceManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramki
 */
@ManagedBean
@SessionScoped

public class DemoBean {
    
     public void pdf() throws JRException, IOException {
     
         EntityManager em=PerisitenceManager.getEntityManager();
        Query query= em.createQuery("select s from ShoppingCart s");
         List<ShoppingCart> listOfShoppingCart=(List<ShoppingCart>)query.getResultList();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listOfShoppingCart);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/report.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
}
