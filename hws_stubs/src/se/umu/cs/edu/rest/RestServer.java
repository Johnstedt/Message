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

			getDefaultHost().attach("/postMessage",
					PostMessage.class);

			getDefaultHost().attach("/retrieveMessage",
					RetrieveMessage.class);

			getDefaultHost().attach("/listMessages",
					ListMessages.class);

			getDefaultHost().attach("/listMessagesWithTimestamps",
					ListMessagesWithTimestamps.class);

			getDefaultHost().attach("/listTopics",
					ListTopics.class);

			getDefaultHost().attach("/subscribe",
					Subscribe.class);

			getDefaultHost().attach("/unsubscribe",
					Unsubscribe.class);

			getDefaultHost().attach("/listSubscribers",
					ListSubscribers.class);
		}
	}



}
