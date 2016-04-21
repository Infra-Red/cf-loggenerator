package com.altoros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class LogGenerator {

    public LogGenerator() {
        LOGGER.info("LogGenerator Instantiated... ");
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(LogGenerator.class);
    private static AtomicInteger messageCounter  = new AtomicInteger(0);
    private static AtomicInteger indexCounter  = new AtomicInteger(0);

    private static Integer TEST_DURATION;
    private static Integer START_INDEX;
    private static Integer TIMEOUT;

    static {
        TEST_DURATION = System.getenv().get("DURATION") != null ? Integer.valueOf(System.getenv().get("DURATION")) : 10;
        START_INDEX = System.getenv().get("START_INDEX") != null ? Integer.valueOf(System.getenv().get("START_INDEX")) : 1;
        TIMEOUT = System.getenv().get("TIMEOUT") != null ? Integer.valueOf(System.getenv().get("TIMEOUT")) : 1000;
    }

    public static void main(String[] args) {

        indexCounter.set(START_INDEX);

        while (true) {
            messageCounter.set(1);
            while(messageCounter.get()<=TEST_DURATION){
                try {
                    if(messageCounter.get() %4 == 0) {
                        try {
                            throwSomeException();
                            //throwAnotherException();
                            //throwUnexpectedException();
                            //throwContainerException();
                            //throwAnotherContException();
                            //throwUnexpectedContException();
                        } catch (Exception e) {
                            LOGGER.error("Some error {},{}", indexCounter.get(), messageCounter.getAndIncrement(), e);
                            //LOGGER.error("Another error {},{}", indexCounter.get(), messageCounter.getAndIncrement(), e);
                            //LOGGER.error("Unexpected error {},{}", indexCounter.get(), messageCounter.getAndIncrement(), e);
                            //String message = String.format("Another Container error %s,%s", indexCounter.get(), messageCounter.getAndIncrement());
                            //LOGGER.error(String.format("[CONTAINER] %-50s %-7s %s%s", LOGGER.getName(), "ERROR", message, ""), e);
                        }
                    }

                    LOGGER.info("Some Message {},{}", indexCounter.get(), messageCounter.getAndIncrement());
                    //LOGGER.info("Another Message {},{}", indexCounter.get(), messageCounter.getAndIncrement());
                    //LOGGER.info("Unexpected Message {},{}", indexCounter.get(), messageCounter.getAndIncrement());
                    //String message = String.format("Another Container message %s,%s", indexCounter.get(), messageCounter.getAndIncrement());
                    //LOGGER.info(String.format("[CONTAINER] %-50s %-7s %s%s", LOGGER.getName(), "INFO", message, ""));

                    Thread.currentThread().sleep(TIMEOUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            indexCounter.incrementAndGet();
        }

    }

    private static void throwSomeException() throws Exception {
        throw new Exception("Some exception");
    }

    private static void throwAnotherException() throws Exception {
        throw new Exception("Another exception");
    }

    private static void throwUnexpectedException() throws Exception {
        throw new Exception("Unexpected exception");
    }

    private static void throwContainerException() throws Exception {
        throw new Exception("Container exception");
    }

    private static void throwAnotherContException() throws Exception {
        throw new Exception("AnotherCont exception");
    }

    private static void throwUnexpectedContException() throws Exception {
        throw new Exception("UnexpectedCont exception");
    }

}
