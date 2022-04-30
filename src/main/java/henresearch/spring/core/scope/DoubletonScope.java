package henresearch.spring.core.scope;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.ArrayList;
import java.util.List;

public class DoubletonScope implements Scope {

    //langkah 1
    //bikin dulu scopenya
    //setelah dibikin lalu kita registerkan si scope itu.

    //langkah 2 ada di ScopeConfiguration

    private List<Object> objects = new ArrayList<>(2);

    private long counter = -1L;

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        counter++;

        if(objects.size() == 2){
            int index = (int) (counter % 2);
            return objects.get(index);
        }else{
            Object object = objectFactory.getObject();
            objects.add(object);
            return object;
        }
    }

    @Override
    public Object remove(String s) {
        if(!objects.isEmpty()){
            return objects.remove(0);
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
