package pl.maciejapanowicz.tasks.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pl.maciejapanowicz.tasks.activity.R;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    static String[] fakeData = new String[] {
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Ah .... ah ... ah!"
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_task, parent, false);
        //wrap it in a ViewHolder
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolde, int position) {
        viewHolde.titleView.setText(fakeData[position]);
    }

    @Override
    public int getItemCount() {
        return fakeData.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView titleView;

        public ViewHolder (CardView card){
            super(card);
            cardView = card;
            titleView = (TextView)card.findViewById(R.id.text1);
        }
    }
}
