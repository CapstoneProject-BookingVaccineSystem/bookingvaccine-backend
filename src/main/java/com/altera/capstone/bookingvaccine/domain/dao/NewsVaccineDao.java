package com.altera.capstone.bookingvaccine.domain.dao;

import java.sql.Time;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.altera.capstone.bookingvaccine.domain.common.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * NewsVaccine
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "news_vaccine")
@SQLDelete(sql = "UPDATE news_vaccine SET is_deleted = true WHERE id_news_vaccine = ?")
@Where(clause = "is_deleted = false")
public class NewsVaccineDao extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_news_vaccine;

    @Column(name = "title", nullable = false)
    private String titleNewsVaccine;

    @Column(name = "author", nullable = false)
    private String authorNewsVaccine;

    @Column(name = "image", nullable = true)
    private String imageNewsVaccine;

    @Column(name = "body_content", columnDefinition="TEXT", nullable = false)
    private String contentNewsVaccine;

    // @Column(name = "create_at")
    // private Timestamp createdAt;

    // @Column(name = "update_at")
    // private Timestamp updatedAt;
}