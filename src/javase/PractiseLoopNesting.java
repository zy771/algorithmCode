package src.javase;

public class PractiseLoopNesting {
    public static void main(String[] args) {
        char grade='c';

        switch (grade){
            case 'a':
                System.out.println("优秀");
                break;
            case 'b':
                System.out.println("良好");
                break;
            default:
                System.out.println("未知");
        }
    }
}
