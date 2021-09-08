package com.capgemini.market.persistence.mapper;

import com.capgemini.market.domain.Client;
import com.capgemini.market.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "id", target = "clientId"),
            @Mapping(source = "nombre", target= "name"),
            @Mapping(source = "apellidos", target = "lastname"),
            @Mapping(source = "celular", target = "phoneNumber"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "correoElectronico", target = "email"),
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);


    @InheritInverseConfiguration
    @Mapping(target = "compras", ignore = true)
    Cliente toCliente(Client client);
}
