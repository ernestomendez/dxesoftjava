package mx.com.oxsoftware.dxesoft.utils.jsfConverters;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by ernesto on 12/10/14.
 *
 * Converts dates to Joda DateTime
 */
@FacesConverter("mx.com.oxsoftware.dxesoft.utils.jsfConverters.JodaDateConverter")
public class JodaDateConverter implements Converter {

    private static String pattern = "dd/MM/yyyy";
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (facesContext == null) {
            throw new NullPointerException("facesContext");
        }

        if (uiComponent == null) {
            throw new NullPointerException("uiComponent");
        }

        DateTime parseDateTime =null;

        if (value != null) {
            value = value.trim();
            if (value.length() > 0) {
                DateTimeFormatter format = DateTimeFormat.forPattern(pattern);

                try {
                    parseDateTime = format.parseDateTime(value);
                } catch (IllegalArgumentException e) {
                    FacesMessage msg = new FacesMessage("Error converting Date",
                            "Invalid Date format");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ConverterException(e);
                }
            }
        }
            return parseDateTime;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        String dateTimeStr = null;

        if (facesContext == null) {
            throw new NullPointerException("facesContext");
        }
        if (uiComponent == null) {
            throw new NullPointerException("uiComponent");
        }

        if (value == null) {
            return "";
        }

        DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
        try {
            dateTimeStr = format.print((DateTime) value);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error converting Date",
                    "Invalid Date format");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(e);
        }
        return dateTimeStr;
    }
}
