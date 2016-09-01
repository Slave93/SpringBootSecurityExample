package slavko.examples.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello-world")
public class HelloWorldResource {

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld() {
		return "Hello world";
	}

}
