package be.vdab.frida.repositories;

import be.vdab.frida.domain.GastenboekEntry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
class JdbcGastenboekRepository implements GastenboekRepository {
    private final JdbcTemplate template;
    private final RowMapper<GastenboekEntry> gastenBoekMapper =
            (result, rowNum) -> new GastenboekEntry(result.getString("naam"), result.getDate("datum").toLocalDate(), result.getString("boodschap"));
    private final SimpleJdbcInsert simpleJdbcInsert;

    public JdbcGastenboekRepository(JdbcTemplate template) {
        this.template = template;
        this.simpleJdbcInsert = new SimpleJdbcInsert(template);
        simpleJdbcInsert.withTableName("gastenboekentries");
    }

    @Override
    public void toevoegen(GastenboekEntry entry) {
        Map<String, Object> kolommen = new HashMap<>();
        kolommen.put("id", entry.getId());
        kolommen.put("datum", entry.getDatum());
        kolommen.put("naam", entry.getNaam());
        kolommen.put("boodschap", entry.getBoodschap());
        simpleJdbcInsert.execute(kolommen);
    }

    @Override
    public List<GastenboekEntry> findAll() {
        String sql = "select * from gastenboekentries order by datum desc";
        return template.query(sql, gastenBoekMapper);
    }
}
