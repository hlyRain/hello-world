package cn.exercise.mode.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构
 */
public class ObjectStructure {
    private List<Person> personList = new ArrayList<>();

    public void attach(Person person){
        personList.add(person);
    }
    public void detach(Person person){
        if(personList.size()>0 && personList.contains(person)){
            personList.remove(person);
        }
    }

    public void display(Action visitor){
        for (Person p: personList) {
            p.accept(visitor);
        }
    }


}
