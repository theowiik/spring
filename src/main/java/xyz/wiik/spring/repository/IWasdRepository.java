package xyz.wiik.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wiik.spring.model.Wasd;

public interface IWasdRepository extends JpaRepository<Wasd, Long> {

}
