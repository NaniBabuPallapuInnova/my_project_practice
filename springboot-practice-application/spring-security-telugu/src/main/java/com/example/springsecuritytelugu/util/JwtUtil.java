package com.example.springsecuritytelugu.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
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


//  private static final String SECRET_KEY = "i=am=generating=a=secure=key=for=my=jwt=project====this=project=is=for=my=personal=learning=spring=security";
  private static final int TOKEN_VALIDITY = 3600 * 5;
  private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);



  public String getUserNameFromToken(String token){
    return getClaimFromToken(token, Claims :: getSubject);
  }

  private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){

    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
  }


  public boolean validateToken(String jwtToken, UserDetails userDetails) {
    String  username = getUserNameFromToken(jwtToken);

    return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
  }

  private boolean isTokenExpired(String jwtToken){
    Date expirationDate = getExpirationDateFromToken(jwtToken);

    return expirationDate.before(new Date());
  }

  private Date getExpirationDateFromToken(String jwtToken){
    return getClaimFromToken(jwtToken, Claims::getExpiration);
  }

  public String generateToken(UserDetails userDetails){
    Map<String, Object> claims = new HashMap<>();

    String token = Jwts.builder()
      .setClaims(claims)
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis()+TOKEN_VALIDITY * 1000))
      .signWith(SECRET_KEY)
      .compact();

    System.out.println("Generated Token: " + token); // Adding this line for debugging

    return token;
  }



}
