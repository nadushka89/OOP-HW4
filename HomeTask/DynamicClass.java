package HomeTask;

public class DynamicClass<T> {
    private Integer startLeng = 1;
    private Integer lenght;
    private T[] array;

    public DynamicClass() { // Конструктор без параметров
        this.lenght = 0;
        this.array = (T[]) new Object[startLeng];
    }

    public DynamicClass(T[] array) { // Конструктор с параметром T[]
        this.lenght = array.length;
        this.array = array;
    }

    public Integer getLenght() {
        return this.lenght;
    }

    public T[] getArray() {
        return this.array;
    }

    public void printArray() { // печать массива
        System.out.print("[");
        for (int i = 0; i < this.getLenght(); i++) {
            if (i != this.getLenght() - 1) {
                System.out.print(this.array[i] + ", ");
            } else {
                System.out.print(this.array[i]);
            }
        }
        System.out.print("]\n");
    }

    public void add(T element) { // добавление в массив элемента
        if (this.lenght == this.array.length) {
            int newLenght = this.getLenght() + 1;
            T[] newArray = (T[]) new Object[newLenght];
            for (int i = 0; i < this.getLenght(); i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
        this.array[this.lenght++] = element;
    }

    public void removeForIndex(int index) throws IndexOutOfBoundsException { // удаление по индексу
        if (index < 0 || index > this.getLenght()) {
            System.out.printf("Индекс %d выходит за рамки массива, длина данного массива %d ", index, this.getLenght());
        } else {
            int newLenght = this.getLenght() - 1;
            T[] newArray = (T[]) new Object[newLenght];
            int i = 0;
            while (i < index) {
                newArray[i] = this.array[i];
                i++;
            }
            i++;
            while (i < this.getLenght()) {
                newArray[i - 1] = this.array[i];
                i++;
            }
            this.array = newArray;
            this.lenght--;
        }
    }

    public void removeArr(T element) { // Удаление всех элементов с заданным значением
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                removeForIndex(i);
                i--;
            }
        }
    }

    public int minArray() { // Поиск минимума
        int min = (int) this.array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > (int) this.array[i]) {
                min = (int) this.array[i];
            }
        }
        return min;
    }

    public int maxArray() { // Поиск максимума
        int max = (int) this.array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < (int) this.array[i]) {
                max = (int) this.array[i];
            }
        }
        return max;
    }

    public int sumArray() { // Поиск суммы элементов массива
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += (int) this.array[i];
        }
        return result;
    }

    public int multArray() { // Поиск произведения элементов массива
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            result *= (int) this.array[i];
        }
        return result;
    }

    public int findIndex(T element) { // Поиск индекса заданного элемента в массиве, если такого элемента в массиве
                                      // нет то возвращать -1
        int count = 0;
        for (T t : array) {
            if (t == element) {
                return count;
            }
            count++;
        }
        return -1;
    }

    public boolean findArray(T element) { // Проверка наличия элемента в массиве. Возвращает true, если элемент в
                                          // массиве есть, false – нет.
        for (T t : array) {
            if (t == element) {
                return true;
            }
        }
        return false;
    }

    public void sortBubble() throws NonComparableEx { // Пузырьковая сортировка
        T temp = this.array[0];
        if (temp instanceof Comparable) {
            for (int i = 0; i < this.getLenght() - 1; i++) {
                boolean available = false;
                for (int j = 0; j < this.getLenght() - i - 1; j++) {
                    Comparable<T> element = (Comparable<T>) this.array[j];
                    T newElement = this.array[j + 1];
                    if (element.compareTo(newElement) > 0) {
                        swap(j, j + 1);
                        available = true;
                    }
                }
                if (!available) {
                    break;
                }
            }
        } else {
            throw new NonComparableEx(temp.getClass().getSimpleName());
        }
    }

    public void sortInsert() throws NonComparableEx { // Сортировка простыми вставками
        T temp = this.array[0];
        if (temp instanceof Comparable) {
            for (int i = 0; i < this.getLenght(); i++) {
                for (int j = i; j > 0; j--) {
                    Comparable<T> element = (Comparable) this.array[j];
                    T previousElement = this.array[j - 1];
                    if (element.compareTo(previousElement) < 0) {
                        swap(j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        } else {
            throw new NonComparableEx(temp.getClass().getSimpleName());
        }

    }

    public void sortSelection() throws NonComparableEx { // Сортировка простым выбором
        T min = this.array[0];
        if (min instanceof Comparable) {
            for (int i = 0; i < this.getLenght(); i++) {
                min = this.array[i];
                int minIndex = i;
                for (int j = i; j < this.getLenght(); j++) {
                    Comparable<T> element = (Comparable<T>) this.array[j];
                    if (element.compareTo(min) < 0) {
                        min = this.array[j];
                        minIndex = j;
                    }

                }
                if (i != minIndex) {
                    swap(i, minIndex);
                }
            }
        } else {
            throw new NonComparableEx(min.getClass().getSimpleName());
        }

    }

    private void swap(int i, int j) {
        T temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }
}
