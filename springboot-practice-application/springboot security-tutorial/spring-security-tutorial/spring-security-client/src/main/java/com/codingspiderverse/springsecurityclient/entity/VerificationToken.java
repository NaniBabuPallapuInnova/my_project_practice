package com.codingspiderverse.springsecurityclient.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "verification_token")
@Data
@NoArgsConstructor
public class VerificationToken {

    //expiration time for 10 minutes
    public static final int EXPIRATION_TIME = 10;
    private static final Logger log = LoggerFactory.getLogger(VerificationToken.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private Date expirationTime;

    /**
     * @OneToOne(fetch = FetchType.EAGER): This annotation is used to define a one-to-one relationship between two entities.
     * In this case, it suggests that the UserVerifyToken entity has a one-to-one relationship with another entity, likely the User entity.
     * The fetch attribute is set to EAGER, which means that when a UserVerifyToken entity is fetched, its associated User entity will also be fetched immediately, rather than lazily (on demand).
     *
     * nullable = false: Indicates that the foreign key column (user_id) cannot have null values,
     * enforcing the existence of a related User for each UserVerifyToken
     *
     * foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"): This sets up a foreign key constraint with a name "FK_USER_VERIFY_TOKEN" on the database level.
     * Foreign key constraints ensure referential integrity between the two tables
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private User user;

    public VerificationToken(User user, String token) {
        super();
        this.user = user;
        this.token = token;
        this.expirationTime = calculateExpirationTime(EXPIRATION_TIME);
        // example : Expiration Time : Fri Dec 01 12:03:58 IST 2023
        log.info("Expiration Time {} : ", expirationTime);

    }

    public VerificationToken(String token){
        super();
        this.token = token;
        this.expirationTime = calculateExpirationTime(EXPIRATION_TIME);
    }

    private Date calculateExpirationTime(int expirationTime){

        // Create a Calendar instance and set it to the current date and time
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());

        // Add a specified number of minutes(10 minutes) to the current date and time
        calendar.add(Calendar.MINUTE, expirationTime);

        // Convert the Calendar's time to a Date object and return it
        return new Date(calendar.getTime().getTime());
    }
}
