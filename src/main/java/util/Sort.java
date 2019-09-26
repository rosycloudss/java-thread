package util;

import java.util.Arrays;

public class Sort {

    /**
     * 冒泡排序
     *
     * @param array  要排序的数组
     * @param isDesc 是否降序
     */
    public static int[] bubbleSort(int[] array, boolean isDesc) {
        int len;
        if (array == null || (len = array.length) < 2) {
            return array;
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
        return array;
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
    public static int[] cocktailSort(int[] array, boolean isDesc) {
        int len;
        if (array == null || (len = array.length) < 2) {
            return array;
        }
        int begin = 0;
        int end = len - 1;
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
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @param isDesc
     */
    public static int[] insertionSort(int[] array, boolean isDesc) {
        int len;
        if (array == null || (len = array.length) < 2) {
            return array;
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
        return array;
    }

    /**
     * 希尔排序
     * 不稳定  O(N^3/2 )
     *
     * @param array
     * @param isDesc
     */
    public static int[] shellSort(int[] array, boolean isDesc) {
        int len;
        if (array == null || (len = array.length) < 2) {
            return array;
        }
        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = array[i];
                while (j - gap >= 0 && (isDesc ? current > array[j - gap] : current < array[j - gap])) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = current;
            }
        }
        return array;
    }

    /**
     * 归并排序
     * 归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，\
     * 因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间。
     *
     * @param array
     * @param isDesc
     */
    public static int[] mergeSort(int[] array, boolean isDesc) {
        int len;
        if (array == null || (len = array.length) < 2) {
            return array;
        }
        int[] left = Arrays.copyOfRange(array, 0, len / 2);
        int[] right = Arrays.copyOfRange(array, len / 2, len);
        return merge(mergeSort(left, isDesc), mergeSort(right, isDesc), isDesc);
    }

    /**
     * 归并
     *
     * @param left
     * @param right
     * @param isDesc
     * @return
     */
    private static int[] merge(int[] left, int[] right, boolean isDesc) {
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        int[] array = new int[left.length + right.length];
        while (leftIndex < left.length && rightIndex < right.length) {
            if (!isDesc) { // 升序
                if (left[leftIndex] <= right[rightIndex]) {
                    array[index++] = left[leftIndex++];
                } else {
                    array[index++] = right[rightIndex++];
                }
            } else { // 降序
                if (left[leftIndex] >= right[rightIndex]) {
                    array[index++] = left[leftIndex++];
                } else {
                    array[index++] = right[rightIndex++];
                }
            }
        }
        while (leftIndex < left.length) {
            array[index++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            array[index++] = right[rightIndex++];
        }
        return array;
    }

    /**
     * 快排序
     *
     * @param array
     * @param isDesc
     * @return
     */
    public static int[] quickSort(int[] array, boolean isDesc) {
        if (array == null || array.length < 2) {
            return array;
        }
        return doQuickSort(array, 0, array.length - 1, isDesc);
    }

    private static int[] doQuickSort(int[] array, int start, int end, boolean isDesc) {
        if (start < end) {
            int index = partition(array, start, end, isDesc);
            doQuickSort(array, start, index, isDesc);
            doQuickSort(array, index + 1, end, isDesc);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end, boolean isDesc) {
        int temp = array[start];
        while (start < end) {
            if (!isDesc) { // 升序
                while (start < end && array[end] >= temp) {
                    end--;
                }
                array[start] = array[end];
                while (start < end && array[start] <= temp) {
                    start++;
                }
                array[end] = array[start];
            } else { // 降序
                while (start < end && array[end] <= temp) {
                    end--;
                }
                array[start] = array[end];
                while (start < end && array[start] >= temp) {
                    start++;
                }
                array[end] = array[start];

            }
        }
        array[start] = temp;
        return start;
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

    public static void printAll(int[] array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
