package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

class MySurfaceView extends SurfaceView implements Callback, Runnable {

        // 用于控制SurfaceView 的大小、格式等，并且主要用于监听SurfaceView 的状态
        private SurfaceHolder sfh;
        // 声明一张波浪图
        private Bitmap bmp;
        // 声明波浪图的X,Y轴坐标
        private int bmpX, bmpY;
        // 声明一个画布
        private Canvas canvas;
        // 声明一个线程
        private Thread th;
        // 线程消亡的标识符
        private boolean flag;

        public MySurfaceView(Context context) {
            super(context);
            // 实例SurfaceView
            sfh = this.getHolder();
            // 为SurfaceView添加状态监听
            sfh.addCallback(this);
        }

        /**
         * SurfaceView 视图创建，响应此函数
         */
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            bmp = BitmapFactory.decodeResource(this.getResources(),
                    R.drawable.dafa);
            // 让位图初始化X轴正好充满屏幕
            bmpX = -bmp.getWidth() + this.getWidth();
            // 让位图绘制在画布的最下方，且图片Y坐标正好是（屏幕高-图片高）
            bmpY = this.getHeight() - bmp.getHeight();
            flag = true;
            // 实例线程
            th = new Thread(this);
            // 启动线程
            th.start();
        }

        /**
         * SurfaceView 视图状态发生改变时，响应此函数
         */
        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {

        }

        /**
         * SurfaceView 视图消亡时，响应此函数
         */
        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            flag = false;
        }

        private void myDraw() {
            try {
                canvas = sfh.lockCanvas();
                if (canvas != null) {
                    //刷屏，画布白色
                    canvas.drawColor(Color.WHITE);
                    //绘制位图
                    canvas.drawBitmap(bmp, bmpX, bmpY, new Paint());
                }
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                if (canvas != null) {
                    sfh.unlockCanvasAndPost(canvas);
                }
            }
        }

        /**
         * 游戏逻辑
         */
        private void logic() {
            bmpX += 2;
        }

        @Override
        public void run() {
            while (flag) {
                long start = System.currentTimeMillis();
                myDraw();
                logic();
                long end = System.currentTimeMillis();
                try {
                    if (end - start < 50) {
                        Thread.sleep(50 - (end - start));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

