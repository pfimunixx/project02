package de.imunixx.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "prefix")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Prefix implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "dial_code", nullable = false)
    private String dialCode;

    @Column(name = "code", nullable = false)
    private String code;

}
