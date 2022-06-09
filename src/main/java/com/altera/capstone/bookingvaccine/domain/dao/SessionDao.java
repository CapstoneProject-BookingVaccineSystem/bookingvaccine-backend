package com.altera.capstone.bookingvaccine.domain.dao;

import com.altera.capstone.bookingvaccine.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "session_vaccine")
@SQLDelete(sql = "UPDATE session_vaccine SET is_deleted = true WHERE id_session = ?")
@Where(clause = "is_deleted = false")
public class SessionDao extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_session;

  @Column(name = "start_time", nullable = false)
  private String startTime;

  @Column(name = "end_time", nullable = false)
  private String endTime;

  @Column(name = "last_stock", nullable = false)
  private Integer lastStock;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private UserDao userDaoMapped;

  @ManyToOne
  @JoinColumn(name = "vaccine_id")
  private VaccineDao vaccineMapped;

  @ManyToOne
  @JoinColumn(name = "id_health_facilities")
  private HealthFacilitiesDao healthFacilitiesDaoMapped;
}
