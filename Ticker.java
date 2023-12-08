import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ticker
{
    public static boolean tick;
    public static int tickCount;
    public static boolean paused = false;
    public static ArrayList<Tick> tickList = new ArrayList<Tick>();

    public static boolean startTicking() throws InterruptedException
    {
        Thread.sleep(250);
        return !tick;
    }

    public static void writeTicksToFile() throws IOException
    {
        FileWriter fileWriter = new FileWriter("./TickerSystemPrototype/Ticks.json"); // issue here, need to change from hard coded file path to one that will work on any computer in any directory
        fileWriter.write("{\n");
        for(int i = 0; i < tickList.size(); i++)
        {
            fileWriter.write(tickList.get(i).toString());
            if(i == tickList.size() - 1){fileWriter.write("\n");}
            else{fileWriter.write(",\n");}
        }
        fileWriter.write("}");
        fileWriter.close();
    }

    public static void main(String [] args) throws InterruptedException, IOException
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
                        System.out.println("PAUSED");
                        writeTicksToFile();
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
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
                tickList.add(new Tick(tick, tickCount));
                tickCount++;
            }
        }
    }
}
