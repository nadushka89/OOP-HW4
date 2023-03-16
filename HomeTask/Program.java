package HomeTask;

public class Program {
    public static void main(String[] args) {
        DynamicClass <Integer> intList = new DynamicClass<>();
        intList.add(58);
        intList.add(25);
        intList.add(41);
        intList.add(59);
        intList.add(100);
        intList.add(36);
        intList.add(47);
        intList.add(89);
        intList.add(54);
        intList.add(36);
        intList.add(7);
        intList.add(2);
        System.out.println("\nМассив чисел:");
        intList.printArray();
        System.out.println();
        try {
            intList.sortInsert();
            System.out.print("Результат cортировка простыми вставками:");
            intList.printArray();
        } catch (NonComparableEx e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("\nМинимальное значение массива %d\n", intList.minArray());
        System.out.printf("Максимальное значение массива %d\n", intList.maxArray());
        System.out.printf("Сумма всех значений массива %d\n", intList.sumArray());
        System.out.printf("Произведение всех значений массива %d\n", intList.multArray());
        System.out.printf("Поиск элемента по индексу %d\n", intList.findIndex(52));
        System.out.print(intList.findArray(2));
        System.out.println();
        intList.removeForIndex(2);
        intList.removeForIndex(5);
        intList.printArray();
        System.out.println();
        intList.removeArr(100);
        intList.printArray();
        System.out.println();
        try {
            intList.sortBubble();
            System.out.print("Результат пузырьковая сортировка:");
            intList.printArray();
        } catch (NonComparableEx e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            intList.sortSelection();
            System.out.print("Результат Сортировка простым выбором:");
            intList.printArray();
        } catch (NonComparableEx e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nМассив стринговый:");
        DynamicClass <String> stringList = new DynamicClass<>();
        stringList.add("Стол");
        stringList.add("Стул");
        stringList.add("Диван");
        stringList.add("Скамейка");
        stringList.add("Кровать");
        stringList.add("Полка");
        stringList.add("Шкаф");
        stringList.add("Кухня");
        stringList.add("Дверь");
        stringList.printArray();
        stringList.removeArr("Полка");
        stringList.printArray();
        stringList.removeForIndex(3);
        stringList.printArray();





    }
    

}
