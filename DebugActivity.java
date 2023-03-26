package com.my.OneTimePad;

import android.app.Activity;

public class DebugActivity extends Activity {
    private String[] exceptionMessages = new String[]{"Invalid string operation\n", "Invalid list operation\n", "Invalid arithmetical operation\n", "Invalid toNumber block operation\n", "Invalid intent operation"};
    private String[] exceptionTypes = new String[]{"StringIndexOutOfBoundsException", "IndexOutOfBoundsException", "ArithmeticException", "NumberFormatException", "ActivityNotFoundException"};

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:7:0x0023, code skipped:
            if (r1.isEmpty() != false) goto L_0x0025;
     */
    public void onCreate(android.os.Bundle r8) {
        /*
        r7 = this;
        r2 = 0;
        super.onCreate(r8);
        r0 = r7.getIntent();
        r1 = "";
        r1 = "";
        if (r0 == 0) goto L_0x00d3;
    L_0x000e:
        r3 = "error";
        r0 = r0.getStringExtra(r3);
        r3 = "\n";
        r3 = r0.split(r3);
    L_0x001a:
        r4 = r7.exceptionTypes;	 Catch:{ Exception -> 0x00b5 }
        r4 = r4.length;	 Catch:{ Exception -> 0x00b5 }
        if (r2 < r4) goto L_0x0054;
    L_0x001f:
        r2 = r1.isEmpty();	 Catch:{ Exception -> 0x00b5 }
        if (r2 == 0) goto L_0x00d3;
    L_0x0025:
        r1 = new android.app.AlertDialog$Builder;
        r1.<init>(r7);
        r2 = "An error occurred";
        r1 = r1.setTitle(r2);
        r0 = r1.setMessage(r0);
        r1 = "End Application";
        r2 = new com.my.OneTimePad.DebugActivity$1;
        r2.<init>();
        r0 = r0.setPositiveButton(r1, r2);
        r0 = r0.create();
        r0.show();
        r1 = 16908299; // 0x102000b float:2.387726E-38 double:8.3538097E-317;
        r0 = r0.findViewById(r1);
        r0 = (android.widget.TextView) r0;
        r1 = 1;
        r0.setTextIsSelectable(r1);
        return;
    L_0x0054:
        r4 = 0;
        r4 = r3[r4];	 Catch:{ Exception -> 0x00b5 }
        r5 = r7.exceptionTypes;	 Catch:{ Exception -> 0x00b5 }
        r5 = r5[r2];	 Catch:{ Exception -> 0x00b5 }
        r4 = r4.contains(r5);	 Catch:{ Exception -> 0x00b5 }
        if (r4 == 0) goto L_0x00b1;
    L_0x0061:
        r4 = r7.exceptionMessages;	 Catch:{ Exception -> 0x00b5 }
        r1 = r4[r2];	 Catch:{ Exception -> 0x00b5 }
        r4 = 0;
        r4 = r3[r4];	 Catch:{ Exception -> 0x00b5 }
        r5 = r7.exceptionTypes;	 Catch:{ Exception -> 0x00b5 }
        r5 = r5[r2];	 Catch:{ Exception -> 0x00b5 }
        r4 = r4.indexOf(r5);	 Catch:{ Exception -> 0x00b5 }
        r5 = r7.exceptionTypes;	 Catch:{ Exception -> 0x00b5 }
        r2 = r5[r2];	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.length();	 Catch:{ Exception -> 0x00b5 }
        r2 = r2 + r4;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b5 }
        r5 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x00b5 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x00b5 }
        r5 = 0;
        r5 = r3[r5];	 Catch:{ Exception -> 0x00b5 }
        r6 = 0;
        r3 = r3[r6];	 Catch:{ Exception -> 0x00b5 }
        r3 = r3.length();	 Catch:{ Exception -> 0x00b5 }
        r2 = r5.substring(r2, r3);	 Catch:{ Exception -> 0x00b5 }
        r2 = r4.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r1 = r2.toString();	 Catch:{ Exception -> 0x00b5 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b5 }
        r3 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x00b5 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00b5 }
        r3 = "\n\nDetailed error message:\n";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r1 = r2.toString();	 Catch:{ Exception -> 0x00b5 }
        goto L_0x001f;
    L_0x00b1:
        r2 = r2 + 1;
        goto L_0x001a;
    L_0x00b5:
        r0 = move-exception;
        r2 = new java.lang.StringBuilder;
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r1);
        r1 = "\n\nError while getting error: ";
        r1 = r2.append(r1);
        r0 = android.util.Log.getStackTraceString(r0);
        r0 = r1.append(r0);
        r0 = r0.toString();
        goto L_0x0025;
    L_0x00d3:
        r0 = r1;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.OneTimePad.DebugActivity.onCreate(android.os.Bundle):void");
    }
}
