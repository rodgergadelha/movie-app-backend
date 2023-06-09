package com.example.movieappbackend.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@MappedSuperclass
public abstract class Comment {
	
	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private final String uuid = UUID.randomUUID().toString();
	
    @Column(columnDefinition = "TEXT")
    private String text;
    
	@ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
	
	@CreationTimestamp
	@Column(columnDefinition = "timestamp")
    private OffsetDateTime creationDate;
}
