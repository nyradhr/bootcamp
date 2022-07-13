package it.accenture.bootcamp.exceptions;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String message, Class<?> entity, long id) {
        super(String.format(message, entity.getSimpleName(), id));
    }

}
