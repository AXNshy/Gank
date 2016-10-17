package com.shy.udpclient;

import java.io.IOException;
import java.net.*;

/**
 * Created by axnshy on 2016/10/11.
 */
public class UdpServer {
    DatagramSocket receiveSo;
    DatagramSocket sendSo;


    private static UdpServer client;

    private static int ReceivePort = 12345;
    private static int SendPort = 12346;

    private static String BroadAddress = "255.255.255.255";

    private UdpEvent event;


    public static UdpServer getInstance() {
        if (client == null)
            return new UdpServer();
        return client;
    }

    private UdpServer() {
        try {
            receiveSo = new DatagramSocket();
            receiveSo.bind(new InetSocketAddress(ReceivePort));
            sendSo = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void receive() {
        byte[] rb = new byte[256];
        DatagramPacket rPacket = new DatagramPacket(rb, rb.length);
        try {
            receiveSo.receive(rPacket);
            if (rPacket.getAddress() instanceof InetAddress && event != null) {
                event.onReceive(new String(rPacket.getData(), "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send() {
        String s = "服务器返回的消息";
        byte[] rb = s.getBytes();
        try {
            InetAddress addr = InetAddress.getByName(BroadAddress);
            DatagramPacket sPacket = new DatagramPacket(rb, rb.length, addr, SendPort);
            sendSo.send(sPacket);
            if (event != null)
                event.onSend();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    interface UdpEvent {
        void onReceive(String re);

        void onSend();
    }

    public void setEventListener(UdpEvent event) {
        this.event = event;
    }

}
