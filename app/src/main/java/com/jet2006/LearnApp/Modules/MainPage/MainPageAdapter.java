package com.jet2006.LearnApp.Modules.MainPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jet2006.LearnApp.R;

import java.util.List;


public class MainPageAdapter extends ArrayAdapter<MainPageItem> {

    private int textViewResourceId;

    public MainPageAdapter(Context context, int textViewResourceId, List<MainPageItem> objects) {
        super(context, textViewResourceId, objects);
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 这是经过优化的视图加载方法，可以减少View的数量。
        // http://blog.csdn.net/zuolongsnail/article/details/7197979

        MainPageItem item = getItem(position);
        View view;
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(textViewResourceId, null);
            viewHolder.img = (ImageView) view.findViewById(R.id.img);
            viewHolder.title = (TextView) view.findViewById(R.id.title);
            viewHolder.desc = (TextView) view.findViewById(R.id.desc);
            viewHolder.tip = (TextView) view.findViewById(R.id.tip);
            viewHolder.silent = (ImageView) view.findViewById(R.id.slient);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.img.setImageResource(item.getIcon());
        viewHolder.title.setText(item.getName());
        viewHolder.desc.setText(item.getDescription());
        viewHolder.tip.setText(item.getTip());

        int resId = R.drawable.imagepager_dot;
        if (item.isOld()) {
            resId = R.drawable.imagepager_dot_focus;
        }
        viewHolder.silent.setImageResource(resId);

        return view;
    }

    static class ViewHolder {
        public ImageView img;
        public TextView title;
        public TextView desc;
        public TextView tip;
        public ImageView silent;
    }
}
