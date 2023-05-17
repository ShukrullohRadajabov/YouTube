package com.company.YouTubeProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
@Getter
@Setter
@Table(name = "tag")
@Entity
public class TagEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "created_date")
    private LocalDateTime createdDate=LocalDateTime.now();
}
