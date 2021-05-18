package com.company.design.faccade;

public class Reader {

    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("reader %s 로 연결 합니다.", fileName);
        System.out.println(msg);
    }

    public void fileRead() {
        String msg = String.format("reader %s 의 내용을 읽어 옵니다.", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect() {
        String msg = String.format("reader %s 로 연결 종료 합니다.", fileName);
        System.out.println(msg);
    }
}
