package ru.aydarov.converter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

public class ConversionAdapter extends RecyclerView.Adapter<ConversionAdapter.UnitHolder> {


    private ItemClickListener mListener;
    private List<Conversion> mConversions = Arrays.asList(Conversion.values());

    public ConversionAdapter(ItemClickListener listener) {
        mListener = listener;
    }

    public void setUnits(List<Conversion> conversions) {
        mConversions = new ArrayList<>(conversions);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UnitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new UnitHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitHolder holder, int position) {
        holder.bind(mConversions.get(position).label);

    }

    @Override
    public int getItemCount() {
        return mConversions != null ? mConversions.size() : 0;
    }

    class UnitHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mText;


        UnitHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mText = itemView.findViewById(R.id.text);
        }

        void bind(@StringRes int label) {
            mText.setText(itemView.getResources().getString(label));
        }

        @Override
        public void onClick(View v) {
            mListener.navigateSecondActivity(mConversions.get(getAdapterPosition()));
        }
    }

}
