package flowersAI_kitcherBE.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL) // ✅ Ignoruje puste wartości
public class Preferences implements Serializable {

    @JsonProperty("text") // ✅ Jawnie określa pole JSON
    private String text;

    public Preferences() {
        this.text = "DUPA"; // Domyślna wartość
    }

    public Preferences(String text) {
        this.text = text;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}