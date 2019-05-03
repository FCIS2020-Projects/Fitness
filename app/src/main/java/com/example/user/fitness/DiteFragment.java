package com.example.user.fitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class DiteFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_view,container,false);
        ArrayList<Blog> blogs = new ArrayList<>();

        BlogAdapter adapter = new BlogAdapter(getActivity(), blogs);
        ListView listView = rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        return rootView;
    }
}
