package com.kito.deepstudy.io;
/**
 * @author zhaoyi
 */
public class Test {
    public static void main(String[] args) {
        int i=200;
        System.out.println("integer = " + i);
        int d=311;
    }

    public void test(){
        int i=0,j=1;

        if(i==1 && j==1){

        }

        if(i==1 && j!=1){

        }


    }


    private interface TestInterface{
        void handlerAEvent();
        void handlerBEvent();
        void handlerCEvent();
        void handlerDEvent();
        void handlerEEvent();

    }


    private class TestInner implements TestInterface{

        public void handlerAEvent(){

        }
        public void handlerBEvent(){

        }

        @Override
        public void handlerCEvent() {

        }

        @Override
        public void handlerDEvent() {

        }

        @Override
        public void handlerEEvent() {

        }
    }

    @org.junit.jupiter.api.Test
    void testtest(){
        new Integer("1");
    }

}
