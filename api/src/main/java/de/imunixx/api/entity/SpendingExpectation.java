package de.imunixx.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "spending_expectation")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SpendingExpectation extends ItemAmount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "profile_id", nullable = true)
    private Profile profile;

    @Column(name = "spending_frequency", nullable = false)
    private String spendingFrequency;

}
