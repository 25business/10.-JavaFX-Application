package com.example;

import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class JavalinServer implements Runnable {
    public static Javalin app;

    @Override
    public void run() {
        app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        app.start(7070);

        app.get("/", ctx -> {
            LocalDateTime now = LocalDateTime.now(ZoneId.of(ctx.queryParam("timezone")));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy.");
            ctx.html(now.format(dtf));
        });
    }
}
