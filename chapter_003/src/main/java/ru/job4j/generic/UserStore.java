package ru.job4j.generic;

public class UserStore extends AbstractStore implements Store {

    public UserStore(int size) {
        super(size);
    }

    @Override
    public void add(Base model) {
        super.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        return super.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id);
    }

    @Override
    public Base findById(String id) {
        return super.findById(id);
    }
}
