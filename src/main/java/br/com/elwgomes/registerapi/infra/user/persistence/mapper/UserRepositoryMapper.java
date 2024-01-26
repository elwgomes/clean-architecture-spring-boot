package br.com.elwgomes.registerapi.infra.user.persistence.mapper;

public interface UserRepositoryMapper<D, E, R> {
    D mapToDomain(E entity);
    E mapToEntity(D domain);
    R mapEntityToDto(E entity);
    R mapDomainToDto(D domain);
}
