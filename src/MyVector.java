public class MyVector {
    private static final int CAPACITY = 10;
    private int[] v;
    private int current;

    MyVector(){
        v = new int[CAPACITY];
        current=0;
    }
    int get(int index) throws IndexOutOfBounds,NoSuchElement{
        if (index<0 || index>CAPACITY){
            throw new IndexOutOfBounds(101,"Index out of bounds in get().");
        }
        if (index>current){
            throw new NoSuchElement(301,"No such element in get().");
        }
        return v[index];
    }
    int size(){
        return this.current;
    }
    void addToEach(int value){
        for (int i = 0; i<current; i++) v[i] += value;
    }
    void multiplyEachBy(int value)throws IndexOutOfBounds{
        if (value==0){
            throw new IndexOutOfBounds(102,"Can't multiply by 0 in multiplyEachBy().");
        }
        for (int i = 0; i<current; i++) v[i] *= value;
    }
    void put(int... value) throws Overflow {
        for (int temp : value){
            if (current+1>CAPACITY){
                throw new Overflow(202,"Vector overflow during put().");
            }
            v[current] = temp;
            current++;
        }
    }
    void union(MyVector vector)throws Overflow{
        if (current+vector.current>CAPACITY){
            throw new Overflow(201,"Vector overflow during union().");
        }
        for (int i = 0; i<vector.current; i++){
            this.put(vector.v[i]);
        }
    }
    boolean equal(MyVector vector){
        for (int i = 0; i<current;i++){
            if(v[i]!=vector.v[i] || current!=vector.current){
                return false;
            }
        }
        return true;
    }
    MyVector intersect(MyVector vector){
        MyVector temp = new MyVector();
        for(int i = 0;i<current;i++){
            for (int j=0;j<vector.current;j++){
                if (v[i]==vector.v[j]){
                    temp.v[i] = v[i];
                    temp.current++;
                }
            }
        }
        return temp;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<current; i++){
            stringBuilder.append("v[");
            stringBuilder.append(i);
            stringBuilder.append("]=");
            stringBuilder.append(v[i]);
            stringBuilder.append("; ");
        }
        return stringBuilder.toString();
    }

}
