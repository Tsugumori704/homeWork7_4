import java.util.Random;

public class MyArrayList<T> {

    private Object[] date;
    private int size;
    private int capasity;

    public MyArrayList(int capasity) {
        this.capasity = capasity;
        this.size = 0;
        this.date = new Object[capasity];
    }

    public MyArrayList() {
        this.capasity = 10;
        this.size = 0;
        this.date = new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public void add(T inElement) {
        ensureCapacity(size + 1);
        date[size] = inElement;
        size++;
    }

/*
    public void add(T[] inElement) {
        ensureCapacity(size + inElement.length);
        Object[] newDate = new Object[capasity];
        System.arraycopy(inElement, 0, newDate, size, inElement.length);
        System.arraycopy(date, 0, newDate, 0, size);
        date = newDate;
        size += inElement.length;
        capasity += inElement.length;
    }
*/

    public Object getDate(int index) {
        return date[index];
    }

    public int getCapasity() {
        return capasity;
    }

    /**
     * Возвращает значение колличества элементов в MyArrayList
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String toString = "";
        for (Object element : date) {
            toString += " " + element;
        }

        return "MyArrayList{" +
                "date=" + toString +
                '}';
    }

    private void ensureCapacity(int minCapasity) {
        if (minCapasity > capasity) {
            int newCapasity = (int) (capasity * 1.5) + 1;
            capasity = newCapasity;
            Object[] newDate = new Object[newCapasity];
            System.arraycopy(date, 0, newDate, 0, size);
            date = newDate;
            if (minCapasity > newCapasity) {
                ensureCapacity(minCapasity);
            }
        }
    }

    /**
     * Добавление элемента в конец массива
     */
    public void pushBack(T inElement) {
        Object[] newDate = new Object[capasity + 1];
        System.arraycopy(date, 0, newDate, 0, capasity);
        newDate[capasity] = inElement;
        date = newDate;
        size++;
        capasity++;
    }

    /**
     * Удаление первого элемента из массива
     */
    public void popFront() {
        Object[] newDate = new Object[capasity - 1];
        System.arraycopy(date, 1, newDate, 0, capasity - 1);
        date = newDate;
        size--;
        capasity--;
    }

    /**
     * Добавление нового элемента в начало массива
     */
    public void pushFront(T inElement) {
        Object[] newDate = new Object[capasity + 1];
        System.arraycopy(date, 0, newDate, 1, capasity);
        newDate[0] = inElement;
        date = newDate;
        size++;
        capasity++;
    }

    /**
     * вставка нового элемента в массив по указанному
     * индексу, с проверкой на выход за пределы массива
     */
    public void insert(T inElement, int index) {
        if (index == 0) {
            pushFront(inElement);
        } else if (index == capasity) {
            pushBack(inElement);
        } else if (index < capasity) {
            Object[] newDate = new Object[capasity + 1];
            System.arraycopy(date, 0, newDate, 0, index);
            System.arraycopy(date, index, newDate, index + 1, date.length - index);
            newDate[index] = inElement;
            date = newDate;
            size++;
            capasity++;
        }
    }

    /**
     * Удаление одного элемента по указанному индексу
     */
    public void removeAt(int index) {
        if (index == 0) {
            popFront();
        } else if (index < capasity) {
            Object[] newDate = new Object[capasity - 1];
            System.arraycopy(date, 0, newDate, 0, index);
            System.arraycopy(date, index + 1, newDate, index, date.length - index - 1);
            date = newDate;
            size--;
            capasity--;
        }
    }

    /**
     * Удаление одного элемента, значение которого
     * совпадает со значением переданного параметра
     */
    public void remove(T inElement) {
        int index = 0;
        for (Object element : date) {
            if (element.equals(inElement)) {
                removeAt(index);
                break;
            }
            index++;
        }
    }

    /**
     * Удаление всех элементов, значения которых
     * совпадает со значением переданного параметра
     */
    public void removeAll(T inElement) {
        int index = 0;
        for (Object element : date) {
            if (element.equals(inElement)) {
                remove(inElement);
            }
            index++;
        }
    }

    /**
     * Удаление последнего элемента из массива
     */
    public void popBack() {
        removeAt(capasity - 1);
    }

    /**
     * Обнуление массива – всем элементам массива по
     * индексам от 0 до size-1 присвоить значение null, полю size
     * присвоить значение 0
     */
    public void clear() {
        int index = 0;
        for (Object element : date) {
            date[index] = null;
            index++;
        }
        size = 0;
    }

    /**
     * Метод возвращает true, если size = 0, и false в
     * обратном случае
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Метод подгоняет значение capacity под size,
     * естественно с перевыделением памяти
     */
    public void trimToSize() {
        int index = 0;
        Object[] newDate = new Object[size];
        for (Object element : date) {
            if (element != null) {
                newDate[index] = element;
                index++;
            }
        }
        date = newDate;
        capasity = size;
    }

    /**
     * Линейный поиск слева направо первого вхождения
     * в массив указанного значения. В результате работы вернуть
     * индекс найденного элемента, а eсли ничего не найдено,
     * вернуть -1
     */
    public int indexOf(T inElement) {
        int index = 0;
        for (Object element : date) {
            if (element != null && element.equals(inElement)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Линейный поиск справа налево вхождения в
     * массив указанного значения. В результате работы вернуть
     * индекс найденного элемента, а eсли ничего не найдено,
     * вернуть -1
     */
    public int lastIndexOf(T inElement) {

        for (int index = capasity - 1; index > 0; index--) {
            if (inElement != null && date[index] != null && date[index].equals(inElement)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Изменение порядка следования элементов в массиве
     * на противоположный
     */
    public void reverse() {
        Object[] newDate = new Object[capasity];
        int steps = 0;
        for (int index = capasity - 1; index >= 0; index--) {
            newDate[steps] = date[index];
            steps++;
        }
        date = newDate;
    }

    /**
     * Случайное перемешивание элементов массива
     */
    public void shufe() {
        Random rnd = new Random();
        for (int i = 1; i < date.length; i++) {
            int j = rnd.nextInt(i);
            Object temp = date[i];
            date[i] = date[j];
            date[j] = temp;
        }
    }

    /**
     * В качестве параметра передается ссылка на другой
     * объект класса MyArrayList. Метод сравнивает массивы не
     * только по количеству элементов, но и по их содержимому
     */

    public boolean equals(MyArrayList<T> inArray) {

        Object[] inDate = inArray.date;
        if (capasity != inDate.length) {
            return false;
        }
        int chek = 0;
        for (int index = 0; index < capasity; index++) {
            if (date[index] != null && inDate[index] != null) {
                if (date[index].equals(inDate[index])) {
                    chek++;
                }
            }
        }
        if (chek == size) {
            return true;
        }
        return false;
    }

    /**
     * Возврат копии элемента массива по указанному
     * индексу, с проверкой на выход за пределы массива
     */
    public T getElementAt(int index) {
        if (index + 1 > capasity) {
            return null;
        } else {
            T element = (T) date[index];
            return element;
        }
    }

    /**
     * метод создает точную копию
     * MyArrayList и возвращает ссылку на эту копию
     */
    @Override
    public MyArrayList<T> clone() {
        MyArrayList<T> newDate = new MyArrayList<T>();
        //newDate = this;
        newDate.date = this.date;
        return newDate;
    }
}
