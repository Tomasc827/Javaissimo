public class Main {
    public static void main(String[] args) {
        ProtoArrayList<Integer> test = new ProtoArrayList<>();
        for(int i = 0; i < 1000; i++){
            test.add(i);
        }
        test.add(5);
        test.remove(1);
        test.lenghty();
        System.out.println(test);
        System.out.println(test.get(5));
    }
}