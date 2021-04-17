import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssigmentOnClasses {

        public static void main(String[]args){

            MAN sam = new MAN("Samuel Akinduro", false,13000.00);  //create a new object called sam


            stateDetail(sam);                                                                        // call the stateDetail function on sam

            System.out.println();

            WOMAN mandy = new WOMAN("Mandy Brookes", true, 5000.00);  // create a new object called mandy from the extended class of MAN called WOMAN

            stateDetail(mandy);                                                               // call the stateDetail function on mandy



            System.out.println();

            FoodVendor iyabasira = new FoodVendor(true);                                //  create a new object from FoodVendor class called iyabasira

            iyabasira.prepareMenuItem();


            sam.makePurchase(sam.purchase("Rice and Plantain"), iyabasira );               //call the makePurchase method of sam  targeting "food" String and an object
            sam.makePurchase(sam.purchase("Rice and Plantain"), iyabasira );                //call the makePurchase method of sam  targeting "food" String and an object
            sam.makePurchase(sam.purchase("Rice and Plantain"), iyabasira );
            sam.makePurchase(sam.purchase("Fried Egg and Boiled yam"), iyabasira );         //call the makePurchase method of sam  targeting "food" String and an object
            sam.makePurchase(sam.purchase("Fried Egg and Boiled yam"), iyabasira );
            sam.makePurchase(sam.purchase("Fried Egg and Boiled yam"), iyabasira );
            sam.makePurchase(sam.purchase("Rice and Plantain"), iyabasira );
            sam.makePurchase(sam.purchase("Rice and Plantain"), iyabasira );
            sam.makePurchase(sam.purchase("Rice and Plantain"), iyabasira );

            mandy.makePurchase(mandy.purchase("Rice and Plantain"), iyabasira );            //call the makePurchase method of mandy  targeting "food" String and an object
            mandy.makePurchase(mandy.purchase("Rice and Plantain"), iyabasira );
            mandy.makePurchase(mandy.purchase("Rice and Plantain"), iyabasira );
            mandy.makePurchase(mandy.purchase("Beans and Plantain"), iyabasira );
            mandy.makePurchase(mandy.purchase("Beans and Plantain"), iyabasira );
            mandy.makePurchase(mandy.purchase("Beans and Plantain"), iyabasira );
            mandy.makePurchase(mandy.purchase("Rice and Plantain"), iyabasira );

            System.out.println(sam.dailyFoodPurchaseList);                                          //print sam's daily food purchase list

            System.out.println(sam.timesEaten("Fried Egg and Boiled yam"));                     // print how many times sam has eaten "Fried Egg and Boiled yam"

            System.out.println(sam.displayAllTimesEaten());
            System.out.println(mandy.displayAllTimesEaten());




        }

        public  static void stateDetail(MAN a) {
            System.out.println("NAME: " + a.name);

            if(a.isMarried == false)
                System.out.println("MARRIED: No");
            else System.out.println("MARRIED: Yes");

            System.out.println("NET WORTH: $"+ a.money);

        }


    }
    class MAN{
        String name;
        boolean isMarried;
        double money;
        List dailyFoodPurchaseList = new ArrayList();
        Map timesEatenandMeal = new HashMap();




        public MAN( String Gname, boolean GisMarried, double Gmoney){
            name = Gname;
            isMarried = GisMarried;
            money = Gmoney;
        }
        public String purchase (String food){

            return food;
        }
        public  void makePurchase(String fooditem , FoodVendor vend){

            boolean present = false;

            for (String item : vend.menuList){
                if (fooditem == item){
                    present = true;
                    dailyFoodPurchaseList.add(fooditem);


                    break;
                }


            }
            if (present){
                System.out.println(name+ " has ordered "+ fooditem +". Order complete! " );

            }else {
                System.out.println(name+ " has ordered "+ fooditem +". "+fooditem + " is not on the menu. Please make another order");

            }
        }
        public int timesEaten(String meal){
            int countTimes = 0;


            if (dailyFoodPurchaseList != null){

                for (Object m : dailyFoodPurchaseList){
                    if(m.toString() == meal){

                        countTimes += 1;

                    }


                }

            }

            return  countTimes;
        }
        public  Map displayAllTimesEaten(){
            for (Object meal : dailyFoodPurchaseList){
                int times = timesEaten((String) meal);
                timesEatenandMeal.put((String)meal, times);
            }
            return timesEatenandMeal;
        }

    }

    class WOMAN extends MAN{
        public WOMAN(String Aname, boolean AisMarried, double Amoney){
            super(Aname, AisMarried, Amoney);

        }
    }

    class FoodVendor {
        String name = "Sweet Haven delicacies";
        String[] menuList = {"Rice and Plantain", "Fried Egg and Boiled yam", "Beans and Plantain"};
        boolean isOpen;

        public FoodVendor(boolean Visopen){
            boolean isOpen = Visopen;

        }

        public void prepareMenuItem (){
            for (String item : menuList){
                System.out.println(item);
            }

        }

    }


