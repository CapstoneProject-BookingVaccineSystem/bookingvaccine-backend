package com.altera.capstone.bookingvaccine.domain.dao;

import com.altera.capstone.bookingvaccine.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "family")
@SQLDelete(sql = "UPDATE family SET is_deleted = true WHERE id_family = ?")
@Where(clause = "is_deleted = false")
public class FamilyDao extends BaseEntity {

  private static final long serialVersionUID = -1266576651734156259L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_family;

  @Column(name = "nik", nullable = false, unique = true)
  private String nik;

  @Column(name = "fullName", nullable = false, unique = true)
  private String fullName;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserDao userMapped;
}
