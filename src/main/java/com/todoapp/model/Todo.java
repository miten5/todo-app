package com.todoapp.model;

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
    private Date reminderAt;

    @Column(name = "due_at")
    private Date dueAt;

    private Integer priority;

    @CreationTimestamp
    @Column(updatable = false, name = "added_at")
    private Date addedAt;
}
