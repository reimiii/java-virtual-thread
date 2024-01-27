package franxx.code.javavirtualthread;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceVirtualThreadApp {

    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 10_000; i++) {
            service.execute(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(2));

                    System.out.println("Hello " + Thread.currentThread() + "!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        System.in.read();
    }
}
