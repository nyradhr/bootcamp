package it.accenture.bootcamp.repositories.implementations.jdbc;

import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.models.Edition;
import it.accenture.bootcamp.models.Sector;
import it.accenture.bootcamp.repositories.abstractions.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.function.Function;

@Repository
@Profile("jdbc")
public class JdbcCourseRepository implements CourseRepository {
    private JdbcTemplate template;
    //private NamedParameterJdbcTemplate namedTemplate;
    private SimpleJdbcInsert simpleInsert;

    @Autowired
    public JdbcCourseRepository(JdbcTemplate template) {
        this.template = template;
        //this.namedTemplate = namedTemplate;
        this.simpleInsert = new SimpleJdbcInsert(template).withTableName("COURSE")
                .usingGeneratedKeyColumns("ID");
    }
    @Override
    public List<Course> findAll() {
        return template.query("SELECT C.ID, C.TITLE, C.DURATION, " +
                "C.COURSE_LEVEL, C.DESCRIPTION, C.COST, S.ID SECTOR_ID, S.NAME SECTOR_NAME " +
                "FROM COURSE C JOIN SECTOR S ON (C.SECTOR = S.ID)", this::rowMapper);
    }

    @Override
    public List<Course> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Course> findAllById(Iterable<Long> longs) {
//
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        template.update("DELETE FROM COURSE WHERE ID = ?", new Object[]{id});
    }

    @Override
    public <S extends Course> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Course> findById(Long id) {
        try{
            Course c = template.queryForObject("SELECT C.ID, C.TITLE, C.DURATION, " +
                    "C.COURSE_LEVEL, C.DESCRIPTION, C.COST, S.ID SECTOR_ID, S.NAME SECTOR_NAME " +
                    "FROM COURSE C JOIN SECTOR S ON (C.SECTOR = S.ID) WHERE C.ID = ?", this::rowMapper, id);
            return Optional.of(c);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Course> findByTitle(String title) {
        try{
            Course c = template.queryForObject("SELECT C.ID, C.TITLE, C.DURATION, " +
                    "C.COURSE_LEVEL, C.DESCRIPTION, C.COST, S.ID SECTOR_ID, S.NAME SECTOR_NAME " +
                    "FROM COURSE C JOIN SECTOR S ON (C.SECTOR = S.ID) WHERE C.TITLE = ?", this::rowMapper, title);
            return Optional.of(c);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Course> findBySectorName(String sectorName) {
        return null;
    }

    @Override
    public List<Course> findByTitleContainingIgnoreCase(String like) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Course> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Course> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Course> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Course getOne(Long aLong) {
        return null;
    }

    @Override
    public Course getById(Long id) {
        return findById(id).isPresent()? findById(id).get() : null;
    }

    @Override
    public Course getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Course> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Course> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Course> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Course> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Course> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Course> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Course, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    private Course rowMapper(ResultSet rs, int rowNum) throws SQLException {
        return new Course( rs.getLong("ID"), rs.getString("TITLE"),
                new Sector(rs.getLong("SECTOR_ID"), rs.getString("SECTOR_NAME")),
                rs.getInt("DURATION"), rs.getString("COURSE_LEVEL"),
                rs.getString("DESCRIPTION"), rs.getInt("COST"), new ArrayList<Edition>());
    }

    @Override
    public void delete(Course c) {
        deleteById(c.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        for (Long id: longs) deleteById(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Course> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Course save(Course c) {
        if (existsById(c.getId())){  //update
            template.update("UPDATE COURSE " +
                    "SET TITLE = ?, SECTOR = ?, DURATION = ?, " +
                    "COURSE_LEVEL = ?, DESCRIPTION = ?, COST = ? WHERE ID = ?", getComponentsForUpdate(c));
            return c;
        }
        else{   //save
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("TITLE", c.getTitle());
            parameters.put("SECTOR", c.getSector().getId());
            parameters.put("DURATION", c.getDuration());
            parameters.put("COURSE_LEVEL", c.getCourseLevel());
            parameters.put("DESCRIPTION", c.getDescription());
            parameters.put("COST", c.getCost());
            simpleInsert.execute(parameters);
            return findByTitle(c.getTitle()).get();
        }
    }


    /*
    public Object[] getComponentsForInsert(Course c){
        return new Object[]{ c.getTitle(), c.getSector().getId(), c.getDuration(), c.getCourseLevel(),
                c.getDescription(), c.getCost()};
    }

     */

    public Object[] getComponentsForUpdate(Course c){
        return new Object[]{ c.getTitle(), c.getSector().getId(), c.getDuration(), c.getCourseLevel(),
                c.getDescription(), c.getCost(), c.getId()};
    }

}