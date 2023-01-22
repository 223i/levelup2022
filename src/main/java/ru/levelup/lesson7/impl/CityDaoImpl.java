package ru.levelup.lesson7.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.levelup.lesson7.model.City;
import ru.levelup.lesson7.model.Region;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CityDaoImpl implements CityDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    private final RowMapper<City> cityRowMapper;

    public CityDaoImpl(NamedParameterJdbcOperations jdbcOperations, RegionDao regionDao) {
        this.jdbcOperations = jdbcOperations;
        this.cityRowMapper = (rs, row) -> {
            final City city = new City();
            city.setId(rs.getInt("id_city"));
            city.setNameRu(rs.getString("name_ru"));
            city.setNameEn(rs.getString("name_en"));
            city.setAmountOfCitizens(rs.getInt("amount_of_citizens"));

            Region region = regionDao.getById(rs.getInt("id_of_region")).orElse(null);
            city.setRegion(region);
            return city;
        };
    }

    @Override
    public List<City> findAll() {
        final String sql = "select * from cities c";
        return jdbcOperations.query(sql, cityRowMapper);
    }

    @Override
    public Optional<City> getById(int cityId) {
        final String sql = "select id_city, name_ru, name_en, amount_of_citizens, id_of_region from cities s " +
                "where id_city = :cityId";
        try {
            return Optional.of(jdbcOperations.queryForObject(sql, Map.of("id_city", cityId), cityRowMapper));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int create(City city) {
        final String sqlQuery = "insert into cities (id_city, name_ru, name_en, amount_of_citizens, id_of_region) " +
                "values (:id, :name_ru, :name_en, :amount_of_citizens, :id_of_region)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        final Integer id = city.getId();
        namedParameters.addValue("id", city.getId(), Types.INTEGER);
        namedParameters.addValue("name_ru", city.getNameRu(), Types.VARCHAR);
        namedParameters.addValue("name_en", city.getNameEn(), Types.VARCHAR);
        namedParameters.addValue("amount_of_citizens", city.getAmountOfCitizens(), Types.INTEGER);
        if (city.getRegion() == null) {
            namedParameters.addValue("id_of_region", null, Types.INTEGER);
        } else {
            namedParameters.addValue("id_of_region", city.getRegion().getId(), Types.INTEGER);
        }
        jdbcOperations.update(sqlQuery, namedParameters);
        return id;
    }

    @Override
    public void update(City city) {
        final String sqlQuery = "update cities set " +
                "name_ru = :name_ru, " +
                "name_en = :name_en, " +
                "amount_of_citizens = :amount_of_citizens, " +
                "id_of_region = :id_of_region " +
                "where id_city = :id";
        jdbcOperations.update(sqlQuery, Map.of(
                "id", city.getId(),
                "name_ru", city.getNameRu(),
                "name_en", city.getNameEn(),
                "amount_of_citizens", city.getAmountOfCitizens(),
                "id_of_region", city.getRegion().getId()));
    }

    @Override
    public void deleteById(int cityId) {
        String sqlQuery = "delete from cities c where c.id_city = :cityId";
        jdbcOperations.update(sqlQuery, Map.of("cityId", cityId));
    }
}
