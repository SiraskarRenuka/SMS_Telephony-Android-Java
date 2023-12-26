package com.example.practical29;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSendSMS;
    EditText txtPhoneNo;
    EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSendSMS =  findViewById(R.id.btnSendSMS);
        txtPhoneNo = findViewById(R.id.txtPhoneNo);
        txtMessage =  findViewById(R.id.txtMessage);

        btnSendSMS.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                String phoneNo = txtPhoneNo.getText().toString();
                String message = txtMessage.getText().toString();
                if (phoneNo.length()>0 && message.length()>0)
                    SendSMS(phoneNo, message);
                else
                    Toast.makeText(getBaseContext(),
                            "Please enter both phone number and message.",
                            Toast.LENGTH_SHORT).show();
            }
        });


}
    private void SendSMS(String phoneNo, String message) {
        PendingIntent pi = PendingIntent.getActivity(this, 0,
                new Intent(this, Telephony.Sms.class), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNo, null, message, pi, null);
    }
}
