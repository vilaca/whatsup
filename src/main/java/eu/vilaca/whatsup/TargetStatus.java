package eu.vilaca.whatsup;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TargetStatus {
	private final Map<String, String> status = new ConcurrentHashMap<>();

	public void put(String name, String value) {
		status.put(name, value);
	}

	public Map<String, String> all() {
		return status;
	}
}
