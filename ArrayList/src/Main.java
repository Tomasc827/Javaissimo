public class Main {
    public static void main(String[] args) {
        ProtoArrayList<Integer> test = new ProtoArrayList<>();
        for(int i = 0; i < 1000; i++){
            test.add(i);
        }
        test.remove(1);
        System.out.println(test);
    }
}