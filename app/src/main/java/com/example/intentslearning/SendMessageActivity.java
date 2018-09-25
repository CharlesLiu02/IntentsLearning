package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE= "com.example.intentslearning";
    private EditText editTextMsg;
    private Button buttonSend;
    private Button buttonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        wireWidgets();

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make an intent with desired action
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                //set the data type of the stuff we're packaging away
                intentShare.setType("text/plain");
                intentShare.putExtra(EXTRA_MESSAGE, editTextMsg.getText().toString());
                startActivity(intentShare);
            }
        });
    }

    private void wireWidgets() {
        editTextMsg = findViewById(R.id.editText_sendmessage_msg);
        buttonSend = findViewById(R.id.button_sendmessage_send);
        buttonShare = findViewById(R.id.button_sendmessage_share);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = editTextMsg.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
