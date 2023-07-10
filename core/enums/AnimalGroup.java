package core.enums;

public enum AnimalGroup {
    
    UNKNOWN("Неизвестно"), PET("Домашние животные"), PACKANIMAL("Вьючные животные");

    private String value;

    AnimalGroup(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {

        return this.name();

    }

}
