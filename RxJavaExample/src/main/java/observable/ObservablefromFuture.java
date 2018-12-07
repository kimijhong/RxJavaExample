package observable;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import comm.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObservablefromFuture {
	
	
	
	public void basic()
	{

		/* ���ü� �񵿱� API ����� ����� ���Ҷ� ���
		 * Executors �������̽��� ������ Ŭ������ Callable��ü�� ���ڷ� �־� Future��ü�� ��ȯ
		 * Future�� Ȱ���ϱ⺸�� �����ٷ��� �������
		 *  */
		Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
			Thread.sleep(1000);
			return "Hello Future";
		});

		Observable<String> observable6 = Observable.fromFuture(future).subscribeOn(Schedulers.newThread());
		observable6.subscribe(data -> {
			Log.i(data);
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ObservablefromFuture().basic();
	}

}
