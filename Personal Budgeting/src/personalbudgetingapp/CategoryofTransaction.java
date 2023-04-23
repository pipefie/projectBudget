package personalbudgetingapp;

import java.util.Arrays;
import java.util.List;

public enum CategoryofTransaction {
	HOUSING("Rent","Mortgage","Repairs","Maintenance","Services","Property Insurance","Furniture"),
	FOODANDDRINKS("groceries","restaurant/delivery","bar/cafe"),
	SHOPPING("clothes","jewels","accesories","health and beauty","kids","pets/animals","electronics/accesories","gifts/joy","tools","free time","cleaning","drug-store"),
	TRANSPORTATION("public (taxi,metro,bus,bike,other)",""),
	OTHERS
	;
	private final List<String> subcategories;
	
	/*
	 * continuar desde aquí 
	 */
	
	
	
	public List<String> getSubcategories() {
		return subcategories;
	}

	private CategoryofTransaction(List<String> subcategories) {
		this.subcategories = subcategories;
	}

	private CategoryofTransaction (String... subcategories){
		this.subcategories = Arrays.asList(subcategories);
	}




}
