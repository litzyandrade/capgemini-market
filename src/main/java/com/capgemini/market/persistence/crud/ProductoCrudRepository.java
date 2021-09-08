package com.capgemini.market.persistence.crud;

import com.capgemini.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> { //la Entity (Tabla) , Tipo de llave primaria
/*
    @Query(value = "SELECT * from productos where id_categoria = ? order by nombres desc", nativeQuery = true)
    List<Producto> findByCategory(Integer idCategoria); //Query nativo
*/
    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria); //QueryMethods

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock, Boolean estado);

}
