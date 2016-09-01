package slavko.examples;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class ClientExample {
	public static void main(String[] args) throws IOException {
		httpGETCollectionExample();
	}

	private static void httpGETCollectionExample() {

		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive()
				.credentials("admin", "admin").build();

		Client client = ClientBuilder.newClient();
		client.register(feature);

		WebTarget webTarget = client.target("http://localhost:8080/").path("hello-world");

		Invocation.Builder invocationBuilder = webTarget.request();
		Response response = invocationBuilder.get();

		System.out.println(response.getStatus());
		System.out.println(response.getStatusInfo());

		if (response.getStatus() == 200) {
			String helloWorld = response.readEntity(String.class);
			System.out.println(helloWorld);
		}
	}
}
