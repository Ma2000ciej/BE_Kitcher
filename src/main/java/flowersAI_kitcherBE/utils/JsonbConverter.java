package flowersAI_kitcherBE.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import flowersAI_kitcherBE.entity.Preferences;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = false)
public class JsonbConverter implements AttributeConverter<Preferences, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Preferences preferences) {
        if (preferences == null) {
            return "{}"; // 🔹 Domyślny pusty JSON zamiast NULL
        }
        try {
            return objectMapper.writeValueAsString(preferences);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Błąd konwersji Preferences -> JSON", e);
        }
    }

    @Override
    public Preferences convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return new Preferences();
        }
        try {
            return objectMapper.readValue(dbData, Preferences.class);
        } catch (IOException e) {
            throw new RuntimeException("Błąd konwersji JSON -> Preferences", e);
        }
    }
}
