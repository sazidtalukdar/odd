package com.example.check;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ApiKeyDao {

    JdbcTemplate jdbcTemplate ;

    public ApiKeyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean isApiKeyValid(String apiKey) {
        String sql = "SELECT COUNT(*) FROM api_key WHERE api_key = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{apiKey}, Integer.class);
        return count != null && count > 0;
    }
}


