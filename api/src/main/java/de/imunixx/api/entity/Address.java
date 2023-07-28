/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.imunixx.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Address implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;
    
    @ManyToOne(cascade = {})
    @JoinColumn(name = "user_data_id", nullable = true)
    private UserData userData;
    
    @ManyToOne(cascade = {})
    @JoinColumn(name = "country_id", nullable = true)
    private Country country;
    
    @ManyToOne(cascade = {})
    @JoinColumn(name = "state_id", nullable = true)
    private State state;
    
    @ManyToOne(cascade = {})
    @JoinColumn(name = "city_id", nullable = true)
    private City city;
    
    @Column(name = "zip_code", nullable = false, unique = true)
    private String zipCode;
    
    @ManyToOne(cascade = {})
    @JoinColumn(name = "street_id", nullable = true)
    private Street street;
    
    @Column(name = "house_number", nullable = false, unique = true)
    private String houseNumber;
    
    
}
