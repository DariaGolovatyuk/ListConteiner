package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    List<Double> list =new List<Double>();

    @BeforeEach
    void setUp() {
        list.addInConteiner(4.0,1);
        list.addInConteiner(3.0, 2);
        list.addInConteiner(5.0, 1);
        list.addInConteiner(2.0, 4);
        list.addInConteiner(9.0, 3);
    }

    @org.junit.jupiter.api.Test
    void addInConteiner() {
        String result1=list.printList();
        String result2=" 5.0 4.0 9.0 3.0 2.0 ";
        Assert.assertEquals(result1,result2);

    }

    @Test
    void deleteFromConteiner() {
        list.deleteFromConteiner(2);
        list.deleteFromConteiner(1);
        list.deleteFromConteiner(3);
        String result1=list.printList();
        String result2=" 9.0 3.0 ";
        Assert.assertEquals(result1,result2);
    }

    @Test
    void getElem() {
        String result="";
        result+=list.getElem(1);
        result+=list.getElem(2);
        result+=list.getElem(5);
        String result_new="5.04.02.0";
        Assert.assertEquals(result,result_new);
    }

    @org.junit.jupiter.api.Test
    void getFirstPlace() {
    int result1=list.getFirstPlace(2.0);
    Assert.assertEquals(result1,5);

    }
}