package eu.vilaca.whatsup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class WhatsUpController {
	private final TargetStatus results;

	public WhatsUpController(TargetStatus ts) {
		this.results = ts;
	}

	@GetMapping
	public Mono<Map<String, String>> main() {
		return Mono.just(results.all());
	}
}
