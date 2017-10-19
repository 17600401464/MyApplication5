package com.example.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.Sideadapter;
import com.example.bean.Beanone;
import com.example.bean.Beantwo;
import com.example.customview.CheckSwitchButton;
import com.example.fragment.Fragmentone;
import com.example.fragment.Fragmenttwo;
import com.example.fragment.Frargmentthree;
import com.example.lib.SlidingMenu;
import com.example.lib.app.SlidingActivity;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.yydcdut.sdlv.Menu;
import com.yydcdut.sdlv.SlideAndDragListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static com.loopj.android.http.AsyncHttpClient.log;

/**
 * Created by lenovo on 2017/8/3.
 */
@ContentView(R.layout.myactivity)

public class MyActivity extends SlidingActivity {

    Button bt1;
    Button txt2;
    private SuperSwipeRefreshLayout swipeRefreshLayout;
    private List<Beanone> mListApp;
    SlideAndDragListView slideAndDragListView;
    private Menu mMenu;
    //滑动和拖动控件
    private SlideAndDragListView<ApplicationInfo> mListView;
    Callback.Cancelable cancelable;
    Beanone beanone = null;
    Button btn1,btn2,btn3;
    TextView tex2;
    FragmentManager fm;
    FragmentTransaction ft;
    Fragmentone fragmentone;
    private SlidingMenu menu;
    Fragmenttwo fragmenttwo;
    MediaPlayer mediaPlayer;
    ImageView img;
    CheckSwitchButton checkSwitchButton;
    private DrawerLayout mDrawerLayout;
    Frargmentthree frargmentthree;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
       // setContentView(R.layout.myactivity);
        setBehindContentView(R.layout.behind);
        Logger.setDebug(true);

        NoHttp.initialize(MyActivity.this);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
//        NavigationView navigationView= (NavigationView) findViewById(R.id.nav_view_right);
//
        mediaPlayer = MediaPlayer.create(MyActivity.this,R.raw.ooo);
        final DrawerLayout drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);

        final Toolbar toobar= (Toolbar) findViewById(R.id.toolbar);
        menu = getSlidingMenu();
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;

        int height = displayMetrics.heightPixels;
        menu.setBehindWidth(width/3*2);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setMode(SlidingMenu.LEFT);
   init();
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                menu.showMenu();
                Toast.makeText(MyActivity.this,"导航按钮",Toast.LENGTH_SHORT).show();
            }
        });
//        toobar.setSubtitleTextAppearance(this,R.style.Theme_ToolBar_Base_Subtitle);
//        //设置菜单弹出样式的文本颜色和背景
        toobar.setPopupTheme(R.style.PopupMenu);
        toobar.inflateMenu(R.menu.menu_main);

        toobar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_item1:
                        drawerLayout.openDrawer(Gravity.RIGHT);
                }
                return false;
            }
        });


        leftinit();

        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        btn1.setTextColor(Color.parseColor("#40E0D0"));
        btn2.setTextColor(Color.parseColor("#292421"));
        btn3.setTextColor(Color.parseColor("#292421"));
        fragmentone=new Fragmentone();
        fragmenttwo=new Fragmenttwo();
        frargmentthree=new Frargmentthree();
        fm=getFragmentManager();
        ft=fm.beginTransaction();
        ft.add(R.id.fragment,fragmentone);
        ft.add(R.id.fragment,fragmenttwo);
        ft.add(R.id.fragment,frargmentthree);
        ft.show(fragmentone);
        ft.hide(fragmenttwo);
        ft.hide(frargmentthree);
        ft.commit();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft=fm.beginTransaction();
                ft.show(fragmentone);
                ft.hide(fragmenttwo);
                ft.hide(frargmentthree);
                btn1.setTextColor(Color.parseColor("#40E0D0"));
                btn2.setTextColor(Color.parseColor("#292421"));
                btn3.setTextColor(Color.parseColor("#292421"));
                ft.commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft=fm.beginTransaction();
                ft.hide(fragmentone);
                ft.show(fragmenttwo);
                ft.hide(frargmentthree);
                btn2.setTextColor(Color.parseColor("#40E0D0"));
                btn1.setTextColor(Color.parseColor("#292421"));
                btn3.setTextColor(Color.parseColor("#292421"));
                ft.commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft=fm.beginTransaction();
                ft.hide(fragmentone);
                ft.hide(fragmenttwo);
                ft.show(frargmentthree);
                btn3.setTextColor(Color.parseColor("#40E0D0"));
                btn2.setTextColor(Color.parseColor("#292421"));
                btn1.setTextColor(Color.parseColor("#292421"));
                ft.commit();
            }
        });

    }

