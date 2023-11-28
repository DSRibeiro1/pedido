// package com.ativ.pedido.Security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// // Seja reconhecido como a classe que habilita a segurança web
// @EnableWebSecurity
// public class SecurityConfig {

// // Filtro: acessos sem autorizações. Acessos públicos
// @Bean
// public SecurityFilterChain configure(HttpSecurity http) throws Exception {

// // HttpSecurity (http) authorizeHttpRequests:
// // configurara as regras de autorização para solicitações HTTP em seu
// aplicativo
// // Spring Security

// http.authorizeHttpRequests(

// // Este bloco configura as regras de autorização usando o objeto
// // authorizeConfig.
// authorizeConfig -> {

// // Matchers: define critérios de combinação de solicitações e aplicar regras
// de
// // segurança de acordo com esses critérios.

// authorizeConfig.requestMatchers("/logout").permitAll();

// authorizeConfig.requestMatchers("/endereco/lista").permitAll();
// // /* variáveis, no caso o ID
// authorizeConfig.requestMatchers("/endereco/busca/*").permitAll();

// authorizeConfig.requestMatchers("/formaDePagamento/lista").permitAll();
// // /* variáveis, no caso o ID
// authorizeConfig.requestMatchers("/formaDePagamento/busca*").permitAll();

// authorizeConfig.requestMatchers("/pedido/lista").permitAll();
// // /* variáveis, no caso o ID
// authorizeConfig.requestMatchers("/pedido/busca/*").permitAll();

// authorizeConfig.requestMatchers("/usuario/lista").permitAll();
// // /* variáveis, no caso o ID
// authorizeConfig.requestMatchers("/usuario/busca/*").permitAll();

// authorizeConfig.requestMatchers("/produto/lista").permitAll();
// // /* variáveis, no caso o ID
// authorizeConfig.requestMatchers("/produto/busca/*").permitAll();

// /*
// * anyRequest: O que não foi definido anteriormente será autenticado, sendo:
// * excluir e cadastro
// * ------------------------------------------------------------------------
// * autenticated: solicitação requer autenticação para ser acessada
// *
// * authorizeConfig.anyRequest().authenticated();
// */

// })
// // Acessa o Login por default, ou seja, caso não digite nada
// // .formLogin(Customizer.withDefaults());

// .oauth2Login(Customizer.withDefaults());

// /*
// * O método retorna o objeto SecurityFilterChain construído usando
// * http.build(), que encapsula a configuração de segurança.
// */
// return http.build();
// }
// }
