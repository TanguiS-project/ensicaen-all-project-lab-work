package chain;

import chain.handler.ProcessorHandler;
import chain.handler.QuickProcessorHandler;
import chain.handler.SlowProcessorHandler;

import java.util.Random;

public class Main {
    public static void main( String[] args ) throws InterruptedException {
        ResultPool results = new ResultPool();
        ProcessorQuick processor = new ProcessorQuick(results);
        ProcessorHandler init = new QuickProcessorHandler( processor );


        ProcessorHandler ph = init.setNextProcessor(
                        new QuickProcessorHandler( new ProcessorQuick(results)).setNextProcessor(
                                new QuickProcessorHandler( new ProcessorQuick(results)).setNextProcessor(
                                        new SlowProcessorHandler(new ProcessorSlow(results)).setNextProcessor(
                                                new SlowProcessorHandler(new ProcessorSlow(results)).setNextProcessor(
                                                    init
                                                )
                                        )
                                )
                        )
                );
        Random r = new Random();
        for ( int i = 0; i < 20; i++ ) {
            ph.handleRequest( r.nextInt(100001) - 1 );
        }
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        results.printResult();
    }
}
