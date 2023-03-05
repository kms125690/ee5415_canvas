package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }

    private class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas) {
//            canvas.scale(0.8f, 0.8f);
            int width = getWidth();
            int height = getHeight();
            Paint linePaint = new Paint();
            linePaint.setColor(Color.GRAY);
            linePaint.setStrokeWidth(4);
            canvas.drawLine(200.0f, 200.0f, 200.0f, height - 200.0f, linePaint);
            canvas.drawLine(width - 200.0f, 200.0f, width - 200.0f, height - 200.0f, linePaint);
//            for (int x = 0; x < width; x += width/5)
//                canvas.drawLine(x, 0, x, height, linePaint);

            canvas.drawLine(200.0f, 200.0f, width - 200.0f, 200.0f, linePaint);
            canvas.drawLine(200.0f, height - 200.0f, width - 200.0f, height - 200.0f, linePaint);
//            for (int y = 0; y < height; y += height/5)
//                canvas.drawLine(0, y, width, y, linePaint);

            Paint circlePaint = new Paint();
            circlePaint.setColor(Color.argb(255, 255, 0, 0));
            canvas.drawCircle(width/2, height/2, width / 5, circlePaint);

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_128);
            canvas.drawBitmap(bitmap, (width - bitmap.getWidth()) / 2, 300, null);

            Paint textPaint = new Paint();
            textPaint.setColor(Color.GREEN);
            textPaint.setTextSize(120);
            textPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("BMI", width/2, height*3/4, textPaint);
        }
    }
}