package com.shy.gank.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shy.gank.Model.Bean.GanHuo;
import com.shy.gank.R;

import java.util.List;

/**
 * Created by axnshy on 16/8/28.
 */
public class GanHuoAdapter extends RecyclerView.Adapter<GanHuoHolder> {

    public static final String TAG = "GanHuoAdapter";
    private Context context;
    private LayoutInflater inflater;
    private List<GanHuo> datas;
    private OnClickListener mListener;
    private OnMenuListener meListener;

    public GanHuoAdapter(Context context,List<GanHuo> datas) {
        this.context = context;
        this.datas=datas;
        inflater=LayoutInflater.from(this.context);
        for (GanHuo gh : datas) {
            Log.w(TAG, "GanHuo desc in UI thread:" + gh.toString());
        }
    }

    @Override
    public GanHuoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ganhuo_android,parent,false);
        Log.w(TAG,"onCreateViewHolder      create a new item view");
        GanHuoHolder holder = new GanHuoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final GanHuoHolder holder, final int position) {
        holder.type.setText(datas.get(position).getType());
        holder.desc.setText(datas.get(position).getDesc());
        holder.who.setText(datas.get(position).getWho());
        holder.published.setText(datas.get(position).getPublishedAt()+"");
        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.OnShortClicked(holder.itemView, position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mListener.OnLongClicked(holder.itemView, position);
                    return false;
                }
            });
        }
        if(meListener != null){
            holder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    meListener.OnShortClicked(holder.more, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public interface OnClickListener{
        void OnShortClicked(View view, int position);
        void OnLongClicked(View view, int position);
    }

    public interface OnMenuListener{
        void OnShortClicked(View view,int position);
    }

    public void setOnClickListener(OnClickListener listener){
        this.mListener=listener;
        this.notifyDataSetChanged();
    }

    public void setMenuListener(OnMenuListener listener){
        this.meListener=listener;
        this.notifyDataSetChanged();
    }


}

class GanHuoHolder extends RecyclerView.ViewHolder {

    TextView type;
    ImageView avater;
    ImageView more;
    TextView desc;
    TextView published;
    TextView who;

    public GanHuoHolder(View itemView) {
        super(itemView);
        type = (TextView) itemView.findViewById(R.id.tv_ganhuo_type);
        avater = (ImageView) itemView.findViewById(R.id.iv_ganhuo_avatar);
        more = (ImageView) itemView.findViewById(R.id.iv_menu);
        desc = (TextView) itemView.findViewById(R.id.tv_ganhuo_desc);
        published = (TextView) itemView.findViewById(R.id.tv_publishedAt);
        who = (TextView) itemView.findViewById(R.id.tv_who);
    }
}