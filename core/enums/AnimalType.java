package core.enums;

public enum AnimalType {

    UNKNOWN(0),
    CAT(1),
    DOG(2),
    HUMSTER(3),
    HORSE(4),
    DUNKEY(5),
    CAMAL(6);

    private int value;

    AnimalType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {

        return this.name();

    }
    
}
