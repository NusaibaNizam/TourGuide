package org.a55889966.bleach.saran.tourguide;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;


public class CostAdapter extends RecyclerView.Adapter<CostAdapter.CostListViewHolder> {

    private Context context;
    private ArrayList<ExpenseClass> expenses;
    private ClickListener clickListener;

    public CostAdapter(Context context, ArrayList<ExpenseClass> expenses, ClickListener clickListener) {
        this.context = context;
        this.expenses = expenses;
        this.clickListener = clickListener;
    }

    @Override
    public CostListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cost_single_row,parent,false);

        return new CostListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CostListViewHolder holder, int position) {

        ExpenseClass expenseClass = expenses.get(position);
        holder.costTittle.setText(expenseClass.getExpenseTittle());
        holder.costAmoutnt.setText(String.valueOf(expenseClass.getExpenseAmount()));
        holder.costDate.setText(String.valueOf(expenseClass.getExpenseDate()));

    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class CostListViewHolder extends RecyclerView.ViewHolder {

        TextView costTittle,costAmoutnt,costDate;
        public CostListViewHolder(View itemView) {
            super(itemView);

            costAmoutnt = itemView.findViewById(R.id.costAmountTv);
            costTittle = itemView.findViewById(R.id.costTittleTv);
            costDate = itemView.findViewById(R.id.costDateTV);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onClickCostItem(expenses.get(getAdapterPosition()));
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    clickListener.onLogClickCostItem(expenses.get(getAdapterPosition()));
                    return true;
                }
            });
        }
    }
    public interface ClickListener{
        void onClickCostItem(ExpenseClass expenseClass);
        void onLogClickCostItem(ExpenseClass expenseClass);
    }
}
