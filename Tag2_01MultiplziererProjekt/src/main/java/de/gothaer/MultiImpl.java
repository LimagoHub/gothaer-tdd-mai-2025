package de.gothaer;

public class MultiImpl implements Multi{

    public long multipliziere(int a, int b){
        var result = 0L;

        for (int i = 0; i < a; i++) {
            result += b;
        }
        return result;
    }
}
