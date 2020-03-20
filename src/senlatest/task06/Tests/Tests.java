package senlatest.task06.Tests;/*
package task06.Tests;

import org.junit.jupiter.api.Test;
import task06.Backpack;
import task06.Thing;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    @Test
    void checkEqualsList_01(){
        Thing thing1 = new Thing(100,100);
        Thing thing2 = new Thing(200,200);
        Thing thing3 = new Thing(300, 300);
        ArrayList<Thing> list1 = new ArrayList<>();
        list1.add(thing1);
        list1.add(thing2);
        list1.add(thing3);
        Collections.sort(list1);
        ArrayList<Thing> list2 = new ArrayList<>();
        list2.add(thing3);
        list2.add(thing2);
        list2.add(thing1);
        Collections.sort(list2);
        assertEquals(true,list1.equals(list2));
    }

    @Test
    void checkEqualsList_02(){
        Thing thing1 = new Thing(100,100);
        Thing thing2 = new Thing(100, 100);
        ArrayList<Thing> list1 = new ArrayList<>();
        list1.add(thing1);
        ArrayList<Thing> list2 = new ArrayList<>();
        list2.add(thing2);
        assertEquals(false,list1.equals(list2));
    }

    @Test
    void checkEqualsBackpack_01(){
        Thing thing1 = new Thing(100,100);
        Thing thing2 = new Thing(200, 100);
        Backpack backpack1 = new Backpack(1000);
        Backpack backpack2 = new Backpack(1000);
        backpack1.addThing(thing1);
        backpack1.addThing(thing2);
        backpack2.addThing(thing2);
        backpack2.addThing(thing1);
        assertEquals(true,backpack1.equals(backpack2));
    }

    @Test
    void checkEqualsBackpack_02(){
        Thing thing1 = new Thing(100,100);
        Thing thing2 = new Thing(100, 100);
        Backpack backpack1 = new Backpack(1000);
        Backpack backpack2 = new Backpack(1000);
        backpack1.addThing(thing1);
        backpack2.addThing(thing2);
        assertEquals(false,backpack1.equals(backpack2));
    }
}
*/