package com.handmark.sidemenu_slidingmenu.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class MainActivity extends ActionBarActivity implements SlidingMenu.OnOpenListener, SlidingMenu.OnOpenedListener {

    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 设置SlidingMenu内容

        // 构造采用SlidingMenu（Context）创建
        // 使用Context创建的，需要调用attachToActivity
        menu = new SlidingMenu(this);   //下面lintener要用到menu，提为成员变量

        //设置菜单在左侧
        menu.setMode(SlidingMenu.LEFT_RIGHT);

        // 添加到Activity，第二个参数
        // 代表是否连标题一起推出，SlidingMenu.SLIDING XX
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        //改成SLIDING_CONTENT  或者把上面改成 AppCompatActivity 或者 fragmentAcitivity看看效果，不一样

        // 当attachToActivity之后，设置菜单
        menu.setMenu(R.layout.menu_left);

        menu.setSecondaryMenu(R.layout.menu_right);

        // 上方Activity滑到最后，能够保留多少
        menu.setBehindOffset(350);

        // 设置滚动的X坐标的倍数；
        // 0 不进行移动，内容从上方移走
        // 1 菜单跟随内容移动
        menu.setBehindScrollScale(1);

        /////////////////////////////////////
        //   menu 的控制

        menu.setOnOpenListener(this);
        menu.setOnOpenedListener(this);
        menu.setSecondaryOnOpenListner(new SlidingMenu.OnOpenListener() {
            @Override
            public void onOpen() {
                Toast.makeText(MainActivity.this, "打开了", Toast.LENGTH_SHORT).show();
            }
        });

        // 是否禁用用户手势滑动，用于ViewPager
        menu.setSlidingEnabled(true);

        // 设置滑动区域,这个是全屏滑动，否则中间不可滑
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        // 设置滑动边界阈值
        ////这个设置的是隔屏幕边缘多远开始响应
        menu.setTouchmodeMarginThreshold(60);

    }

    @Override
    public void onOpen() {
        Toast.makeText(this,"打开了",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOpened() {
        // 跟业务逻辑相关的
        if (menu.isSecondaryMenuShowing()){
            setTitle("个人中心");   //------ 都忘了居然可以这么玩
        }else if (menu.isMenuShowing()){
            setTitle("菜单");
        }
    }

    public void btnCloseMenu(View view) {
        // TODO 关闭菜单
        // showContent()  隐藏菜单
        menu.showContent();
    }
}
