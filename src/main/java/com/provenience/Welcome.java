package com.provenience;

import org.springframework.stereotype.Component;

// component class available to spring
@Component
public class Welcome {
    public String getWelcome(){
        return "com.provenience.Welcome";
    }
}
