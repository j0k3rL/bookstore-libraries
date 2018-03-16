package com.bookstore.libraries.ws;

public interface ObjectMapper<E, D> {

	E toEntity(D dto);
	
	D toDTO(E entity);
}