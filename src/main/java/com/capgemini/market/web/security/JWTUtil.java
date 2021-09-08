package com.capgemini.market.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWTUtil {
    private static final String KEY = "capgemini"; //Debe ser muy compleja en realidad

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())//se setea el usuario
                .setIssuedAt(new Date())//fecha de inicio
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))//le damos 10 horas de vida al token
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }
    public boolean validateToken(String token, UserDetails userDetails){
    return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    //valida si el username es igual al de la funcion extractuser y si el token ya expiro o no

    }
    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }
    public boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        //obtiene la llave y verifica que sea correcta para las peticiones del postman
        //lado derecha regresa la info del cuerpo
    }
}
