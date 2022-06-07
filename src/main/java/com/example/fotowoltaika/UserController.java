package com.example.fotowoltaika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController// This means that this class is a Controller
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @GetMapping("/list")
    public CollectionModel<EntityModel<User>> all() {

        List<EntityModel<User>> users = userRepository.findAll().stream()
                .map(user -> EntityModel.of(user,
                        //WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).one(user.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).all()).withRel("users")))
                .collect(Collectors.toList());

        return CollectionModel.of(users, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).all()).withSelfRel());

    /*
    CollectionModel<EntityModel<User>> all() {

    List<EntityModel<User>> users = repository.findAll().stream()
      .map(user -> EntityModel.of(user,
          linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
          linkTo(methodOn(UserController.class).all()).withRel("users")))
      .collect(Collectors.toList());

  return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
}
    * */
    }
}
