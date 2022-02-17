package eu.vilaca.whatsup;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
@Data
@NoArgsConstructor
public class TargetsConfig {

	private List<Target> targets;
}

@Data
@NoArgsConstructor
class Target {
	private String name;
	private String host;
}