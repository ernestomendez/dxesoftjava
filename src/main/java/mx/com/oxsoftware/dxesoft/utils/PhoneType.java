package mx.com.oxsoftware.dxesoft.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ernesto on 12/11/14.
 *
 * This enum represents all the available phone types.
 */
public enum PhoneType {

    MOBILE ("dxesoft.phone.type.mobile"),
    HOME ("dxesoft.phone.type.home"),
    WORK ("dxesoft.phone.type.work"),
    FAX ("dxesoft.phone.type.fax"),
    OTHER ("dxesoft.phone.type.other");

    private final String label;

    private static final Map<String, PhoneType> lookup = new HashMap<>(5);

    static {
        for (PhoneType phoneTypes: PhoneType.values()) {
            lookup.put(phoneTypes.label, phoneTypes);
        }
    }

    private PhoneType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public PhoneType get(String label) {
        return lookup.get(label);
    }

}
