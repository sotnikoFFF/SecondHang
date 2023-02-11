package com.sotnikoff.secondhand.repository;

import com.sotnikoff.secondhand.data.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class JdbcListingRepository implements ListingRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcListingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Listing> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<Listing> findAll() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS listings (id BIGSERIAL PRIMARY KEY, " +
                "title VARCHAR(255), description VARCHAR(1024), price DECIMAL(10, 2), created_at DATE)";
        jdbcTemplate.update(createTableSQL);
        return jdbcTemplate.query("SELECT * FROM listings", (rs, rowNum) ->
                new Listing(rs.getLong("id"), rs.getString("title"), rs.getString("description"),
                        rs.getBigDecimal("price"), rs.getDate("created_at")));
    }

    @Override
    public List<Listing> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Optional<Listing> findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM listings WHERE id = ?", new Object[]{id}, (rs) -> {
            if (rs.next()) {
                return Optional.of(new Listing(rs.getLong("id"), rs.getString("title"),
                        rs.getString("description"), rs.getBigDecimal("price"), rs.getDate("created_at")));
            }
            return Optional.empty();
        });
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Listing save(Listing listing) {
        jdbcTemplate.update("INSERT INTO listings (title, description, price, created_at) VALUES (?, ?, ?, ?)",
                listing.getTitle(), listing.getDescription(), listing.getPrice(), new Date());
        return listing;
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM listings WHERE id = ?", id);
    }

    @Override
    public void delete(Listing entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Listing> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Listing> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Listing> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Listing> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Listing getOne(Long aLong) {
        return null;
    }

    @Override
    public Listing getById(Long aLong) {
        return null;
    }

    @Override
    public Listing getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Listing> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Listing> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Listing> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Listing> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Listing> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Listing> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Listing, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }


    @Override
    public Page<Listing> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Listing> findAll(Sort sort) {
        return null;
    }
}
