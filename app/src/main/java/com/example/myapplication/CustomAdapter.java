package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] localDataSet;
    private String[] localDataSet2;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView textView2;

        public ViewHolder1(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = (TextView) view.findViewById(R.id.textView);
            textView2 = (TextView) view.findViewById(R.id.textView2);
        }

        public TextView getTextView() {
            return textView;
        }
        public TextView getTextView2() {
            return textView2;
        }

    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        private final TextView textView;
        public ViewHolder2(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = (TextView) view.findViewById(R.id.textView);
        }
        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter(String[] dataSet, String[] dataSet2) {
        localDataSet = dataSet;
        localDataSet2 = dataSet2;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.text_row_item, viewGroup, false);
                return new ViewHolder1(view);
            case 2:
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.text_row_item_2, viewGroup, false);
                return new ViewHolder2(view);
            default:
                return null;
        }
    }
    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2 * 2;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        switch (viewHolder.getItemViewType()) {
            case 0:
                ViewHolder1 viewHolder1 = (ViewHolder1)viewHolder;
                viewHolder1.getTextView().setText(localDataSet[position]);
                viewHolder1.getTextView2().setText(localDataSet2[position]);
                break;
            case 2:
                ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
                viewHolder2.getTextView().setText(localDataSet[position]);
                break;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
