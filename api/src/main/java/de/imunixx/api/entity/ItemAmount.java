package de.imunixx.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class ItemAmount {

    @Column(name = "item", nullable = false)
    private String item;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
}
