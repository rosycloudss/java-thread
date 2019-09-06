package util;

public class Sort {

    /**
     * 冒泡排序
     *
     * @param array  要排序的数组
     * @param isDesc 是否降序
     */
    public static void bubbleSort(int[] array, boolean isDesc) {
        int len;
        if (array == null || (len = array.length) == 0) {
            return;
        }
        int sorted = 0; // sorted 之前的元素已经拍好序了
        for (int i = 0; i < len - 1; i++) {
            int s = 0;
            for (int j = len - 1; j > sorted; j--) {
                if (isDesc) {
                    if (array[j] > array[j - 1]) {
                        swap(array, j, j - 1);
                        s = j - 1;
                    }
                } else {
                    if (array[j] < array[j - 1]) {
                        swap(array, j, j - 1);
                        s = j - 1;
                    }
                }
            }
            sorted = s;
            if (sorted == len) {
                break;// 所有的元素已经排序了
            }
//            printAll(array);
        }
    }

    /**
     * 鸡尾酒排序
     * 进行双向循环
     * 正向循环 将最大或最小元素向末尾移动
     * 逆向循环 将最小或最大元素向顶部移动
     *
     * @param array
     * @param isDesc 是否降序排序
     */
    public static void cocktailSort(int[] array, boolean isDesc) {
        if (array == null || array.length == 0) {
            return;
        }
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            int newBegin = end;
            int newEnd = begin;

            // 正向循环
            for (int j = begin; j < end; j++) {
                if (isDesc) {
                    if (array[j] < array[j + 1]) {
                        swap(array, j, j + 1);
                        newEnd = j + 1;
                    }
                } else {
                    if (array[j] > array[j + 1]) {
                        swap(array, j, j + 1);
                        newEnd = j + 1;
                    }
                }
            }

            end = newEnd - 1;

            // 逆向循环
            for (int j = end; j > begin - 1; j--) {
                if (isDesc) {
                    if (array[j] < array[j + 1]) {
                        swap(array, j, j + 1);
                        newBegin = j;
                    }
                } else {
                    if (array[j] > array[j + 1]) {
                        swap(array, j, j + 1);
                        newBegin = j;
                    }
                }
            }
            begin = newBegin + 1;
//            printAll(array);
        }
    }

    /**
     * 插入排序
     *
     * @param array
     * @param isDesc
     */
    public static void insertionSort(int[] array, boolean isDesc) {
        int len;
        if (array == null || (len = array.length) == 0) {
            return;
        }
        for (int i = 1; i < len; i++) {
            int temp = array[i];
            int insertIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (isDesc) {
                    if (temp > array[j]) {
                        array[j + 1] = array[j];
                        insertIndex = j;
                    }
                } else {
                    if (temp < array[j]) {
                        array[j + 1] = array[j];
                        insertIndex = j;
                    }
                }
            }
            array[insertIndex] = temp;
//            printAll(array);
        }
    }

    /**
     * 交换数组中的两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printAll(int[] array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        ;
    }
}
