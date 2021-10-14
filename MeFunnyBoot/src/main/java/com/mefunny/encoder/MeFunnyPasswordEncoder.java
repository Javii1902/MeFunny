package com.mefunny.encoder;

import org.springframework.security.crypto.password.PasswordEncoder; // More like Password "Encoder"

public class MeFunnyPasswordEncoder implements PasswordEncoder {
	
	@Override
	public String encode(CharSequence notActuallyEncrypting) {
		
		return notActuallyEncrypting.toString();
		
	}
	
	@Override
	public boolean matches(CharSequence notActuallyEncrypting, String validPassword) {
		
		return notActuallyEncrypting.toString().equals(validPassword);
	}

}
