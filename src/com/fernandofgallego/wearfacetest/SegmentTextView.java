package com.fernandofgallego.wearfacetest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class SegmentTextView extends TextView
{

	public SegmentTextView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		init(context);
	}

	public SegmentTextView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init(context);
	}

	public SegmentTextView(Context context)
	{
		super(context);
		init(context);
	}

	private void init(Context c)
	{
		setTypeface(Typefaces.get(getContext(), "font/digital.ttf"));
	}

}
