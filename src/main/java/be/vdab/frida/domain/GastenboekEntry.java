package be.vdab.frida.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GastenboekEntry {
    private long id;
    @NotBlank
    private String naam;
    @NotNull
    @DateTimeFormat(style = "S-")
    private LocalDate datum = LocalDate.now();
    @NotBlank
    private String boodschap;

    public GastenboekEntry() {
    }

    public GastenboekEntry(@NotBlank String naam, @NotBlank String boodschap) {
        this(naam, LocalDate.now(), boodschap);
    }

    public GastenboekEntry(@NotBlank String naam, @NotNull LocalDate datum, @NotBlank String boodschap) {
        id++;
        this.naam = naam;
        this.datum = datum;
        this.boodschap = boodschap;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getDatumAlsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        return formatter.format(datum);
    }

    public String getNaam() {
        return naam;
    }

    public String getBoodschap() {
        return boodschap;
    }


    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setBoodschap(String boodschap) {
        this.boodschap = boodschap;
    }
}
