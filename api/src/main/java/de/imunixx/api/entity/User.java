package de.imunixx.api.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name = "\"user\"") // why is user quoted may be I dont get the point
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    /*
    Dont use primitive dataType here should be Long id.
    Cause long isnt nullable. With Long id you could post one of the following
    examples to create a new user. try it with swagger
    - post {
                "id": null,
                "email": "pf@imunixx.de",
                "password": "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4",
                "userCode": "0",
                "activated": false
            }
    or
    -> post {
                "email": "pf@imunixx.de",
                "password": "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4",
                "userCode": "0",
                "activated": false
            }
    */        
    //private long id; 
    private Long id;
    
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;
    
    // this is moved to Contact -> try to make it possible that user is able to login by userName or email
    //@Column(nullable = false, unique = true)
    //private String email;

    // this should be come encoded from FE and also storded encoded in db
    @Column(nullable = false)
    private String password;

    // i have no clou what is it for pls make a comment
    @Column(name = "user_code", nullable = false)
    private String userCode;

    @Column(nullable = false)
    private Boolean activated;
    
    @OneToOne(cascade = {})
    @JoinColumn(name = "user_data_id", nullable = true)
    private UserData userData;
}
