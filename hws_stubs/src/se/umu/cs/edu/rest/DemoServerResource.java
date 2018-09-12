package se.umu.cs.edu.rest;

import org.restlet.resource.*;


public class DemoServerResource extends ServerResource {


	@Get
	public String Read() {
		String item = getQueryValue("q");
		return item;
	}

	@Put
	public String Update(String body) {
		return "update " + body +"!\n";
	}

	@Post
	public String Create() {
		return "create!\n";
	}

	@Delete
	public String Delete() {
		return "delete!\n";
	}

}