package com.arielagenin.postpc_ex02;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message>
{

    Context context;
    List<Message> messageList;
    OnLongClickMessageListener longClickListener;

    public MessageAdapter(@NonNull Context context, @NonNull List<Message> objects,OnLongClickMessageListener list)
    {
        super(context, 0, objects);
        this.longClickListener = list;
        this.context = context;
        this.messageList = objects;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        View singleItem = convertView;
        final Message message = messageList.get(position);

        if (singleItem == null)
        {
            singleItem = LayoutInflater.from(context).inflate(R.layout.single_message, parent, false);
            singleItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longClickListener.onLongClickMessage(message);
                    return true;
                }
            });
        }


        TextView temp = singleItem.findViewById(R.id.message_content);
        temp.setText(message.getMessage());

        temp = singleItem.findViewById(R.id.user_name);
        temp.setText(message.getUsername());

        temp = singleItem.findViewById(R.id.time_of_message);
        temp.setText(message.getTime());

        return singleItem;

    }

    @Override
    public void add(@Nullable Message object)
    {
        messageList.add(object);
        notifyDataSetChanged();
    }

    public void remove(Message toRemove)
    {
        messageList.remove(messageList.indexOf(toRemove));
        notifyDataSetChanged();
    }

    interface OnLongClickMessageListener
    {
        void onLongClickMessage(Message msg);
    }
}
