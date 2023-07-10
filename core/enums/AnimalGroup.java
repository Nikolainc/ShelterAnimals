package core.enums;

public enum AnimalGroup {
    
    UNKNOWN(0), PET(1), PACKANIMAL(2);

    private int value;

    AnimalGroup(int value) {
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
