package ru.job4j.generic;

public class AbstractStore<T extends Base> implements Store<T> {
    private int size;
    private SimpleArray<T> simpleArray = new SimpleArray<>(size);

    public AbstractStore(int size) {
        this.size = size;
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = 0;
        boolean result = false;
        for (T item : simpleArray) {
            if (item.getId().equals(id)) {
                simpleArray.set(index, model);
                result = true;
            }
            index++;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        int index = 0;
        boolean result = false;
        for (T base : simpleArray) {
            if (base.getId().equals(id)) {
                result = simpleArray.remove(index);
                break;
            }
            index++;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        int index = 0;
        for (T base : simpleArray) {
            if (base.getId().equals(id)) {
                result = (T) simpleArray.get(index);
                break;
            }
            index++;
        }
        return result;
    }
}
