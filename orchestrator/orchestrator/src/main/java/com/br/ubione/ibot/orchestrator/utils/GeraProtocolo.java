package com.br.ubione.ibot.orchestrator.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeraProtocolo {

	public String generateUniqueAlphanumeric(String phoneNumber) {
		 try {
	            // Get current date and time
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	            String dateTime = sdf.format(new Date());

	            // Concatenate phone number and dateTime
	            String input = phoneNumber + dateTime;

	            // Hash the concatenated string using SHA-256
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

	            // Convert hash bytes to hex string
	            StringBuilder hashHex = new StringBuilder();
	            for (byte b : hashBytes) {
	                hashHex.append(String.format("%02x", b));
	            }

	            // Convert the hex string to an alphanumeric string
	            String alphanumeric = hexToAlphanumeric(hashHex.toString());

	            // Truncate or pad to ensure it is 9 characters long
	            String uniqueAlphanumeric = alphanumeric.substring(0, 9);

	            return uniqueAlphanumeric;
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("Error generating unique alphanumeric value", e);
	        }
	    }

	    private String hexToAlphanumeric(String hex) {
	        StringBuilder alphanumeric = new StringBuilder();
	        for (int i = 0; i < hex.length(); i += 2) {
	            String str = hex.substring(i, i + 2);
	            int decimal = Integer.parseInt(str, 16);
	            alphanumeric.append((char) ((decimal % 36) + (decimal % 36 < 10 ? '0' : 'a' - 10)));
	        }
	        return alphanumeric.toString();
	    }
}

