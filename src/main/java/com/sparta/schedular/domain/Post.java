package com.sparta.schedular.domain;

import java.time.LocalDateTime;

public class Post {
    private Long id;        // 게시글 ID
    private String title;    // 제목
    private String author;   // 작성자
    private String content;  // 내용
    private String password; // 비밀번호
    private String confirmPassword;// 비밀번호 확인
    private LocalDateTime eventDateTime;

    // 기본 생성자
    public Post() {
    }

    // 모든 필드를 포함하는 생성자
    public Post(Long id, String title, String author, String content, String password, String confirmPassword, LocalDateTime eventDateTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.eventDateTime = eventDateTime;
    }

    // ID 없이 사용하는 생성자
    public Post(String title, String author, String content, String password, String confirmPassword, LocalDateTime eventDateTime) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.eventDateTime = eventDateTime;
    }

    public Post(String title, String author, String content, String password) {
    }

    public Post(String title, String author, String content, String password, LocalDateTime eventDateTime) {
    }

    // Getter & Setter 메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public LocalDateTime getEventDateTime() {
        return eventDateTime; // 추가된 부분
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime; // 추가된 부분
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", eventDateTime=" + eventDateTime + // 추가된 부분
                '}';

    }

    public Post orElse(Post defaultPost) {
        return (this != null) ? this : defaultPost;
    }
}
