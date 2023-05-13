package com.idenu.customer.repository;

import com.idenu.customer.model.Address;
import com.idenu.customer.model.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class JdbcCustomerRespository implements CustomerRepository{

    private JdbcTemplate jdbcTemplate;

    public JdbcCustomerRespository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void save(Customer customer) {
        String sql = "INSERT INTO students (id, firstName, lastName, email, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone(), customer.getAddress(), new CustomerRowMapper());
    }

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    @Override
    public Customer findById(long id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerRowMapper());
    }

    @Override
    public void update(Customer customer) {
        String sql = "UPDATE customers SET firstName = ?, lastName = ?, email = ?, phone = ?, address = ? WHERE id = ?";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone(), customer.getAddress(), customer.getId());
    }

    public static class CustomerRowMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(resultSet.getLong("id"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setEmail(resultSet.getString("email"));
            customer.setPhone(resultSet.getString("phone"));
            Address address = Address.mapAddress(resultSet);
            customer.setAddress(address);

            return customer;
        }
    }

    @Override
    public <T> T execute(ConnectionCallback<T> connectionCallback) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T execute(StatementCallback<T> statementCallback) throws DataAccessException {
        return null;
    }

    @Override
    public void execute(String s) throws DataAccessException {

    }

    @Override
    public <T> T query(String s, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return null;
    }

    @Override
    public void query(String s, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public <T> List<T> query(String s, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> Stream<T> queryForStream(String s, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T queryForObject(String s, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T queryForObject(String s, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Override
    public Map<String, Object> queryForMap(String s) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryForList(String s, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryForList(String s) throws DataAccessException {
        return null;
    }

    @Override
    public SqlRowSet queryForRowSet(String s) throws DataAccessException {
        return null;
    }

    @Override
    public int update(String s) throws DataAccessException {
        return 0;
    }

    @Override
    public int[] batchUpdate(String... strings) throws DataAccessException {
        return new int[0];
    }

    @Override
    public <T> T execute(PreparedStatementCreator preparedStatementCreator, PreparedStatementCallback<T> preparedStatementCallback) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T execute(String s, PreparedStatementCallback<T> preparedStatementCallback) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T query(PreparedStatementCreator preparedStatementCreator, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T query(String s, PreparedStatementSetter preparedStatementSetter, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T query(String s, Object[] objects, int[] ints, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T query(String s, Object[] objects, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T query(String s, ResultSetExtractor<T> resultSetExtractor, Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public void query(PreparedStatementCreator preparedStatementCreator, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public void query(String s, PreparedStatementSetter preparedStatementSetter, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public void query(String s, Object[] objects, int[] ints, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public void query(String s, Object[] objects, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public void query(String s, RowCallbackHandler rowCallbackHandler, Object... objects) throws DataAccessException {

    }

    @Override
    public <T> List<T> query(PreparedStatementCreator preparedStatementCreator, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> query(String s, PreparedStatementSetter preparedStatementSetter, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> query(String s, Object[] objects, int[] ints, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> query(String s, Object[] objects, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> query(String s, RowMapper<T> rowMapper, Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public <T> Stream<T> queryForStream(PreparedStatementCreator preparedStatementCreator, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> Stream<T> queryForStream(String s, PreparedStatementSetter preparedStatementSetter, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> Stream<T> queryForStream(String s, RowMapper<T> rowMapper, Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T queryForObject(String s, Object[] objects, int[] ints, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T queryForObject(String s, Object[] objects, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T queryForObject(String s, RowMapper<T> rowMapper, Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T queryForObject(String s, Object[] objects, int[] ints, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T queryForObject(String s, Object[] objects, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T queryForObject(String s, Class<T> aClass, Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public Map<String, Object> queryForMap(String s, Object[] objects, int[] ints) throws DataAccessException {
        return null;
    }

    @Override
    public Map<String, Object> queryForMap(String s, Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryForList(String s, Object[] objects, int[] ints, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryForList(String s, Object[] objects, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryForList(String s, Class<T> aClass, Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryForList(String s, Object[] objects, int[] ints) throws DataAccessException {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryForList(String s, Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public SqlRowSet queryForRowSet(String s, Object[] objects, int[] ints) throws DataAccessException {
        return null;
    }

    @Override
    public SqlRowSet queryForRowSet(String s, Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public int update(PreparedStatementCreator preparedStatementCreator) throws DataAccessException {
        return 0;
    }

    @Override
    public int update(PreparedStatementCreator preparedStatementCreator, KeyHolder keyHolder) throws DataAccessException {
        return 0;
    }

    @Override
    public int update(String s, PreparedStatementSetter preparedStatementSetter) throws DataAccessException {
        return 0;
    }

    @Override
    public int update(String s, Object[] objects, int[] ints) throws DataAccessException {
        return 0;
    }

    @Override
    public int update(String s, Object... objects) throws DataAccessException {
        return 0;
    }

    @Override
    public int[] batchUpdate(String s, BatchPreparedStatementSetter batchPreparedStatementSetter) throws DataAccessException {
        return new int[0];
    }

    @Override
    public int[] batchUpdate(String s, List<Object[]> list) throws DataAccessException {
        return new int[0];
    }

    @Override
    public int[] batchUpdate(String s, List<Object[]> list, int[] ints) throws DataAccessException {
        return new int[0];
    }

    @Override
    public <T> int[][] batchUpdate(String s, Collection<T> collection, int i, ParameterizedPreparedStatementSetter<T> parameterizedPreparedStatementSetter) throws DataAccessException {
        return new int[0][];
    }

    @Override
    public <T> T execute(CallableStatementCreator callableStatementCreator, CallableStatementCallback<T> callableStatementCallback) throws DataAccessException {
        return null;
    }

    @Override
    public <T> T execute(String s, CallableStatementCallback<T> callableStatementCallback) throws DataAccessException {
        return null;
    }

    @Override
    public Map<String, Object> call(CallableStatementCreator callableStatementCreator, List<SqlParameter> list) throws DataAccessException {
        return null;
    }
}
