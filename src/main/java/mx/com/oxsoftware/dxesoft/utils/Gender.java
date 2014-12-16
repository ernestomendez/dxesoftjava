package mx.com.oxsoftware.dxesoft.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ernesto on 11/11/14.
 *
 * This enum represents the gender for the contacts.
 */
public enum Gender {
    MASCULINO("dxesoft.male"),
    FEMENINO("dxesoft.female");

    private final String label;

    private static final Map<String, Gender> lookup = new HashMap<>(2);

    static {
        for (Gender gender: Gender.values()) {
            lookup.put(gender.label, gender);
        }
    }

    private Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Gender get(String label) {
        return lookup.get(label);
    }


}
