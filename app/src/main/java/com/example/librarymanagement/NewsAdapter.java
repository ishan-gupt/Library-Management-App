package com.example.librarymanagement;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        String data[];
        String desp[];
        String image_url[];
        Context context;
    private static final String TAG = "NewsAdapter";

    public NewsAdapter(String data[],String desp[],String imageView1[], Context context) {
        this.data = data;
        this.desp=desp;
        this.image_url=imageView1;
        this.context = context;
    }

    @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.inflatenews,viewGroup,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            viewHolder.textView.setText(data[i]);
            String des=desp[i];
            if(des.length()>=42) {
                des= des.substring(0, 41)+"...  "+"Read More";

                viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(context,NewsPage.class);
                        intent.putExtra("newstitle",data[i]);
                        intent.putExtra("newsdesp",desp[i]);
                        intent.putExtra("newsimg",image_url[i]);
                        context.startActivity(intent);
                    }
                });
            }
            viewHolder.textdesp.setText(des);
            Glide.with(context).load(image_url[i]).into(viewHolder.imageView);

        }

    interface ItemClickListener{
        void onItemClick(int pos);
    }

        @Override
        public int getItemCount() {
            return data.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

            private TextView textView;
            private TextView textdesp;
            private ImageView imageView;
            LinearLayout linearLayout;

            private ItemClickListener itemClickListene;

            @Override
            public void onClick(View view) {
                this.itemClickListene.onItemClick(this.getLayoutPosition());
            }
            void setItemClickListener(ItemClickListener itemClickListene)
            {
                this.itemClickListene=itemClickListene;
            }

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                textView=(TextView)itemView.findViewById(R.id.text);
                textdesp=(TextView)itemView.findViewById(R.id.textdesp);
                imageView=(ImageView)itemView.findViewById(R.id.news_img);
                linearLayout=(LinearLayout) itemView.findViewById(R.id.newsdata);
                //itemView.setOnClickListener((View.OnClickListener) this);
            }
        }
}
