package observable;
import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableExample {

	/*
	 * Subject Ŭ���� ó�� ������ Observable�� �߰ſ� Observable�� ��ȯ
	 * 
	 * subscribe()�Լ��� ȣ���ص� ������ X 
	 * connect()�Լ��� ȣ���� �������� subscribe()�� ȣ���� �����ڿ��� ������ ����
	 * 
	 */
	public void emit() {
		String dt[] = { "1", "3", "5" };

		Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(i -> dt[i])
				.take(dt.length);
		
		ConnectableObservable<String> connectableObservable = balls.publish(); //����
		connectableObservable.subscribe(data-> System.out.println("subscriber #1 =>" + data));
		connectableObservable.subscribe(data-> System.out.println("subscriber #2 =>" + data));
		connectableObservable.connect();
		
		CommUtil.sleep(250);
		connectableObservable.subscribe(data-> System.out.println("subscriber #3 =>" + data));
		CommUtil.sleep(1000);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConnectableObservableExample().emit();
	}

}
