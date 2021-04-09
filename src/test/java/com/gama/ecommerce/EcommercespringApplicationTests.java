package com.gama.ecommerce;

import com.gama.ecommerce.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class EcommercespringApplicationTests {
	Usuario usuario = new Usuario();
	Produto produto = new Produto();
	Marca marca = new Marca();
	Categoria categoria = new Categoria();
	Venda venda = new Venda();

	@Test
	void deveCriarClassesVazias() {
		assertThat(usuario).hasAllNullFieldsOrProperties();
		assertThat(produto).hasAllNullFieldsOrProperties();
		//assertThat(venda).hasAllNullFieldsOrProperties();
		assertThat(marca).hasAllNullFieldsOrProperties();
		assertThat(categoria).hasAllNullFieldsOrProperties();
	}
}


/*

	class Calculadora {
		int add(int a, int b)
		{return a+b;}
	}
}
*/
