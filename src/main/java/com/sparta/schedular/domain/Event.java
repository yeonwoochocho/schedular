package com.sparta.schedular.domain;

import java.time.LocalDateTime;


public class Event {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String password;
    private String author;
    private String content;
    private LocalDateTime modifiedDate;
    private LocalDateTime createdDate;

    // 기본 생성자
    public Event() {
    }

    // 생성자
    public Event(Long id, String title, String description, LocalDateTime startTime, LocalDateTime endTime, String password) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.password = password;
    }

    // Getter와 Setter

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getContent() { // content에 대한 Getter
        return content;
    }

    public void setContent(String content) { // content에 대한 Setter
        this.content = content;
    }
    public LocalDateTime getCreatedDate() { // createdDate에 대한 Getter
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) { // createdDate에 대한 Setter
        this.createdDate = createdDate;
    }
    // toString 메서드 (디버깅 시 유용)
    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", password='" + password + '\'' +
                '}';
    }

    public void setAuthor(String author) {
    }
}
