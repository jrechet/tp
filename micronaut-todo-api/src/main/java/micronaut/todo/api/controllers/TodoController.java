package micronaut.todo.api.controllers;

import io.micronaut.http.annotation.*;
import micronaut.todo.api.domains.TodoEntity;
import micronaut.todo.api.repositories.TodoRepository;

import javax.inject.Inject;

@Controller("/todos")
public class TodoController {

	@Inject
	private TodoRepository todoRepository;

	@Get("/{id}")
	public TodoEntity show(@PathVariable Long id) {
		return todoRepository.findById(id).orElse(null);
	}

	@Get("/")
	public Iterable<TodoEntity> list() {
		return todoRepository.findAll();
	}

	@Post
	public Long save(@Body TodoEntity todoEntity) {
		TodoEntity entity = todoRepository.save(todoEntity);
		return entity.getId();
	}

}
