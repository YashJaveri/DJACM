package com.imbuegen.alumniapp.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.imbuegen.alumniapp.R;

import com.imbuegen.alumniapp.Models.EventModel;

import java.util.List;

public class EventListAdapter extends ArrayAdapter<EventModel> {

    private Activity context;
    private List<EventModel> data;

    public EventListAdapter(Activity context, List<EventModel> alumniList) {
        super(context,R.layout.event_list,alumniList);
        this.context = context;
        this.data = alumniList;
    }


    @NonNull
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {


        LayoutInflater inflater = context.getLayoutInflater();

        View listItemView = inflater.inflate(R.layout.event_list,null,true);
        TextView title_tv = (TextView) listItemView.findViewById(R.id.title_tv);
        title_tv.setText(data.get(position).title);
        TextView date_tv = (TextView) listItemView.findViewById(R.id.date_tv);
        date_tv.setText(data.get(position).date);
        TextView body_tv = (TextView) listItemView.findViewById(R.id.body_tv);
        body_tv.setText(data.get(position).body);

        return listItemView;
    }
}
