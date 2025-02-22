package com.travelagency.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serialized<T> implements Serializable {
    public static Map<Class<?>, List<Serialized<?>>> database = new HashMap<>();

    public Serialized() {
        Class<?> c = this.getClass();
        List<Serialized<?>> list = database.computeIfAbsent(c, k -> new ArrayList<>());
        list.add(this);

        /*List<T> list;

        if(database.containsKey(c)){
            list = (List<T>) database.get(c);
        }else{
            list = new ArrayList<>();
            database.put(c, (List<Class<?>>) list);
        }
        list.add((T) this);*/
    }

    public static void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(database);
    }

    public static void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        database = (Map<Class<?>, List<Serialized<?>>>) stream.readObject();
    }
}