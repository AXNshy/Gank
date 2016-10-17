package com.shy.udpclient;

/**
 * Created by axnshy on 2016/10/11.
 */
public class UdpControl {
    static UdpServer server;
    private static boolean isReOn = true;
    private static boolean isSeOn = true;

    public static void main(String[] args) {
        server = UdpServer.getInstance();
        new ReceiveThread().start();
        new SendThread().start();
        server.setEventListener(new UdpServer.UdpEvent() {
            @Override
            public void onReceive(String re) {
                System.out.print(re+"\n");
                server.send();
            }

            @Override
            public void onSend() {

            }
        });
        server.receive();

    }

    static class ReceiveThread extends Thread{
        @Override
        public void run() {
            while (true){
                while (isReOn){
                    server.receive();
                }
            }
        }
    }

    static class  SendThread extends Thread{
        @Override
        public void run() {
            while (true){
                while (isSeOn){
                    server.send();
                }
            }
        }
    }


}
