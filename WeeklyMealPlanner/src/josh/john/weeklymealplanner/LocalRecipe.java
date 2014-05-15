package josh.john.weeklymealplanner;

public class LocalRecipe {
	private long localRecID;
	private String name;
	private String ingredients;
	private String method;
	private float calories;
	private float protein;
	private float carbohydrates;
	private float fats;
	private float cost;
	
	public LocalRecipe() {}
	
	public LocalRecipe(long localRecID, String name, String ingredients,
			String method) {
		super();
		this.localRecID = localRecID;
		this.name = name;
		this.ingredients = ingredients;
		this.method = method;
	}



	public LocalRecipe(long localRecID, String name, String ingredients,
			String method, float calories, float protein, float carbohydrates,
			float fats, float cost) {
		super();
		this.localRecID = localRecID;
		this.name = name;
		this.ingredients = ingredients;
		this.method = method;
		this.calories = calories;
		this.protein = protein;
		this.carbohydrates = carbohydrates;
		this.fats = fats;
		this.cost = cost;
	}

	public LocalRecipe(int i, String name) {
		this.localRecID = i;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public float getCalories() {
		return calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}

	public float getProtein() {
		return protein;
	}

	public void setProtein(float protein) {
		this.protein = protein;
	}

	public float getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(float carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public float getFats() {
		return fats;
	}

	public void setFats(float fats) {
		this.fats = fats;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public long getLocalRecID() {
		return localRecID;
	}
	
	public void setLocalRecID(long localRecID) {
		this.localRecID = localRecID;
	}
	
}
