package de.imunixx.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "fixed_movement")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class FixedMovement extends ItemAmount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "profile_id", nullable = true)
    private Profile profile;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @Column(name = "transaction_frequency", nullable = false)
    private String transactionFrequency;

}
