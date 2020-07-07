package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context first
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //get number generator from bean
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        //call method next() to get random number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {}", number);

        //get game bean from context
        Game game = context.getBean(Game.class);

        MessageGenerator mg = context.getBean(MessageGenerator.class);
        log.info(mg.getMainMessage());
        log.info(mg.getResultMessage());
        //close context
        context.close();
    }
}
