package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.essat.model.TypePfe;

public interface IGestionType  extends JpaRepository<TypePfe, Integer>{

}

