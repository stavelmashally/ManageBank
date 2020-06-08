package test;

import application.view.View;

public class MockView implements View {

    String msg;

    @Override
    public void initComponents() {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void displayMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
