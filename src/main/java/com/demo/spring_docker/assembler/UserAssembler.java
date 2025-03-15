package com.demo.spring_docker.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.demo.spring_docker.controller.UserController;
import com.demo.spring_docker.entity.User;

@Component
public class UserAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
	@Override
	public EntityModel<User> toModel(User user) {
		return EntityModel.of(user, linkTo(methodOn(UserController.class).getByID(user.getId().longValue())).withSelfRel(),
				linkTo(methodOn(UserController.class).getAll()).withRel("users"));
	}
}
