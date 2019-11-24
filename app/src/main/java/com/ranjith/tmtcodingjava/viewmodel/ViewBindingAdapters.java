package com.ranjith.tmtcodingjava.viewmodel;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.ranjith.tmtcodingjava.models.BaseAttribute;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

public class ViewBindingAdapters {

    public  static  float getFontSize(Object model) {
        BaseAttribute baseAttribute = (BaseAttribute)model;
        int fontSize = 18;
        if (baseAttribute != null && baseAttribute.getAttributes() != null && baseAttribute.getAttributes().getFont() != null && baseAttribute.getAttributes().getFont() != null) {
            fontSize = baseAttribute.getAttributes().getFont().getSize();
        }
        return fontSize;
    }

    public  static CharSequence getText(Object model) {
        BaseAttribute baseAttribute = (BaseAttribute)model;
        if (baseAttribute != null && !TextUtils.isEmpty(baseAttribute.getValue())) {
            String text = baseAttribute.getValue();
            return text;
        }
        return "";
    }

    public static int getTextColor(Object model) {
        BaseAttribute baseAttribute = (BaseAttribute)model;
        if (baseAttribute != null && baseAttribute.getAttributes() != null && baseAttribute.getAttributes().getTextColor() != null) {
            return Color.parseColor(baseAttribute.getAttributes().getTextColor());
        }
        return Color.parseColor("#000000");
    }

    @BindingAdapter("app:setTextViewAttribute")
    public static void setTextViewAttribute(TextView textView, Object card) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, getFontSize(card));
        textView.setText(getText(card));
        textView.setTextColor(getTextColor(card));
    }


    @BindingAdapter({"app:setImage"})
    public static void setImage(ImageView view, String imageUrl) {
        final ImageView sourceImageView = view;

        Transformation transformation = new Transformation() {

            @Override
            public Bitmap transform(Bitmap source) {
                int targetWidth = sourceImageView.getWidth();

                double aspectRatio = (double) source.getHeight() / (double) source.getWidth();
                int targetHeight = (int) (targetWidth * aspectRatio);
                Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                if (result != source) {
                    // Same bitmap is returned if sizes are the same
                    source.recycle();
                }
                return result;
            }

            @Override
            public String key() {
                return "transformation" + " desiredWidth";
            }
        };

        Picasso.get().load(imageUrl).transform(transformation).into(view);

    }
}
