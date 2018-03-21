package com.bookstore.libraries.ws;

public interface ObjectMapper<E, T> {

	E toEntity(T to);
	
	T toDTO(E entity);
}