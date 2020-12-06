package by.bsu.creator;

public class ArrayCreator {
    public  Integer[] factoryArray(String[] values){
        Integer[] result = new Integer[values.length];
        for (int i = 0; i < values.length ; i++) {
            result[i] = Integer.parseInt(values[i]);
        }
        return  result;
    }
}
