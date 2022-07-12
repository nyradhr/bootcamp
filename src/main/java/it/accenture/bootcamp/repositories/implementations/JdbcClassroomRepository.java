package it.accenture.bootcamp.repositories.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.repositories.abstractions.ClassroomRepository;

@Repository
public class JdbcClassroomRepository implements ClassroomRepository {

    private JdbcTemplate template;

    @Autowired
    public JdbcClassroomRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Iterable<Classroom> getAll() {
        return template.query("SELECT * FROM CLASSROOM", this::rowMapper);
    }

    private Classroom rowMapper(ResultSet rs, int rownNum) throws SQLException {
        Boolean projector = rs.getBoolean("PROJECTOR");
        if (rs.wasNull()) {
            projector = null;
        }
        Boolean mainPc = rs.getBoolean("MAIN_PC");
        if (rs.wasNull()) {
            mainPc = null;
        }

        Boolean isComp = rs.getBoolean("IS_COMPUTERIZED");
        if (rs.wasNull()) {
            isComp = null;
        }

        return new Classroom(rs.getLong("ID"), rs.getString("NAME"),
                rs.getInt("CAPACITY"), rs.getString("SOFTWARE"),
                projector, mainPc, isComp, rs.getBoolean("IS_VIRTUAL"));
    }

}
