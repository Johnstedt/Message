package se.umu.cs.edu.rest;

//import com.google.gson.Gson;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class DemoServer {

	public static void main(String[] args) throws Exception {
		Server demoServer = new Server(Protocol.HTTP, 8111,
				DemoServerResource.class);
		demoServer.start();

/*		Gson gson = new Gson();
		SerlizeME sm = new SerlizeME("hej", "haa");
		System.out.println(gson.toJson(sm));*/
	}





}
