package it.accenture.bootcamp.models.abstractions;

public interface WithId<K> {
    K getId();
    void setId(K id);
}
