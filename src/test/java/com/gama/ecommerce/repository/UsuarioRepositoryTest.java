package com.gama.ecommerce.repository;

import com.gama.ecommerce.api.object.ViaCepObject;
import com.gama.ecommerce.model.Endereco;
import com.gama.ecommerce.model.Usuario;
import com.gama.ecommerce.utils.ConversaoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepositoryParaOTeste;

    @Test
    void deveProcurarUsuarioPorCPFOuLogin() {

        String cpf = "44606521023";
        String login = "ttCPFELog";

        Usuario usuario = new Usuario("testee",
                "email@",
                cpf,
                login,
                "123456",
                ConversaoUtils.converterStringToDate("1990-05-31"),
                new Endereco("Rua Jurema", "21862371", "lunar", "Caxias", "RJ", 0002, "02", "21", "2365", ""));
        usuarioRepositoryParaOTeste.save(usuario);

        boolean seHouver = usuarioRepositoryParaOTeste.existsByCpfOrLogin(cpf, login);

        assertThat(seHouver).isTrue();
    }

    @Test
    void deveChecarSeOLoginNaoExiste() {

        String login = "testador";

        Usuario seHouver = usuarioRepositoryParaOTeste.findByLogin(login);

        assertThat(seHouver).isNull();
    }

    @Test
    void deveChecarQuandoCPFNãoExiste() {
        String cpf = "90567689050";
        Optional<Usuario> seHouver = usuarioRepositoryParaOTeste.findByCpf(cpf);

        assertThat(seHouver).isEmpty();
    }



}
/*



    }

        {
    */
/* Modelo para criação de usuario

    "nome":"teste",
    "email": "teste@gmail.com",
    "senha": "123456",
    "login" : "teste123",
    "cpf": "44606521023",
    "dataNascimento": "1990-05-31",
    "endereco":{"cep": "21862371"}
    *//*


    @Test
    void deveProcurarPorCpf() {
    }

    @Test
    void deveProcurarPorCpfOuLogin() {
    }

    @Test
    void deveProcurarPorEmail() {
    }

    @Test
    void deveProcurarPorId() {
    }

    @Test
    void deveProcurarPorLogin() {
    }
}*/
