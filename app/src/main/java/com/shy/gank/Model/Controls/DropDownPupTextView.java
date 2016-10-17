package com.shy.gank.Model.Controls;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.shy.gank.R;

/**
 * Created by axnshy on 16/9/12.
 */
public class DropDownPupTextView extends TextView{
    PopupWindow mPopupWindow;
    int popupWindowId=R.layout.dropdownexample;



    public DropDownPupTextView(Context context) {
        this(context,null);
    }

    public DropDownPupTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DropDownPupTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            showPopupWindow();
        }else {

        }
        return true;
    }

    private void showPopupWindow() {
        FrameLayout frame =
                (FrameLayout) LayoutInflater.from(getContext())
                .inflate(R.layout.drop_down_popup,null);
        final View view = initPopup(frame);
        mPopupWindow = new PopupWindow(frame
                , ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.MATCH_PARENT
                , true);
        frame.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if(motionEvent.getY()>view.getY()+view.getHeight()){
                    mPopupWindow.dismiss();
                }
                return false;
            }
        });
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        mPopupWindow.showAsDropDown(this,-(int)getX(),getHeight());
    }

    public View initPopup(ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(popupWindowId,parent);
        Button btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "it's a test", Toast.LENGTH_SHORT).show();
            }
        });
        setPopupBackgroundDark(parent);
        return view;
    }

    public void setPopupBackgroundDark(View view){
        view.setBackgroundColor(Color.parseColor("#38000000"));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DropDownPupTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void setDropDownLayout(int res){
        this.popupWindowId=res;
    }

}
