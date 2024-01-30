package br.com.elwgomes.registerapi.infra.user.persistence.mapper;

import br.com.elwgomes.registerapi.core.user.domain.Address;
import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.dto.AddressDTO;
import br.com.elwgomes.registerapi.core.user.dto.UserDTO;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.AddressEntity;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryMapperImpl implements UserRepositoryMapper<User, UserEntity, UserDTO> {

    @Override
    public User mapToDomain(UserEntity entity) {
        List<Address> addresses = entity.getAddresses().stream().map(address -> new Address(null, address.getZipCode(), address.getCity(), address.getState(), address.getNeighborhood(), address.getStreet(), address.getNumber())).collect(Collectors.toList());
        return new User(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getDocument(), entity.getEmail(), entity.getRole(), addresses);
    }

    @Override
    public UserEntity mapToEntity(User domain) {
        List<AddressEntity> addressesEntity = domain.getAddresses().stream().map(address -> new AddressEntity(null, address.getZipCode(), address.getCity(), address.getState(), address.getNeighborhood(), address.getStreet(), address.getNumber())).collect(Collectors.toList());
        return new UserEntity(domain.getId(), domain.getUsername(), domain.getPassword(), domain.getDocument(), domain.getEmail(), domain.getRole(), addressesEntity);
    }

    @Override
    public UserDTO mapEntityToDto(UserEntity entity) {
        List<AddressDTO> addresses = entity.getAddresses().stream().map(address -> new AddressDTO(address.getZipCode(), address.getCity(), address.getState(), address.getNeighborhood(), address.getStreet(), address.getNumber())).collect(Collectors.toList());
        return new UserDTO(entity.getUsername(), entity.getEmail(), entity.getRole(), addresses);
    }

    @Override
    public UserDTO mapDomainToDto(User domain) {
        List<AddressDTO> addresses = domain.getAddresses().stream().map(address -> new AddressDTO(address.getZipCode(), address.getCity(), address.getState(), address.getNeighborhood(), address.getStreet(), address.getNumber())).collect(Collectors.toList());
        return new UserDTO(domain.getUsername(), domain.getEmail(), domain.getRole(), addresses);
    }

}
