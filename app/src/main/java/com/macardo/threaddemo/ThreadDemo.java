package com.macardo.threaddemo;

public class ThreadDemo {
    //共享变量
    static int count;

    public static void main(String[] args){
        new Task().start();
        new Task().start();
    }

    static class Task extends Thread{

        @Override
        public void run() {
            int temp = count;//获取共享变量的值
            try {
                //让线程休眠，以更容易观察数据同步问题
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = temp +1;//修改共享变量的值
            System.out.println("Count value is:"+count);
        }
    }
}
