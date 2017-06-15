package com.tbo.password_management;

import java.util.Base64 ;

import com.tbo.dao.LoginDao;

import java.security.GeneralSecurityException;
import java.util.Arrays;

public class Authentication {
        
        static PasswordManagementUtils pwdMgmtUtils = new PasswordManagementUtils() ;
        
        public static boolean authenticate(String username, String attemptedPassword){
                //String attemptedPassword = args[0].trim() ;
                
                //String storedEncryptedPassword = getEncryptedStoredPassword(args) ;
                //String salt =  getUserSalt(args) ;
        		//SaltHash sh = null ;
        		SaltHash sh = LoginDao.validate(username);
        		
        		String salt = sh.getsaltObject();
                String storedEncryptedPassword = sh.getpasswordObject();
                
                
                byte[] computePBKDF2AttemptedPassword = null ;
                try {
                        computePBKDF2AttemptedPassword = pwdMgmtUtils.generateEncryptedPassword(attemptedPassword, pwdMgmtUtils.returnByteArray(salt)) ;
                } catch(GeneralSecurityException genSecExc) {System.out.println(genSecExc.getMessage() + " " + genSecExc.getCause() ) ; System.exit(1) ; }              
                
                boolean successful_authentication = Arrays.equals(computePBKDF2AttemptedPassword, pwdMgmtUtils.returnByteArray(storedEncryptedPassword)) ;
                
                System.out.println("User authenticated ? " + successful_authentication);
                return successful_authentication;
        }
        
        
        
        
        // For sake of this example, passing it from command line
        // Should be retrieved from database, as stored in PasswordStorage class
        private static String getEncryptedStoredPassword(String args[]) {
                return args[1].trim() ;
        }
        
        // For sake of this example, passing it from command line
        // Should be retrieved from database, as stored in PasswordStorage class.
        private static String getUserSalt(String args[]) {
                        return args[2].trim() ;
        }
        
}