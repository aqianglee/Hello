

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class ManualTest {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8888);
		WebAppContext context = new WebAppContext();
		context.setResourceBase("src/main/webapp");
		context.setContextPath("/app");
		server.setHandler(context);
		server.start();
	}
}
