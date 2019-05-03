package com.example.user.fitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.example.user.fitness.Database.DbHelper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class BlogFragment extends Fragment {
    EditText blogTitle;
    EditText blogBody;
    DbHelper dbHelper;
    Button newBlogBtn;
    BlogAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_blogs,container,false);

        ListView listView = rootView.findViewById(R.id.blogs_list_view);
        blogTitle = rootView.findViewById(R.id.blog_title_edit);
        blogBody = rootView.findViewById(R.id.blog_body_edit);
        newBlogBtn = rootView.findViewById(R.id.new_blog_btn);

        newBlogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Blog blog = new Blog(blogTitle.getText().toString(), Calendar.getInstance().getTime().toString(), blogBody.getText().toString());
                long id = dbHelper.AddBlog(blog);
                blog.setID(id);
                adapter.add(blog);

                blogTitle.setText("");
                blogBody.setText("");
            }
        });

        dbHelper = new DbHelper(getContext());
        ArrayList<Blog> blogs = dbHelper.getBlogs();
        adapter = new BlogAdapter(getActivity(), blogs);
        listView.setAdapter(adapter);

        return rootView;
    }
}
