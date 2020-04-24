package com.falc.daynightthemedemo.picasso

import android.graphics.*
import com.squareup.picasso.Transformation


class CircleTransformation : Transformation {

    override fun transform(source: Bitmap): Bitmap {

        val size = Math.min(source.width, source.height)

        val width = (source.width - size) / 2f
        val height = (source.height - size) / 2f

        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)

        val canvas = Canvas(bitmap)
        val bitmapShader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        if (width != 0f || height != 0f) { // source isn't square, move viewport to center
            val matrix = Matrix()
            matrix.setTranslate(-width, -height)
            bitmapShader.setLocalMatrix(matrix)
        }

        val paint = Paint().apply {
            shader = bitmapShader
            isAntiAlias = true
        }

        val radius = size / 2f
        canvas.drawCircle(radius, radius, radius, paint)

        source.recycle()

        return bitmap
    }

    override fun key(): String {
        return "circleTransformation"
    }
}