package com.cjrequena.sample.controller;

import com.cjrequena.sample.db.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 *
 * @author cjrequena
 */
@Controller
public class IndexController {

  @Autowired AlbumRepository albumRepository;

  @GetMapping({"/", "/index"})
  public String index(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
    this.albumRepository.findAll();
    model.addAttribute("name", name);
    return "index";
  }
}
