package com.mobiledash.clases;

import java.util.ArrayList;

import com.dragdrop.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemHistoriaAdapter extends BaseAdapter {
	protected Activity activity;
	protected ArrayList<Historia> items;

	/**
	 * 
	 */
	public ItemHistoriaAdapter(Activity activity, ArrayList<Historia> items)
	{
		this.activity = activity;
		this.items = items;
	}
	
	public int getCount()
	{
		return items.size();
	}
	 
	public Object getItem(int position)
	{
		return items.get(position);
	}
	 
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View vi=convertView;
	         
	    if(convertView == null)
	    {
	    	LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    	vi = inflater.inflate(R.layout.lista_blanca, null);
	    }
	             
	    Historia item = items.get(position);
	         
	    TextView nombre = (TextView) vi.findViewById(R.id.myNr);
	    if(!item.getNombre().equals(""))
	    {
	    	nombre.setText(item.getNombre());
	    }
	    
	    return vi;
	}

	public long getItemId(int position) {
		return items.get(position).getIdHistoria();
	}
}