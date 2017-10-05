package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;


public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {

    private final static Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        int l = (int) (collection.size()/.75f + 1);
        int max = 16 > l ? 16: l;
        map = new HashMap<>(max);
        this.addAll(collection);
    }
    //Capacity для объекта map должно быть вычислено по формуле максимальное из 16 и (collection.size()/.75f).

    @Override
    public boolean add(E e) {
        return null == map.put(e,PRESENT);
    }


    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();

    }

    @Override
    public int size() {
        //return map.keySet().size();
        return map.size();

    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        //return map.keySet().isEmpty();
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public Object clone() {
       AmigoSet<E> amigoSet
                //= new AmigoSet<>()
        ;

        try {
            amigoSet = new AmigoSet<>();
            amigoSet.addAll(this);
            amigoSet.map.putAll((Map) this.map.clone());

        }
        catch (Exception e){
            throw new InternalError();
        }

        return amigoSet;
    }

/* В методе writeObject должен быть вызван метод defaultWriteObject на объекте типа ObjectOutputStream полученном в качестве параметра.
5. В методе readObject должен быть вызван метод defaultReadObject на объекте типа ObjectInputStream полученном в качестве параметра.*/

private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();

        out.writeObject(map.size());

        for(E e:map.keySet()){
            out.writeObject(e);
        }
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        int size = (int)in.readObject();
        Set<E> set = new HashSet<>();
        for(int i =0;i<size;i++){
            set.add((E)in.readObject());
        }
        int capacity = (int)in.readObject();
        float loadFactor = (float)in.readObject();
        map = new HashMap<>(capacity,loadFactor);
        for(E e:set){
            map.put(e,PRESENT);
        }
    }


}