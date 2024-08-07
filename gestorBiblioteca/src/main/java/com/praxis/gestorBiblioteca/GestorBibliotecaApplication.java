package com.praxis.gestorBiblioteca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestorBibliotecaApplication {
	private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);


	public static void main(String[] args) {
		logger.info("Iniciando Servlet de Inicio de proyecto");

		SpringApplication.run(GestorBibliotecaApplication.class, args);
		logger.warn("Finalizando desafio opcional(?)");
	}


}
