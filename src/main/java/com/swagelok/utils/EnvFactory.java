package com.swagelok.utils;

import org.junit.Assert;

public class EnvFactory {
    private static String ENV_NAME;
    private static String mainLink;

    public static String getMainUrl(){
        if(mainLink != null){
            return mainLink;
        }
        String envName;
        System.out.println(getEnvName().toLowerCase());

        switch (getEnvName().toLowerCase()){
            case "qa":
                envName = "qa.";
                break;
            case "staging":
                envName = "staging.";
                break;
            case "prod":
                envName = "";
                break;
            default:
                envName = "qa.";
                break;
        }

        mainLink = "https://products." + envName + "swagelok.com/en/";
        return mainLink;
    }

    private static String getEnvName(){
        if(ENV_NAME == null){
            ENV_NAME = System.getProperty("test.environment");
        }
        System.out.println("ENV: " + ENV_NAME);
        Assert.assertNotNull(ENV_NAME, "Env name in Maven is absent");
       return ENV_NAME;
    }
}
