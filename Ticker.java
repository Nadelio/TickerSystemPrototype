import java.util.Scanner;

public class Ticker
{
    public static boolean tick;
    public static int tickCount;
    public static boolean paused = false;

    public static boolean startTicking() throws InterruptedException
    {
        Thread.sleep(250);
        return !tick;
    }

    public static void main(String [] args) throws InterruptedException
    {
        Thread inputThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try (Scanner scan = new Scanner(System.in)) {
                    String input = "";
                    while(true)
                    {
                        input = scan.nextLine();
                        if(input.equals(""))
                        {
                            paused = !paused;
                        }
                    }
                }
            }
        });

        inputThread.start();
        while(true)
        {
            while(!paused)
            {
                tick = startTicking();
                System.out.println("This tick is: " + tick + "\nTick Count: " + tickCount);
                DoOnTick.everyOtherTick(tick);
                DoOnTick.everyTick(tick);
                tickCount++;
            }
        }
    }
}
