package com.example.springsecuritytelugu.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

  private final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

  // The validity period of the JWT token in seconds
  private static final int TOKEN_VALIDITY = 3600 * 5;

  // Secret key used to sign the JWT token
  private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

  // Extracts the username from the JWT token
  public String getUserNameFromToken(String token){
    return getClaimFromToken(token, Claims :: getSubject);
  }

  // Retrieves a specific claim from the JWT token
  private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  // Parses the JWT token and retrieves all claims
  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
  }

  // Validates whether the JWT token is still valid for the given user details
  public boolean validateToken(String jwtToken, UserDetails userDetails) {
    String  username = getUserNameFromToken(jwtToken);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
  }

  // Checks whether the JWT token has expired
  private boolean isTokenExpired(String jwtToken){
    Date expirationDate = getExpirationDateFromToken(jwtToken);
    return expirationDate.before(new Date());
  }

  // Extracts the expiration date from the JWT token
  private Date getExpirationDateFromToken(String jwtToken){
    return getClaimFromToken(jwtToken, Claims::getExpiration);
  }

  // Generates a new JWT token for the given user details
  public String generateToken(UserDetails userDetails){
    Map<String, Object> claims = new HashMap<>();

    String token = Jwts.builder()
      .setClaims(claims)
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
      .signWith(SECRET_KEY)
      .compact();

    // Debugging statement to log the generated token
    System.out.println("Generated Token: " + token);

    return token;
  }
}
