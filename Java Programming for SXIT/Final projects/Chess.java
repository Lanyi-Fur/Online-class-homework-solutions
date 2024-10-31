import java.util.Scanner;
public class Chess {
    static String white = "☆";
    static String black = "★";
    static String[][] qp = new String[15][15];
    static String[] num = {"⒈", "⒉", "⒊", "⒋", "⒌", "⒍", "⒎", "⒏", "⒐", "⒑", "⒒", "⒓", "⒔", "⒕", "⒖"};
    static String line = "十";
    public static void main(String[] args) {
        qipan();//初始化棋盘
        print();//打印棋盘
        xiaqi();//开始下棋
    }
    /**
     * 开始下棋
     */
    public static void xiaqi() {
        boolean flag = true;
        Scanner s = new Scanner(System.in);
        while (true) {
            if (flag) {
                System.out.println("请黑子下棋");
                int x = s.nextInt() - 1;
                int y = s.nextInt() - 1;
                boolean b = panduan(x, y);
                if (b) {
                    qp[x][y] = black;
                    print();
                    boolean win = shuying(x, y, black);
                    if (win) {
                        System.out.println("黑棋胜利");
                        break;
                    }
                    flag = false;
                }
            } else {
                System.out.println("请白子下棋");
                int x = s.nextInt() - 1;
                int y = s.nextInt() - 1;
                boolean b = panduan(x, y);
                if (b) {
                    qp[x][y] = white;
                    print();
                    boolean win = shuying(x, y, white);
                    if (win) {
                        System.out.println("白棋胜利");
                        break;
                    }
                    flag = true;
                }
            }
        }
    }
 
    private static boolean shuying(int x, int y, String qz) {
        //判断水平输赢
        int spsum = 0;
        for (int i = y; i >= 0; i--) {//判断向左
            if (qp[x][i] == qz) {
                spsum++;
            } else break;
        }
        for (int i = y + 1; i < qp.length - 1; i++) {//判断向右
            if (qp[x][i] == qz) {
                spsum++;
            } else break;
        }
        if (spsum >= 5)
            return true;
        //判断垂直输赢
        int czsum = 0;
        for (int i = x; i >= 0; i--) {//判断向上
            if (qp[i][y] == qz) {
                czsum++;
            } else break;
        }
        for (int i = x + 1; i < qp.length - 1; i++) {//判断向下
            if (qp[i][y] == qz) {
                czsum++;
            } else break;
        }
        if (czsum >= 5)
            return true;
        //判断左斜
        int zxsum=0;
        for (int i = x,j=y; i >=0&&j>=0; i--,j--) {//判断左上
            if(qp[i][j]==qz){
                zxsum++;
            }else break;
        }
        for (int i = x+1,j=y+1; i <qp.length-1&&j<qp[0].length-1; i++,j++) {//判断右下
            if(qp[i][j]==qz){
                zxsum++;
            }else break;
        }
        if(zxsum>=5){
            return true;
        }
        //判断右斜
        int yxsum=0;
        for(int i=x,j=y;i>=0&&j<qp[0].length-1;i--,j++){//判断右上
            if(qp[i][j]==qz){
                yxsum++;
            }else break;
        }
        for(int i=x+1,j=y-1; i<qp.length-1&&j>=0;i++,j--){//判断左下
            if(qp[i][j]==qz){
                yxsum++;
            }else break;
        }
        if(yxsum>=5){
            return true;
        }
        else return false;
    }
 
    /**
     * 初始化棋盘
     */
    public static void qipan(){
        qp[14]=num;//棋盘最后一行为数字
        int t=0;
        for (int i = 0; i < qp.length-1; i++) {//循环14行即可
            for (int j = 0; j < qp.length; j++) {//每一列
                if (j == 14) {
                    qp[i][j] = num[i];//最后一列为数字
                } else {
                    qp[i][j] = line;
                }
            }
        }
    }
 
    /**
     * 打印棋盘
     */
    public static void print(){
        /*输出棋盘*/
        for (int i = 0; i <15 ; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(qp[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean panduan(int x,int y){
        if(x>=14||y>=14||qp[x][y]!=line){
            System.out.println("输入的不合法");
            return false;
        }
        else return true;
    }
}