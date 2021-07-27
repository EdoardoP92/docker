package docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerApplication {

	@RequestMapping("/")
	public String home(@RequestHeader HttpHeaders headers) {
		return "---------- request header ----------\n" + headers;
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class, args);
	}

}