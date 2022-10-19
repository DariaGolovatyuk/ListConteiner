package org.example;
import org.junit.jupiter.api.Test;

/**
 * Шаблонный класс List - это контэйнер элементов, использующий огдносвязный список и обладающий методами добавления, удаления и поиска элементов
 * @param <T> тип шаблонного класса
 */
public class List<T> {
    private Node <T> begin;
    private Node <T> end;
    private int size;

    /**
     * Метод провреряет пуст ли текущий контейнер
     * @return true в случае, если иупшт равен null, иначе false
     */
    private boolean isEmpty() {
        return begin == null;
    }

    /**
     *  Конструктор класса List
     */
    public List () {
        begin = null;
        end = null;
        size = 0;
    }

    /**
     * Метод находит указатель на эелемент перед заданным
     * @param place место заданного элемента в контейнере
     * @return указатель на найденный элемент
     */
    protected Node <T> find(int place) {
        Node<T> p1 = null;
        Node<T> p2 = begin;
        int place_find = 1;
        if(place<=size+1 && place!=1) {
            while (p2.next != null && place_find < place) {
                place_find++;
                p1 = p2;
                p2 = p2.next;
            }
            if (p2.next == null && place_find != place) p1=p2;
        }
        return p1;
    }

    /**
     * Метод находит первый номер места вхождения элемента в контейнере по его значению
     * @param elem элемент, номер которого необходимо найти
     * @return место заданного элемента в контейнере или -1 при отсутствии элемента
     */
    private int findPlace(T elem)
    {
        Node<T> p=begin;
        int place=1;
        while(p!=null&&!p.x.equals(elem))
        {
            place++;
            p=p.next;
        }
        if (p!=null) return place;
        else return -1;
    }
    /**
     * Метод возвращает элемент по номеру его места
     * @param place_elem местно элемента, которое необходимо получить
     * @return значение переменной или null в случае не нахождение элемента
     */

    @Test
    public T getElem(int place_elem) {
        T x_;
        if (place_elem <= size) {
            Node<T> p = find(place_elem);
            if (p == null) x_= begin.x;
            else x_ = p.next.x;
            return x_;
        }
        return null;
    }

    /**
     * Метод возвращает номер первого вхождения в контейнер заданного элемента
     * @param elem заданный элемент, номер которого необходимо найти
     * @return место заданного элемента
     */
    @Test
    public int getFirstPlace(T elem) {

        int place = findPlace(elem);
        return place;
    }

    /**
     * Метод добавляет элемент в начало контейнера
     * @param new_x элемент, добавляемый в контейнер
     */

    protected void addToBegin(T new_x) {
        Node<T> p = new Node(new_x);
        p.x = new_x;
        p.next = begin;
        begin = p;
        if(begin.next==null)
            end=begin;
    }


    /**
     * Метод добавляет элемент в конец контейнера
     * @param new_x элемент, добавляемый в контейнер
     */
    protected void addAfterEnd(T new_x) {
        Node<T> p = new Node(new_x);
        p.x = new_x;
        end.next = p;
        end = p;
    }

    /**
     * Метод добавляет элемент после заданного
     * @param new_x элемент, добавляемый в контейнер
     * @param pN указатель на элемент, после котрого необходимо добавить заданный
     */
    protected void addAfterList(T new_x, Node <T> pN) {
        if (pN== end) addAfterEnd(new_x);
        else {
            Node<T> p = new Node(new_x);
            p.x = new_x;
            p.next = pN.next;
            pN.next = p;
        }
    }

    /**
     * Метод добавляет элемент на определенное место в контейнере
     * @param new_x элемент, добавляемый в контейнер
     * @param place_elem место, в которое необходимо добавить элемент
     * @return возврвщвет true в случае корректного добавления и false в случае ошибочно переданного места добавления элемента
     */
    @Test
    public boolean addInConteiner(T new_x, int place_elem) {
        if (place_elem <= size+1) {
            if (!isEmpty()) {
                Node<T> p = find( place_elem);
                if (p == null) addToBegin(new_x);
                else addAfterList(new_x, p);
            }
            else addToBegin(new_x);
            size++;
            return true;
        }
        return false;
    }


    /**
     * Метод удаляет элемент из начала контейнера
     */
    protected void deleteFromBegin() {
        if (!isEmpty()) {
            if (begin == end) {
                begin = null;
                end = null;
            }
            else {
                Node p = begin;
                begin = p.next;
                p.next = null;
                p = null;
            }
        }
    }


    /**
     * Метод удаляет элемент после заданного указателя на элемент в  контейнере
     * @param pN указатель на предществующий удаляемрму элементу
     */
    protected void deleteAfterList(Node <T> pN) {
        Node<T> p = pN.next;
        if (p == end) {
            pN.next = null;
            end = pN;
        }
        if (p != null) {
            pN.next = p.next;
            p.next = null;
            p = null;
        }
    }


    /**
     * Метод удаляет элемент из контейнера по заданному месту
     * @param place_elem место, из которого необходимо удалить элемент
     * @return true в случае корректного добавления и false в случае некорректного добавления
     */
    @Test
    public boolean deleteFromConteiner(int place_elem) {
        boolean tmp=false;
        if (place_elem <= size ) {
            Node<T> p = find( place_elem);
            if (p == null) deleteFromBegin();
            else deleteAfterList(p);
            size--;
            tmp=true;
        }
        return tmp;
    }


    /**
     * Метод print выводит список элементов
     * @return rezult - список в виде строки
     */
    public String printList() {
        String result=" ";
        if (!isEmpty()) {
            Node<T> p = begin;
            while (p != null) {
                result=result+p.x+" ";
                p = p.next;
            }
        }
        else System.out.println("Набор элементов пуст!");
        return result;
    }
}
