package io.fabric8.kubernetes.types.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RFC3339DateDeserializer extends StdDeserializer<Date> {

    public static final String RFC3339_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";

    private SimpleDateFormat formatter = new SimpleDateFormat(RFC3339_FORMAT);

    public RFC3339DateDeserializer() {
        this(null);
    }

    public RFC3339DateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        String date = jsonparser.getText();
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
