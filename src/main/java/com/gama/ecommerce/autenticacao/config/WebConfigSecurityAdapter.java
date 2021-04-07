package com.gama.ecommerce.autenticacao.config;


import com.gama.ecommerce.dto.autenticacao.UsuarioCustomDTO;
import com.gama.ecommerce.model.Usuario;
import com.gama.ecommerce.repository.UsuarioRepository;
import com.gama.ecommerce.utils.ConversaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebConfigSecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/v2/api-docs","/configuration/ui","/swagger-resource/**",
                "/configuration/security", "/swagger-ui.html", "webjars/**", "/h2-console/**");
    }

    @Bean
    public AuthenticationManager customAuthenticationManager()throws Exception{
        return authenticationManagerBean();
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void autheticationManager(AuthenticationManagerBuilder builder,
                                     UsuarioRepository usuarioRepository) throws Exception {
        if (usuarioRepository.count() == 0 ) {
            Usuario usuario = new Usuario();
            usuario.setNome("admin");
            usuario.setLogin("admin");
            usuario.setSenha(passwordEncoder().encode("admin1"));
            usuario.setEmail("doAdmin@admin.com");
            usuario.setDataNascimento(ConversaoUtils.converterStringToDate("2000-05-16"));
            usuario.setCpf("79914865089");
            // usuario.setEndereco();
            usuarioRepository.save(usuario); }
        builder.userDetailsService(login -> new UsuarioCustomDTO(usuarioRepository.findByLogin(login)));

        //http://localhost:8080/oauth/token?grant_type=password&username=admin&password=admin
    }


}
