package core.enums;

public enum AnimalType {

    UNKNOWN("Неизвестно"),
    CAT("Кот"),
    DOG("Собака"),
    HUMSTER("Хомяк"),
    HORSE("Лошадь"),
    DUNKEY("Осел"),
    CAMAL("Верблюд");

    private String value;

    AnimalType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {

        return this.getValue();

    }
    
}
