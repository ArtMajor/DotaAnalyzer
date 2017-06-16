package ua.nure.babenko.dotaanalyzer.web.listeners;

import ua.nure.babenko.dotaanalyzer.constants.Params;
import ua.nure.babenko.dotaanalyzer.db.dao.ConfrontationDao;
import ua.nure.babenko.dotaanalyzer.db.dao.ConfrontationDaoImpl;
import ua.nure.babenko.dotaanalyzer.db.dao.TransactionManager;
import ua.nure.babenko.dotaanalyzer.exceptions.InitException;
import ua.nure.babenko.dotaanalyzer.services.ConfrontationService;
import ua.nure.babenko.dotaanalyzer.services.ConfrontaionServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        DataSource dataSource;
        try {
            Context dataSourceContext = new InitialContext();
            dataSource = (DataSource) dataSourceContext.lookup("java:comp/env/jdbc/dotaanalyzer");
        } catch (NamingException e){
            e.printStackTrace();
            throw new InitException();
        }

        TransactionManager transactionManager = new TransactionManager(dataSource);

        ConfrontationDao confrontationDao = new ConfrontationDaoImpl();

        ConfrontationService confrontationService = new ConfrontaionServiceImpl(confrontationDao, transactionManager);

        context.setAttribute(Params.CONFRONTATION_SERVICE, confrontationService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void databaseInit(DataSource dataSource) throws NamingException{

    }
}
