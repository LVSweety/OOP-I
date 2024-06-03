package lv.lvs.backend.repo;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.backend.model.Mechanic;

public interface IMechanicRepo extends CrudRepository<Mechanic, Integer> {
    
}
