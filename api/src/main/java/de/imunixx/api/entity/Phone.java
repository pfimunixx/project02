/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.imunixx.api.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 *
 * @author uli.baehr@imunixx.de
 */
@Entity
@Table(name = "phone",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"prefix_id", "number"})
    })
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Phone implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;
    
    @ManyToOne(cascade = {})
    @JoinColumn(name = "user_data_id", nullable = true)
    private UserData userData;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "prefix_id", nullable = true)
    private Prefix prefix;

    @Column(name = "number", nullable = false, unique = true)
    private String number;
    
}