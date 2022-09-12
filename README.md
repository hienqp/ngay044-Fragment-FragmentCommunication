FRAGMENT COMMUNICATION - GIAO TIẾP CỦA STATIC FRAGMENT (FRAGMENT TĨNH - GẮN CỐ ĐỊNH BỞI XML)

- trong phần này ta sẽ thực hiện giao tiếp giữa Static Fragment với Activity, và giữa Static Fragment với nhau
- trong phần thực hành này, ta sẽ dựng layout của MainActivity trình tự như sau
	- trên cùng là 1 TextView
	- thứ 2 là Button dùng để thực hiện thay đổi TextView của FragmentA
	- thứ 3 là FragmentA, dùng để nhập data và click truyền data đó cho TextView của MainActivity
	- thứ tư là FragmentB, dùng để nhập data và click truyền data đó cho TextView của FragmentA

- như vậy ta sẽ có 1 Activity và 2 Fragment

___

XÂY DỰNG LAYOUT XML VÀ FILE JAVA QUẢN TRỊ CỦA ACTIVITY VÀ FRAGMENT

- LAYOUT FRAGMENT A __fragment_a.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="#ff0">

    <TextView
        android:id="@+id/textviewFragA"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Fragment A"
        android:textSize="40sp" />

    <EditText
        android:hint="input in Fragment A"
        android:id="@+id/edittextFragA"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:id="@+id/buttonFragA"
        android:text="Click A"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```

- CODE JAVA FRAGMENT A__FragmentA.java__
```java
package com.hienqp.fragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}
```

- LAYOUT FRAGMENT B __fragment_b.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="#185d99">

    <TextView
        android:id="@+id/textviewFragB"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Fragment B"
        android:textSize="40sp" />

    <EditText
        android:hint="input in Fragment B"
        android:id="@+id/edittextFragB"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:id="@+id/buttonFragB"
        android:text="Click B"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```

- CODE JAVA FRAGMENT B__FragmentB.java__
```java
package com.hienqp.fragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
}
```

- LAYOUT ACTIVITY MAIN __main_activity.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textview_Main"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:textColor="#EA0505"
        android:textSize="30sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.107"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.057" />

    <Button
        android:id="@+id/buttonMain"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="28dp"
        android:text="Change Text"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.082"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textview_Main" />

    <fragment
        android:id="@+id/fragmentA"
        android:name="com.hienqp.fragmentcommunication.FragmentA"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="36dp"
        android:layout_marginEnd="8dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/buttonMain" />

    <fragment
        android:id="@+id/fragmentB"
        android:name="com.hienqp.fragmentcommunication.FragmentB"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="30dp"
        android:layout_marginEnd="8dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/fragmentA" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

- CODE JAVA ACTIVITY MAIN __MainActivity.java__
```java
package com.hienqp.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

___

ÁNH XẠ VÀ BẮT LISTENER CỦA CÁC THÀNH PHẦN CÓ TRONG FRAGMENT

- khai báo các thành phần có trong FragmentA và FragmnetB
- __FragmentA.java__
```
    TextView txtA;
    EditText edtA;
    Button btnA;
```
- __FragmentB.java__
```
    TextView txtB;
    EditText edtB;
    Button btnB;
```
- ánh xạ các thành phần đã khai báo trong FragmentA và FragmentB
- Fragment không phải là 1 Activity, nó chỉ là 1 thành phần được chứa trong Activity, nó cũng chỉ là 1 View, vì vậy để ánh xạ được các thành phần có trong Fragment, giống như Adapter, ta phải thông qua 1 Context (View) cụ thể
- method __onCreateView()__ có kiểu trả về là View, và bên trong method return chính là 1 View thông qua __inflater.inflate()__
- vì vậy ta sẽ lấy View có được từ __inflater.inflate()__ để ánh xạ các thành phần (View con) có trong Fragment, sau khi dựng xong thành phần giao diện của Fragment ta mới trả về View của Fragment
- ta thay thế đoạn code ``return inflater.inflate(R.layout.fragment_a, container, false);`` trong method __onCreateView()__ bằng đoạn code sau
```
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
```        
- sau khi có được View của Fragment, ta dùng View đó để ánh xạ các thành phần có trong Fragment, cuối cùng mới return về View đã dựng giao diện hoàn tất, chỉnh sửa đoạn code trên như sau
```
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        txtA = view.findViewById(R.id.textviewFragA);
        edtA = view.findViewById(R.id.edittextFragA);
        btnA = view.findViewById(R.id.buttonFragA);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), edtA.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
```
- ở đoạn code trên, thông qua View của Fragment ta có thể ánh xạ đến id của các thành phần có trong FragmentA đồng thời bắt luôn listener của Button có trong FragmentA Toast lên thông báo là giá trị được nhập vào EditText của FragmentA, ta làm tương tự với FragmentB     
- Lưu ý:
    - trong Fragment, để show 1 thông báo Toast, ta phải truyền tham số thứ 1 cho method __Toast.makeText()__ là method __getActivity()__, bởi vì thông báo Toast sẽ xuất hiện lên 1 Activity, chứ không phải 1 Fragment, nhưng method __Toast.makeText()__ đang được gọi trong Fragment, nó không hiểu sẽ phải show thông báo lên Activity nào, vì vậy phải truyền vào __getActivity()__ để cho nó biết phải Toast ở đâu.

___

ACTIVITY GIAO TIẾP ĐẾN FRAGMENT

- trong phần này sẽ thực hiện tương tác Activity đến Fragment, khi click vào Button CHANGE TEXT trên Activity, thì nội dung TextView của FragmentA sẽ thay đổi theo String ta truyền vào
- tiến hành khai báo các thành phần của MainActivity (TextView và Button)
```
    TextView txtMain;
    Button btnMain;
