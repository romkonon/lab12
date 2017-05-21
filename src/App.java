public class App {
    public static void main(String[] args) throws MyException {
        MyVector test1 = new MyVector();
        test1.put(1, 2, 3, 4, 5, 6);
        System.out.println(test1.toString());
        MyVector test2 = new MyVector();
        test2.put(1, 2, 3, 4);
        System.out.println(test2.toString());
        try {
            System.out.println(test1.get(-1));
        } catch (IndexOutOfBounds e) {
            e.printStackTrace();
        }
        try {
            System.out.println(test1.get(7));
        } catch (NoSuchElement e) {
            e.printStackTrace();
        }
        System.out.println(test1.size());
        System.out.println(test2.size());
        test1.addToEach(2);
        test2.addToEach(3);
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        test1.multiplyEachBy(1);
        test2.multiplyEachBy(2);
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        try{
            test1.multiplyEachBy(0);
        }
        catch (IndexOutOfBounds e){
            e.printStackTrace();
        }
        MyVector test3 = new MyVector();
        try{
            test3.put(11,12,13,14,15,16,17,18,19,20,111);
            System.out.println(test3.toString());
        }
        catch (Overflow e){
            e.printStackTrace();
        }
        try{
            test3.union(test2);
        }
        catch (Overflow e){
            e.printStackTrace();
        }
        MyVector test4 = new MyVector();
        test4.put(1, 2, 3, 4);
        MyVector test5 = new MyVector();
        test5.put(1, 2, 3, 4);
        System.out.println(test4.equal(test5));
        System.out.println(test4.equal(test3));
        System.out.println(test4.intersect(test5));
        System.out.println(test1.intersect(test4));
    }
}
