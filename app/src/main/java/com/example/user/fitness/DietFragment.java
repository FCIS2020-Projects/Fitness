package com.example.user.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DietFragment extends Fragment {
    ArrayList<DietPlan> dietPlans;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_view,container,false);
        dietPlans = new ArrayList<>();

        dietPlans.add(new DietPlan("The Military Diet",  "The Meal Plan\n" +
                "\n" +
                "This is the 3-day meal plan on the military diet.\n" +
                "Day 1\n" +
                "\n" +
                "This is the meal plan for day 1. It amounts to around 1,400 calories.\n" +
                "\n" +
                "Breakfast:\n" +
                "\n" +
                "    A slice of toast with 2 tablespoons of peanut butter.\n" +
                "    Half a grapefruit.\n" +
                "    A cup of coffee or tea (optional).\n" +
                "\n" +
                "Lunch:\n" +
                "\n" +
                "    A slice of toast.\n" +
                "    Half a cup of tuna.\n" +
                "    A cup of coffee or tea (optional).\n" +
                "\n" +
                "Dinner:\n" +
                "\n" +
                "    A 3-oz (85 grams) serving of meat with a cup of green beans.\n" +
                "    A small apple.\n" +
                "    Half a banana.\n" +
                "    One cup vanilla ice cream.\n" +
                "\n" +
                "Day 2\n" +
                "\n" +
                "These are the meals for day 2, amounting to around 1,200 calories.\n" +
                "\n" +
                "Breakfast:\n" +
                "\n" +
                "    A slice of toast.\n" +
                "    One hard-boiled egg.\n" +
                "    Half a banana.\n" +
                "    A cup of coffee or tea (optional).\n" +
                "\n" +
                "Lunch:\n" +
                "\n" +
                "    One hard-boiled egg.\n" +
                "    A cup of cottage cheese.\n" +
                "    5 saltine crackers.\n" +
                "    A cup of coffee or tea (optional).\n" +
                "\n" +
                "Dinner:\n" +
                "\n" +
                "    Two hot dogs, with no bun.\n" +
                "    Half a cup of carrots and half a cup of broccoli.\n" +
                "    Half a banana.\n" +
                "    Half a cup of vanilla ice cream.\n" +
                "\n" +
                "Day 3\n" +
                "\n" +
                "Here is the plan for day 3, which amounts to around 1,100 calories.\n" +
                "\n" +
                "Breakfast:\n" +
                "\n" +
                "    A 1-ounce slice of cheddar cheese.\n" +
                "    5 saltine crackers.\n" +
                "    A small apple.\n" +
                "    A cup of coffee or tea (optional).\n" +
                "\n" +
                "Lunch:\n" +
                "\n" +
                "    A slice of toast.\n" +
                "    One egg, cooked however you like.\n" +
                "    A cup of coffee or tea (optional).\n" +
                "\n" +
                "Dinner:\n" +
                "\n" +
                "    A cup of tuna.\n" +
                "    Half a banana.\n" +
                "    1 cup of vanilla ice cream.\n" +
                "\n" +
                "Feel free to drink as much coffee or tea as you want, as long as you don't add any calories from sugar or cream. Drink plenty of water too.\n" +
                "The Remaining 4 Days\n" +
                "\n" +
                "The remainder of the week also involves dieting.\n" +
                "\n" +
                "Snacks are permitted and there are no food group restrictions. However, you are encouraged to limit portion sizes and keep total calorie intake under 1,500 per day.\n" +
                "\n" +
                "You can find a list of websites and apps to track your calorie intake in this article.\n" +
                "\n" +
                "There are no other rules for the remaining 4 days of the diet.", R.drawable.military));

        dietPlans.add(new DietPlan("Fad Free diet" , "\n" +
                        "\n" +
                        "A simple, nutritious meal plan for the week, suitable for the whole family and developed by an Accredited Practising Dietitian to make healthy eating easy! For more healthy meal ideas, check out the Healthy Weight Week cookbook, Everyday Healthy Seasonal, Fresh & Tasty Bumper Edition.\n" +
                        "Day 1\n" +
                        "\n" +
                        "Breakfast: Untoasted muesli + reduced-fat milk + tinned apricots\n" +
                        "\n" +
                        "Lunch: Medium wholemeal pita bread wrap filled with tuna and salad greens, plus a tub of reduced-fat yoghurt\n" +
                        "\n" +
                        "Dinner: Sweet potato, rocket and asparagus frittata + bean salad + multigrain bread, plus a tub of reduced-fat yoghurt mixed with frozen berries.\n" +
                        "Day 2\n" +
                        "\n" +
                        "Breakfast: Multigrain toast + cottage cheese, honey & banana\n" +
                        "\n" +
                        "Lunch: Salmon potato cakes + spinach and sweet corn salad + multigrain bread\n" +
                        "\n" +
                        "Dinner: Grilled lemon chicken wraps + green salad, plus spiced apple compote + reduced fat ice cream\n" +
                        "Day 3\n" +
                        "\n" +
                        "Breakfast: Wholegrain cereal flakes + reduced-fat milk + canned peaches\n" +
                        "\n" +
                        "Lunch: Ham, cheese & salad sandwich, plus some carrot sticks\n" +
                        "\n" +
                        "Dinner: Salmon + chickpea salad, plus a tub of reduced-fat yoghurt with fresh rockmelon\n" +
                        "Day 4\n" +
                        "\n" +
                        "Breakfast: Two thin slices fruit toast + a banana smoothie\n" +
                        "\n" +
                        "Lunch: Pumpkin & chickpea salad\n" +
                        "\n" +
                        "Dinner: Spaghetti bolognaise + a green salad + soughdough bread, plus grilled plums + a tub of reduced-fat yoghurt\n" +
                        "Day 5\n" +
                        "\n" +
                        "Breakfast: Wholegrain cereal flakes + reduced-fat milk + banana\n" +
                        "\n" +
                        "Lunch: Sushi rolls (salmon, tuna, avocado or salad fillings), plus small coffee or hot chocolate, made with skim milk\n" +
                        "\n" +
                        "Dinner: Lean steak + potato + steam vegetables + multigrain bread, plus a small reduced-fat cheese & fruit platter\n" +
                        "Day 6\n" +
                        "\n" +
                        "Breakfast: ‘Breakfast bruschetta’ with sourdough bread, avocado & tomatoes\n" +
                        "\n" +
                        "Lunch: Medium wholemeal pita bread wrap filled with roast beef, wholegrain mustard & salad greens, plus milkshake made on reduced-fat milk\n" +
                        "\n" +
                        "Dinner: Chicken, rocket & leek risotto + side salad, plus tinned peaches + reduced fat ice cream\n" +
                        "Day 7\n" +
                        "\n" +
                        "Breakfast: Multigrain toast + avocado + a poached egg and a grilled tomato\n" +
                        "\n" +
                        "Lunch: Chicken, lettuce & mayonnaise sandwich, plus tub of reduced-fat yoghurt\n" +
                        "\n" +
                        "Dinner: Tofu, vegetable & cashew stir-fry + hokkien noodles, plus banana smoothie made from reduced-fat milk" , R.drawable.healthy));

        dietPlans.add(new DietPlan("Healthy Weight Gain" , "DAY 1:\n" +
                "\n" +
                "Meal 1\n" +
                "\n" +
                "Pro-Oatmeal bowl:\n" +
                "\n" +
                "    2/3 Cup Oats (Cooked in Whole or Almond Milk)\n" +
                "    Mixed With 1 Scoop Protein Powder\n" +
                "    Topped With 1 Tbsp. of Almond Butter and 1 Sliced Banana\n" +
                "    Optional: Sprinkle 1 Tbsp. of Honey\n" +
                "\n" +
                "Meal 2\n" +
                "\n" +
                "    3 Hard Boiled Eggs\n" +
                "    1 Whole Wheat Bagel\n" +
                "\n" +
                "Meal 3\n" +
                "\n" +
                "Pasta with Grilled Chicken:\n" +
                "\n" +
                "    6 oz. Grilled Chicken Breast\n" +
                "    1 Tsp. EVOO\n" +
                "    1 Cup of Veggies (Tomato, Avocado, Peppers, Spinach, etc.)\n" +
                "    1 Cup Whole Wheat Pasta\n" +
                "    1 Tsp. Minced Garlic\n" +
                "\n" +
                "\n" +
                "DAY 2:\n" +
                "\n" +
                "Meal 1\n" +
                "\n" +
                "Eggs, Turkey Bacon + Grapefruit:\n" +
                "\n" +
                "    3 Eggs, Scrambled or Lightly Fried (Using Coconut oil)\n" +
                "    3 Slices Turkey Bacon\n" +
                "    1 Large Grapefruit\n" +
                "    2 Piece Whole Grain or Ezekiel Toast\n" +
                "\n" +
                "\n" +
                "Meal 2\n" +
                "\n" +
                "Turkey Pita Sandwich:\n" +
                "\n" +
                "    ½ Cup Avocado\n" +
                "    1 Whole Wheat Pita Bread\n" +
                "    1 Slice Low Fat Swiss Cheese\n" +
                "    3 Oz. Turkey Breast\n" +
                "    Lettuce\n" +
                "    Tomato\n" +
                "    1 Tsp. Mustard\n" +
                "\n" +
                "Meal 3\n" +
                "\n" +
                "Steak and Rice:\n" +
                "\n" +
                "    8 oz. Sirloin Steak\n" +
                "    1 Cup Brown Rice\n" +
                "    1 Sweet Potato\n" +
                "\n" +
                "DAY 3:\n" +
                "\n" +
                "Meal 1\n" +
                "\n" +
                "Pro-Oatmeal:\n" +
                "\n" +
                "    2/3 Cup Oats (Cooked in Whole or Almond Milk)\n" +
                "    Mixed With 1 Scoop Protein Powder\n" +
                "    Topped With 1 Tbsp. of Almond Butter and 1 Sliced Banana\n" +
                "\n" +
                "\n" +
                "Meal 2\n" +
                "\n" +
                "Quinoa and Spicy Chicken:\n" +
                "\n" +
                "    1 Cup Quinoa\n" +
                "    8 oz. Chicken Breast\n" +
                "    1 Cup Broccoli\n" +
                "    ¼ Onion, Chopped\n" +
                "    Salsa, To Taste\n" +
                "\n" +
                "Meal 3\n" +
                "\n" +
                "    1 Cup Mixed Berries\n" +
                "    ½ Cup Greek Yogurt\n" +
                "    1 Serving Granola, Unsweetened\n" +
                "\n" +
                "DAY 4:\n" +
                "Meal 1\n" +
                "\n" +
                "Cheese and Egg Scramble with Fruit:\n" +
                "\n" +
                "    3 Eggs Scrambled\n" +
                "    ¼ Cup Cheddar Cheese\n" +
                "    1 Cup Spinach\n" +
                "    2 Slices Turkey Bacon, Crumbled\n" +
                "    1 Banana or Apple\n" +
                "\n" +
                "\n" +
                "Meal 2\n" +
                "\n" +
                "Cheeseburger:\n" +
                "\n" +
                "    8 oz. Burger\n" +
                "    1 Slice American Cheese\n" +
                "    Lettuce, Tomato, Onion\n" +
                "    1 Tsp. Mayonnaise\n" +
                "    1 Tsp. Mustard\n" +
                "    1 Whole Wheat Bun\n" +
                "\n" +
                "Meal 3\n" +
                "\n" +
                "    Handful of Raw Nuts\n" +
                "\n" +
                "DAY 5:\n" +
                "\n" +
                "Meal 1\n" +
                "\n" +
                "Egg White Scramble with Oats + Berries:\n" +
                "\n" +
                "    3 Egg Whites, Scrambled\n" +
                "    ½ Steel Cut Oats Cooked + Topped With 2 Teaspoons Unsalted Almond Butter\n" +
                "    1 Cup Mixed Berries\n" +
                "\n" +
                "Meal 2\n" +
                "\n" +
                "    1 Cup Carrots\n" +
                "    ½ Cup Hummus\n" +
                "\n" +
                "Meal 3\n" +
                "\n" +
                "BLT Wrap:\n" +
                "\n" +
                "    2 Slices Turkey Bacon\n" +
                "    2 Large Lettuce Leaves\n" +
                "    Tomato Slices\n" +
                "    2 oz. Grilled Chicken\n" +
                "    3 oz. Shredded Cheese\n" +
                "    2 tsp. Mayonnaise\n" +
                "    2 Whole Wheat Tortilla Wraps\n" +
                "\n" +
                "DAY 6:\n" +
                "\n" +
                "Meal 1\n" +
                "\n" +
                "Pro-Oatmeal bowl:\n" +
                "\n" +
                "    2/3 Cup Oats (Cooked in Whole or Almond Milk)\n" +
                "    Mixed With 1 Scoop Protein Powder\n" +
                "    Topped With 1 Tbsp. of Almond Butter and 1 Sliced Banana\n" +
                "    Optional: Sprinkle 1 Tbsp. of Honey\n" +
                "\n" +
                "Meal 2\n" +
                "\n" +
                "    3 Hard Boiled Eggs\n" +
                "    1 Whole Wheat Bagel\n" +
                "\n" +
                "Meal 3\n" +
                "\n" +
                "Pasta with Grilled Chicken:\n" +
                "\n" +
                "    6 oz. Grilled Chicken Breast\n" +
                "    1 Tsp. EVOO\n" +
                "    1 Cup of Veggies (Tomato, Avocado, Peppers, Spinach, etc.)\n" +
                "    1 Cup Whole Wheat Pasta\n" +
                "    1 Tsp. Minced Garlic\n" +
                "\n" +
                "DAY 7:\n" +
                "\n" +
                "Meal 1\n" +
                "\n" +
                "Eggs, Turkey Bacon + Grapefruit:\n" +
                "\n" +
                "    3 Eggs, Scrambled or Lightly Fried (Using Coconut oil)\n" +
                "    3 Slices Turkey Bacon\n" +
                "    1 Large Grapefruit\n" +
                "    2 Piece Whole Grain or Ezekiel Toast\n" +
                "\n" +
                "Meal 2\n" +
                "\n" +
                "Turkey Pita Sandwich:\n" +
                "\n" +
                "    ½ Cup Avocado\n" +
                "    1 Whole Wheat Pita Bread\n" +
                "    1 Slice Low Fat Swiss Cheese\n" +
                "    3 Oz. Turkey Breast\n" +
                "    Lettuce\n" +
                "    Tomato\n" +
                "    1 Tsp. Mustard\n" +
                "\n" +
                "Meal 3\n" +
                "\n" +
                "Steak and Rice:\n" +
                "\n" +
                "    8 oz. Sirloin Steak\n" +
                "    1 Cup Brown Rice\n" +
                "    1 Sweet Potato" , R.drawable.pro_oatmeal_bowl)) ;

        DietPlanAdapter adapter = new DietPlanAdapter(getActivity(), dietPlans);
        ListView listView = rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DietInfoActivity.class);
                intent.putExtra("diet_plan", dietPlans.get(i).getmDescription());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
