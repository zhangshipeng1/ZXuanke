package util;

import javafx.scene.input.ContextMenuEvent;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @PackageName:util
 * @ClassName:ServletContextLode
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/25 11:53
 */

public class ServletContextLode implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context= servletContextEvent.getServletContext ();
        context.setAttribute ("ctx",context.getContextPath ());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
