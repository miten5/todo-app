package com.todoapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Table(name = "todos")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "reminder_at")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date reminderAt;

    @Column(name = "due_at")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date dueAt;

    private Integer priority;

    private Boolean completed = false;

    @CreationTimestamp
    @Column(updatable = false, name = "added_at")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date addedAt;
}
