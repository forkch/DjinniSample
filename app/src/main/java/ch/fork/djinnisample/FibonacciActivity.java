package ch.fork.djinnisample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FibonacciActivity extends AppCompatActivity {

    @Bind(R.id.tvResult)
    TextView tvResult;

    @OnClick(R.id.btCompute)
    public void computeFibonacci() {
        final FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        final long result = fibonacciCalculator.computeFibonacci(10);
        tvResult.setText("" + result);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci_activiy);

        ButterKnife.bind(this);
    }

}
