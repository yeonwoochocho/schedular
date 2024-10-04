package com.sparta.schedular.repository;

import com.sparta.schedular.domain.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sparta.schedular.domain.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostRepository {

    private final JdbcTemplate jdbcTemplate;

    public PostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 게시글 저장
    public void save(Post post) {
        String sql = "INSERT INTO posts (title, author, content, password) VALUES (?, ?, ?,?)";
        jdbcTemplate.update(sql, post.getTitle(), post.getAuthor(), post.getContent(), post.getPassword());
    }

    // 게시글 모두 조회
    public List<Post> findAll() {
        String sql = "SELECT * FROM posts";
        return jdbcTemplate.query(sql, new PostRowMapper());
    }

    // ID로 게시글 조회
    public Post findById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new PostRowMapper(), id);
    }

    // 게시글 수정
    public void update(Post post) {
        String sql = "UPDATE posts SET title = ?, author = ?, content = ? WHERE id = ?";
        jdbcTemplate.update(sql, post.getTitle(), post.getAuthor(), post.getContent(), post.getId());
    }

    // 게시글 삭제
    public void deleteById(Long id) {
        String sql = "DELETE FROM posts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // RowMapper 클래스: DB에서 조회한 데이터를 Post 객체로 매핑
    private static class PostRowMapper implements RowMapper<Post> {
        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setId(rs.getLong("id"));
            post.setTitle(rs.getString("title"));
            post.setAuthor(rs.getString("author"));
            post.setContent(rs.getString("content"));
            return post;
        }
    }
}
