package teste.config;

import lombok.Getter;

@Getter
public enum Features {

    INTEGRA_VIA_RABBIT("integra-via-rabbit", "training",
            "Integra produtos via Rabbit", false);

    private final String key;
    private final String description;
    private final String groupname;
    private final boolean defaultValue;

    Features(final String key, final String group, final String description,
             final boolean defaultValue) {
        this.key = key;
        this.description = description;
        this.defaultValue = defaultValue;
        this.groupname = group;
    }

    public static String getDescription(final String key) {
        for (Features value : Features.values()) {
            if (value.getKey().equalsIgnoreCase(key)) {
                return value.getDescription();
            }
        }
        throw new IllegalArgumentException("The parameter invalid!");
    }
}