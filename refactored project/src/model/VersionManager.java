package model;

import model.version.strategies.StableVersionsStrategy;
import model.version.strategies.VersionsStrategy;
import model.version.strategies.VolatileVersionsStrategy;

public class VersionManager {
	
	private boolean isVersionManagerStrategyEnabled ;
	private VersionsStrategy versionManagerStrategy ;

	
	public VersionManager(VersionsStrategy versionsStrategy) {
		this.versionManagerStrategy = versionsStrategy;
		this.isVersionManagerStrategyEnabled = false;
	}

	
	public void enableVersionStrategy(String strategyType) {
		
		if(isStrategyChanged(strategyType)) {
			changeVersionStrategy(strategyType);
		}
		
		enableVersionManagerStrategy();
	}
	
	public void changeVersionStrategy(String strategyType) {

		VersionsStrategy newVersionStrategy = versionManagerStrategy ;
		
		if(isStrategyChangedFromVolatileToStable(strategyType)) {
			newVersionStrategy = new StableVersionsStrategy();
		}
		else if(isStrategyChangedFromStableToVolatile(strategyType)) {
			newVersionStrategy = new VolatileVersionsStrategy();
		}
		else {
			enableVersionManagerStrategy();
			return ;
		}
		
		setNewVersiondStrategyProperties(newVersionStrategy);
	}


	private void setNewVersiondStrategyProperties(VersionsStrategy newVersionStrategy) {
		
		newVersionStrategy.setEntireHistory(versionManagerStrategy.getEntireHistory());
		versionManagerStrategy = newVersionStrategy ;
		
		enableVersionManagerStrategy();
	}

	private boolean isStrategyChangedFromStableToVolatile(String strategyType) {		
		return strategyType.equals("volatile") && versionManagerStrategy instanceof StableVersionsStrategy;
	}

	private boolean isStrategyChangedFromVolatileToStable(String strategyType) {
		return strategyType.equals("stable") && versionManagerStrategy instanceof VolatileVersionsStrategy;
	}
	
	private boolean isStrategyChanged(String strategyType) {
		return isStrategyChangedFromStableToVolatile(strategyType) || isStrategyChangedFromVolatileToStable(strategyType) ;
	}
	
	public boolean isVersionManagerStrategyEnabled() {
		return isVersionManagerStrategyEnabled;
	}
	
	public void enableVersionManagerStrategy() {
		isVersionManagerStrategyEnabled = true;
	}

	public void disableVersionManagerStrategy() {
		isVersionManagerStrategyEnabled = false;
	}
	
	public void  putVersionManagerStrategy(Document document) {
		versionManagerStrategy.putVersionID(document);
	}

	public VersionsStrategy getVersionManagerStrategy() {
		return versionManagerStrategy ;
	}
}
