package com.zsp;

import org.apache.tools.ant.taskdefs.Get;

import java.util.Scanner;

/**
 * @PackageName:com.zsp
 * @ClassName:Zijietest
 * @Description:
 * @Author 张世朋
 * @Data 2019/8/25 19:19
 */
public class Zijietest {
    public static Integer getdouyou(int[][] a, int b){
        int num=0;
        for (int i=0;i<b;i++){
            for (int j=0;j<b;j++){
                if(a [i][j]>=3){
                    num+=1;
                }

                }

            }
return num;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner (System.in);



       int a=scanner.nextInt ();
        int[][] arr = new int[a][a];
       for (int i=0;i<a;i++){
           for (int j=0;j<a;j++){
            arr[i][j]=scanner.nextInt ();
           }
       }
       System.out.println(getdouyou (arr,a));

/*for (int i=0;i<scanner;)*/
    }
}
