package com.lchnan7.modules.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
public class EmailConfig {

    private static int springMailPort;

    private static String springMailHost;

    private static String springMailUserName;

    private static String springMailPassword;

    public static String getSpringMailHost() {
        return springMailHost;
    }


    @Value("${spring.mail.host}")
    public void setSpringMailHost(String springMailHost) {
        EmailConfig.springMailHost = springMailHost;
    }

    public static String getSpringMailUserName() {
        return springMailUserName;
    }

    @Value("${spring.mail.username}")
    public void setSpringMailUserName(String springMailUserName) {
        EmailConfig.springMailUserName = springMailUserName;
    }

    public static String getSpringMailPassword() {
        return springMailPassword;
    }

    @Value("${spring.mail.password}")
    public void setSpringMailPassword(String springMailPassword) {
        EmailConfig.springMailPassword = springMailPassword;
    }

    public static int getSpringMailPort() {
        return springMailPort;
    }
    @Value("${spring.mail.port}")
    public void setSpringMailPort(Integer springMailPort) {
        EmailConfig.springMailPort = springMailPort;
    }
}
