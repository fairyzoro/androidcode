说明：单选框变形术
xml文件里 CheckBox内 android:button="@drawable/selector_chb"

drawable/selector_chb.xml  内
--------------------------------------------
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">

    <!-- item 标签 -->

    <item
            android:state_checked="true"
            android:drawable="@drawable/ic_action_favorite"/>

    <!-- 默认 item 不写任何状态的，通用的图片 -->

    <item
            android:drawable="@drawable/ic_action_good"/>

</selector>


=================================
//TODO    想到了点赞，或者说RadioButton 的变形,回头补链接