package uitests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTests;

public class FindMyNextElectionPageUI extends BaseTests {
	
	public FindMyNextElectionPageUI() {
		
	}
	
	@Test
	public void verifyHeaderText() {
		String headertext = this.findMyNextElectionPage.getHeader();
		Assert.assertEquals(headertext, "Find my next election");
		
	} 
	@Test
	public void verifyUserMessage() {
		String userMessageText = this.findMyNextElectionPage.getUserMessage();
		Assert.assertEquals(userMessageText, "Enter the address where you are registered to vote.");
	}
	@Test
	public void verifyStreetFieldLabel() {
		String streetFieldLabel = this.findMyNextElectionPage.getStreetFieldLabel();
		Assert.assertEquals(streetFieldLabel, "Street:");
	}
	@Test
	public void verifyStreet2FieldLabel() {
		String street2FieldLabel = this.findMyNextElectionPage.getStreet2FieldLabel();
		Assert.assertEquals(street2FieldLabel, "Street-2:");
	}
	@Test
	public void verifyCityFieldLabel() {
		String cityFieldLabel = this.findMyNextElectionPage.getCityFieldLabel();
		Assert.assertEquals(cityFieldLabel, "City:");
	}
	@Test
	public void verifyStateDropdownLabel() {
		String stateDropdownLabel = this.findMyNextElectionPage.getStateDropdownLabel();
		Assert.assertEquals(stateDropdownLabel, "State:");
	}
	
	@Test
	public void verifyZipFieldLabel() {
		String zipFieldLabel = this.findMyNextElectionPage.getZipFieldLabel();
		Assert.assertEquals(zipFieldLabel, "Zip:");
	}
	
	@Test
	public void verifySearchButtonLabel() {
		String searchButtonLabel = this.findMyNextElectionPage.getSearchButtonLabel();
		Assert.assertEquals(searchButtonLabel, "Search");
	}
	
}
