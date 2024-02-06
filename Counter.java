public class Counter {

    public int counter = 0;

    public void add() {
        counter++;
    }

   public void showCounter()   {
       System.out.println(counter + " раз");
   }
/*
    public void close() throws Exception {
        if (counter == 0)
            throw new Exception("Счетчик не был увеличен, или ресурс не закрыт.");


    }
*/

}

