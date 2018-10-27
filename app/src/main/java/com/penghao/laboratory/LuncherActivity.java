package com.penghao.laboratory;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class LuncherActivity extends Activity {

    public List<ResolveInfo> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luncher_activity);

        loadApps();

        GridView gridView=(GridView)findViewById(R.id.apps_list);
        AppsAdapter adapter=new AppsAdapter();
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(clickListener);
    }

    private void loadApps() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
       // new ImageView(MainActivity.this);

        apps = getPackageManager().queryIntentActivities(mainIntent, 0);
    }

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if(keyCode==KeyEvent.KEYCODE_BACK){
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

    private AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            ResolveInfo info = apps.get(i);
            //该应用的包名
            String pkg = info.activityInfo.packageName;
            //应用的主activity类
            String cls = info.activityInfo.name;
            ComponentName componet = new ComponentName(pkg, cls);

            Intent intent = new Intent();
            intent.setComponent(componet);
            startActivity(intent);
        }
    };

    class AppsAdapter extends BaseAdapter {

        public AppsAdapter(){
        }

        @Override
        public int getCount() {
            return apps.size();
        }

        @Override
        public Object getItem(int i) {
            return apps.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
			if(view==null){
				view=LayoutInflater.from(LuncherActivity.this).inflate(R.layout.luncher_item_view,null);
			}
			ImageView img=(ImageView) view.findViewById(R.id.item_viewImageView);
			TextView tv=(TextView) view.findViewById(R.id.item_viewTextView);
			
            ResolveInfo info = apps.get(i);
            img.setImageDrawable(info.activityInfo.loadIcon(getPackageManager()));
			tv.setText(info.activityInfo.loadLabel(getPackageManager()));
            return view;
        }
    }
}
