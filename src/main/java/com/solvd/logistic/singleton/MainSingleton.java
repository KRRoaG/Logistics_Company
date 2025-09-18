package com.solvd.logistic.singleton;


public class MainSingleton {

    public static void main(String[] args) {
        for (int i = 0 ; i < 5 ; i++){
            Thread thread = new Thread(new PrintTask(i), "Thread- " + i );
            thread.start();
        }
    }


    static class PrintTask implements Runnable{
        private int taskId;
        public PrintTask(int taskId){this.taskId = taskId;}
        @Override
        public void run(){
            PrinterManager printer = PrinterManager.getInstance();
            printer.printMessage("Task " + taskId + " completed" );
        }
    }
}
