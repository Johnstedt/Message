package se.umu.cs.edu.rest;

import org.restlet.Component;
import org.restlet.data.Protocol;
import se.umu.cs.edu.messenger.IMessenger;
import se.umu.cs.edu.messenger.IMessengerImpl;


public class RestServer {


	public static void main(String[] args) throws Exception {

		new DemoServerComponent().start();

/*		Gson gson = new Gson();
		SerlizeME sm = new SerlizeME("hej", "haa");
		System.out.println(gson.toJson(sm));*/
	}

	static class DemoServerComponent extends Component {

		public DemoServerComponent() {
			getServers().add(Protocol.HTTP, 8111);

			getDefaultHost().attach("/postMessage/",
					PostMessage.class);
		}
	}



}
