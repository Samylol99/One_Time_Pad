package com.my.OneTimePad;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileUtil {
    private static void createNewFile(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf > 0) {
            makeDir(str.substring(0, lastIndexOf));
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037 A:{SYNTHETIC, Splitter:B:20:0x0037} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0044 A:{SYNTHETIC, Splitter:B:27:0x0044} */
    public static java.lang.String readFile(java.lang.String r6) {
        /*
        createNewFile(r6);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = 0;
        r1 = new java.io.FileReader;	 Catch:{ IOException -> 0x0054, all -> 0x0040 }
        r0 = new java.io.File;	 Catch:{ IOException -> 0x0054, all -> 0x0040 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x0054, all -> 0x0040 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x0054, all -> 0x0040 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new char[r0];	 Catch:{ IOException -> 0x0031 }
    L_0x0017:
        r2 = r1.read(r0);	 Catch:{ IOException -> 0x0031 }
        if (r2 > 0) goto L_0x0027;
    L_0x001d:
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        r1.close();	 Catch:{ Exception -> 0x004d }
    L_0x0022:
        r0 = r3.toString();
        return r0;
    L_0x0027:
        r4 = new java.lang.String;	 Catch:{ IOException -> 0x0031 }
        r5 = 0;
        r4.<init>(r0, r5, r2);	 Catch:{ IOException -> 0x0031 }
        r3.append(r4);	 Catch:{ IOException -> 0x0031 }
        goto L_0x0017;
    L_0x0031:
        r0 = move-exception;
    L_0x0032:
        r0.printStackTrace();	 Catch:{ all -> 0x0052 }
        if (r1 == 0) goto L_0x0022;
    L_0x0037:
        r1.close();	 Catch:{ Exception -> 0x003b }
        goto L_0x0022;
    L_0x003b:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0022;
    L_0x0040:
        r0 = move-exception;
        r1 = r2;
    L_0x0042:
        if (r1 == 0) goto L_0x0047;
    L_0x0044:
        r1.close();	 Catch:{ Exception -> 0x0048 }
    L_0x0047:
        throw r0;
    L_0x0048:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0047;
    L_0x004d:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0022;
    L_0x0052:
        r0 = move-exception;
        goto L_0x0042;
    L_0x0054:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.OneTimePad.FileUtil.readFile(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022 A:{SYNTHETIC, Splitter:B:13:0x0022} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e A:{SYNTHETIC, Splitter:B:19:0x002e} */
    public static void writeFile(java.lang.String r4, java.lang.String r5) {
        /*
        createNewFile(r4);
        r2 = 0;
        r1 = new java.io.FileWriter;	 Catch:{ IOException -> 0x001b, all -> 0x002b }
        r0 = new java.io.File;	 Catch:{ IOException -> 0x001b, all -> 0x002b }
        r0.<init>(r4);	 Catch:{ IOException -> 0x001b, all -> 0x002b }
        r3 = 0;
        r1.<init>(r0, r3);	 Catch:{ IOException -> 0x001b, all -> 0x002b }
        r1.write(r5);	 Catch:{ IOException -> 0x003f }
        r1.flush();	 Catch:{ IOException -> 0x003f }
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r1.close();	 Catch:{ IOException -> 0x0037 }
    L_0x001a:
        return;
    L_0x001b:
        r0 = move-exception;
        r1 = r2;
    L_0x001d:
        r0.printStackTrace();	 Catch:{ all -> 0x003c }
        if (r1 == 0) goto L_0x001a;
    L_0x0022:
        r1.close();	 Catch:{ IOException -> 0x0026 }
        goto L_0x001a;
    L_0x0026:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001a;
    L_0x002b:
        r0 = move-exception;
    L_0x002c:
        if (r2 == 0) goto L_0x0031;
    L_0x002e:
        r2.close();	 Catch:{ IOException -> 0x0032 }
    L_0x0031:
        throw r0;
    L_0x0032:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0031;
    L_0x0037:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001a;
    L_0x003c:
        r0 = move-exception;
        r2 = r1;
        goto L_0x002c;
    L_0x003f:
        r0 = move-exception;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.OneTimePad.FileUtil.writeFile(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003b A:{SYNTHETIC, Splitter:B:28:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0040 A:{SYNTHETIC, Splitter:B:31:0x0040} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003b A:{SYNTHETIC, Splitter:B:28:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0040 A:{SYNTHETIC, Splitter:B:31:0x0040} */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0053 A:{SYNTHETIC, Splitter:B:40:0x0053} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0058 A:{SYNTHETIC, Splitter:B:43:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0053 A:{SYNTHETIC, Splitter:B:40:0x0053} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0058 A:{SYNTHETIC, Splitter:B:43:0x0058} */
    public static void copyFile(java.lang.String r5, java.lang.String r6) {
        /*
        r2 = 0;
        r0 = isExistFile(r5);
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        createNewFile(r6);
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0070, all -> 0x004e }
        r3.<init>(r5);	 Catch:{ IOException -> 0x0070, all -> 0x004e }
        r1 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0074, all -> 0x006b }
        r0 = 0;
        r1.<init>(r6, r0);	 Catch:{ IOException -> 0x0074, all -> 0x006b }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ IOException -> 0x0035 }
    L_0x001a:
        r2 = r3.read(r0);	 Catch:{ IOException -> 0x0035 }
        if (r2 > 0) goto L_0x0030;
    L_0x0020:
        if (r3 == 0) goto L_0x0025;
    L_0x0022:
        r3.close();	 Catch:{ IOException -> 0x0066 }
    L_0x0025:
        if (r1 == 0) goto L_0x0007;
    L_0x0027:
        r1.close();	 Catch:{ IOException -> 0x002b }
        goto L_0x0007;
    L_0x002b:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0007;
    L_0x0030:
        r4 = 0;
        r1.write(r0, r4, r2);	 Catch:{ IOException -> 0x0035 }
        goto L_0x001a;
    L_0x0035:
        r0 = move-exception;
    L_0x0036:
        r0.printStackTrace();	 Catch:{ all -> 0x006e }
        if (r3 == 0) goto L_0x003e;
    L_0x003b:
        r3.close();	 Catch:{ IOException -> 0x0049 }
    L_0x003e:
        if (r1 == 0) goto L_0x0007;
    L_0x0040:
        r1.close();	 Catch:{ IOException -> 0x0044 }
        goto L_0x0007;
    L_0x0044:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0007;
    L_0x0049:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x003e;
    L_0x004e:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x0051:
        if (r3 == 0) goto L_0x0056;
    L_0x0053:
        r3.close();	 Catch:{ IOException -> 0x005c }
    L_0x0056:
        if (r1 == 0) goto L_0x005b;
    L_0x0058:
        r1.close();	 Catch:{ IOException -> 0x0061 }
    L_0x005b:
        throw r0;
    L_0x005c:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0056;
    L_0x0061:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x005b;
    L_0x0066:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0025;
    L_0x006b:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0051;
    L_0x006e:
        r0 = move-exception;
        goto L_0x0051;
    L_0x0070:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
        goto L_0x0036;
    L_0x0074:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.OneTimePad.FileUtil.copyFile(java.lang.String, java.lang.String):void");
    }

    public static void copyDir(String str, String str2) {
        File[] listFiles = new File(str).listFiles();
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                copyFile(file2.getPath(), new StringBuilder(String.valueOf(str2)).append("/").append(file2.getName()).toString());
            } else if (file2.isDirectory()) {
                copyDir(file2.getPath(), new StringBuilder(String.valueOf(str2)).append("/").append(file2.getName()).toString());
            }
        }
    }

    public static void moveFile(String str, String str2) {
        copyFile(str, str2);
        deleteFile(str);
    }

    public static void deleteFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteFile(file2.getAbsolutePath());
                }
                if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
        file.delete();
    }

    public static boolean isExistFile(String str) {
        return new File(str).exists();
    }

    public static void makeDir(String str) {
        if (!isExistFile(str)) {
            new File(str).mkdirs();
        }
    }

    public static void listDir(String str, ArrayList<String> arrayList) {
        File file = new File(str);
        if (file.exists() && !file.isFile()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0 && arrayList != null) {
                arrayList.clear();
                for (File absolutePath : listFiles) {
                    arrayList.add(absolutePath.getAbsolutePath());
                }
            }
        }
    }

    public static boolean isDirectory(String str) {
        if (isExistFile(str)) {
            return new File(str).isDirectory();
        }
        return false;
    }

    public static boolean isFile(String str) {
        if (isExistFile(str)) {
            return new File(str).isFile();
        }
        return false;
    }

    public static long getFileLength(String str) {
        if (isExistFile(str)) {
            return new File(str).length();
        }
        return 0;
    }

    public static String getExternalStorageDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getPackageDataDir(Context context) {
        return context.getExternalFilesDir(null).getAbsolutePath();
    }

    public static String getPublicDir(String str) {
        return Environment.getExternalStoragePublicDirectory(str).getAbsolutePath();
    }

    public static String convertUriToFilePath(Context context, Uri uri) {
        String str;
        String str2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    str = Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                str = str2;
            } else if (isDownloadsDocument(uri)) {
                str = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(str) && str.startsWith("raw:")) {
                    return str.replaceFirst("raw:", "");
                }
                str = getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(str).longValue()), str2, str2);
            } else {
                if (isMediaDocument(uri)) {
                    Uri uri2;
                    Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
                    if ("image".equals(obj)) {
                        uri2 = Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(obj)) {
                        uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(obj)) {
                        uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
                    } else {
                        obj = str2;
                    }
                    str = getDataColumn(context, uri2, "_id=?", new String[]{r2[1]});
                }
                str = str2;
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            str = getDataColumn(context, uri, str2, str2);
        } else {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                str = uri.getPath();
            }
            str = str2;
        }
        if (str == null) {
            return str2;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            return str2;
        }
    }

    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Throwable th2;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (th != null) {
                        if (th != th2) {
                            th.addSuppressed(th2);
                        }
                        th2 = th;
                    }
                    try {
                        throw th2;
                    } catch (Exception e) {
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th4) {
            th2 = th4;
            th = null;
        }
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static void saveBitmap(Bitmap bitmap, String str) {
        Throwable th;
        createNewFile(str);
        Throwable th2 = null;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            if (th2 != null) {
                if (th2 != th3) {
                    th2.addSuppressed(th3);
                }
                th3 = th2;
            }
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Bitmap getScaledBitmap(String str, int i) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        if (width > height) {
            width = (int) ((((float) i) / ((float) width)) * ((float) height));
            height = i;
        } else {
            height = (int) (((float) width) * (((float) i) / ((float) height)));
            width = i;
        }
        return Bitmap.createScaledBitmap(decodeFile, height, width, true);
    }

    public static int calculateInSampleSize(Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            i4 /= 2;
            i3 /= 2;
            while (i4 / i5 >= i2 && i3 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap decodeSampleBitmapFromPath(String str, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static void resizeBitmapFileRetainRatio(String str, String str2, int i) {
        if (isExistFile(str)) {
            saveBitmap(getScaledBitmap(str, i), str2);
        }
    }

    public static void resizeBitmapFileToSquare(String str, String str2, int i) {
        if (isExistFile(str)) {
            saveBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeFile(str), i, i, true), str2);
        }
    }

    public static void resizeBitmapFileToCircle(String str, String str2) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, decodeFile.getWidth(), decodeFile.getHeight());
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawCircle((float) (decodeFile.getWidth() / 2), (float) (decodeFile.getHeight() / 2), (float) (decodeFile.getWidth() / 2), paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawBitmap(decodeFile, rect, rect, paint);
            saveBitmap(createBitmap, str2);
        }
    }

    public static void resizeBitmapFileWithRoundedBorder(String str, String str2, int i) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, decodeFile.getWidth(), decodeFile.getHeight());
            RectF rectF = new RectF(rect);
            float f = (float) i;
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f, f, paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawBitmap(decodeFile, rect, rect, paint);
            saveBitmap(createBitmap, str2);
        }
    }

    public static void cropBitmapFileFromCenter(String str, String str2, int i, int i2) {
        int i3 = 0;
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            if (width >= i || height >= i2) {
                int i4;
                if (width > i) {
                    i4 = (width - i) / 2;
                } else {
                    i4 = 0;
                }
                if (height > i2) {
                    i3 = (height - i2) / 2;
                }
                if (i > width) {
                    i = width;
                }
                if (i2 > height) {
                    i2 = height;
                }
                saveBitmap(Bitmap.createBitmap(decodeFile, i4, i3, i, i2), str2);
            }
        }
    }

    public static void rotateBitmapFile(String str, String str2, float f) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Matrix matrix = new Matrix();
            matrix.postRotate(f);
            saveBitmap(Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true), str2);
        }
    }

    public static void scaleBitmapFile(String str, String str2, float f, float f2) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Matrix matrix = new Matrix();
            matrix.postScale(f, f2);
            saveBitmap(Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true), str2);
        }
    }

    public static void skewBitmapFile(String str, String str2, float f, float f2) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Matrix matrix = new Matrix();
            matrix.postSkew(f, f2);
            saveBitmap(Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true), str2);
        }
    }

    public static void setBitmapFileColorFilter(String str, String str2, int i) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            decodeFile = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth() - 1, decodeFile.getHeight() - 1);
            Paint paint = new Paint();
            paint.setColorFilter(new LightingColorFilter(i, 1));
            new Canvas(decodeFile).drawBitmap(decodeFile, 0.0f, 0.0f, paint);
            saveBitmap(decodeFile, str2);
        }
    }

    public static void setBitmapFileBrightness(String str, String str2, float f) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ColorMatrix colorMatrix = new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 1.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 1.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), decodeFile.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(decodeFile, 0.0f, 0.0f, paint);
            saveBitmap(createBitmap, str2);
        }
    }

    public static void setBitmapFileContrast(String str, String str2, float f) {
        if (isExistFile(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ColorMatrix colorMatrix = new ColorMatrix(new float[]{f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), decodeFile.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(decodeFile, 0.0f, 0.0f, paint);
            saveBitmap(createBitmap, str2);
        }
    }

    public static int getJpegRotate(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", -1)) {
                case 3:
                    return 180;
                case 6:
                    return 90;
                case 8:
                    return 270;
                default:
                    return 0;
            }
        } catch (IOException e) {
            return 0;
        }
    }

    public static File createNewPictureFile(Context context) {
        return new File(new StringBuilder(String.valueOf(context.getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath())).append(File.separator).append(new StringBuilder(String.valueOf(new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()))).append(".jpg").toString()).toString());
    }
}
