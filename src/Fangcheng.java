public class Fangcheng
{
    public static void main(String [] args)
    {
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                for(int m=1;m<10;m++)
                {
                    if (i * 100 + j * 110 + m * 12 == 532)
                    {
                        System.out.println("X:" + i + " " + "Y:" + j + " " + "Z:" + m + " ");

                    }
                }
            }
        }

    }
}
