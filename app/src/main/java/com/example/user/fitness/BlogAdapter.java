package com.example.user.fitness;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitness.Database.DbHelper;

import java.util.ArrayList;

public class BlogAdapter extends ArrayAdapter<Blog> {
    public BlogAdapter(Context context, ArrayList<Blog> blogs) {
        super(context,0, blogs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder) convertView.getTag();

        final Blog blog = getItem(position);

        viewHolder.title.setText(blog.getTitle());

        viewHolder.date.setText(blog.getDate());

        viewHolder.body.setText(blog.getBody());

        viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(getContext());
                dbHelper.DeleteBlog(blog);
                BlogAdapter.this.remove(blog);
            }
        });
        return convertView;
    }

    class ViewHolder {
        private TextView title;
        private TextView date;
        private TextView body;
        private Button deleteBtn;
        public ViewHolder(View itemView) {
            title = itemView.findViewById(R.id.blog_title);
            date = itemView.findViewById(R.id.blog_date);
            body = itemView.findViewById(R.id.blog_body);
            deleteBtn = itemView.findViewById(R.id.delete_blog_btn);
        }
    }
}
