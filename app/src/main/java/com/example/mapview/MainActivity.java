package com.example.mapview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MapView(this));
    }

    public static class MapView extends View {

        private static int TILE_SIZE_X = 256;
        private static int TILE_SIZE_Y = 256;
        private static int COUNT_TILE_X = 10;
        private static int COUNT_TILE_Y = 10;

        float xTranslate = 0;
        float yTranslate = 0;

        float xLastTouch = 0;
        float yLastTouch = 0;

        Paint paint;

        public MapView(Context context) {
            super(context);
            init();
        }

        public MapView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public MapView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init();
        }

        public void init(){

            paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10);

        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){

                xLastTouch = event.getX();
                yLastTouch = event.getX();

                return true;
            }else if(event.getAction() == MotionEvent.ACTION_MOVE){

                float dx = event.getX() - xLastTouch;
                float dy = event.getY() - yLastTouch;
                xLastTouch = event.getX();
                yLastTouch = event.getX();
                setTranslate(-dx,-dy);
                return true;
            }else if(event.getAction() == MotionEvent.ACTION_UP){

            }
            return super.onTouchEvent(event);
        }

        public void setTranslate(float dx,float dy){
            xTranslate=+dx;
            xTranslate=+dy;
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(xTranslate,yTranslate,10,paint);
        }
    }
}
