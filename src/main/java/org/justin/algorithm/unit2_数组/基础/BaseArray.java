package org.justin.algorithm.unit2_数组.基础;

import java.util.Arrays;

/**
 * @author Justin
 * @date 2023/1/9 2:50 PM
 */
public class BaseArray {

    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 2, 8, 9, 7};
        System.out.println(arr.length);
        toArrString(arr);

        System.out.println(findElement(arr, 7, 0));

        int[] ints = new int[10];
        ints[0] = 4;
        System.out.println(addElement(ints, 1, 3));

        System.out.println(removeElement(arr, 7, 8));
    }

    /**
     * 查找
     */
    public static int findElement(int[] arr, int size, int key){
        for (int i = 0; i < size; i++){
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    /**
     * 插入有序
     * 数组已经存储的元素数量，从1开始编号
     */
    public static int addElement(int[] arr, int size, int element){
        if (size > arr.length){
            throw new IllegalArgumentException("fail");
        }

        int index = size;
        for (int i = 0; i < size; i++){
            if (arr[i] > element){
                index = i;
                break;
            }
        }

        //理解size=长度，j即是下标加一
        for (int j = size; j > index; j--){
            arr[j] = arr[j-1];
        }
        arr[index] = element;
        toArrString(arr);

        return index;
    }

    public static int removeElement(int[] arr, int size, int key){
        int index = -1;
        for (int i=0; i < size; i++){
            if (arr[i] == key){
                index = i;
                break;
            }
        }
        if (index != -1){
            for (int j = index+1; j < size; j++){
                arr[j-1] = arr[j];
            }
            size--;
        }
        toArrString(arr);
        return size;
    }


    public static String toArrString(int[] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append(arr[i]);
        }
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }


}
