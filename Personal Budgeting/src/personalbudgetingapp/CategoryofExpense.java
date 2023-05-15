package personalbudgetingapp;

import java.util.Arrays;
import java.util.List;

public enum CategoryofExpense {
	HOUSING("Rent","Mortgage","Repairs","Maintenance","Services","Property Insurance","Furniture"),
	FOOD_AND_DRINKS("Groceries","Restaurant/Delivery","Bar/Cafe"),
	SHOPPING("Clothes","Jewels","Accesories","Health and Beauty","Kids","Pets/Animals","Electronics/Accesories","Gifts/Joy","Tools","Free Time","Cleaning","Drug-store"),
	TRANSPORTATION("Public (taxi,metro,bus,bike,other)","Long Distance","Personal Vehicule"),
	LIFE_ENTERTAINMENT("Health Care","Personal Care", "Fitness","Culture","Life Events","Hobbies","Education/Development","Book/Audio","Subscriptions","Holiday/Trips/Hotels","Charity/Gifts","Tobacco,alcohol,etc.","Loterry/Gambling"),
	COMMUNICATION("Phone/Cellphone","Internte","Software,apps,games,etc,"),
	FINANCIAL_EXPENSES("Taxes","Insurances","Loan/Interests","Fines","Charges/Fees","Advisors","Other"),
	OTHERS
	;
	
	private String category;
	private String[] subcategories;
	
	private CategoryofExpense() {
		
	}
	private CategoryofExpense(String category, String...subcategories ) {
		this.category = category;
		this.subcategories = subcategories;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String[] getSubcategories() {
		return subcategories;
	}

	




}
