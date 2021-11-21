package ua.sumdu.j2se.belokon.tasks;
import java.util.Arrays;

public class ArrayTaskList {
    private Task[] arr = new Task[10];
    private int index = 0;
    /*метод, що додає до списку вказану задач*/
    public void add(Task task) {
        if (index == arr.length - 1) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[index] = task;
        index++;
    }
    /*метод, що видаляє задачу зі списку і повертає істину, якщо така задача була у списку.
    Якщо у списку було декілька таких задач, необхідно видалити одну будь-яку.*/
    public boolean remove(Task task) {
        boolean presence = false;
        for (int i = 0; i < index; i++) {
            if (task.equals(arr[i])) {
                arr[i] = null;
                presence = true;
            }
            if (presence) {
                arr[i] = arr[i + 1];
            }
        }
        return presence;
    }
    /*метод, що повертає кількість задач у списку*/
    public int size() {
        return index;
    }
    /* метод, що повертає задачу, яка знаходиться на вказаному місці у
    списку, перша задача має індекс 0*/
    public Task getTask(int index) {
        if (index < arr.length - 1) {
            return arr[index];
        }
        return null;
    }
    /* метод, що повертає підмножину задач, які заплановані на виконання хоча б раз після часу from і не пізніше ніж to*/
    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList TaskList = new ArrayTaskList();
        for (int i = 0; i < index; i++) {
            Task task = arr[i];
            int time = 0;
            if (task != null && task.isActive()) {
                if (task.isRepeated()) {
                    time = task.getStartTime();
                } else if (!task.isRepeated() && task.isActive()) {
                    time = task.getTime();
                }
                if (time > from && time < to) {
                    TaskList.add(task);
                }
            }
        }
        return TaskList;
    }
}
