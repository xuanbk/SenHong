package giupviec.senhong.com.senhong.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import giupviec.senhong.com.senhong.R;
import giupviec.senhong.com.senhong.activitys.OrderActivity;


/**
 * Created by Administrator on 04/24/2017.
 */

public class OrderAdapter extends RecyclerView.Adapter {
    private Activity mActivity;
    private LayoutInflater layoutInflater = null;

    public OrderAdapter(Activity activity) {
        this.mActivity = activity;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_order, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final OrderAdapter.ViewHolder viewHolder = (OrderAdapter.ViewHolder) holder;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogOrder();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
    public void dialogOrder() {
        final Dialog dialog = new Dialog(mActivity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_order);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.findViewById(R.id.btNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
