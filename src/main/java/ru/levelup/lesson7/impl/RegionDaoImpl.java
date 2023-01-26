package ru.levelup.lesson7.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.levelup.lesson7.model.Region;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RegionDaoImpl implements RegionDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    private final RowMapper<Region> regionRowMapper = (rs, row) -> new Region(
            rs.getInt("id"), rs.getString("name_ru"), rs.getString("name_en"));

    @Override
    public List<Region> findAll() {
        final String sql = "SELECT * FROM regions r";
        return jdbcOperations.query(sql, regionRowMapper);
    }

    @Override
    public Optional<Region> getById(int regionId) {
        final String sql = "select id, name_ru, name_en from regions r " +
                "where id = :regionId";
        try {
            return Optional.of(jdbcOperations.queryForObject(sql, Map.of("id", regionId), regionRowMapper));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int create(Region region) {
        final String sqlQuery = "insert into regions (id, name_ru, name_en) " +
                "values (:id, :name_ru, :name_en)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        final Integer id = region.getId();
        namedParameters.addValue("id", region.getId(), Types.INTEGER);
        namedParameters.addValue("name_ru", region.getName_ru(), Types.VARCHAR);
        namedParameters.addValue("name_en", region.getName_en(), Types.VARCHAR);
        jdbcOperations.update(sqlQuery, namedParameters);
        return id;
    }
}
