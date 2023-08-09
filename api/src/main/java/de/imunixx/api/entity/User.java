package de.imunixx.api.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "\"user\"") // why is user quoted may be I dont get the point.
// Because "user" itself it is a SQL command, so you need to specify in that way that
// it is just a table's name. If not, you will get an error. Try it in an SQL environment
// and you will see.
//@Table(name = "users")
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
    
    // this should come encoded from FE and also stored encoded in db
    @Column(nullable = false)
    private String password;

    // i have no clue what is it for pls make a comment:
    // This is the code I want to use in order to create urls to update passwords and send confirmation emails to the user (maybe there's a better way)
    @Column(name = "user_code", nullable = false)
    private String userCode;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Profile> profilesList = new ArrayList<>();

    @OneToOne(cascade = {})
    @JoinColumn(name = "userActivated_id", nullable = true)
    private UserActivated userActivated;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserData userData;
}
