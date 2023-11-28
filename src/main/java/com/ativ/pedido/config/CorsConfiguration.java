// Pacote onde a classe está localizada
package com.ativ.pedido.config;

// Importação de classes necessárias do Spring Framework
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Classe de configuração para tratar CORS (Cross-Origin Resource Sharing)
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    // Método para adicionar configurações específicas para CORS
    @Override
    public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        // Adiciona mapeamento CORS para todos os caminhos da aplicação
        registry.addMapping("/**")
                // Permite solicitações somente da origem especificada
                .allowedOrigins("http://localhost:5173")
                // Define os métodos HTTP permitidos para solicitações CORS
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
                // Permite qualquer cabeçalho nas solicitações
                .allowedHeaders("*")
                // Permite a inclusão de credenciais, como cookies, nas solicitações
                .allowCredentials(true);
    }
}
