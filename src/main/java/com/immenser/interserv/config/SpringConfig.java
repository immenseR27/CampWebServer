package com.immenser.interserv.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.immenser.interserv")
@EnableWebMvc
public class SpringConfig {
}
