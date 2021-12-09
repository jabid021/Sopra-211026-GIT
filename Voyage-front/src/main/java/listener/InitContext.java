package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import util.Context;

@WebListener
public class InitContext implements ServletContextListener {

	 public void contextInitialized(ServletContextEvent sce)  { 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		 
		// Context.getInstance(); 
		  
		  
		  
	 }
   
  
	 public void contextDestroyed(ServletContextEvent sce)  { 
		 
		 Context.getInstance().getEmf().close();
		 
    }

   
	
}
