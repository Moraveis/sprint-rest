package me.joao.springrest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"me.joao.springrest"})
@EnableWebMvc
public class SpringConfig {
}
