public class TriangleDrawer {
    public static int drawTriangle(int n) {
        for (int size = n,row =1;row - 1 < size;) {
            for (int col = 0;col < row;col +=1) {
                System.out.print('*');
            }
            row = row + 1;
            System.out.println();
        }
        return n;
    }
    public static void main(String[] args) {
        System.out.println(drawTriangle(10));
    }
}