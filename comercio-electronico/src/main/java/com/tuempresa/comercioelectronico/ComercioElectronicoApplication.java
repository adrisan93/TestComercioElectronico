package com.tuempresa.comercioelectronico;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ComercioElectronicoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ComercioElectronicoApplication.class, args);

        Thread thread = new Thread(() -> {
            System.out.println("Presiona 'S' para detener la aplicación...");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = "";
                while (!"S".equalsIgnoreCase(input)) {
                    input = reader.readLine();
                }
                System.out.println("Deteniendo la aplicación...");
                ctx.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.setDaemon(true);
        thread.start();
	}

	@Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Bienvenido a la aplicación de Comercio Electrónico!");
        };
    }
}
