package com.tbo.password_management;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64 ;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class PasswordStorage {
        
        
    public static int SALT_SIZE = 20 ; // This would be in bytes

    static PasswordManagementUtils pwdMgmtUtils = new PasswordManagementUtils() ;
    
    	public static SaltHash computePassword(String enteredPassword){
                
                //String enteredPassword = args[0].trim() ;
                
                byte[] salt = generateSalt() ;
                byte[] saltedStretchedPassword = null ;
                try {
                        saltedStretchedPassword = pwdMgmtUtils.generateEncryptedPassword(enteredPassword , salt) ;
                } catch(GeneralSecurityException genSecExc) {System.out.println(genSecExc.getMessage() + " " + genSecExc.getCause() ) ; System.exit(1) ; }      
                                
                storeSaltAndEncryptedPassword(saltedStretchedPassword, salt ) ;
                String h = pwdMgmtUtils.returnStringRep(saltedStretchedPassword);
                String s = pwdMgmtUtils.returnStringRep(salt);
                SaltHash sh = new SaltHash(s,h); // make SH object
                return sh;
                
        }
        
        
        private static byte[] generateSalt() {
                SecureRandom secRan = new SecureRandom(); 
                byte[] ranBytes = new byte[SALT_SIZE];
                secRan.nextBytes(ranBytes);
                
                return ranBytes;
        }
        
        // Dummy function, which is supposed to store encrypted user password and corresponding salt in database. 
        // Salt would be unique to each user. It can be non-secret value, so can co-exist with encrypted password.
        public static boolean storeSaltAndEncryptedPassword(byte[] encryptedPassword, byte[] salt) {
                System.out.println("Password = " + pwdMgmtUtils.returnStringRep(encryptedPassword) + " and corresponding salt = " + pwdMgmtUtils.returnStringRep(salt) + " stored in credentials database ");
                //System.out.println("Decoded password = " + new String(encryptedPassword) + " decoded salt = " + new String(salt));
                return true;
        }
        
        
}