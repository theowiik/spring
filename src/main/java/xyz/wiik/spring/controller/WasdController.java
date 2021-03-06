package xyz.wiik.spring.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wiik.spring.model.Wasd;
import xyz.wiik.spring.repository.IWasdRepository;

@RestController
@RequestMapping("/api/v1/")
public class WasdController {

  @Autowired
  private IWasdRepository wasdRepository;

  @GetMapping("/wasds")
  public List<Wasd> index() {
    return wasdRepository.findAll();
  }

  @GetMapping("/wasds/{id}")
  public Wasd get(@PathVariable(value = "id") Long wasdId) {
    return wasdRepository.findById(wasdId).get();
  }

  @PostMapping("/wasds/random")
  public ResponseEntity<Wasd> create() {
    var wasd = new Wasd("name: " + UUID.randomUUID(), UUID.randomUUID().toString());
    return ResponseEntity.ok(wasdRepository.save(wasd));
  }
}
