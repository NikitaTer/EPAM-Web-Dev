package by.epam.entity;

import java.util.Date;

public class Candy {

    private String name;
    private String production;
    private String id;

    private CandyType type;
    private CandyIngredients ingredients;
    private CandyValue value;

    private int energy;
    private int expiry;

    private Date date;

    public Candy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CandyType getType() {
        return type;
    }

    public void setType(CandyType type) {
        this.type = type;
    }

    public CandyIngredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(CandyIngredients ingredients) {
        this.ingredients = ingredients;
    }

    public CandyValue getValue() {
        return value;
    }

    public void setValue(CandyValue value) {
        this.value = value;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Candy candy = (Candy) o;

        return  energy == candy.energy &&
                expiry == candy.expiry &&
                name.equals(candy.name )&&
                production.equals(candy.production) &&
                type == candy.type &&
                ingredients.equals(candy.ingredients) &&
                value.equals(candy.value) &&
                date.equals(candy.date);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * energy;
        result += 31 * expiry;
        result += 31 * name.hashCode();
        result += 31 * production.hashCode();
        result += 31 * type.hashCode();
        result += 31 * ingredients.hashCode();
        result += 31 * value.hashCode();
        result += 31 * date.hashCode();

        return result;
    }
}