	/*package com.pw.TiendaRopa.security;
	
	import java.util.Date;
	import java.util.function.Function;
	
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.security.core.Authentication;
	import org.springframework.stereotype.Component;
	
	import io.jsonwebtoken.Claims;
	import io.jsonwebtoken.Jwts;
	import io.jsonwebtoken.SignatureAlgorithm;
	
	@Component
	public class JwtUtil {
	
	    @Value("${jwt.secret}")
	    private String secretKey;
	
	    @Value("${jwt.expiration}")
	    private long validityInMilliseconds;
	
	    @SuppressWarnings("deprecation")
		public String generateToken(Authentication authentication) {
	        return Jwts.builder()
	            .setSubject(authentication.getName())
	            .setIssuedAt(new Date(System.currentTimeMillis()))
	            .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
	            .signWith(SignatureAlgorithm.HS512, secretKey)
	            .compact();
	    }
	
	    public boolean validateToken(String token) {
	        return !isTokenExpired(token);
	    }
	
	    public String getUsernameFromToken(String token) {
	        return getClaimFromToken(token, Claims::getSubject);
	    }
	
	    private Date getExpirationDateFromToken(String token) {
	        return getClaimFromToken(token, Claims::getExpiration);
	    }
	
	    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = getAllClaimsFromToken(token);
	        return claimsResolver.apply(claims);
	    }
	
	    @SuppressWarnings("deprecation")
	    private Claims getAllClaimsFromToken(String token) {
	        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
	    }
	
	    private boolean isTokenExpired(String token) {
	        final Date expiration = getExpirationDateFromToken(token);
	        return expiration.before(new Date());
	    }
	}*/
