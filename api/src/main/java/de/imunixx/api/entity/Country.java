/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.imunixx.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 *
 * @author uli.baehr@imunixx.de
 */
@Entity
@Table(name = "country")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Country implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;
    
    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;
    
    @Column(name = "country_iso_code", nullable = false, unique = true)
    private String countryIsoCode; 
    // try to create a country only by isoCode 
    //-> you could do that by PathParameter (not included) 
    // example:post /country/{isocode} 
    // get the CountryName on Service Level with java.util.Locale
    
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Address> addressList = new ArrayList<>();
    
}
