package io.innofang.visitor.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inno Fang on 2018/5/6.
 */
public class ObjectStructure {

    List<Element> elements = new ArrayList<>();

    {
        elements.add(new ElementA());
        elements.add(new ElementB());
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
