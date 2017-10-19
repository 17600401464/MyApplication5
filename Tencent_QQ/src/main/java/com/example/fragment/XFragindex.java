package com.example.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.Frienddate;
import com.example.bean.Frintdateclass;
import com.example.myapplication.ChatRoom;
import com.example.myapplication.CircularImage;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.yydcdut.sdlv.Menu;
import com.yydcdut.sdlv.MenuItem;
import com.yydcdut.sdlv.SlideAndDragListView;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/9/21.
 */

public class XFragindex extends Fragment implements AdapterView.OnItemLongClickListener,
        AdapterView.OnItemClickListener,
        SlideAndDragListView.OnSlideListener,
        SlideAndDragListView.OnMenuItemClickListener, SlideAndDragListView.OnItemDeleteListener,
        SlideAndDragListView.OnItemScrollBackListener {
    SlideAndDragListView slideAndDragListView;
    private Menu mMenu;
    ArrayList<Frintdateclass> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.xfragindex,null);
        slideAndDragListView = view.findViewById(R.id.lv_edit);
        getdate();
        mMenu = new Menu(true);
        mMenu.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn_width))
                .setBackground(new ColorDrawable(Color.parseColor("#FF0000")))
                .setText("删除")
                .setTextColor(Color.WHITE)
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextSize(14)
                .build());
        mMenu.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn_width))
                .setBackground(new ColorDrawable(Color.parseColor("#ffcc00")))
                .setText("标为未读")
                .setTextColor(Color.WHITE)
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextSize((14))
                .build());
        mMenu.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn_width))
                .setBackground(new ColorDrawable(Color.parseColor("#C0C0C0")))
                .setText("置顶")
                .setTextColor(Color.WHITE)
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextSize((14))
                .build());
        slideAndDragListView.setMenu(mMenu);
        slideAndDragListView.setAdapter(mAdapter);
        slideAndDragListView.setOnItemClickListener(this);
        slideAndDragListView.setOnItemScrollBackListener(this);
        slideAndDragListView.setOnSlideListener(this);
        slideAndDragListView.setOnMenuItemClickListener(this);
View header=View.inflate(getActivity(),R.layout.header,null);
        slideAndDragListView.addHeaderView(header);
slideAndDragListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(getActivity(),ChatRoom.class);
        intent.putExtra("name",list.get(i).toString());
        startActivity(intent);
    }
});
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        return false;
    }

    @Override
    public void onItemDeleteAnimationFinished(View view, int position) {

    }

    @Override
    public void onSlideOpen(View view, View parentView, int position, int direction) {

    }

    @Override
    public void onSlideClose(View view, View parentView, int position, int direction) {

    }

    @Override
    public int onMenuItemClick(View v, int itemPosition, int buttonPosition, int direction) {
        switch (direction) {
            case MenuItem.DIRECTION_RIGHT:
                switch (buttonPosition) {
                    case 0:
                        return Menu.ITEM_DELETE_FROM_BOTTOM_TO_TOP;
                    case 1:
                        return Menu.ITEM_NOTHING;
                    case 2:

                        return Menu.ITEM_SCROLL_BACK;
                }
        }
        return Menu.ITEM_NOTHING;

    }


    @Override
    public void onScrollBackAnimationFinished(View view, int position) {

    }
    void getdate() {
        Frienddate frienddate=new Frienddate();
        list=frienddate.getfrindate();

    }
    protected BaseAdapter mAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return list.get(position).hashCode();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CustomViewHolder cvh;
            if (convertView == null) {
                cvh = new CustomViewHolder();
                convertView = View.inflate(getActivity(), R.layout.item_custom_btne, null);
                cvh.imgLogo = (CircularImage) convertView.findViewById(R.id.img);
                cvh.txtName = (TextView) convertView.findViewById(R.id.name);
                cvh.btnClick = (TextView) convertView.findViewById(R.id.timee);

                convertView.setTag(cvh);
            } else {
                cvh = (CustomViewHolder) convertView.getTag();
            }

            cvh.txtName.setText(list.get(position).name);
            cvh.imgLogo.setImageResource(list.get(position).img);
            cvh.btnClick.setText(list.get(position).time);
            cvh.btnClick.setTag(position);
            return convertView;
        }

        class CustomViewHolder {
            public CircularImage imgLogo;
            public TextView txtName;
            public TextView btnClick;
        }
    };
}
