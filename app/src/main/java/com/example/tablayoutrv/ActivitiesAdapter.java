package com.example.tablayoutrv;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ExampleViewHolder> {

    private ArrayList<ActivitiesItem> mExamplelist;
    Context context;



    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView booktitle_tv;
        public TextView accno_tv;
        public TextView authorname_tv;
        public TextView issuedate_tv;
        public TextView returndate_tv;

        public CardView card_outer;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            card_outer = itemView.findViewById(R.id.card_outer);

            booktitle_tv = itemView.findViewById(R.id.booktitle_tv);
            accno_tv = itemView.findViewById(R.id.accno_tv);
            authorname_tv = itemView.findViewById(R.id.authorname_tv);
            issuedate_tv = itemView.findViewById(R.id.issuedate_tv);
            returndate_tv = itemView.findViewById(R.id.returndate_tv);



        }
    }

    public ActivitiesAdapter(ArrayList<ActivitiesItem> examplelist ) {
        mExamplelist = examplelist;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activities_item, viewGroup, false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(v);
        context =viewGroup.getContext();
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder exampleViewHolder, final int position) {

        ActivitiesItem currentItem  = mExamplelist.get(position);



        exampleViewHolder.booktitle_tv.setText(currentItem.getBooktitle_tv());
        exampleViewHolder.accno_tv.setText(currentItem.getAccno_tv());
        exampleViewHolder.authorname_tv.setText(currentItem.getAuthorname_tv());
        exampleViewHolder.issuedate_tv.setText(currentItem.getIssuedate_tv());
        exampleViewHolder.returndate_tv.setText(currentItem.getReturndate_tv());

         {

            exampleViewHolder.card_outer.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    exampleViewHolder.card_outer.setCardBackgroundColor(Color.rgb(98, 0, 238));

                    //ActivitiesItem.selected.add(position);
                    Toast.makeText(context, "" + ActivitiesItem.selected, Toast.LENGTH_SHORT).show();
                    ActivitiesItem.selecter = true;
                    return false;
                }
            });
        }

         {

            exampleViewHolder.card_outer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (ActivitiesItem.selecter && !(ActivitiesItem.selected.contains((Integer)position))) {
                        exampleViewHolder.card_outer.setCardBackgroundColor(Color.rgb(98, 0, 238));

                        ActivitiesItem.selected.add((Integer) position);
                        Toast.makeText(context, "" + ActivitiesItem.selected, Toast.LENGTH_SHORT).show();
                        //ActivitiesItem.card_selected_position.add((Integer) position);

                    }

                    else if (ActivitiesItem.selected.contains((Integer)position)){

                        exampleViewHolder.card_outer.setCardBackgroundColor(Color.parseColor("#00000000"));

                        ActivitiesItem.selected.remove((Integer) position);
                        Toast.makeText(context, "" + ActivitiesItem.selected, Toast.LENGTH_SHORT).show();
                        //ActivitiesItem.card_selected_position.remove((Integer)position);


                    }
                    else {
                        Toast.makeText(context, "Press Long for selection", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mExamplelist.size();
    }
}
