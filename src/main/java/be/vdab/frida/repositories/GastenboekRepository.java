package be.vdab.frida.repositories;

import be.vdab.frida.domain.GastenboekEntry;

import java.util.List;

public interface GastenboekRepository {
    void toevoegen(GastenboekEntry entry);
    List<GastenboekEntry> findAll();
}
