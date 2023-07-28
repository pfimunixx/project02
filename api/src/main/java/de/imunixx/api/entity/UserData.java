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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
//@Table(name = "\"user\"") // why is user quoted may be I dont get the point
@Table(name = "user_data")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @OneToOne(cascade = {})
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "sure_name", nullable = false)
    private String sureName;

    @OneToMany(mappedBy = "user_data", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Address> addressList = new ArrayList<>();

    @OneToMany(mappedBy = "user_data", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Email> emailList = new ArrayList<>();

    @OneToMany(mappedBy = "user_data", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Phone> phoneList = new ArrayList<>();

}
