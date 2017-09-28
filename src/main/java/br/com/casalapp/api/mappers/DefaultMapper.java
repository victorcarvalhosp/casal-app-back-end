package br.com.casalapp.api.mappers;

public interface DefaultMapper<E, Dto> {
	
	 Dto toDto(E entity);
	 E toEntity(Dto dto);

}
