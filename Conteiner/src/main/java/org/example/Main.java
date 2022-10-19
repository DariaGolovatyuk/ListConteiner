package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
        List<Double> list = new List <Double>();
        boolean repeat = true;

        while (repeat) {
            System.out.println("Выберите действие: " + "\n" + " __(1)-Добавление элемента в заданное место" + "\n" + " __(2)-Удаление элемента из заданного места" + "\n" + " __(3)-Поиск элемента по заданному месту" + "\n"+ " __(4)-Поиск места по заданному элементу" + "\n");
            int n = scan.nextInt();
            switch (n) {
                case 1: {
                    System.out.println("Текущий набор:" + "\n");
                    System.out.println(list.printList());
                    System.out.println();
                    System.out.println("Введите элемент, который необходимо добавить: " + "\n");
                    double x = scan.nextInt();
                    System.out.println("Введите номер места на которое нужно поставить элемент: " + "\n");
                    int place = scan.nextInt();
                    if(list.addInConteiner(x, place))
                    {
                        System.out.println("Созданный набор:" + "\n");
                        System.out.println(list.printList());
                        System.out.println();
                    }
                    else System.out.println("Неверно введенное место!" + "\n");
                    break;
                }
                case 2: {
                    System.out.println("Текущий набор:" + "\n");
                    System.out.println(list.printList());
                    System.out.println();
                    System.out.println("Введите номер места с которого хотите удалить элемент: " + "\n");
                    int place = scan.nextInt();
                    if (list.deleteFromConteiner(place))
                    {
                        System.out.println("Созданный набор:" + "\n");
                        System.out.println(list.printList());
                        System.out.println();
                    }
                    else System.out.println("Неверно введенное место!" + "\n");
                    break;
                }
                case 3: {
                    System.out.println("Текущий набор:" + "\n");
                    System.out.println(list.printList());
                    System.out.println();
                    System.out.println("Введите номер места элемента, который хотите получить: " + "\n");
                    int place = scan.nextInt();
                    if(list.getElem(place)==null) System.out.println("Неверно введенное место!" + "\n");
                    else
                    {
                        System.out.print(list.getElem(place));
                        System.out.println();
                    }
                    break;
                }
                case 4: {
                    System.out.println("Текущий набор:" + "\n");
                    System.out.println(list.printList());
                    System.out.println();
                    System.out.println("Введите элемент, у которого хотите узнать место в контейнере: " + "\n");
                    double elem = scan.nextDouble();
                    if(list.getFirstPlace(elem)==-1) System.out.println("Нет такого элемента!" + "\n");
                    else
                    {
                        System.out.print("Место в контейнере: "+list.getFirstPlace(elem));
                        System.out.println();
                    }
                    break;
                }


            }
            System.out.println("Продолжить действия? (Y/N)" + "\n");
            String s = scan.next();
            if (s.equals("Y")) repeat = true;
            else repeat = false;
        }
    }
    }