Sideadapter mAdapterr;
    void leftinit() {

//    tex1= (TextView) findViewById(R.id.textView);

        swipeRefreshLayout = (SuperSwipeRefreshLayout) findViewById(R.id.swipe_refreshe);
        swipeRefreshLayout
                .setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {

                    @Override
                    public void onRefresh() {
                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        }, 2000);
                    }

                    @Override
                    public void onPullDistance(int distance) {
                        System.out.println("debug:distance = " + distance);
                        // myAdapter.updateHeaderHeight(distance);
                    }

                    @Override
                    public void onPullEnable(boolean enable) {
                    }
                });

        tex2 = (TextView) findViewById(R.id.textView2);
////        //tex3= (TextView) findViewById(R.id.textView3);
//        img = (ImageView) findViewById(R.id.imageView5);
        tex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent picture = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(picture, 110);
            }
        });


        mAdapterr = new Sideadapter(MyActivity.this, beanone);
//        initData();
//
        slideAndDragListView = (SlideAndDragListView) findViewById(R.id.lv_edit);
        initData();
        mMenu = new Menu(true);
        mMenu.addItem(new com.yydcdut.sdlv.MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn2_width))
                .setBackground(new ColorDrawable(Color.parseColor("#FF0000")))
                .setText("删除")
                .setTextColor(Color.WHITE)
                .setDirection(com.yydcdut.sdlv.MenuItem.DIRECTION_RIGHT)
                .setTextSize(14)
                .build());
        mMenu.addItem(new com.yydcdut.sdlv.MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn2_width))
                .setBackground(new ColorDrawable(Color.parseColor("#ffcc00")))
                .setText("标为未读")
                .setTextColor(Color.WHITE)
                .setDirection(com.yydcdut.sdlv.MenuItem.DIRECTION_RIGHT)
                .setTextSize((14))
                .build());
        mMenu.addItem(new com.yydcdut.sdlv.MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn2_width))
                .setBackground(new ColorDrawable(Color.parseColor("#C0C0C0")))
                .setText("置顶")
                .setTextColor(Color.WHITE)
                .setDirection(com.yydcdut.sdlv.MenuItem.DIRECTION_RIGHT)
                .setTextSize((14))
                .build());
        slideAndDragListView.setMenu(mMenu);
        slideAndDragListView.setAdapter(mAdapterr);
        slideAndDragListView.setOnMenuItemClickListener(new SlideAndDragListView.OnMenuItemClickListener() {
            @Override
            public int onMenuItemClick(View v, int itemPosition, int buttonPosition, int direction) {
                switch (direction) {
                    case com.yydcdut.sdlv.MenuItem.DIRECTION_RIGHT:
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

        });
    }
//
//@Event(type = View.OnClickListener.class,value = R.id.textView2)
//private void ClickListener(View v){
//    Intent picture = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//     startActivityForResult(picture, 110);
//}


    String picturePath = null;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 110 && resultCode == Activity.RESULT_OK && null != data){

            Uri selectedImage = data.getData();
            String[] filePathColumns={MediaStore.Images.Media.DATA};
            Cursor c = this.getContentResolver().query(selectedImage,
                    filePathColumns, null,null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            picturePath= c.getString(columnIndex);
            c.close();
            try {
                InputStream is = new FileInputStream(picturePath);
                CircularImage cover_user_photo = (CircularImage) findViewById(R.id.cover_user_photo);
                cover_user_photo.setImageBitmap(BitmapFactory.decodeStream(is));
//                CircularImage cover_user_photos = (CircularImage) findViewById(R.id.cover_user_photos);
//                cover_user_photos.setImageBitmap(BitmapFactory.decodeStream(is));
//
//       setImageResource(R.mipmap.ic_launcher);
//                img.setImageBitmap(BitmapFactory.decodeStream(is));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    void init() {
        checkSwitchButton = (CheckSwitchButton) findViewById(R.id.myview);
        checkSwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                }
            }
        });
    }
    public void initData() {

        String url = "http://op.juhe.cn/onebox/basketball/nba";


        RequestParams params = new RequestParams(url);
        params.addQueryStringParameter("type","");
        params.addQueryStringParameter("key","2879274f89775de8809e836220c8eff4");
        //NetWorkonMainThread
        cancelable = x.http().get(params ,new Callback.CommonCallback<String>(){
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                beanone = gson.fromJson(result, Beanone.class);
                if(beanone.getResult()==null){
                    Gson gson1=new Gson();
                    InputStream inputStreams = null;
                    try {

                        inputStreams = getAssets().open("zk_new_json.txt");

                        ByteArrayOutputStream bss = new ByteArrayOutputStream();
                        byte[] buffers = new byte[512];
                        int lengths;
                        while ((lengths = inputStreams.read(buffers)) != -1) {
                            bss.write(buffers, 0, lengths);
                            bss.flush();
                        }
                        beanone = gson1.fromJson(bss.toString(), Beanone.class);
                        mAdapterr.updateAdapter(beanone);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                mAdapterr.updateAdapter(beanone);


            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            @Override
            public void onCancelled(CancelledException cex) {
                Log.d("data","3");
            }

            @Override
            public void onFinished() {

            }
        });
    }

    }





