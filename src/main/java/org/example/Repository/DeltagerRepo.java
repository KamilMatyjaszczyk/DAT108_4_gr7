package org.example.Repository;

import org.example.Model.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeltagerRepo extends JpaRepository<Deltager, String> {

}
