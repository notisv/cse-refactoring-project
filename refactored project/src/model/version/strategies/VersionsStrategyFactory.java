package model.version.strategies;

import java.util.HashMap;

public class VersionsStrategyFactory {
	private HashMap<String, VersionsStrategy> strategiesMap;
	
	public VersionsStrategyFactory() {
		
		strategiesMap = new HashMap<String, VersionsStrategy>();
		
		strategiesMap.put("volatileStrategy", new VolatileVersionsStrategy());
		strategiesMap.put("stableStrategy", new StableVersionsStrategy());
	}
	
	public VersionsStrategy createStrategy(String type) {
		return strategiesMap.get(type);
	}
}
