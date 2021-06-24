
package com.mycompany.employee.backend.model;

public class ResponseClass {
    String token;

    
    public ResponseClass(String token){
        this.token=token;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
