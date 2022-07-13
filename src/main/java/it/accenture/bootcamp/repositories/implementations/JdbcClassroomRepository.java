package it.accenture.bootcamp.repositories.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.repositories.abstractions.ClassroomRepository;

@Repository
@Profile("jdbc")
public class JdbcClassroomRepository implements ClassroomRepository {

    private JdbcTemplate template;

    @Autowired
    public JdbcClassroomRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Iterable<Classroom> findAll() {
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

    @Override
    public void delete(Classroom c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<Classroom> findById(long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Classroom save(Classroom c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existsById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
