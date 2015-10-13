package ch.fork.djinnisample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FibonacciActivity extends AppCompatActivity implements FibonacciView {

    @Bind(R.id.tvResult)
    TextView tvResult;
    @Bind(R.id.etAmount)
    TextView etAmount;
    @Bind(R.id.lvSequence)
    ListView lvSequence;
    private FibonacciPresenter presenter;

    private ArrayAdapter<Long> adapter;

    @OnClick(R.id.btCompute)
    public void computeFibonacci() {
        presenter.computeFibonacci(Long.parseLong(etAmount.getText().toString()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci_activiy);

        ButterKnife.bind(this);

        presenter = new FibonacciPresenter(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvSequence.setAdapter(adapter);
    }

    @Override
    public void nextChunkComputed(List<Long> sequenceChunk) {
        adapter.addAll(sequenceChunk);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void clearSequence() {
        adapter.clear();
        adapter.notifyDataSetChanged();
    }

}
