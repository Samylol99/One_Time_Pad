package com.my.OneTimePad;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {
    private double CharaNew = 0.0d;
    private double CharaOld = 0.0d;
    private String Chifre = "";
    private String Crypted = "";
    private double Shift = 0.0d;
    private String Shifts = "";
    private String Textmemory = "";
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private EditText edittext1;
    private EditText edittext2;
    private double i = 0.0d;
    private LinearLayout linear10;
    private LinearLayout linear11;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private Switch switch1;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private TextView textview5;
    private TextView textview6;
    private TextView textview8;
    private TextView textview9;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.linear11 = (LinearLayout) findViewById(R.id.linear11);
        this.linear6 = (LinearLayout) findViewById(R.id.linear6);
        this.linear7 = (LinearLayout) findViewById(R.id.linear7);
        this.linear8 = (LinearLayout) findViewById(R.id.linear8);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.linear10 = (LinearLayout) findViewById(R.id.linear10);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.button5 = (Button) findViewById(R.id.button5);
        this.edittext1 = (EditText) findViewById(R.id.edittext1);
        this.button4 = (Button) findViewById(R.id.button4);
        this.edittext2 = (EditText) findViewById(R.id.edittext2);
        this.button1 = (Button) findViewById(R.id.button1);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button3 = (Button) findViewById(R.id.button3);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.textview5 = (TextView) findViewById(R.id.textview5);
        this.switch1 = (Switch) findViewById(R.id.switch1);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this.button5.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.edittext1.setText("");
            }
        });
        this.button4.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.edittext2.setText("");
            }
        });
        this.button1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.edittext1.setText(MainActivity.this.edittext1.getText().toString().toLowerCase());
                MainActivity.this.Textmemory = MainActivity.this.edittext1.getText().toString();
                MainActivity.this.Crypted = "";
                MainActivity.this.Shifts = "";
                int i;
                MainActivity mainActivity;
                if (MainActivity.this.switch1.isChecked()) {
                    MainActivity.this.Shifts = MainActivity.this.edittext2.getText().toString();
                    if (MainActivity.this.edittext1.getText().toString().equals("") || MainActivity.this.edittext2.getText().toString().equals("")) {
                        SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Write Something Please");
                    } else if (MainActivity.this.Shifts.substring(0, 1).equals(" ") && MainActivity.this.Shifts.substring(MainActivity.this.Shifts.length() - 1, MainActivity.this.Shifts.length()).equals(" ")) {
                        for (i = 0; i < MainActivity.this.edittext1.getText().toString().length(); i++) {
                            if (MainActivity.this.Textmemory.substring(0, 1).equals(" ")) {
                                MainActivity.this.Crypted = MainActivity.this.Crypted.concat(" ");
                                MainActivity.this.Shifts = MainActivity.this.Shifts.substring(2, MainActivity.this.Shifts.length());
                            } else {
                                MainActivity.this.Shifts = MainActivity.this.Shifts.substring(1, MainActivity.this.Shifts.length());
                                MainActivity.this.Chifre = MainActivity.this.Shifts.substring(0, MainActivity.this.Shifts.indexOf(" "));
                                if (!(MainActivity.this.Chifre.equals("") || MainActivity.this.Chifre.equals(" "))) {
                                    MainActivity.this.Shift = Double.parseDouble(MainActivity.this.Chifre);
                                    MainActivity.this._GetCharacter();
                                    MainActivity.this.CharaNew = MainActivity.this.CharaOld - MainActivity.this.Shift;
                                    if (MainActivity.this.CharaNew < 0.0d) {
                                        mainActivity = MainActivity.this;
                                        mainActivity.CharaNew = mainActivity.CharaNew + 36.0d;
                                    }
                                    MainActivity.this._ShifCharacter();
                                    MainActivity.this.Shifts = MainActivity.this.Shifts.substring(MainActivity.this.Shifts.indexOf(" "), MainActivity.this.Shifts.length());
                                }
                            }
                            MainActivity.this.Textmemory = MainActivity.this.Textmemory.substring(1, MainActivity.this.Textmemory.length());
                            MainActivity.this.textview2.setText(MainActivity.this.Crypted);
                        }
                    } else {
                        SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Invalid Shifts");
                    }
                } else if (MainActivity.this.edittext1.getText().toString().equals("")) {
                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Write Something Please");
                } else {
                    for (i = 0; i < MainActivity.this.edittext1.getText().toString().length(); i++) {
                        if (MainActivity.this.Textmemory.substring(0, 1).equals(" ")) {
                            MainActivity.this.Crypted = MainActivity.this.Crypted.concat(" ");
                            MainActivity.this.Shifts = MainActivity.this.Shifts.concat(" ".concat("0"));
                        } else {
                            MainActivity.this.Shift = (double) SketchwareUtil.getRandom(1, 35);
                            MainActivity.this.Shifts = MainActivity.this.Shifts.concat(" ".concat(String.valueOf((long) MainActivity.this.Shift)));
                            MainActivity.this.textview3.setText(MainActivity.this.Shifts);
                            MainActivity.this._GetCharacter();
                            MainActivity.this.CharaNew = MainActivity.this.CharaOld + MainActivity.this.Shift;
                            if (MainActivity.this.CharaNew > 36.0d) {
                                mainActivity = MainActivity.this;
                                mainActivity.CharaNew = mainActivity.CharaNew - 36.0d;
                            }
                            MainActivity.this._ShifCharacter();
                        }
                        MainActivity.this.Textmemory = MainActivity.this.Textmemory.substring(1, MainActivity.this.Textmemory.length());
                        MainActivity.this.textview2.setText(MainActivity.this.Crypted);
                    }
                    MainActivity.this.textview3.setText(MainActivity.this.Shifts.concat(" "));
                }
            }
        });
        this.button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity mainActivity = MainActivity.this;
                MainActivity.this.getApplicationContext();
                ((ClipboardManager) mainActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", MainActivity.this.textview3.getText().toString()));
                SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Shifts Copied !");
            }
        });
        this.button3.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity mainActivity = MainActivity.this;
                MainActivity.this.getApplicationContext();
                ((ClipboardManager) mainActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", MainActivity.this.textview2.getText().toString()));
                SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Shifted Text Copied !");
            }
        });
        this.switch1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.this.switch1.isChecked()) {
                    MainActivity.this.button2.setVisibility(8);
                    MainActivity.this.linear7.setVisibility(8);
                    MainActivity.this.linear11.setVisibility(0);
                    MainActivity.this.textview2.setText("Decrypted Text");
                    return;
                }
                MainActivity.this.button2.setVisibility(0);
                MainActivity.this.linear7.setVisibility(0);
                MainActivity.this.linear11.setVisibility(8);
                MainActivity.this.textview2.setText("Encrypted Text");
            }
        });
    }

    private void initializeLogic() {
        this.linear11.setVisibility(8);
    }

    public void _GetCharacter() {
        this.i = 0.0d;
        for (int i = 0; i < 35; i++) {
            if ("abcdefghijklmnopqrstuvwxyz0123456789".substring((int) this.i, (int) (this.i + 1.0d)).equals(this.Textmemory.substring(0, 1))) {
                this.CharaOld = this.i + 1.0d;
            }
            this.i += 1.0d;
        }
    }

    public void _ShifCharacter() {
        this.Crypted = this.Crypted.concat("abcdefghijklmnopqrstuvwxyz0123456789".substring((int) (this.CharaNew - 1.0d), (int) this.CharaNew));
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList arrayList = new ArrayList();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
