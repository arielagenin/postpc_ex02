package com.arielagenin.postpc_ex02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements MessageFragment.InputMessageToMainActivity,MessageAdapter.OnLongClickMessageListener,DeleteFragment.OnLongClickListenerFromDeleteAdapter{

    String userName = "Ariela";
    EditText text;
    ListView messagesListView;
    MessageAdapter messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.messegeEditText);

        messagesListView = findViewById(R.id.list_view);

        messagesAdapter = new MessageAdapter(this,new ArrayList<Message>(),this);
        messagesListView.setAdapter(messagesAdapter);

    }

    private void addMessageToList(Message msg){
        messagesAdapter.add(msg);

    }


    public void sendCLicked(View view) {
        String msgText = text.getText().toString();
        if(!msgText.isEmpty()){
            addMessageToList(new Message(userName,msgText,new Date()));
            text.setText(null);
        }

    }

    public void messageContentClicked(View view) {
        MessageFragment.newInstance(this,text.getText().toString().trim()).show(getSupportFragmentManager());

    }

    @Override
    public void onSendClickedOnFragment(String messageToSend) {
        addMessageToList(new Message(userName,messageToSend,new Date()));
    }


    @Override
    public void onLongClickMessage(Message msg) {
        final DeleteFragment fragment = DeleteFragment.newInstance(this,msg);
        fragment.show(getSupportFragmentManager());


    }

    @Override
    public void OnAnyButtonCLicked(Message msg) {

        messagesAdapter.remove(msg);

    }
}

