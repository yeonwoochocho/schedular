package com.example.todo.domain.todo.entity;


import com.example.todo.domain.todo.dto.TodoRequestDto;
import com.example.todo.domain.todo.dto.TodoResponseDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
//DTO 와 DB 사이의 연결 고리
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Todo {
    @Setter
    private Long id;
    private String username;
    private String title;
    private String password;
    private String description;
    private String createdAt;
    private String updatedAt;


    public static Todo from(TodoRequestDto requestDto){
        Todo todo = new Todo();
        todo.init(requestDto);
        return todo;
    }

    public static Todo from(ResultSet rs) throws SQLException {
        Todo todo = new Todo();
        todo.init(rs);
        return todo;
    }

    private void init(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
        this.username = rs.getString("username");
        this.title = rs.getString("title");
        this.password = rs.getString("password");
        this.description = rs.getString("description");
        this.createdAt = rs.getString("created_at");
        this.updatedAt = rs.getString("updated_at");
    }


    private void init(TodoRequestDto todoRequestDto){
        this.username = todoRequestDto.getUsername();
        this.title = todoRequestDto.getTitle();
        this.password = todoRequestDto.getPassword();
        this.description = todoRequestDto.getDescription();
        this.createdAt = todoRequestDto.getCreatedAt();
        this.updatedAt = todoRequestDto.getUpdatedAt();
    }

    public TodoResponseDto to() {
        return new TodoResponseDto(
                this.id,
                this.username,
                this.title,
                this.description,
                this.createdAt,
                this.updatedAt
        );
    }
}
