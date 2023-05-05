package personalbudgetingapp;

import java.util.Arrays;
import java.util.List;

public enum CategoryofExpense {
	HOUSING("Rent","Mortgage","Repairs","Maintenance","Services","Property Insurance","Furniture"),
	FOODANDDRINKS("Groceries","Restaurant/Delivery","Bar/Cafe"),
	SHOPPING("Clothes","Jewels","Accesories","Health and Beauty","Kids","Pets/Animals","Electronics/Accesories","Gifts/Joy","Tools","Free Time","Cleaning","Drug-store"),
	TRANSPORTATION("Public (taxi,metro,bus,bike,other)","Long Distance","Personal Vehicule"),
	LIFE_ENTERTAINMENT("Health Care","Personal Care", "Fitness","Culture","Life Events","Hobbies","Education/Development","Book/Audio","Subscriptions","Holiday/Trips/Hotels","Charity/Gifts","Tobacco,alcohol,etc.","Loterry/Gambling"),
	COMMUNICATION("Phone/Cellphone","Internte","Software,apps,games,etc,"),
	FINANCIAL_EXPENSES("Taxes","Insurances","Loan/Interests","Fines","Charges/Fees","Advisors","Other"),
	OTHERS
	;
	private final List<String> subcategories;
	
	/*
	 * continuar desde aquí 
	 */
	
	
	
	public List<String> getSubcategories() {
		return subcategories;
	}

	private CategoryofExpense(List<String> subcategories) {
		this.subcategories = subcategories;
	}

	private CategoryofExpense (String... subcategories){
		this.subcategories = Arrays.asList(subcategories);
	}




}
