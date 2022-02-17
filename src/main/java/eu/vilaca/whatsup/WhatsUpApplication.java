package eu.vilaca.whatsup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class WhatsUpApplication {

	private final List<Target> targets;
	private final TargetStatus results;

	public WhatsUpApplication(TargetsConfig targetsConfig, TargetStatus ts) {
		this.targets = targetsConfig.getTargets();
		this.results = ts;
	}

	public static void main(String[] args) {
		SpringApplication.run(WhatsUpApplication.class, args);
	}

	@Scheduled(fixedDelay = 1000 * 60 * 5)
	public void checkWhatsUp() {
		for (Target target : this.targets) {
			WebClient.builder()
					.baseUrl(target.getHost())
					.build().get()
					.retrieve()
					.toBodilessEntity()
					.doOnError(e -> results.put(target.getName(), e.getMessage()))
					.subscribe(response -> results.put(target.getName(), response.getStatusCode().name()));
		}
	}
}
