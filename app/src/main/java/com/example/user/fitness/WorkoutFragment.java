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

public class WorkoutFragment extends Fragment {
    ArrayList<DietPlan> workoutPlans;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_view,container,false);
        workoutPlans = new ArrayList<>();


        workoutPlans.add( new DietPlan("Biginner Workout" , " Beginner full body workout routine\n" +
                "\n" +
                "    Chest – Barbell Bench Press – 4 sets of 8 reps.\n" +
                "    Back – Lat-pulldowns – 4 sets of 10 reps.\n" +
                "    Shoulders – Seated Dumbbell Press – 4 sets of 10 reps.\n" +
                "    Legs – Leg Extensions – 4 sets of 10 reps.\n" +
                "    Biceps – Barbell Bbicep Curls – 3 sets of 10 reps.\n" +
                "    Triceps – Triceps Rope Pushdowns – 3 sets of 15 reps." , R.drawable.osos));

        workoutPlans.add( new DietPlan("WorkOut 1" , "Day 1: Chest, Back, Shoulders, Legs, Biceps, Triceps\n" +
                "\n" +
                "    Chest – Barbell Bench Press – 4 sets of 8 reps\n" +
                "    Back – Lat-pulldowns – 4 sets of 10 reps\n" +
                "    Shoulders – Seated Dumbbell Press – 4 sets of 10 reps\n" +
                "    Legs – Leg Extensions – 4 sets of 10 reps\n" +
                "    Biceps – Barbell Bbicep Curls – 3 sets of 10 reps\n" +
                "    Triceps – Triceps Rope Pushdowns – 3 sets of 15 reps\n" +
                "\n" +
                "Day 2: Legs, Triceps, Biceps, Chest, Back, Shoulder\n" +
                "\n" +
                "    Legs – Leg Press Machine – 4 sets of 8 reps\n" +
                "    Triceps – Overhead Bar Extensions – 3 sets of 20 reps\n" +
                "    Biceps – EZ Bar Curls – 4 sets of 10 reps\n" +
                "    Chest – Machine Chest Press – 4 sets of 10 reps\n" +
                "    Back – T-Bar Row – 4 sets of 10 reps\n" +
                "    Shoulders – Lateral Raises – 3 sets of 20 reps\n" +
                "\n" +
                "Day 3: Shoulders, Back, Chest, Legs, Triceps, Biceps\n" +
                "\n" +
                "    Shoulders – EZ Bar Upright Rows – 3 sets of 15 reps\n" +
                "    Back – Close-Grip Pulldowns – 4 sets of 12 reps\n" +
                "    Chest – Cable Fly – 4 sets of 10 reps\n" +
                "    Legs – Lunges – 3 sets of 10 reps per leg\n" +
                "    Triceps – Skullcrushers – 3 sets of 15 reps\n" +
                "    Biceps – Hammer Curls – 3 sets of 12 reps\n" , R.drawable.biginnerworkout)) ;

        workoutPlans.add( new DietPlan("WorkOut 2", "Day 1: Chest & Back\n" +
                "\n" +
                "    Barbell Bench Press – work up to a 5 rep max for the day\n" +
                "        Set 1 at 50% – 1 set of 5 reps\n" +
                "        Set 2 at 60% – 1 set of 5 reps\n" +
                "        Set 3 at 70% – 1 set of 5 reps\n" +
                "        Set 4 at 80% – 1 set of 5 reps\n" +
                "        Set 5 at 90% – 1 set of 5 reps\n" +
                "        Set 6 at 100% – 1 set of 5 reps\n" +
                "    Incline Dumbbell Press – 3 sets of 6-8 reps\n" +
                "    Dips – 3 sets of 6-10 reps\n" +
                "    Pullups – 3 sets of 5-8 reps\n" +
                "    Pendlay Rows – 3 sets of 6-10 reps\n" +
                "    Pulldowns – 3 sets of 6-10 reps\n" +
                "\n" +
                "Day 2: Legs\n" +
                "\n" +
                "    Squats: work up to a 5 rep max for the day\n" +
                "        Set 1 at 50% – 1 set of 5 reps\n" +
                "        Set 2 at 60% – 1 set of 5 reps\n" +
                "        Set 3 at 70% – 1 set of 5 reps\n" +
                "        Set 4 at 80% – 1 set of 5 reps\n" +
                "        Set 5 at 90% – 1 set of 5 reps\n" +
                "        Set 6 at 100% – 1 set of 5 reps\n" +
                "    Leg Press – 3 sets of 6-10 reps\n" +
                "    Stiff-Legged Deadlift – 5 sets of 5 reps\n" +
                "    Hamstring Curls – 3 sets of 6-8 reps\n" +
                "    Calf-Raise – 5 sets of 10 reps\n" +
                "\n" +
                "Day 3: Shoulders & Arms\n" +
                "\n" +
                "    Military Press or Dumbbell Press – 3 sets of 6-8\n" +
                "    Lateral Raises – 5 sets of 10 reps\n" +
                "    Barbell Curls – 5 sets of 6-10 reps\n" +
                "    Dumbbell Curls – 3 sets of 6-10 reps\n" +
                "\n" +
                "Day 4: Rest\n" +
                "\n" +
                "It’s your rest day. Rest your muscle to prepare for the next round of training.\n" +
                "Day 5: Chest, Shoulders, & Triceps\n" +
                "\n" +
                "    Flat Dumbbell Press – 5 sets of 20-6 (Pyramiding) reps\n" +
                "    Incline Dumbbell Press – 3 sets of 6-10 reps\n" +
                "    Hammer Strength Press – 3 sets of 10 reps\n" +
                "    Cable Flys – 3 sets of 12-15 reps\n" +
                "    Lateral Raises – 5 sets of 15-20 reps\n" +
                "    Reverse-Grip Pull-Downs – 5 sets of 15-20 reps\n" +
                "\n" +
                "Day 6: Back & Biceps\n" +
                "\n" +
                "    Barbell Rows – 5 sets of 20-8 (Pyramiding) reps\n" +
                "    Barbell Shrugs – 3 sets of 15-20 reps\n" +
                "    Rack Deadlifts – 3 sets of 10-12 reps\n" +
                "    Pullups – 3 sets of 6-10 reps\n" +
                "    Pulldowns – 3 sets of 6-10 reps\n" +
                "\n" +
                "Day 7: Legs\n" +
                "\n" +
                "    Front Squats – 5 sets of 20-8 (Pyramiding) reps\n" +
                "    Leg Extensions – 5 sets of 10 reps\n" +
                "    Hamstring Curls – 5 sets of 6-10 reps\n" +
                "    Seated Calf Raise – 5 sets of 6-10 reps\n" +
                "    Standing Calf Raise – 3 sets of 8-12 reps\n" , R.drawable.workout1));


        DietPlanAdapter adapter = new DietPlanAdapter(getActivity(), workoutPlans);
        ListView listView = rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DietInfoActivity.class);
                intent.putExtra("diet_plan", workoutPlans.get(i).getmDescription());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
