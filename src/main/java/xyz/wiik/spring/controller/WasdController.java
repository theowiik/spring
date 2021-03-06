package xyz.wiik.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
