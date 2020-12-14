package ru.homework;

public final class ArrayUtils {

    private ArrayUtils(){}

    public static int[] changeArray(int[] array){
        int temp = 0;
        boolean flag=true;
        for(int i=0;i<array.length;i++){
            if(array[i]==4){
                temp=i;
                flag=false;
            }
        }
        if(flag){
            throw new RuntimeException("SWW");
        }
        int[] newArray = new int[array.length-temp-1];
        System.arraycopy(array, temp+1, newArray, 0, array.length-temp-1);
        return newArray;
    }

    public static boolean checkArray(int[] array){
        boolean flag1=false;
        boolean flag2=false;
        for(int i=0;i<array.length;i++){
            if(array[i]==4){
                flag1=true;
            }
            if(array[i]==1){
                flag2=true;
            }
        }
        if (flag1 && flag2){
            return true;
        }
        return false;
    }
}