```
- ánh xạ TextView, Button của MainActivity (có thể trong __onCreate()__ hoặc trong 1 method tự tạo)
```
        txtMain = findViewById(R.id.textview_Main);
        btnMain = findViewById(R.id.buttonMain);
```
- sau khi có các thành phần của MainActivity, ta tiến hành bắt sự kiện Button của MainActivity, khi click vào Button của MainActivity ta thực hiện thay đổi TextView của FragmentA        
- nhưng TextView của FragmentA lại thuộc sự quản lý của FragmentA, muốn tác động đến nó từ MainActivity ta phải thông qua đối tượng FragmentA, như vậy trong sự kiện click vào Button của MainActivity ta phải 
    - có được đối tượng FragmentA
    - thông qua đối tượng của FragmentA tác động đến TextView của FragmentA
- mà để có được đối tượng FragmentA ta phải thông qua __getFragmentManager__ tìm đến __id__ hoặc __tag__ của FragmentA 
- sự kiện click Button của MainActivity trong __onCreate()__ sẽ như sau
```
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentById(R.id.fragmentA);
                fragmentA.GanNoiDung("Change By Activity");
            }
        });
```
- __fragmentA.GanNoiDung()__ là method ta khai báo bên FragmentA nhằm giảm tải code cho Activity
- __GanNoiDung()__ của FragmentA
```
    public void GanNoiDung(String str) {
        txtA.setText(str);
    }
```
- như vậy để từ Activity giao tiếp đến Fragment ta phải có được đối tượng của của Fragment đó thông qua 1 trong 2 method
    - getFragmentManager().findFragmentById()
    - getFragmentManager().findFragmentByTag()
- sau khi có được đối tượng Fragment ta có thể gọi đến các thành phần, method có trong Fragment đó

___

FRAGMENT GIAO TIẾP ĐẾN ACTIVITY

- bài toán đề ra là, khi click vào Button của FragmentA, thì sẽ thay đổi TextView của Activity đang chứa FragmentA bởi giá trị được nhập vào EditText của FragmentA
- từ 1 Fragment để tác động đến 1 View của Activity đang chứa nó, ta phải có đối tượng của View được ánh xạ đến id của View đó thông qua Activity đang chứa nó
- trong sự kiện click Button của FragmentA ta bỏ đi thông báo Toast để kiểm tra code hoạt động ban đầu
- sau đó ta lấy đối tượng TextView của Activity thông qua 
    - getActivity().findViewById(R.id.textview_Main)
- sau khi có được TextView của MainActivity, lúc này ta có thể tác động đến TextView của MainActivity
- sự kiện click Button của FragmnetA trong __onCreateView()__
```
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtMain = getActivity().findViewById(R.id.textview_Main);
                txtMain.setText(edtA.getText().toString());
            }
        });
```      

___

FRAGMENT GIAO TIẾP ĐẾN FRAGMENT

- bài toán lúc này là, click vào Button của FragmentB, thì TextView của FragmentA chính là nội dung được nhập vào EditText của FragmentB
- đối với tương tác từ Fragment đến Fragment cũng tương tự như từ Fragment đến Activity, thì từ Fragment thứ nhất
    - ta phải có đối tượng của Fragment thứ 2 thông qua __getActivity()__ ánh xạ đến __id__ của đối tượng đó bởi __findViewById()__
    - có được đối tượng của Fragment thứ 2, ta có thể tác động đến đối tượng đó từ Fragment thứ nhất
- sự kiện click Button của FragmentB trong __onCreateView()__
```
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtA = getActivity().findViewById(R.id.textviewFragA);
                txtA.setText(edtB.getText().toString());
            }
        });
```

___

TỔNG KẾT CÁCH THỨC GIAO TIẾP GIỮA ACTIVITY ĐẾN CÁC STATIC FRAGMENT ĐƯỢC CỐ ĐỊNH TRÊN ACTIVITY

- Activity đến Fragment:
    - lấy được đối tượng Fragment thông qua getFragmentManager() ánh xạ đến id của Fragment bởi findFragmentById() hoặc findFragmentByTag()
    - thông đối tượng Fragment có được, tác động đến các thành phần có trong Fragment đó
- Fragment đến Activity, Fragment đến Fragment
    - lấy được đối tượng View có trong Activity hoặc trong Fragment cần tác động đến thông qua getActivity() ánh xạ đến id của đối tượng tương ứng trong Activity hoặc Fragment bị tác động bởi findViewById()
    - sau khi có được đối tượng cần giao tiếp, ta có thể tùy ý tác động đến đối tượng đó     