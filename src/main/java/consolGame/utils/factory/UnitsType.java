package consolGame.utils.factory;

import lombok.Getter;

public enum UnitsType {
    ARCHER("Лучник"), WARRIOR("Воин"), WIZARD("Маг");

    @Getter
    private final String type;

    UnitsType(String type) {
        this.type = type;
    }
}
