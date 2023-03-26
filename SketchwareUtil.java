package com.my.OneTimePad;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class SketchwareUtil {
    public static int BOTTOM = 3;
    public static int CENTER = 2;
    public static int TOP = 1;

    public static void CustomToast(Context context, String str, int i, int i2, int i3, int i4, int i5) {
        Toast makeText = Toast.makeText(context, str, 0);
        View view = makeText.getView();
        TextView textView = (TextView) view.findViewById(16908299);
        textView.setTextSize((float) i2);
        textView.setTextColor(i);
        textView.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius((float) i4);
        view.setBackgroundDrawable(gradientDrawable);
        view.setPadding(15, 10, 15, 10);
        view.setElevation(10.0f);
        switch (i5) {
            case 1:
                makeText.setGravity(48, 0, 150);
                break;
            case 2:
                makeText.setGravity(17, 0, 0);
                break;
            case 3:
                makeText.setGravity(80, 0, 150);
                break;
        }
        makeText.show();
    }

    public static void CustomToastWithIcon(Context context, String str, int i, int i2, int i3, int i4, int i5, int i6) {
        Toast makeText = Toast.makeText(context, str, 0);
        View view = makeText.getView();
        TextView textView = (TextView) view.findViewById(16908299);
        textView.setTextSize((float) i2);
        textView.setTextColor(i);
        textView.setCompoundDrawablesWithIntrinsicBounds(i6, 0, 0, 0);
        textView.setGravity(17);
        textView.setCompoundDrawablePadding(10);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius((float) i4);
        view.setBackgroundDrawable(gradientDrawable);
        view.setPadding(10, 10, 10, 10);
        view.setElevation(10.0f);
        switch (i5) {
            case 1:
                makeText.setGravity(48, 0, 150);
                break;
            case 2:
                makeText.setGravity(17, 0, 0);
                break;
            case 3:
                makeText.setGravity(80, 0, 150);
                break;
        }
        makeText.show();
    }

    public static void sortListMap(ArrayList<HashMap<String, Object>> arrayList, final String str, final boolean z, final boolean z2) {
        Collections.sort(arrayList, new Comparator<HashMap<String, Object>>() {
            public int compare(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
                if (z) {
                    int intValue = Integer.valueOf(hashMap.get(str).toString()).intValue();
                    int intValue2 = Integer.valueOf(hashMap2.get(str).toString()).intValue();
                    if (z2) {
                        if (intValue < intValue2) {
                            return -1;
                        }
                        return intValue < intValue2 ? 1 : 0;
                    } else if (intValue <= intValue2) {
                        return intValue > intValue2 ? 1 : 0;
                    } else {
                        return -1;
                    }
                } else if (z2) {
                    return hashMap.get(str).toString().compareTo(hashMap2.get(str).toString());
                } else {
                    return hashMap2.get(str).toString().compareTo(hashMap.get(str).toString());
                }
            }
        });
    }

    public static void CropImage(Activity activity, String str, int i) {
        try {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(Uri.fromFile(new File(str)), "image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 280);
            intent.putExtra("outputY", 280);
            intent.putExtra("return-data", false);
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, "Your device doesn't support the crop action!", 0).show();
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String copyFromInputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
            }
        }
        byteArrayOutputStream.close();
        inputStream.close();
        return byteArrayOutputStream.toString();
    }

    public static void hideKeyboard(Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(1, 0);
    }

    public static void showKeyboard(Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public static void showMessage(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    public static int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    public static int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    public static ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList arrayList = new ArrayList();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    public static float getDip(Context context, int i) {
        return TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static int getDisplayWidthPixels(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getDisplayHeightPixels(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static void getAllKeysFromMap(Map<String, Object> map, ArrayList<String> arrayList) {
        if (arrayList != null) {
            arrayList.clear();
            if (map != null && map.size() >= 1) {
                for (Entry key : map.entrySet()) {
                    arrayList.add((String) key.getKey());
                }
            }
        }
    }
}
