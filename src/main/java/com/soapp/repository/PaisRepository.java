package com.soapp.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import jakarta.annotation.PostConstruct;
import localhost._8081.ws.Moneda;
import localhost._8081.ws.Pais;

@Component
public class PaisRepository {
 private static final Map<String, Pais> paises = new HashMap<>();
 
 @PostConstruct
 public void initData() {
	 Pais argentina = new Pais();
	 argentina.setNombre("argentina");
	 argentina.setCapital("Ciudad Autonoma de Buenos Aires");
	 argentina.setMoneda(Moneda.ARS);
	 argentina.setPoblacion(46234830);
	 argentina.setBandera("https://flagcdn.com/w2560/ar.png");
	 
	 paises.put(argentina.getNombre(), argentina);
	 
	 Pais colombia = new Pais();
	 colombia.setNombre("colombia");
	 colombia.setCapital("Bogota");
	 colombia.setMoneda(Moneda.COP);
	 colombia.setPoblacion(52210913);
	 colombia.setBandera("https://flagcdn.com/w2560/co.png");
	 
	 
	 paises.put(colombia.getNombre(), colombia);
	 
	 Pais ecuador = new Pais();
	 ecuador.setNombre("ecuador");
	 ecuador.setCapital("Quito");
	 ecuador.setMoneda(Moneda.USD);
	 ecuador.setPoblacion(1775700);
	 ecuador.setBandera("https://flagcdn.com/w2560/ec.png");
	 
	 paises.put(ecuador.getNombre(), ecuador);
 }
 
 public Pais encontrarPais (String name) {
	 Assert.notNull(name, "El nombre del pais no puede estar vacio");
	 return paises.get(name.toLowerCase());
 }
}
