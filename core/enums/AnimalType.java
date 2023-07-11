package core.enums;

public enum AnimalType {

    UNKNOWN("Неизвестно", 0),
    CAT("Кот", 1),
    DOG("Собака", 2),
    HUMSTER("Хомяк", 3),
    HORSE("Лошадь", 4),
    DUNKEY("Осел", 5),
    CAMAL("Верблюд", 6);

    private String value;
    private int animal_id;

    AnimalType(String value, int animal_id) {
        this(value);
        this.animal_id = animal_id;
    }

    AnimalType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public int getId() {
        return this.animal_id;
    }

    public AnimalType IsType(String value){

        return this.valueOf(value);

    }

    @Override
    public String toString() {

        return this.getValue();

    }
    
}
