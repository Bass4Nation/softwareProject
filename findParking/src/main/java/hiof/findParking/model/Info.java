package hiof.findParking.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Annonse.class, name = "Annonse"),
//        @JsonSubTypes.Type(value = Invertebrates.class, name = "Invertebrates"),
//        @JsonSubTypes.Type(value = Amphibians.class, name = "Amphibians"),

})

public abstract class Info extends Bruker {
    private String beskrivelse;

    public Info(String adresse, String navn, String beskrivelse) {
        super(adresse, navn);
        this.beskrivelse = beskrivelse;
    }


//    public Info(){}


    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
