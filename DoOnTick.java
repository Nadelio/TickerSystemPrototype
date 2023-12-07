public class DoOnTick
{
    public static void everyTick(boolean tick)
    {
        boolean lastTick = !tick;
        if(tick != lastTick){System.out.println("Tick Change Detected!");}
    }    

    public static void everyOtherTick(boolean tick)
    {
        if(tick){System.out.println("Tick is same as two ticks before!");}
    }
}
