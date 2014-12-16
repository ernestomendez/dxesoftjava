package mx.com.oxsoftware.dxesoft.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ernesto on 12/13/14.
 *
 * This enum represents all the available email types.
 */
public enum EmailType {

    PERSONAL ("dxesoft.email.type.personal"),
    WORK ("dxesoft.email.type.work"),
    OTHER ("dxesoft.email.type.other");

    private final String label;

    private static final Map<String, EmailType> lookup = new HashMap<>(5);

    static {
        for (EmailType emailTypes: EmailType.values()) {
            lookup.put(emailTypes.label, emailTypes);
        }
    }

    private EmailType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public EmailType get(String label) {
        return lookup.get(label);
    }
}
