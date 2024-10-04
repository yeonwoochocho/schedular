package com.sparta.schedular.repository;

import com.sparta.schedular.domain.Event;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setId(rs.getLong("id"));
        event.setTitle(rs.getString("title"));
        event.setAuthor(rs.getString("author"));
        event.setContent(rs.getString("content"));
        event.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        event.setModifiedDate(rs.getTimestamp("modified_date").toLocalDateTime());
        return event;
    }
}