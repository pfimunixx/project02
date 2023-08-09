package de.imunixx.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "user_activated")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserActivated implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @Column(name = "is_activated", nullable = false)
    private Boolean isActivated;

    @OneToOne(cascade = {})
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

}
