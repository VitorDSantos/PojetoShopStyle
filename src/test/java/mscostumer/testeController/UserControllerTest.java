package mscostumer.testeController;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;
import mscostumer.controller.UsuarioController;

@WebMvcTest
public class UserControllerTest {
	
	@Autowired
	private UsuarioController userController;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.userController);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarUsuario() {
		given()
		.accept(ContentType.JSON)
	.when()
		.get("/api/user")
	.then()
		.statusCode(HttpStatus.OK.value());
	}
}
