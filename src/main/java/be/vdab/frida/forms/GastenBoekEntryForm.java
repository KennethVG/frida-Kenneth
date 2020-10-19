package be.vdab.frida.forms;

import be.vdab.frida.domain.GastenboekEntry;

import javax.validation.constraints.NotBlank;

public class GastenBoekEntryForm extends GastenboekEntry {
    public GastenBoekEntryForm(@NotBlank String naam, String boodschap) {
        super(naam, boodschap);
    }
}
