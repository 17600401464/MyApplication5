package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by lenovo on 2017/10/17.
 */

public class Adapter extends BaseAdapter {
    Context con;
    Beantwo bean;
    public Adapter(Context context,Beantwo beantwo) {

        con=context;
        bean=beantwo;
    }

    @Override
    public int getCount() {
        if(bean==null){
            return 0;
        }
        return bean.getResult().getList().size();
    }

    @Override
    public Object getItem(int i) {
        return bean.getResult().getList();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HolderView holderView;
        if(view==null) {
            holderView=new HolderView();
             view = View.inflate(con, R.layout.child, null);
            holderView.img=view.findViewById(R.id.ima);
            holderView.tex=view.findViewById(R.id.tex);
            view.setTag(holderView);

        }else{
            holderView= (HolderView) view.getTag();
        }
        Picasso.with(con)
                .load(bean.getResult().getList().get(i).getPlayer2logo())

                .placeholder(R.mipmap.ic_launcher)

                .error(R.mipmap.ic_launcher)

                .into(holderView.img);
        holderView.tex.setText(bean.getResult().getList().get(i).getLink1text());
        return view;
    }
    class HolderView{
        private ImageView img;
        private TextView tex;
    }
    public void update(Beantwo beantwo){
        this.bean=beantwo;
        notifyDataSetChanged();
    }
}
