package com.barryzhang.tcontributionsviewdemo.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * https://github.com/barryhappy
 * Created by Barry on 2016/12/4
 */

public class CanvasUtil {
    /**
     * Draw a Regular polygon inside the giving Rect area
     * @param rect
     * @param canvas
     * @param paintByLevel
     * @param number the number of side： For 3/4/5/6... is triangle/square/Pentagon/hexagon/...
     */
    public static void drawPolygon (RectF rect, Canvas canvas, Paint paintByLevel, int number) {
        if(number<3) {
            return;
        }
        float r = (rect.right - rect.left) / 2;
        float mX = (rect.right + rect.left) / 2;
        float my = (rect.top + rect.bottom) / 2;
        Path path = new Path();
        for (int i = 0; i <= number; i++) {
            // - 0.5 : Turn 90 ° counterclockwise
            float alpha = Double.valueOf(((2f / number) * i - 0.5) * Math.PI).floatValue();
            float nextX = mX + Double.valueOf(r * Math.cos(alpha)).floatValue();
            float nextY = my + Double.valueOf(r * Math.sin(alpha)).floatValue();
            if (i == 0) {
                path.moveTo(nextX, nextY);
            } else {
                path.lineTo(nextX, nextY);
            }
        }
        canvas.drawPath(path, paintByLevel);
    }
}
