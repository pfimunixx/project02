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
@Table(name = "email")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Email implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;
    
    @ManyToOne(cascade = {})
    @JoinColumn(name = "user_data_id", nullable = true)
    private UserData userData;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "is_login_email", nullable = false)
    private Boolean isLoginEmail;
    
}
